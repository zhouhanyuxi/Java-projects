package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

import ui.BeginFrame;
import ui.DoubleFrame;
import ui.MessageFrame;
import ui.SingleFrame;
import ui.RecordFrame;

public class BeginFrameControl {
	
	public BeginFrameControl(){
	}
	
	public void exitControl(BeginFrame b){
		b.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				int ret = JOptionPane.showConfirmDialog(b, "确认退出", "退出", 
						JOptionPane.YES_NO_OPTION);
				if(ret == JOptionPane.YES_OPTION)
				{
					System.exit(0);
				}
			}
		});
		
		b.getBtnExit().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				int ret = JOptionPane.showConfirmDialog(b, "确认退出", "退出", 
						JOptionPane.YES_NO_OPTION);
				if(ret == JOptionPane.YES_OPTION)
				{
					System.exit(0);
				}
			}
		});
	}
	
	public void beginControl(BeginFrame b,SingleFrame s,DoubleFrame d,DoubleFrameControl dc){
		b.getBtnSingle().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				s.setVisible(true);
				b.setVisible(false);
			}
		});
		
		b.getBtnDouble().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				d.setVisible(true);
				b.setVisible(false);
			}
		});
	}
	
	public void normalControl(BeginFrame b){
		b.getBtnRule().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				String s = "";
				try {
					FileReader r = new FileReader(System.getProperty("user.dir")+File.separator+"rule.txt");
					BufferedReader buf = new BufferedReader(r);
					boolean eof = false;
					while(!eof){
						String line = buf.readLine();
						if(line == null)eof = true;
						else s = s + line + "\r\n";
					}
					buf.close();
					MessageFrame m = new MessageFrame();
					m.setTitle("游戏规则");
					//System.out.print(s);
					m.getTextArea().setText(s);
					m.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		b.getBtnAbout().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				String s = "";
				try {
					FileReader r = new FileReader(System.getProperty("user.dir")+File.separator+"about.txt");
					BufferedReader buf = new BufferedReader(r);
					boolean eof = false;
					while(!eof){
						String line = buf.readLine();
						if(line == null)eof = true;
						else s = s + line + "\r\n";
					}
					buf.close();
					MessageFrame m = new MessageFrame();
					m.setTitle("关于");
					//System.out.print(s);
					m.getTextArea().setText(s);
					m.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		b.getBtnRecord().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				RecordFrame r = new RecordFrame();
				r.setVisible(true);
			}
		});
	}
}
