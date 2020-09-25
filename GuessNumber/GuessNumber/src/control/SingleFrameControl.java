package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import dao.Record;
import dao.RecordDaoImp;
import ui.BeginFrame;
import ui.SingleFrame;

public class SingleFrameControl {
	private GameLogic game;
	private boolean gameState;
	private TimeThread t;

	public SingleFrameControl(){
		game = new GameLogic();
		gameState = false;
	}	
	
	public void gameBegin(SingleFrame m){
		gameState = true;
		if(t == null || !t.isAlive()){
			t = new TimeThread();
			System.out.println("����Ϸ");
		}
		t.setState(true);
		t.setCom(m.getTimerLabel());
		t.start();
		game.GenerateString();
		//game.timeingBegin();
		//game.timingNow();
		m.getResultLabel().setText("���������²������");
		m.getGuessTextField().setText(null);
		m.getBeginPanel().setVisible(false);
		m.getGamePanel().setVisible(true);
	}
	
	public void guessOnce(SingleFrame m){
		String result = game.guessOnce(m.getGuessTextField().getText());
		if(result.equals("")){
			m.getResultLabel().setText("���벻�Ϸ�������������");
			m.getGuessTextField().setText(null);
		}else{
			if(!result.equals("4A0B")){
				m.getResultLabel().setText("�²�����"+result+"����������һ����������");
				m.getGuessTextField().setText(null);
			}
			else{
				String time = m.getTimerLabel().getText();
				String str = "һ������"+game.getCount()+"��,����ʱ"+time;
				gameStop(m);
				boolean flag = checkRecord(time);
				if(flag){
					JOptionPane.showMessageDialog(m, "�����ˣ����Ƽ�¼����ʱ"+time,"���Ƽ�¼", JOptionPane.INFORMATION_MESSAGE);
					boolean check = updateRecord(m,time);
					if(check)m.getResultLabel().setText("��¼�Ѹ��£�\r\n�뷢��ƥ������ƥ��");
					else m.getResultLabel().setText("��¼����ʧ�ܣ�\r\n�뷢��ƥ������ƥ��");
				}else{
					JOptionPane.showMessageDialog(m, str, "������", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		}
	}
	
	public void gameStop(SingleFrame m){
		gameState = false;
		m.getResultLabel().setText("���������²������");
		m.getTimerLabel().setText("0:0");
		m.getGuessTextField().setText(null);
		if(t!=null)t.setState(false);
		
//		SimpleDateFormat min = new SimpleDateFormat("mm:ss");
//		m.getTimingLabel().setText(min.format(game.getTime()));
		m.getBeginPanel().setVisible(true);
		m.getGamePanel().setVisible(false);
		if(t!=null && t.isAlive())
			System.out.println("û����");
	}
	public synchronized boolean checkRecord(String time){
		System.out.println("�Աȼ�¼");
		boolean flag = false;	
		RecordDaoImp dao = new RecordDaoImp();
		Record r = dao.queryRecord("sin");
		if(r!=null){
			StringTokenizer st = new StringTokenizer(time,":");
			int mm = Integer.parseInt(st.nextToken());
			int ss = Integer.parseInt(st.nextToken());
			String time2 = r.getTime();
			st = new StringTokenizer(time2,":");
			int mm2 = Integer.parseInt(st.nextToken());
			int ss2 = Integer.parseInt(st.nextToken());
			if(mm<mm2 || (mm>mm2&&ss<ss2)){
				flag = true;
				System.out.println("�����¼�¼");
			}
		}
		return flag;
	}
	public synchronized boolean updateRecord(SingleFrame s,String time){
		RecordDaoImp dao = new RecordDaoImp();
		boolean flag = dao.updateRecord("sin", time);
		if(flag)s.getBeginLabel().setText("��¼���³ɹ���");
		else s.getBeginLabel().setText("��¼����ʧ�ܣ�");
		return flag;
	}
	public void exitControl(SingleFrame s,BeginFrame b){
		s.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				int ret = JOptionPane.showConfirmDialog(b, "ȷ���˳�", "�˳�", 
						JOptionPane.YES_NO_OPTION);
				if(ret == JOptionPane.YES_OPTION)
				{
					System.exit(0);
				}
			}
		});
		s.getBackButton().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int ret = JOptionPane.YES_OPTION;
				if(gameState){
					ret = JOptionPane.showConfirmDialog(b, "�뿪�������˾֣�ȷ���뿪��", "����������", 
						JOptionPane.YES_NO_OPTION);
				}
				if(ret == JOptionPane.YES_OPTION)
				{
					gameStop(s);
					s.getBeginPanel().setVisible(true);
					s.getGamePanel().setVisible(false);
					b.setVisible(true);
					s.setVisible(false);
				}
			}
		});
	}
	
	public void Control(SingleFrame m){
		m.getStartButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameBegin(m);
			}
		});
		m.getStopButton().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gameStop(m);
			}
		});
		m.getOkButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guessOnce(m);
			}
		});
		m.getGuessTextField().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
					m.getOkButton().doClick();
			}
		});
//		m.getSoundButton().addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e){
//	
//			}
//		});
	}
}
