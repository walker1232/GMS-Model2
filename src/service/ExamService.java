package service;
import domain.*;
import java.util.List;
public interface ExamService {
	public void createExam(ExamBean team);
	public List<ExamBean> listExam();
	public List<ExamBean> searchByName(String name);
	public ExamBean searchById(String id);
	public int countExam();
	public void updateExam(ExamBean team);
	public void deleteExam(ExamBean team);
}
