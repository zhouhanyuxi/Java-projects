# 单双人猜数字小游戏
2018.1.10-2018.1.20

## 介绍
游戏每局随机生成4个不同数字，检查猜测情况并提供字符串匹配结果反馈，玩家根据反馈继续猜测，猜中则计时结束，游戏结束，用时记录保存在数据库中。双人模式，玩家需发起及接收匹配，会看到双方的结果反馈。

## 功能模块
整个项目分为菜单界面模块和游戏模块。
菜单界面模块包括进入游戏界面、查看游戏记录、查看规则和关于等文本。游戏模块包括游戏逻辑控制、反馈提示控制、通信匹配控制和数据库更新四部分， 其中单人模式不包含通信匹配控制部分。

## 关键技术问题
### 1.多线程
多线程是一个比较难理解和学习的概念，尤其是当线程对象比较多的时候。

在本项目的双人模式中，双方都有读写线程和计时线程，相当于有6个线程同时在运行，要理清这6个线程之间的关系，理清各个线程的任务，理清各个线程的生命周期，让6个线程互不影响，还要防止主线程受影响而阻塞，还要考虑到各个操作的顺序能不能使它们正常执行完。这些对我来说还是比较复杂的，尤其是读写线程还涉及到网络Socket通信的部分，相当于两个难点混合起来，更加有难度，比如当服务器调用socket.accpt()时，是阻塞的，这时界面上的按钮是无响应的，要退出accpt()函数，要另开一个线程调用socket.close()。

### 2.时间同步
由于猜测数字串需要计时，所以当两人合作猜测时需要尽可能的将双方时间同步。

为了实现此功能，发起匹配者在接受到匹配同意信息匹配成功后，将发出游戏开始时间信息，接受匹配者收到开始时间信息，从收到的信息中的开始时刻开始计时。这样双方的时间差就是信息收发操作和开启计时线程的时延，数量级为毫秒，可以接受。

### 3.网络通信Socket编程
本项目中所有的通信均用Socket完成，为了能完成匹配、时间同步和通信的任务，需要设计通信的流程和简单的协议。

参与游戏的双发需要发起匹配或接受匹配，若等待接收匹配，则该方为服务器方，若发起匹配，则该方为客户端方，故需要先有一方开启接受匹配，否则另一方将一直发起匹配失败。

+ （1）通信流程：

> 1）匹配  
服务器开启，准备接受链接，客户端开启，发起链接，服务器接受链接，判断是否同意匹配，发送匹配信息。若发送拒绝信息，则服务器关闭。若客户端方接收到拒绝匹配信息，则客户端也关闭，匹配失败。若发送同意信息，客户端接收到同意信息，则匹配成功。

> 2）时间同步  
匹配成功后，服务器等待接收游戏开始时间。客户端发送游戏开始时间后，开始计时，游戏开始，开启读进程；服务器接收到游戏开始时间后，开始计时，游戏开始，开启读进程。

> 3）通信  
服务器客户端开启读进程后，双方随时可以收发信息通信。

> 4）结束通信  
若我方猜中，计时结束，判断是否破纪录。若未破记录，发送猜中结果反馈信息，；若破纪录，则更新数据库后发送破纪录信息。发送完信息后，关闭socket关闭进程结束通信。  
若对方猜中，则我方将接收到猜中结果反馈信息或破记录信息，接受完信息后关闭socket关闭进程结束通信。

+ （2）协议：

所传送的信息的第一个字段标识信息的种类，C代表普通控制信息，R代表破纪录游戏信息记录。

第一个字段为C，若第二个字段为“agree”或“reject”，则该类信息为匹配信息，分别代表服务器匹配同意信息和拒绝信息，该类信息只有这两个字段；若第二个字段为“time”，则该类信息为游戏开始时间信息，后面跟着的字段为该局游戏开始时间；若第二个字段为“0”或“1”，则该类为猜测结果反馈信息，分别代表数字串猜测信息猜中与否，后面跟着的字段分别为该次猜测所输入的数字串、该次猜测发生的时刻以及该次猜测的结果反馈信息。

第一个字段为R，则该类信息为破纪录信息，后面跟着的字段分别为该局游戏要猜的数字串，以及该局游戏猜中的时刻。