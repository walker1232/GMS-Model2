package service;

import java.util.List;

import dao.ExamDAOImpl;
import dao.RecordDAOImpl;
import dao.SubjectDAOImpl;
import domain.ExamBean;
import domain.RecordBean;
import domain.SubjectBean;

public class ExamServiceImpl implements ExamService{
	private static ExamService instance = new ExamServiceImpl();
	public static ExamService getinstance() {return instance;}
	private ExamServiceImpl() {}
	@Override
	public void createExam(ExamBean bean) {
		System.out.println(bean);
		System.out.println(bean.getScore());
		String arr[] = bean.getScore().split("/");
		String temp = "";
		for(int i = 0 ; i < arr.length; i++) {
			temp += arr[i]+" ";
		}
		System.out.println(temp);
		
		// 과목SEQ, 성적표 SEQ 각각 null 인것을 해결
		bean.setScore(bean.getScore().split("/")[0]);
		bean.setSubSeq(SubjectDAOImpl.getinstance().selectByName("JAVA").get(0).getSubSeq());
		RecordBean rec = new RecordBean();
		rec.setGrade("B");
		rec.setAvg("80");
		RecordDAOImpl.getinstance().insertRecord(rec);
		bean.setRecordSeq(RecordDAOImpl.getinstance().selectFirstRowNum());
		
		/* 풀이
		bean.setScore(bean.getScore().split("/")[0]);
		bean.setSubSeq(SubjectDAOImpl.getinstance().selectByName("JAVA").get(0).getSubSeq()); 루프를 이용하면 selectByName(subName[i]).get(i).getSubSeq()) 처럼 사용가능
		RecordBean rec1 = new RecordBean();
		rec1.setGrade("B");
		rec1.setAvg("80");
		RecordDAOImpl.getinstance().insertRecord(rec1);
		bean.setRecordSeq(RecordDAOImpl.getinstance().selectFirstRowNum());
		*/
		
		
		
		
		ExamDAOImpl.getinstance().insertExam(bean);
	}

	@Override
	public void updateExam(ExamBean exam) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteExam(ExamBean exam) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<ExamBean> listExam() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ExamBean> searchByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ExamBean searchById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countExam() {
		// TODO Auto-generated method stub
		return 0;
	}

}
