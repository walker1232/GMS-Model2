package dao;

import java.util.List;

import domain.*;

public interface ExamDAO {
	public void insertExam(ExamBean team);
	public List<ExamBean> selectAllExamList();
	public List<ExamBean> selectExamByWord(String word);
	public ExamBean selectExamById(String id);
	public int countExam();
	public void updateExam(ExamBean team);
	public void deleteExam(ExamBean team);
}
