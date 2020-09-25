package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.Record;
import dao.RecordDaoImp;


public class RecordFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTable table;
	private JTableHeader head;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecordFrame frame = new RecordFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void table(){
		Font fontTable = new Font("��Բ", Font.PLAIN, 15);
		
		table = new JTable();
		table.setShowGrid(false);
		table.setFont(fontTable);
		table.setRowSelectionAllowed(false);
		table.setBackground(SystemColor.inactiveCaption);
		
		RecordDaoImp dao = new RecordDaoImp();
		ArrayList<Record> rlist = (ArrayList<Record>) dao.queryAll();
		Record s = new Record();
		Record d = new Record();
		if(rlist.size()==2){
			for(int i=0;i<2;i++){
				if(rlist.get(i).getMode().equals("sin")){
					s = rlist.get(i);
				}else{
					d = rlist.get(i);
				}
			}
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{"����", s.getTime()},
					{"˫��", d.getTime()},
				},
				new String[] {
					"ģʽ", "��ʱ"
				}
			));
		}else{
			System.out.println("���ɱ��δ��ѯ����¼");
			table.setModel(new DefaultTableModel(
					new Object[][] {
						{"����", "��"},
						{"˫��", "��"},
					},
					new String[] {
						"ģʽ", "��ʱ"
					}
				));
		}
		
		head=table.getTableHeader();
		head.setFont(fontTable);
		
		table.setRowHeight(30);
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(20);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//��Ԫ����Ⱦ��  
		tcr.setHorizontalAlignment(JLabel.CENTER);//������ʾ  
		table.setDefaultRenderer(Object.class, tcr);//������Ⱦ�� 
	}

	/**
	 * Create the frame.
	 */
	public RecordFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 150);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		table();
		
		contentPane.add(table,BorderLayout.CENTER);
		contentPane.add(head,BorderLayout.NORTH);

	}

}
