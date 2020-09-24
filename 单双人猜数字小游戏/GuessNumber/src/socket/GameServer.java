package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import control.GameLogic;
import control.TimeThread;
import dao.Record;
import dao.RecordDaoImp;
import ui.DoubleFrame;

public class GameServer implements Runnable{
	DoubleFrame d;
	GameLogic game;
	
	Thread rt;
	TimeThread t;
	Thread thread;
	
	ServerSocket server;
	Socket socket;
	DataInputStream in;
	DataOutputStream out;
	
	boolean live;
	boolean matchEnable;
	boolean matchState;
	boolean guessEnable;
	boolean receive;
	String msg;
	String name;
	String time;
	String str;
	//构造函数
	public GameServer(DoubleFrame df){
		d = df;
		live = true;
		matchEnable = true;
		matchState = false;
		guessEnable = false;
		receive = false;
		thread = new Thread(this);
		thread.start();
		rt = new Thread(this);
		rt.start();
		System.out.println("服务器启动");
	}
	
	//接受链接
	public synchronized boolean match(){
		try {
				try {
				server= new ServerSocket(6667);
				System.out.println("服务器端口启动");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(" 等待客户呼叫");
			if(matchEnable){
				d.getLabelMessage().setText("正在接受匹配...");;
				socket = server.accept();
				matchEnable = false;
				matchState = true;
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return matchState;
	}
	//同意链接
	public synchronized void sendMatch(){
		try {
			out.writeUTF("C,agree");
			matchState = true;
		}catch (SocketException e){
			gameStop();
			d.getLabelMessage().setText("与客户端断开连接");
			serverClose();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			gameStop();
			d.getLabelMessage().setText("与客户端断开连接");
			serverClose();
		}
	}
	//不同意连接
	public synchronized void disMatch(){
		try {
			out.writeUTF("C,reject");
			gameStop();
			serverClose();
			matchState = false;
			matchEnable = true;
		}catch (SocketException e){
			gameStop();
			d.getLabelMessage().setText("与客户端断开连接");
			serverClose();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			gameStop();
			d.getLabelMessage().setText("与客户端断开连接");
			serverClose();
		}
	}
	
	//游戏开始
	public synchronized String gameBegin(){
		String s = "";
		try {
			s = in.readUTF();
			System.out.println("服务器端开始时间："+s);
			receive = true;
			StringTokenizer st = new StringTokenizer(s,",");
			if(st.nextToken().equals("C")){
				if(!st.nextToken().equals("time")){
					s = "";
				}else{
					String str = st.nextToken();
					long time = System.currentTimeMillis() - Long.parseLong(st.nextToken());
					game = new GameLogic();
					this.str = game.GenerateString(str);
					
					if(t == null || !t.isAlive()){
						t = new TimeThread(time);
						System.out.println("服务器端新游戏");
					}
					t.setState(true);
					t.setCom(d.getLabelTimer());
					t.start();
					
					d.getPanelMessage().setVisible(false);
					d.getPanelGame().setVisible(true);
					d.getLabelGameMsg().setText("请输入所猜测的数字");
					d.getTextField().setText(null);
					d.getPanelGame().paintImmediately(d.getPanelGame().getBounds());
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s;
	}
	//猜测一次
	public synchronized String guessOnce(){
		boolean check = false;
		String result = game.guessOnce(d.getTextField().getText());
		msg = "";
		if(result.equals("")){
			d.getLabelGameMsg().setText("输入不合法");
			d.getTextField().setText(null);
		}else{
			if(!result.equals("4A0B")){//没猜中
				msg = "C,0,"+d.getTextField().getText()+","
						+d.getLabelTimer().getText()+",\r\n猜测结果："+result;
				d.getLabelGameMsg().setText("猜测结果："+result);
				d.getTextArea().append("我方：\r\n"+d.getLabelTimer().getText()+" "
						+d.getTextField().getText()+",\r\n猜测结果："+result+"\r\n");
				d.getTextArea().paintImmediately(d.getTextArea().getBounds());
				d.getTextField().setText(null);
			}else{//猜中
				receive = false;
				time = d.getLabelTimer().getText();
				msg = "C,1,"+d.getTextField().getText()+","+time
						+",猜中了！总用时"+time;
				d.getTextArea().append("我方：\r\n"+d.getLabelTimer().getText()+" "+d.getTextField().getText()
						+"猜中了,总用时"+time+"\r\n");
				d.getTextArea().paintImmediately(d.getTextArea().getBounds()); 
				gameStop();
				check = checkRecord(time);
				if(check){//破纪录
					msg = "R,"+game.getStr()+","+time;
					boolean update = updateRecord(time);
					if(update)d.getLabelMessage().setText("记录已更新！\r\n请发起匹配或接受匹配");
					else d.getLabelMessage().setText("记录更新失败！\r\n请发起匹配或接受匹配");
				}
			}
			try {//发送信息
				System.out.println("服务器发送：我方：\r\n"+msg);
				out.writeUTF(msg);
			}catch (SocketException e){
				gameStop();
				d.getLabelMessage().setText("与客户端断开连接");
				serverClose();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				gameStop();
				d.getLabelMessage().setText("与客户端断开连接");
				serverClose();
			}
			if(!receive){
				if(check){
					JOptionPane.showMessageDialog(d, "猜中了，打破纪录，用时"+time,"打破纪录", JOptionPane.INFORMATION_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(d, "猜中了，用时"+time,"猜中了", JOptionPane.INFORMATION_MESSAGE);
				}
				d.getLabelMessage().setText("请发起匹配或接受匹配");
				serverClose();
			}
		}
		guessEnable = false;
		return msg;
	}
	
	public synchronized boolean checkRecord(String time){
		System.out.println("对比记录");
		boolean flag = false;	
		RecordDaoImp dao = new RecordDaoImp();
		Record r = dao.queryRecord("dou");
		if(r!=null){
			System.out.println("对比记录时读取到记录");
			StringTokenizer st = new StringTokenizer(time,":");
			int mm = Integer.parseInt(st.nextToken());
			int ss = Integer.parseInt(st.nextToken());
			System.out.println("mm："+mm+"ss:"+ss);
			String time2 = r.getTime();
			st = new StringTokenizer(time2,":");
			int mm2 = Integer.parseInt(st.nextToken());
			int ss2 = Integer.parseInt(st.nextToken());
			System.out.println("原mm："+mm2+"原ss:"+ss2);
			if(mm<mm2 || (mm==mm2&&ss<ss2)){
				flag = true;
				System.out.println("破记录了");
			}else{
				System.out.println("没破记录");
			}
		}else{
			System.out.println("对比记录时未读取到记录");
		}
		return flag;
	}
	public synchronized boolean updateRecord(String time){
		//System.out.println("更新记录");
		RecordDaoImp dao = new RecordDaoImp();
		boolean flag = dao.updateRecord("dou",time);
//		if(flag)System.out.println("跟新记录成功");
//		else System.out.println("跟新记录失败");
		return flag;
	}
	//处理接收到的信息
	public void dealMsg(){
		StringTokenizer st = new StringTokenizer(msg,",");
		String snext = st.nextToken();
		if(snext!=null && snext.equals("C")){
			String win = st.nextToken();
			String num = st.nextToken();
			String tim = st.nextToken();
			String tip = st.nextToken();
			String str =tim+" "+ num+tip;
			d.getTextArea().append("对方：\r\n" +str+"\r\n");
			if(win!=null && win.equals("1")){
				receive = false;
				gameStop();
				JOptionPane.showMessageDialog(d, "对方猜中了,总用时"+tim,
					"猜中了", JOptionPane.INFORMATION_MESSAGE);
				serverClose();
			}
		}else if(snext!=null && snext.equals("R")){
			receive = false;
			gameStop();
			JOptionPane.showMessageDialog(d, "对方猜中了，数字为"+st.nextToken()
					+"\r\n打破纪录，用时"+st.nextToken(),"打破纪录", JOptionPane.INFORMATION_MESSAGE);
			serverClose();
		}
	}
	public synchronized void serverClose(){
		receive = false;
		guessEnable = false;
		live = false;
		
		if(rt!=null && rt.isAlive())
			System.out.println("rt没死！");
		if(thread!=null && thread.isAlive())
			System.out.println("thread没死！");
		System.out.println("退出服务器");
		socketClose();
	}
	public void socketClose(){
		matchEnable = false;
		try {
			if(socket != null)
			socket.close();
			if(server != null)
			server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	public synchronized void gameStop(){
		if(t!= null)t.setState(false);
		if(t!=null && t.isAlive())
			System.out.println("t没死！");
		//gameState = false;
		d.getLabelGameMsg().setText("请输入所猜测的数字");
		d.getLabelTimer().setText("0:0");
		d.getTextArea().setText("");
		d.getTextField().setText(null);
		d.getPanelGame().setVisible(false);
		
		d.getPanelMessage().setVisible(true);
		d.getLabelMessage().setText("请发起匹配或接受匹配");
		
		
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(live){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(Thread.currentThread() == thread){
				if(matchEnable){
					if(match()){
						int ret;
						ret = JOptionPane.showConfirmDialog(d, "有匹配请求，是否同意？", "匹配请求"
								,JOptionPane.YES_NO_OPTION);
						if(ret == JOptionPane.NO_OPTION){
							disMatch();
							gameStop();
							serverClose();
						}
						else{
							sendMatch();
							d.getLabelMessage().setText("游戏初始化，请稍等");
							gameBegin();
						}
					}
				}
			}
			if(Thread.currentThread() == rt){
				if(receive){
					System.out.println("服务器端读");
					try {
						msg = in.readUTF();
						System.out.println("服务器端接收：对方：\r\n" + msg);
						dealMsg();
					}catch (SocketException e){
						//e.printStackTrace();
						gameStop();
						d.getLabelMessage().setText("与客户端断开连接");
						serverClose();
						
					}catch (IOException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
						gameStop();
						d.getLabelMessage().setText("与客户端断开连接");
						serverClose();
						
					}
				}
			}
			
		}
	}

	public DoubleFrame getD() {
		return d;
	}

	public void setD(DoubleFrame d) {
		this.d = d;
	}

	public GameLogic getGame() {
		return game;
	}

	public void setGame(GameLogic game) {
		this.game = game;
	}

	public Thread getRt() {
		return rt;
	}

	public void setRt(Thread rt) {
		this.rt = rt;
	}

	public TimeThread getT() {
		return t;
	}

	public void setT(TimeThread t) {
		this.t = t;
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public ServerSocket getServer() {
		return server;
	}

	public void setServer(ServerSocket server) {
		this.server = server;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public DataInputStream getIn() {
		return in;
	}

	public void setIn(DataInputStream in) {
		this.in = in;
	}

	public DataOutputStream getOut() {
		return out;
	}

	public void setOut(DataOutputStream out) {
		this.out = out;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public boolean isMatchEnable() {
		return matchEnable;
	}

	public void setMatchEnable(boolean matchEnable) {
		this.matchEnable = matchEnable;
	}

	public boolean isMatchState() {
		return matchState;
	}

	public void setMatchState(boolean matchState) {
		this.matchState = matchState;
	}

	public boolean isGuessEnable() {
		return guessEnable;
	}

	public void setGuessEnable(boolean guessEnable) {
		this.guessEnable = guessEnable;
	}

	public boolean isReceive() {
		return receive;
	}

	public void setReceive(boolean receive) {
		this.receive = receive;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
}
