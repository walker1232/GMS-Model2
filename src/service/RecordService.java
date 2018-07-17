package service;
import domain.*;
import java.util.List;
public interface RecordService {
	public void createRecord(RecordBean record);
	public List<RecordBean> listRecord();
	public List<RecordBean> findByName(String name);
	public int countRecord();
	public void updateRecord(RecordBean record);
	public void deleteRecord(RecordBean record);
	List<RecordBean> findByWord(String word);
}
