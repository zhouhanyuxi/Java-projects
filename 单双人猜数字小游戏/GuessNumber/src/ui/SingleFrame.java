package ui;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;



public class SingleFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private JPanel northPanel;
	private JButton startButton;
	private JButton stopButton;
	private JLabel levelLabel;
	private JLabel timingLabel;
	private JLabel timerLabel;
	
	private JPanel westPanel;
	private JButton backButton;
	private JButton recordButton;
	private JButton soundButton;
	
	private JPanel centerPanel;
	private JPanel gamePanel;
	private JButton okButton;
	private JLabel resultLabel;
	private JTextField guessTextField;
	private JPanel beginPanel;
	private JLabel beginLabel;
	
	private JPanel southPanel;
	private JLabel nameLabel;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SingleFrame frame = new SingleFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void northPanel(){
		//北面板
		northPanel = new JPanel();
		northPanel.setBackground(new Color(102, 153, 204));
		contentPane.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		levelLabel = new JLabel("单人模式");
		levelLabel.setFont(new Font("华文新魏", Font.BOLD, 20));
		northPanel.add(levelLabel);
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		northPanel.add(horizontalStrut_1);
		
		startButton = new JButton("开始游戏");
		northPanel.add(startButton);
		stopButton = new JButton("停止游戏");
		northPanel.add(stopButton);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		northPanel.add(horizontalStrut);

		Font fontTimer = new Font("幼圆", Font.BOLD, 15);

		timingLabel = new JLabel("计时");
		timingLabel.setFont(fontTimer);
		northPanel.add(timingLabel);		
		timerLabel = new JLabel();
		timerLabel.setFont(fontTimer);
		northPanel.add(timerLabel);
		timerLabel.setText("0:0");
	}
	
	public void westPanel(){
		westPanel = new JPanel();
		westPanel.setBackground(new Color(153, 204, 255));
		westPanel.setBorder(new EmptyBorder(3, 3, 3, 3));
		contentPane.add(westPanel, BorderLayout.WEST);		
		GridBagLayout gbl_westPanel = new GridBagLayout();
		gbl_westPanel.columnWidths = new int[]{81, 0};
		gbl_westPanel.rowHeights = new int[]{25, 0, 175, 0, 0};
		gbl_westPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_westPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		westPanel.setLayout(gbl_westPanel);
		
		backButton = new JButton("返回主界面");
		GridBagConstraints gbc_backButton = new GridBagConstraints();
		gbc_backButton.insets = new Insets(0, 0, 5, 0);
		gbc_backButton.gridx = 0;
		gbc_backButton.gridy = 1;
		westPanel.add(backButton, gbc_backButton);
		
//		soundButton = new JButton("声音设置");
//		GridBagConstraints gbc_soundButton = new GridBagConstraints();
//		gbc_soundButton.anchor = GridBagConstraints.NORTH;
//		gbc_soundButton.gridx = 0;
//		gbc_soundButton.gridy = 3;
//		westPanel.add(soundButton, gbc_soundButton);
	}
	
	public void centerPanel(){
		centerPanel = new JPanel();
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new CardLayout(0, 0));
		
		//游戏面板
		gamePanel = new JPanel();
		gamePanel.setBackground(new Color(255, 153, 153));
		centerPanel.add(gamePanel, "name_205006770175639");
		GridBagLayout gbl_gamePanel = new GridBagLayout();
		gbl_gamePanel.columnWidths = new int[]{50, 0, 0};
		gbl_gamePanel.rowHeights = new int[]{50, 0, 50, 0, 0, 0};
		gbl_gamePanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_gamePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gamePanel.setLayout(gbl_gamePanel);
		
		resultLabel = new JLabel("请输入所猜测的数字");
		resultLabel.setFont(new Font("幼圆", Font.BOLD, 15));
		GridBagConstraints gbc_resultLabel = new GridBagConstraints();
		gbc_resultLabel.fill = GridBagConstraints.BOTH;
		gbc_resultLabel.insets = new Insets(0, 0, 5, 0);
		gbc_resultLabel.gridx = 1;
		gbc_resultLabel.gridy = 1;
		gamePanel.add(resultLabel, gbc_resultLabel);
		
		guessTextField = new JTextField();
		guessTextField.setColumns(10);
		GridBagConstraints gbc_guessTextField = new GridBagConstraints();
		gbc_guessTextField.anchor = GridBagConstraints.WEST;
		gbc_guessTextField.fill = GridBagConstraints.VERTICAL;
		gbc_guessTextField.insets = new Insets(0, 0, 5, 0);
		gbc_guessTextField.gridx = 1;
		gbc_guessTextField.gridy = 3;
		gamePanel.add(guessTextField, gbc_guessTextField);
		
		okButton = new JButton("确定");
		GridBagConstraints gbc_okButton = new GridBagConstraints();
		gbc_okButton.anchor = GridBagConstraints.WEST;
		gbc_okButton.fill = GridBagConstraints.VERTICAL;
		gbc_okButton.gridx = 1;
		gbc_okButton.gridy = 4;
		gamePanel.add(okButton, gbc_okButton);
		gamePanel.setVisible(false);
		
		//开始面板
		beginPanel = new JPanel();
		beginPanel.setBackground(new Color(192, 192, 192));
		centerPanel.add(beginPanel, "name_205255963734140");
		beginPanel.setLayout(null);
		
		beginLabel = new JLabel("按开始游戏按钮开始游戏");
		beginLabel.setFont(new Font("幼圆", Font.BOLD, 15));
		beginLabel.setBounds(105, 90, 199, 26);
		beginPanel.add(beginLabel);
		beginPanel.setVisible(true);
	}
	
	/**
	 * Create the frame.
	 */
	public SingleFrame() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE );
		setBounds(300, 150, 550, 400);
		
		//内容面板
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//北面板
		northPanel();
		
		//西面板
		westPanel();
		
		//中面板
		centerPanel();

		setLocationRelativeTo(null);
	}

	public JPanel getNorthPanel() {
		return northPanel;
	}

	public void setNorthPanel(JPanel northPanel) {
		this.northPanel = northPanel;
	}

	public JButton getStartButton() {
		return startButton;
	}

	public void setStartButton(JButton startButton) {
		this.startButton = startButton;
	}

	public JButton getStopButton() {
		return stopButton;
	}

	public void setStopButton(JButton stopButton) {
		this.stopButton = stopButton;
	}

	public JLabel getLevelLabel() {
		return levelLabel;
	}

	public void setLevelLabel(JLabel levelLabel) {
		this.levelLabel = levelLabel;
	}

	public JLabel getTimingLabel() {
		return timingLabel;
	}

	public void setTimingLabel(JLabel timingLabel) {
		this.timingLabel = timingLabel;
	}

	public JLabel getTimerLabel() {
		return timerLabel;
	}

	public void setTimerLabel(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}

	public JPanel getWestPanel() {
		return westPanel;
	}

	public void setWestPanel(JPanel westPanel) {
		this.westPanel = westPanel;
	}

	public JButton getBackButton() {
		return backButton;
	}

	public void setBackButton(JButton backButton) {
		this.backButton = backButton;
	}

	public JButton getRecordButton() {
		return recordButton;
	}

	public void setRecordButton(JButton recordButton) {
		this.recordButton = recordButton;
	}

	public JButton getSoundButton() {
		return soundButton;
	}

	public void setSoundButton(JButton soundButton) {
		this.soundButton = soundButton;
	}

	public JPanel getCenterPanel() {
		return centerPanel;
	}

	public void setCenterPanel(JPanel centerPanel) {
		this.centerPanel = centerPanel;
	}

	public JPanel getGamePanel() {
		return gamePanel;
	}

	public void setGamePanel(JPanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public void setOkButton(JButton okButton) {
		this.okButton = okButton;
	}

	public JLabel getResultLabel() {
		return resultLabel;
	}

	public void setResultLabel(JLabel resultLabel) {
		this.resultLabel = resultLabel;
	}

	public JTextField getGuessTextField() {
		return guessTextField;
	}

	public void setGuessTextField(JTextField guessTextField) {
		this.guessTextField = guessTextField;
	}

	public JPanel getBeginPanel() {
		return beginPanel;
	}

	public void setBeginPanel(JPanel beginPanel) {
		this.beginPanel = beginPanel;
	}

	public JLabel getBeginLabel() {
		return beginLabel;
	}

	public void setBeginLabel(JLabel beginLabel) {
		this.beginLabel = beginLabel;
	}

	public JPanel getSouthPanel() {
		return southPanel;
	}

	public void setSouthPanel(JPanel southPanel) {
		this.southPanel = southPanel;
	}

	public JLabel getNameLabel() {
		return nameLabel;
	}

	public void setNameLabel(JLabel nameLabel) {
		this.nameLabel = nameLabel;
	}
	
}
