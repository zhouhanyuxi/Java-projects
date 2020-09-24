package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	private final static String Driver ="oracle.jdbc.driver.OracleDriver";				//����
	private final static String url = "jdbc:oracle:thin:@localhost:1521:xe";	//URL·��
	private final static String SUERNAME = "guest";		//�˺�
	private final static String PASSWORD = "systems";	//����
	//final static String TABLE = "record";     //���ݱ���
	/**
	 * ���췽�� �������ݿ�
	 */
	public static Connection GetConn(){
		try {
			Class.forName(Driver);
			Connection connection = DriverManager.getConnection(url,SUERNAME,PASSWORD);
			if(connection!=null){
				//System.out.println("���ݿ����ӳɹ�");
			}
			return connection;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("���ݿ�����������");
			System.out.println(e.getMessage());
		}catch(SQLException e){
			System.out.println("���ݿ����Ӵ������ɹ�");
			System.out.println(e.getMessage());
		}
		return null;	
		
	}
	
	/**
	 * ���췽�� �������ݿ� 
	 * @param url ��URL	, 
	 * @param Driver : ����  , 
	 * @param SUERNAME �� �û���  , 
	 * @param PASSWORD ������
	 */
	public static Connection GetConn(String url,String Driver,String SUERNAME,String PASSWORD){
		try {
			Class.forName(Driver);
			Connection connection = DriverManager.getConnection(url,SUERNAME,PASSWORD);
			return connection;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("���ݿ�����������");
			System.out.println(e.getMessage());
		}catch(SQLException e){
			System.out.println("���ݿ����Ӵ������ɹ�");
			System.out.println(e.getMessage());
		}
		return null;		
	}
	
	
	
	
	/**
	 * �ر����ݿ�connection
	 * @param conn : ����رյ�Connection
	 */
	public static void closeDb(Connection conn){
		if(conn!=null){
			try {
				conn.close();
				//System.out.println("���ݿ�رճɹ�");
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println("�ر����ݿ����");
				System.out.println(e.getMessage());
			}
		}
	}
	
	/**
	 * �ر�Statement
	 * @param st : ����رյ�Statement
	 */
	public static void closeStatement(Statement st){
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println("�ر�������");
				System.out.println(e.getMessage());
			}
		}
	}
	
	/**
	 * �ر�ResultSet
	 * @param pst : ����رյ�ResultSet
	 */
	public static void closeStatement(ResultSet pst){
		if(pst!=null){
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println("�ر�������");
				System.out.println(e.getMessage());
			}
		}
	}
	
	/**
	 * �ر�ResultSet
	 * @param rs : ����رյ�ResultSet
	 */
	public static void closeResultSet(ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println("�رս��������");
				System.out.println(e.getMessage());
			}
		}
	}
}
