package dao;

import java.util.List;

import domain.*;

public interface SubjectDAO {
	public void insertSubject(SubjectBean subject);
	public List<SubjectBean> selectAllSubjectList();
	public List<SubjectBean> selectByName(String name);
	public SubjectBean selectById(String id);
	public int countSubject();
	public void updateSubject(SubjectBean subject);
	public void deleteSubject(SubjectBean subject);
}
