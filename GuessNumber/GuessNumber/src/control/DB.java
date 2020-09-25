package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	private final static String Driver ="oracle.jdbc.driver.OracleDriver";				//驱动
	private final static String url = "jdbc:oracle:thin:@localhost:1521:xe";	//URL路径
	private final static String SUERNAME = "guest";		//账号
	private final static String PASSWORD = "systems";	//密码
	//final static String TABLE = "record";     //数据表名
	/**
	 * 构造方法 链接数据库
	 */
	public static Connection GetConn(){
		try {
			Class.forName(Driver);
			Connection connection = DriverManager.getConnection(url,SUERNAME,PASSWORD);
			if(connection!=null){
				//System.out.println("数据库链接成功");
			}
			return connection;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库驱动不存在");
			System.out.println(e.getMessage());
		}catch(SQLException e){
			System.out.println("数据库连接创建不成功");
			System.out.println(e.getMessage());
		}
		return null;	
		
	}
	
	/**
	 * 构造方法 链接数据库 
	 * @param url ：URL	, 
	 * @param Driver : 驱动  , 
	 * @param SUERNAME ： 用户名  , 
	 * @param PASSWORD ：密码
	 */
	public static Connection GetConn(String url,String Driver,String SUERNAME,String PASSWORD){
		try {
			Class.forName(Driver);
			Connection connection = DriverManager.getConnection(url,SUERNAME,PASSWORD);
			return connection;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库驱动不存在");
			System.out.println(e.getMessage());
		}catch(SQLException e){
			System.out.println("数据库连接创建不成功");
			System.out.println(e.getMessage());
		}
		return null;		
	}
	
	
	
	
	/**
	 * 关闭数据库connection
	 * @param conn : 所需关闭的Connection
	 */
	public static void closeDb(Connection conn){
		if(conn!=null){
			try {
				conn.close();
				//System.out.println("数据库关闭成功");
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println("关闭数据库出错！");
				System.out.println(e.getMessage());
			}
		}
	}
	
	/**
	 * 关闭Statement
	 * @param st : 所需关闭的Statement
	 */
	public static void closeStatement(Statement st){
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println("关闭语句出错！");
				System.out.println(e.getMessage());
			}
		}
	}
	
	/**
	 * 关闭ResultSet
	 * @param pst : 所需关闭的ResultSet
	 */
	public static void closeStatement(ResultSet pst){
		if(pst!=null){
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println("关闭语句出错！");
				System.out.println(e.getMessage());
			}
		}
	}
	
	/**
	 * 关闭ResultSet
	 * @param rs : 所需关闭的ResultSet
	 */
	public static void closeResultSet(ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println("关闭结果集出错！");
				System.out.println(e.getMessage());
			}
		}
	}
}
