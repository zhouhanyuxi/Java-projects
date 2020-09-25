package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import control.BeginFrameControl;
import control.DoubleFrameControl;
import control.SingleFrameControl;


public class BeginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private GridBagLayout gbl_panel;
	private JLabel labelTitle;
	private JPanel panel;
	private JButton btnDouble;
	private JButton btnRecord;
	private JButton btnRule;
	private JButton btnAbout;
	private JButton btnExit;
	private JButton btnSound;
	private ImageIcon iconSound;
	private JButton btnSingle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BeginFrame b = new BeginFrame();
					BeginFrameControl bc = new BeginFrameControl();
					SingleFrame s = new SingleFrame();
					SingleFrameControl sc = new SingleFrameControl();
					DoubleFrame d = new DoubleFrame();
					DoubleFrameControl dc = new DoubleFrameControl();
					
					dc.exitControl(d, b);
					dc.control(d);
					
					bc.exitControl(b);
					bc.normalControl(b);
					
					sc.Control(s);
					sc.exitControl(s, b);
					
					bc.beginControl(b, s, d, dc);
					
					b.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void panel(){
		Font f = new Font("微软雅黑",Font.BOLD, 15);
		gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{10, 60, 20, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{25, 0, 25, 0, 0, 0, 25, 0, 20, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		btnSingle = new JButton("单人");
		btnSingle.setForeground(SystemColor.textHighlight);
		btnSingle.setFont(f);
		GridBagConstraints gbc_btnSingle = new GridBagConstraints();
		gbc_btnSingle.insets = new Insets(0, 0, 5, 5);
		gbc_btnSingle.gridx = 3;
		gbc_btnSingle.gridy = 1;
		panel.add(btnSingle, gbc_btnSingle);
		
		btnDouble = new JButton("双人");
		btnDouble.setForeground(SystemColor.textHighlight);
		btnDouble.setFont(f);
		GridBagConstraints gbc_btnDouble = new GridBagConstraints();
		gbc_btnDouble.fill = GridBagConstraints.BOTH;
		gbc_btnDouble.insets = new Insets(0, 0, 5, 0);
		gbc_btnDouble.gridx = 4;
		gbc_btnDouble.gridy = 1;
		panel.add(btnDouble, gbc_btnDouble);
		
		btnRecord = new JButton("游戏记录");
		btnRecord.setFont(f);
		GridBagConstraints gbc_btnRecord = new GridBagConstraints();
		gbc_btnRecord.gridwidth = 2;
		gbc_btnRecord.fill = GridBagConstraints.BOTH;
		gbc_btnRecord.insets = new Insets(0, 0, 5, 0);
		gbc_btnRecord.gridx = 3;
		gbc_btnRecord.gridy = 3;
		panel.add(btnRecord, gbc_btnRecord);
		
		btnRule = new JButton("游戏规则");
		btnRule.setFont(f);
		GridBagConstraints gbc_btnRule = new GridBagConstraints();
		gbc_btnRule.gridwidth = 2;
		gbc_btnRule.fill = GridBagConstraints.BOTH;
		gbc_btnRule.insets = new Insets(0, 0, 5, 0);
		gbc_btnRule.gridx = 3;
		gbc_btnRule.gridy = 4;
		panel.add(btnRule, gbc_btnRule);
		
		btnAbout = new JButton("关于");
		btnAbout.setFont(f);
		GridBagConstraints gbc_btnAbout = new GridBagConstraints();
		gbc_btnAbout.gridwidth = 2;
		gbc_btnAbout.fill = GridBagConstraints.BOTH;
		gbc_btnAbout.insets = new Insets(0, 0, 5, 0);
		gbc_btnAbout.gridx = 3;
		gbc_btnAbout.gridy = 5;
		panel.add(btnAbout, gbc_btnAbout);
		
		btnExit = new JButton("退出");
		btnExit.setForeground(new Color(250, 128, 114));
		btnExit.setFont(f);
		GridBagConstraints gbc_btnExit = new GridBagConstraints();
		gbc_btnExit.gridwidth = 2;
		gbc_btnExit.fill = GridBagConstraints.BOTH;
		gbc_btnExit.insets = new Insets(0, 0, 5, 0);
		gbc_btnExit.gridx = 3;
		gbc_btnExit.gridy = 7;
		panel.add(btnExit, gbc_btnExit);
		
//		btnSound = new JButton("声音");
//		btnSound.setFont(new Font("幼圆", Font.BOLD, 12));
//		btnSound.setSize(60, 25);
//		iconSound = new ImageIcon("sound.png");
//		//btnSound.setIcon(iconSound);
//		GridBagConstraints gbc_btnSound = new GridBagConstraints();
//		gbc_btnSound.anchor = GridBagConstraints.EAST;
//		gbc_btnSound.insets = new Insets(0, 0, 0, 5);
//		gbc_btnSound.gridx = 1;
//		gbc_btnSound.gridy = 9;
//		panel.add(btnSound, gbc_btnSound);
	}

	/**
	 * Create the frame.
	 */
	public BeginFrame() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 350, 415);
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		labelTitle = new JLabel("GuessNumber");
		labelTitle.setBackground(new Color(255, 255, 255));
		labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitle.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 35));
		contentPane.add(labelTitle, BorderLayout.NORTH);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		contentPane.add(panel, BorderLayout.CENTER);
		
		panel();
		
		setLocationRelativeTo(null);
	}

	public GridBagLayout getGbl_panel() {
		return gbl_panel;
	}

	public void setGbl_panel(GridBagLayout gbl_panel) {
		this.gbl_panel = gbl_panel;
	}

	public JLabel getLabelTitle() {
		return labelTitle;
	}

	public void setLabelTitle(JLabel labelTitle) {
		this.labelTitle = labelTitle;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JButton getBtnDouble() {
		return btnDouble;
	}

	public void setBtnDouble(JButton btnDouble) {
		this.btnDouble = btnDouble;
	}

	public JButton getBtnRecord() {
		return btnRecord;
	}

	public void setBtnRecord(JButton btnRecord) {
		this.btnRecord = btnRecord;
	}

	public JButton getBtnRule() {
		return btnRule;
	}

	public void setBtnRule(JButton btnRule) {
		this.btnRule = btnRule;
	}

	public JButton getBtnAbout() {
		return btnAbout;
	}

	public void setBtnAbout(JButton btnAbout) {
		this.btnAbout = btnAbout;
	}

	public JButton getBtnExit() {
		return btnExit;
	}

	public void setBtnExit(JButton btnExit) {
		this.btnExit = btnExit;
	}

	public JButton getBtnSound() {
		return btnSound;
	}

	public void setBtnSound(JButton btnSound) {
		this.btnSound = btnSound;
	}

	public ImageIcon getIconSound() {
		return iconSound;
	}

	public void setIconSound(ImageIcon iconSound) {
		this.iconSound = iconSound;
	}

	public JButton getBtnSingle() {
		return btnSingle;
	}

	public void setBtnSingle(JButton btnSingle) {
		this.btnSingle = btnSingle;
	}
}
