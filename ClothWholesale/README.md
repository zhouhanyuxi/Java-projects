# 布料批发管理系统
2019.3.1 - 2019.5.26

## 介绍
本项目是设计与实现一个布料批发管理Web App，要求实现批发公司从采购到销售一系列业务的自动化，整合前台线上销售与后台企业资源管理的功能，实现企业信息的前后交流。 

选择使用Java语言进行开发，使用SpringMVC+Spring+Mybatis框架，集成开发环境选择eclipse，使用MySQL数据库，Web服务器使用Tomcat。使用JSON字符串将浏览器与服务之间传送的数据进行对象化处理，使用ajax技术实现网页的部分更新和动态加载。安全性要求方面，所有用户的密码都要进行MD5加密操作，并且要对不同角色的系统使用者进行权限管理。保证项目对三个主流浏览器（IE，Firefox，Chrome）基本兼容，可正常使用。

### 功能模块设计
布料批发管理系统分为两大部分，分别为批发公司直接操作的部分（即类似于ERP软件或者“进销存”软件的功能），以及客户直接操作部分（即类似于电子商务网站的功能）。

批发商部分分为四个模块：基础信息模块为对软件系统和批发公司运作所需的基础信息进行管理，包括管理员、供应商、产品、仓库和财务统计信息，其中产品信息包括产品基本信息、产品属性类别以及产品的分梯度价格；采购模块为采购管理员对采购开单入库过程的管理以及对采购过程的款项流通进行查看；库存管理为仓库管理员对产品出入库过程的管理以及对仓库内容明细和出入库流水的查看；批发管理模块为批发管理员对批发过程（包含下单和退换货）以及批发订单的管理，对批发过程的款项流通进行查看。

客户部分分为三个模块：搜索查看产品信息功能是网站客户首页的展示、搜索功能和产品具体信息页的加入进货单、查看评论等等功能；批发下单是客户参与的批发全过程，包含付款、退换货、评价订单等功能；客户信息管理为客户对自身基本信息、订单和进货单的管理，对款项流水信息的查看。

### 数据库设计
本系统一共设计了29张数据表。数据库设计中考虑实际使用的批发系统的原型，为每个批发产品设置多个价格，同时一个产品也对应多个型号。业务逻辑中，采购操作以订单项为单位进行，而批发操作以订单为单位进行。

所有储存流水记录的数据表都是将出入记录存储在一起的，以出入标识作为区分。

采购订单和批发订单都分别由订单本身的属性和订单项构成，订单项就是一个订单中的不同产品项。所有的订单项数据表都是将订单编号和每个订单中的订单项序号组合在一起形成编号，作为主键。

主键为这种形式的还有产品价格表和产品型号表。因为购买数量不同的时候单价有不同，所以产品和价格在批发业务中是一对多关系，产品和产品型号之间的关系也是一对多。

产品型号和产品图片之间也是一对多关系，一种产品的型号序号从1开始实际计算，序号为0的型号代表空型号，不用于售卖，是用于储存为该种产品不同型号间的通用信息，如型号序号为0所对应的产品图片为该种产品的通用介绍图片，而不是某个型号的实物图片。

库存内容表中存储的数据是某个仓库存储某种产品型号的数量，单位是米。

批发订单的取消、换货和退货都有特定的数据表存储相关的记录，为批发订单取消记录表、换货记录表和退货记录表。因为这些操作中是涉及到的订单状态过多，换货退货还涉及到货物和款项的流通，如果不将其分解开来，数据表的结构和操作将很复杂，因此本系统中将其分解开。

产品属性及类别信息表是用于存储产品的属性类别及属性的。由于布料的属性类别太多，如成分类型、原料及含量、纺织工艺、染整工艺等等，每种属性类别又包含很多种属性，如成分类型就有棉织物、麻织物、毛织物、丝织物、化纤织物、混纺织物、交织物，所以此处使用一张单独的数据表存储这些属性，和填写地址时使用下拉列表选择省份和城市类似，在新建产品填写信息的时候就可以直接使用下拉列表选择该产品的属性。本系统版本2中产品属性及类别信息可以增删查改。
