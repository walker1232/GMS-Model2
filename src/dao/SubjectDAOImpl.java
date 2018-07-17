package dao;

import java.util.List;

import domain.SubjectBean;

public class SubjectDAOImpl implements SubjectDAO{
	private static SubjectDAO instance = new SubjectDAOImpl();
	public static SubjectDAO getinstance() {return instance;}
	private SubjectDAOImpl() {}
	@Override
	public void insertSubject(SubjectBean subject) {
		System.out.println(subject);
	}

	@Override
	public List<SubjectBean> selectAllSubjectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectBean> selectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubjectBean selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countSubject() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateSubject(SubjectBean subject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSubject(SubjectBean subject) {
		// TODO Auto-generated method stub
		
	}

}
