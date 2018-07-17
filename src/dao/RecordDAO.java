package dao;

import java.util.List;

import domain.*;

public interface RecordDAO {
	public void insertRecord(RecordBean record);
	public List<RecordBean> selectAllRecordList();
	public List<RecordBean> selectByName(String name);
	public RecordBean selectById(String id);
	public int countRecord();
	public void updateRecord(RecordBean record);
	public void deleteRecord(RecordBean record);
	public String selectFirstRowNum();
}
