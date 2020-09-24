package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import control.DB;

public class RecordDaoImp implements RecordDao{

	public RecordDaoImp(){}
	
	@Override
	public boolean updateRecord(String mode,String time) {
		// TODO Auto-generated method stub
		Connection conn = DB.GetConn();
		boolean ret = false;
		
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("update record set rtime = ? where rmode like ?");
			//调用预编译对象的setXxx方法，给？号赋值
			pstam.setString(1,time);
			pstam.setString(2,mode);
			//执行操作，返回结果
			int rs = pstam.executeUpdate();
			//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中，所有对象放到集合中
			if(rs>0)ret = true;
			System.out.println("更新"+rs+"条记录");
		} catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("更新记录出错了.错误信息是 ：" + e.getMessage());
			e.printStackTrace();
		}finally {
			if(pstam !=null)
				DB.closeStatement(pstam);
			if(conn!=null){
				DB.closeDb(conn);
			}
		}
		//返回结果
		return ret;
	}

	@Override
	public Record queryRecord(String mode) {
		// TODO Auto-generated method stub
		Connection conn = DB.GetConn();

		//声明变量，用于保存查询结果
		Record r = null;
		
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		try {
			
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select * from record where rmode like ?");
			//调用预编译对象的setXxx方法，给？号赋值
			pstam.setString(1,mode);
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中，所有对象放到集合中
			while(rs.next()){
				//创建用户对象，用于封装当前游标中的各个字段的值
				r = new Record();
				r.setMode(rs.getString("rmode"));
				r.setTime(rs.getString("rtime"));
				//r.setName(rs.getString("rname"));
				System.out.println("查询到单条记录");
			}
		} catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("查询单条记录出错了.错误信息是 ：" + e.getMessage());
			e.printStackTrace();
		}finally {
			if(pstam !=null)
				DB.closeStatement(pstam);
			if(rs != null){
				DB.closeResultSet(rs);
			}
			if(conn!=null){
				DB.closeDb(conn);
			}
		}
		//返回查询结果集
		return r;
	}

	@Override
	public ArrayList<Record> queryAll() {
		// TODO Auto-generated method stub
		Connection conn = DB.GetConn();
		
		//声明变量，用于保存查询结果
		ArrayList<Record> rlist = new ArrayList<Record>();
	
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		try {
			
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select * from record");
			
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中，所有对象放到集合中
			while(rs.next()){
				//创建用户对象，用于封装当前游标中的各个字段的值
				Record r = new Record();
				r.setMode(rs.getString("rmode"));
				r.setTime(rs.getString("rtime"));
				//r.setName(rs.getString("rname"));
				//将对象放入集合中
				rlist.add(r);
			}
			System.out.println("查询到"+rlist.size()+"条记录");
		} catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("查询全部记录出错了.错误信息是 ：" + e.getMessage());
			e.printStackTrace();

		}finally {
			if(pstam !=null)
				DB.closeStatement(pstam);
			if(rs != null){
				DB.closeResultSet(rs);
			}
			if(conn!=null){
				DB.closeDb(conn);
			}
		}
		//返回查询结果集
		return rlist;
	}

}
