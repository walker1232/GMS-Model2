package dao;

import java.util.List;

import domain.ProjectTeamBean;

public class ProjectTeamDAOImpl implements ProjectTeamDAO{
	private static ProjectTeamDAO instance = new ProjectTeamDAOImpl();
	public static ProjectTeamDAO getinstance() {return instance;}
	private ProjectTeamDAOImpl() {}
	@Override
	public void insertProjectTeam(ProjectTeamBean team) {
		System.out.println(team);
	}

	@Override
	public List<ProjectTeamBean> selectAllTeamlist() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProjectTeamBean> selectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectTeamBean selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countProjectTeam() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateAccount(ProjectTeamBean account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccount(ProjectTeamBean account) {
		// TODO Auto-generated method stub
		
	}

}
