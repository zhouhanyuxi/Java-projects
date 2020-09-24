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
		
		//����Ԥ���������������������ڽ������ݿ����������
		PreparedStatement pstam = null;
		try {
			//�������Ӷ����prepareStatement�������õ�Ԥ������󣬸�ֵ��Ԥ����������
			pstam = conn.prepareStatement("update record set rtime = ? where rmode like ?");
			//����Ԥ��������setXxx�����������Ÿ�ֵ
			pstam.setString(1,time);
			pstam.setString(2,mode);
			//ִ�в��������ؽ��
			int rs = pstam.executeUpdate();
			//�����ѯ�����Ϊ�գ���ȡ��������еĸ����ֶΣ���װ���û�����ĸ��������У����ж���ŵ�������
			if(rs>0)ret = true;
			System.out.println("����"+rs+"����¼");
		} catch (SQLException e) {
			//��������쳣������쳣��Ϣ
			System.out.println("���¼�¼������.������Ϣ�� ��" + e.getMessage());
			e.printStackTrace();
		}finally {
			if(pstam !=null)
				DB.closeStatement(pstam);
			if(conn!=null){
				DB.closeDb(conn);
			}
		}
		//���ؽ��
		return ret;
	}

	@Override
	public Record queryRecord(String mode) {
		// TODO Auto-generated method stub
		Connection conn = DB.GetConn();

		//�������������ڱ����ѯ���
		Record r = null;
		
		//���������������������ڱ������ݿ��ѯ���
		ResultSet rs = null;
		//����Ԥ���������������������ڽ������ݿ����������
		PreparedStatement pstam = null;
		try {
			
			//�������Ӷ����prepareStatement�������õ�Ԥ������󣬸�ֵ��Ԥ����������
			pstam = conn.prepareStatement("select * from record where rmode like ?");
			//����Ԥ��������setXxx�����������Ÿ�ֵ
			pstam.setString(1,mode);
			//����Ԥ��������executeQuery������ִ�в�ѯ���������ز�ѯ�������ֵ��������������
			rs = pstam.executeQuery();
			//�����ѯ�����Ϊ�գ���ȡ��������еĸ����ֶΣ���װ���û�����ĸ��������У����ж���ŵ�������
			while(rs.next()){
				//�����û��������ڷ�װ��ǰ�α��еĸ����ֶε�ֵ
				r = new Record();
				r.setMode(rs.getString("rmode"));
				r.setTime(rs.getString("rtime"));
				//r.setName(rs.getString("rname"));
				System.out.println("��ѯ��������¼");
			}
		} catch (SQLException e) {
			//��������쳣������쳣��Ϣ
			System.out.println("��ѯ������¼������.������Ϣ�� ��" + e.getMessage());
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
		//���ز�ѯ�����
		return r;
	}

	@Override
	public ArrayList<Record> queryAll() {
		// TODO Auto-generated method stub
		Connection conn = DB.GetConn();
		
		//�������������ڱ����ѯ���
		ArrayList<Record> rlist = new ArrayList<Record>();
	
		//���������������������ڱ������ݿ��ѯ���
		ResultSet rs = null;
		//����Ԥ���������������������ڽ������ݿ����������
		PreparedStatement pstam = null;
		try {
			
			//�������Ӷ����prepareStatement�������õ�Ԥ������󣬸�ֵ��Ԥ����������
			pstam = conn.prepareStatement("select * from record");
			
			//����Ԥ��������executeQuery������ִ�в�ѯ���������ز�ѯ�������ֵ��������������
			rs = pstam.executeQuery();
			//�����ѯ�����Ϊ�գ���ȡ��������еĸ����ֶΣ���װ���û�����ĸ��������У����ж���ŵ�������
			while(rs.next()){
				//�����û��������ڷ�װ��ǰ�α��еĸ����ֶε�ֵ
				Record r = new Record();
				r.setMode(rs.getString("rmode"));
				r.setTime(rs.getString("rtime"));
				//r.setName(rs.getString("rname"));
				//��������뼯����
				rlist.add(r);
			}
			System.out.println("��ѯ��"+rlist.size()+"����¼");
		} catch (SQLException e) {
			//��������쳣������쳣��Ϣ
			System.out.println("��ѯȫ����¼������.������Ϣ�� ��" + e.getMessage());
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
		//���ز�ѯ�����
		return rlist;
	}

}
