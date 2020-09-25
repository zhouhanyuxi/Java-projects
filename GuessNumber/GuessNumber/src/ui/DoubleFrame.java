package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class DoubleFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel labelTitle;
	private JPanel panelUtility;
	private GridBagLayout gbl_panelUtility;
	private JButton btnBack;
	private JButton btnSend;
	private JButton btnReceive;
	private JButton btnExit;
	private JButton btnSound;
	
	private JPanel panelCenter;
	private JPanel panelMessage;
	
	private JPanel panelGame;
	private JLabel labelMessage;
	private JPanel panelGuess;
	private GridBagLayout gbl_panelGuess;
	private JTextArea textArea;
	private JLabel labelGameMsg;
	private JTextField textField;
	private JButton btnOK;
	private JLabel label;
	private JLabel labelTimer;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoubleFrame frame = new DoubleFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void panelUtility(){
		panelUtility = new JPanel();
		panelUtility.setBackground(SystemColor.textHighlight);
		contentPane.add(panelUtility, BorderLayout.WEST);
		gbl_panelUtility = new GridBagLayout();
		gbl_panelUtility.columnWidths = new int[]{105, 0};
		gbl_panelUtility.rowHeights = new int[]{25, 0, 25, 0, 0, 0, 125, 0, 0};
		gbl_panelUtility.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelUtility.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelUtility.setLayout(gbl_panelUtility);
		//panelUtility.setLayout(null);
		
		btnBack = new JButton("返回开始界面");
		btnBack.setBackground(new Color(255, 255, 255));
		//btnBack.setBounds(10, 10, 105, 25);
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.anchor = GridBagConstraints.NORTH;
		gbc_btnBack.insets = new Insets(0, 0, 5, 0);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 1;
		panelUtility.add(btnBack, gbc_btnBack);
		
		btnSend = new JButton("发起匹配");
		//btnBegin.setBounds(40, 10, 80, 25);
		GridBagConstraints gbc_btnSend = new GridBagConstraints();
		gbc_btnSend.anchor = GridBagConstraints.NORTH;
		gbc_btnSend.insets = new Insets(0, 0, 5, 0);
		gbc_btnSend.gridx = 0;
		gbc_btnSend.gridy = 3;
		panelUtility.add(btnSend, gbc_btnSend);
		
		btnReceive = new JButton("接收匹配");
		GridBagConstraints gbc_btnReceive = new GridBagConstraints();
		gbc_btnReceive.insets = new Insets(0, 0, 5, 0);
		gbc_btnReceive.gridx = 0;
		gbc_btnReceive.gridy = 4;
		panelUtility.add(btnReceive, gbc_btnReceive);
		
		btnExit = new JButton("退出该局");
		//btnExit.setBounds(70, 86, 80, 25);
		GridBagConstraints gbc_btnExit = new GridBagConstraints();
		gbc_btnExit.anchor = GridBagConstraints.NORTH;
		gbc_btnExit.insets = new Insets(0, 0, 5, 0);
		gbc_btnExit.gridx = 0;
		gbc_btnExit.gridy = 5;
		panelUtility.add(btnExit, gbc_btnExit);
		
//		btnSound = new JButton("声音");
//		//btnSound.setBounds(100, 294, 60, 25);
//		GridBagConstraints gbc_btnSound = new GridBagConstraints();
//		gbc_btnSound.gridx = 0;
//		gbc_btnSound.gridy = 7;
//		panelUtility.add(btnSound, gbc_btnSound);
	}

	
	public void panelGuess(){
		panelGuess = new JPanel();
		panelGuess.setBackground(new Color(255, 153, 153));
		panelGame.add(panelGuess, BorderLayout.SOUTH);
		gbl_panelGuess = new GridBagLayout();
		gbl_panelGuess.columnWidths = new int[]{50, 0, 0, 100, 0, 0};
		gbl_panelGuess.rowHeights = new int[]{5, 0, 0, 0};
		gbl_panelGuess.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0,Double.MIN_VALUE};
		gbl_panelGuess.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelGuess.setLayout(gbl_panelGuess);
		
		Font fontGuess = new Font("幼圆", Font.BOLD, 15);
		
		labelGameMsg = new JLabel("请输入所猜测的数字：");
		labelGameMsg.setFont(fontGuess);
		GridBagConstraints gbc_labelGameMsg = new GridBagConstraints();
		gbc_labelGameMsg.anchor = GridBagConstraints.EAST;
		gbc_labelGameMsg.gridwidth = 2;
		gbc_labelGameMsg.insets = new Insets(0, 0, 5, 5);
		gbc_labelGameMsg.gridx = 1;
		gbc_labelGameMsg.gridy = 1;
		panelGuess.add(labelGameMsg, gbc_labelGameMsg);
		
		label = new JLabel("计时");
		label.setFont(fontGuess);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 4;
		gbc_label.gridy = 1;
		panelGuess.add(label, gbc_label);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.NORTHEAST;
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		panelGuess.add(textField, gbc_textField);
		textField.setColumns(10);
		
		btnOK = new JButton("确定");
		GridBagConstraints gbc_btnOK = new GridBagConstraints();
		gbc_btnOK.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnOK.insets = new Insets(0, 0, 0, 5);
		gbc_btnOK.gridx = 2;
		gbc_btnOK.gridy = 2;
		panelGuess.add(btnOK, gbc_btnOK);
		
		labelTimer = new JLabel("0:0");
		labelTimer.setFont(fontGuess);
		GridBagConstraints gbc_labelTimer = new GridBagConstraints();
		gbc_labelTimer.gridx = 4;
		gbc_labelTimer.gridy = 2;
		panelGuess.add(labelTimer, gbc_labelTimer);
	}

	/**
	 * Create the frame.
	 */
	public DoubleFrame() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		labelTitle = new JLabel("双人模式");
		labelTitle.setBackground(new Color(255, 255, 255));
		labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitle.setFont(new Font("华文新魏", Font.BOLD, 20));
		contentPane.add(labelTitle, BorderLayout.NORTH);

		panelUtility();
		
		panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new CardLayout(0, 0));
		
		panelMessage = new JPanel();
		panelMessage.setBackground(SystemColor.inactiveCaption);
		panelCenter.add(panelMessage, "name_8175981268742");
		panelMessage.setLayout(null);
		//panelMessage.setLayout(new BorderLayout(0, 0));
		
		labelMessage = new JLabel("请发起匹配或接受匹配");
		labelMessage.setBounds(57, 134, 294, 24);
		labelMessage.setBackground(SystemColor.scrollbar);
		labelMessage.setFont(new Font("楷体", Font.BOLD, 20));
		labelMessage.setHorizontalAlignment(SwingConstants.CENTER);
		panelMessage.add(labelMessage);
		//panelMessage.add(labelMessage, BorderLayout.CENTER);
		
		panelGame = new JPanel();
		panelCenter.add(panelGame, "name_8276415775124");
		panelGame.setLayout(new BorderLayout(0, 0));

		panelGuess();
		
		textArea = new JTextArea();
		textArea.setBackground(new Color(153, 204, 255));
		panelGame.add(textArea, BorderLayout.CENTER);
		
		setLocationRelativeTo(null);
	}

	public JLabel getLabelTitle() {
		return labelTitle;
	}

	public void setLabelTitle(JLabel labelTitle) {
		this.labelTitle = labelTitle;
	}

	public JPanel getPanelUtility() {
		return panelUtility;
	}

	public void setPanelUtility(JPanel panelUtility) {
		this.panelUtility = panelUtility;
	}

	public GridBagLayout getGbl_panelUtility() {
		return gbl_panelUtility;
	}

	public void setGbl_panelUtility(GridBagLayout gbl_panelUtility) {
		this.gbl_panelUtility = gbl_panelUtility;
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}

	public JButton getBtnSend() {
		return btnSend;
	}

	public void setBtnSend(JButton btnSend) {
		this.btnSend = btnSend;
	}

	public JButton getBtnReceive() {
		return btnReceive;
	}

	public void setBtnReceive(JButton btnReceive) {
		this.btnReceive = btnReceive;
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

	public JPanel getPanelCenter() {
		return panelCenter;
	}

	public void setPanelCenter(JPanel panelCenter) {
		this.panelCenter = panelCenter;
	}

	public JPanel getPanelMessage() {
		return panelMessage;
	}

	public void setPanelMessage(JPanel panelMessage) {
		this.panelMessage = panelMessage;
	}

	public JPanel getPanelGame() {
		return panelGame;
	}

	public void setPanelGame(JPanel panelGame) {
		this.panelGame = panelGame;
	}

	public JLabel getLabelMessage() {
		return labelMessage;
	}

	public void setLabelMessage(JLabel labelMessage) {
		this.labelMessage = labelMessage;
	}

	public JPanel getPanelGuess() {
		return panelGuess;
	}

	public void setPanelGuess(JPanel panelGuess) {
		this.panelGuess = panelGuess;
	}

	public GridBagLayout getGbl_panelGuess() {
		return gbl_panelGuess;
	}

	public void setGbl_panelGuess(GridBagLayout gbl_panelGuess) {
		this.gbl_panelGuess = gbl_panelGuess;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public JLabel getLabelGameMsg() {
		return labelGameMsg;
	}

	public void setLabelGameMsg(JLabel labelGameMsg) {
		this.labelGameMsg = labelGameMsg;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JButton getBtnOK() {
		return btnOK;
	}

	public void setBtnOK(JButton btnOK) {
		this.btnOK = btnOK;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public JLabel getLabelTimer() {
		return labelTimer;
	}

	public void setLabelTimer(JLabel labelTimer) {
		this.labelTimer = labelTimer;
	}

	

}
