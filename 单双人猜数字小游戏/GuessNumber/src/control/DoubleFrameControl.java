package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import socket.GameClient;
import socket.GameServer;
import ui.BeginFrame;
import ui.DoubleFrame;

public class DoubleFrameControl{
	private GameServer gs;
	private GameClient gc;
	//private String msg;

	
	public DoubleFrameControl(){
	}
	

	public void exitControl(DoubleFrame d,BeginFrame b){
		d.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				int ret = JOptionPane.showConfirmDialog(d, "ȷ���˳�", "�˳�", 
						JOptionPane.YES_NO_OPTION);
				if(ret == JOptionPane.YES_OPTION)
				{
					System.exit(0);
				}
			}
		});
		d.getBtnBack().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int ret = JOptionPane.YES_OPTION;
				if((gc!=null&&gc.isLive()) || (gs!=null&&gs.isLive())){
					ret = JOptionPane.showConfirmDialog(b, "�뿪�������˾֣�ȷ���뿪��", "����������", 
						JOptionPane.YES_NO_OPTION);
				}
				if(ret == JOptionPane.YES_OPTION)
				{
					if((gc!=null&&gc.isLive())){
						gc.gameStop();
						gc.clientClose();
					}
					else if((gs!=null&&gs.isLive())){
						gs.gameStop();
						gs.serverClose();
					}
					d.getPanelMessage().setVisible(true);
					d.getPanelGame().setVisible(false);
					b.setVisible(true);
					d.setVisible(false);
				}
			}
		});
	}
	
	public void control(DoubleFrame d){
		d.getBtnSend().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gc = new GameClient(d);
			}
		});
		d.getBtnReceive().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gs = new GameServer(d);
			}
		});
		//�˳��þ�
		d.getBtnExit().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Thread(){//��ֹ��ʱ���������ڽ��������������߳�
					public void run(){
						if((gc!=null&&gc.isLive())){
							gc.socketClose();
						}
						else if((gs!=null&&gs.isLive())){
							gs.socketClose();
						}
						d.getLabelMessage().setText("�뷢��ƥ������ƥ��");
						d.getPanelMessage().setVisible(true);
						d.getPanelGame().setVisible(false);
					}
				}.start();
			}
		});
		d.getBtnOK().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((gc!=null&&gc.isLive())){
					gc.guessOnce();
					//gc.setGuessEnable(true);
				}else if((gs!=null&&gs.isLive())){
					gs.guessOnce();
					//gs.setGuessEnable(true);
				}
				
			}
		});
		d.getTextField().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
					d.getBtnOK().doClick();
			}
		});
	}

}
