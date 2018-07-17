package service;

import java.util.List;
import java.util.ArrayList;
import domain.RecordBean;

public class RecordServiceImpl implements RecordService{
	private static RecordService instance = new RecordServiceImpl();
	public static RecordService getinstance() {return instance;}
	private RecordServiceImpl() {}
	List<RecordBean> listRecord;
	/*public RecordServiceImpl() {
		listRecord = new ArrayList<RecordBean>();
	}*/
	@Override
	public void createRecord(RecordBean record) {
		record.setRecordSeq(record.recordSeq);
		record.setAvg(record.avg);
		record.setGrade(record.grade);
	}

	@Override
	public void updateRecord(RecordBean record) {
		
	}

	@Override
	public void deleteRecord(RecordBean record) {
		
	}

	@Override
	public List<RecordBean> findByWord(String word) {
		List<RecordBean> temp = new ArrayList<RecordBean>();
		/*for(int i = 0; i < listRecord.size(); i++) {
			if(word.equals(listRecord.get(i).getGrade())) {
				temp.add(listRecord.get(i));
			}
		}*/
		return temp;
	}
	@Override
	public int countRecord() {
		return listRecord.size();
	}
	@Override
	public List<RecordBean> listRecord() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<RecordBean> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
