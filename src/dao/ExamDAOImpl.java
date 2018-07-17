package dao;

import java.util.List;

import domain.ExamBean;

public class ExamDAOImpl implements ExamDAO{
	private static ExamDAO instance = new ExamDAOImpl();
	public static ExamDAO getinstance() {return instance;}
	private ExamDAOImpl() {}
	@Override
	public void insertExam(ExamBean bean) {
		System.out.println("ok");
		System.out.println(bean.getExamSeq());
	}

	@Override
	public List<ExamBean> selectAllExamList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExamBean> selectExamByWord(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExamBean selectExamById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countExam() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateExam(ExamBean team) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteExam(ExamBean team) {
		// TODO Auto-generated method stub
		
	}

}
