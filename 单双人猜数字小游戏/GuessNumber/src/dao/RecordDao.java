package dao;

import java.util.ArrayList;

public interface RecordDao {
	public boolean updateRecord(String mode,String time);
	public Record queryRecord(String mode);
	public ArrayList<Record> queryAll();
}
