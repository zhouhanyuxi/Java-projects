package ui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

import java.awt.BorderLayout;

public class MessageFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextArea textArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MessageFrame frame = new MessageFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MessageFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		setTitle("游戏规则");
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("华文楷体", Font.BOLD, 15));
		contentPane.add(textArea, BorderLayout.CENTER);
		
//		String s = "";
//		try {
//			FileReader r = new FileReader(System.getProperty("user.dir")+File.separator+"rule.txt");
//			BufferedReader buf = new BufferedReader(r);
//			boolean eof = false;
//			while(!eof){
//				String line = buf.readLine();
//				if(line == null)eof = true;
//				else s = s + line + "\r\n";
//			}
//			buf.close();
//			System.out.print(s);
//			textArea.setText(s);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		setVisible(true);
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
}
