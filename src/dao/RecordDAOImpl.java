package dao;

import java.util.List;

import domain.RecordBean;

public class RecordDAOImpl implements RecordDAO{
	private static RecordDAO instance = new RecordDAOImpl();
	public static RecordDAO getinstance() {return instance;}
	private RecordDAOImpl() {}
	@Override
	public void insertRecord(RecordBean record) {
		System.out.println(record);
	}

	@Override
	public List<RecordBean> selectAllRecordList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RecordBean> selectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countRecord() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateRecord(RecordBean record) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRecord(RecordBean record) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public RecordBean selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String selectFirstRowNum() {
		// TODO Auto-generated method stub
		return null;
	}

}
