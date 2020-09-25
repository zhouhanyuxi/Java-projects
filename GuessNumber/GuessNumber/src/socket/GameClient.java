package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import ui.DoubleFrame;
import control.GameLogic;
import control.TimeThread;
import dao.Record;
import dao.RecordDaoImp;

public class GameClient implements Runnable{
	DoubleFrame d;
	GameLogic game;
	
	Thread rt;
	TimeThread t;
	Thread thread;
	
	boolean live;
	boolean matchEnable;
	boolean matchState;
	boolean receive;
	boolean guessEnable;
	String msg;
	String name;
	String time;
	String str;
	
	Socket socket;
	DataInputStream in;
	DataOutputStream out;
	
	//���캯��
	public GameClient(DoubleFrame df){
		d = df;
		live = true;
		matchEnable = true;
		matchState = false;
		receive = false;
		guessEnable = false;
		thread = new Thread(this);
		thread.start();
		rt = new Thread(this);
		rt.start();
		System.out.println("�ͻ�������");
	}
	//��������
	public synchronized boolean match(){
		matchState = false;
		String IP = JOptionPane.showInputDialog(d, "������������˵�ַ��");
//		try {
//			InetAddress a = InetAddress.getByName(IP);
//		} catch (UnknownHostException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		try {
			d.getLabelMessage().setText("����ƥ��...");
			socket=new Socket(IP,6667);
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			d.getLabelMessage().setText("���ڵȴ��Է�ͬ��...");
			
			String msg = in.readUTF();
			System.out.println("�ͻ��˽���ͬ����Ϣ��"+msg);
			StringTokenizer st = new StringTokenizer(msg,",");
			String snext = st.nextToken();
			if(snext!=null && snext.equals("C")){
				snext = st.nextToken();
				if(snext!=null && snext.equals("agree")){
					System.out.println("�ͻ��˽��յ�ͬ����Ϣ");
					matchState = true;
					matchEnable = false;
				}else{
					d.getLabelMessage().setText("�ѱ��ܾ���������ƥ�䡣");
					matchState = false;
					matchEnable = true;
				}
			}
		}catch(ConnectException e){
			e.printStackTrace();
			System.out.println("ƥ��ʧ�ܣ�");
			d.getLabelMessage().setText("ƥ��ʧ�ܣ�");
		}catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			d.getLabelMessage().setText("ƥ��ʧ�ܣ�");
		}catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			d.getLabelMessage().setText("ƥ��ʧ�ܣ�");
		}
		
		return matchState;
	}
	//��ʼ��Ϸ
	public synchronized void gameBegin(){
		try {
			game = new GameLogic();
			str = game.GenerateString();
			msg = "C,time,"+game.getStr()+","+System.currentTimeMillis();
			out.writeUTF(msg);
			System.out.println("�ͻ��˿�ʼʱ�䣺"+msg);
			receive = true;
			if(t == null || !t.isAlive()){
				t = new TimeThread(0);
				System.out.println("�ͻ�������Ϸ");
			}
			t.setState(true);
			t.setCom(d.getLabelTimer());
			t.start();
			
			d.getPanelMessage().setVisible(false);
			d.getPanelGame().setVisible(true);
			d.getLabelGameMsg().setText("���������²������");
			d.getTextField().setText(null);
			d.getPanelGame().paintImmediately(d.getPanelGame().getBounds());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//�²�һ��
	public synchronized String guessOnce(){
		boolean check = false;
		String result = game.guessOnce(d.getTextField().getText());
		msg = "";
		if(result.equals("")){
			d.getLabelGameMsg().setText("���벻�Ϸ�");
			d.getTextField().setText(null);
		}else{
			if(!result.equals("4A0B")){//û����
				msg = "C,0,"+d.getTextField().getText()+","
						+d.getLabelTimer().getText()+",\r\n�²�����"+result;
				d.getLabelGameMsg().setText("�²�����"+result);
				d.getTextArea().append("�ҷ���\r\n"+d.getLabelTimer().getText()+" "
						+d.getTextField().getText()+",\r\n�²�����"+result+"\r\n");
				d.getTextArea().paintImmediately(d.getTextArea().getBounds());
				d.getTextField().setText(null);
			}else{//����
				receive = false;
				time = d.getLabelTimer().getText();
				msg = "C,1,"+d.getTextField().getText()+","+time
						+",�����ˣ�����ʱ"+time;
				d.getTextArea().append("�ҷ���\r\n"+d.getLabelTimer().getText()+" "+d.getTextField().getText()
						+"������,����ʱ"+time+"\r\n");
				d.getTextArea().paintImmediately(d.getTextArea().getBounds()); 
				gameStop();
				check = checkRecord(time);
				if(check){//���Ƽ�¼
					msg = "R,"+game.getStr()+","+time;
					boolean update = updateRecord(time);
					if(update)d.getLabelMessage().setText("��¼�Ѹ��£�\r\n�뷢��ƥ������ƥ��");
					else d.getLabelMessage().setText("��¼����ʧ�ܣ�\r\n�뷢��ƥ������ƥ��");
				}
			}
			try {//������Ϣ
				System.out.println("�ͻ��˷��ͣ��ҷ���\r\n"+msg);
				out.writeUTF(msg);
			}catch (SocketException e){
				gameStop();
				d.getLabelMessage().setText("��������Ͽ�����");
				clientClose();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				gameStop();
				d.getLabelMessage().setText("��������Ͽ�����");
				clientClose();
			}
			if(!receive){//���е��Ի���
				if(check){
					JOptionPane.showMessageDialog(d, "�����ˣ����Ƽ�¼����ʱ"+time,"���Ƽ�¼", JOptionPane.INFORMATION_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(d, "�����ˣ���ʱ"+time,"������", JOptionPane.INFORMATION_MESSAGE);
				}
				d.getLabelMessage().setText("�뷢��ƥ������ƥ��");
				clientClose();
			}
		}
		guessEnable = false;//
		return msg;
	}
	
	public synchronized boolean checkRecord(String time){
		System.out.println("�Աȼ�¼");
		boolean flag = false;	
		RecordDaoImp dao = new RecordDaoImp();
		Record r = dao.queryRecord("dou");
		if(r!=null){
			System.out.println("�Աȼ�¼ʱ��ȡ����¼");
			StringTokenizer st = new StringTokenizer(time,":");
			int mm = Integer.parseInt(st.nextToken());
			int ss = Integer.parseInt(st.nextToken());
			System.out.println("mm��"+mm+"ss:"+ss);
			String time2 = r.getTime();
			st = new StringTokenizer(time2,":");
			int mm2 = Integer.parseInt(st.nextToken());
			int ss2 = Integer.parseInt(st.nextToken());
			System.out.println("ԭmm��"+mm2+"ԭss:"+ss2);
			if(mm<mm2 || (mm==mm2&&ss<ss2)){
				flag = true;
				System.out.println("�Ƽ�¼��");
			}else{
				System.out.println("û�Ƽ�¼");
			}
		}else{
			System.out.println("�Աȼ�¼ʱδ��ȡ����¼");
		}
		return flag;
	}
	public synchronized boolean updateRecord(String time){
		System.out.println("���¼�¼");
		RecordDaoImp dao = new RecordDaoImp();
		boolean flag = dao.updateRecord("dou",time);
		if(flag)System.out.println("���¼�¼�ɹ�");
		else System.out.println("���¼�¼ʧ��");
		return flag;
	}
	//������յ�����Ϣ
	public void dealMsg(){
		StringTokenizer st = new StringTokenizer(msg,",");
		String snext = st.nextToken();
		if(snext!=null && snext.equals("C")){
			String win = st.nextToken();
			String num = st.nextToken();
			String tim = st.nextToken();
			String tip = st.nextToken();
			String str =tim+" "+ num+tip;
			d.getTextArea().append("�Է���\r\n" +str+"\r\n");
			if(win!=null && win.equals("1")){
				gameStop();
				receive = false;
				JOptionPane.showMessageDialog(d, "�Է�������,����ʱ"+tim,
					"������", JOptionPane.INFORMATION_MESSAGE);
				clientClose();
			}
		}else if(snext!=null && snext.equals("R")){
			receive = false;
			gameStop();
			JOptionPane.showMessageDialog(d, "�Է������ˣ�����Ϊ"+st.nextToken()
					+"\r\n���Ƽ�¼����ʱ"+st.nextToken(),"���Ƽ�¼", JOptionPane.INFORMATION_MESSAGE);
			clientClose();
		}
	}
	public synchronized void clientClose(){
		receive = false;
		guessEnable = false;
		live = false;
		
		if(rt!=null && rt.isAlive())
			System.out.println("rtû����");
		if(thread!=null && thread.isAlive())
			System.out.println("threadû����");
		System.out.println("�˳��ͻ���");
		socketClose();
	}
	public void socketClose(){
		try {
			if(socket != null)
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	public synchronized void gameStop(){
		if(t!= null)t.setState(false);
		if(t!=null && t.isAlive())
			System.out.println("tû����");
		
		d.getLabelGameMsg().setText("���������²������");
		d.getLabelTimer().setText("0:0");
		d.getTextArea().setText("");
		d.getTextField().setText(null);
		d.getPanelGame().setVisible(false);
		
		d.getPanelMessage().setVisible(true);
		d.getLabelMessage().setText("�뷢��ƥ������ƥ��");
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
						gameBegin();
					}else{
						clientClose();
					}
				}
			}
			if(Thread.currentThread() == rt){
				if(receive){System.out.println("�ͻ��˶�");
					try {
						msg = in.readUTF();
						System.out.println("�ͻ��˽��գ��Է���\r\n" + msg);
						dealMsg();
					}catch (SocketException e){
						//e.printStackTrace();
						gameStop();
						d.getLabelMessage().setText("��������Ͽ�����");
						clientClose();
					}
					catch (IOException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
						gameStop();
						d.getLabelMessage().setText("��������Ͽ�����");
						clientClose();
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

	public boolean isReceive() {
		return receive;
	}

	public void setReceive(boolean receive) {
		this.receive = receive;
	}

	public boolean isGuessEnable() {
		return guessEnable;
	}

	public void setGuessEnable(boolean guessEnable) {
		this.guessEnable = guessEnable;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
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

	
	
}
