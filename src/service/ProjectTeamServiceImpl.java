package service;

import java.util.List;
import java.util.ArrayList;

import domain.ProjectTeamBean;

public class ProjectTeamServiceImpl implements ProjectTeamService{
	private static ProjectTeamService instance = new ProjectTeamServiceImpl();
	public static ProjectTeamService getinstance() {return instance;}
	private ProjectTeamServiceImpl() {}
	List<ProjectTeamBean> listTeam;
	/*public ProjectTeamServiceImpl() {
		listTeam = new ArrayList<ProjectTeamBean>();
	}*/
	
	@Override
	public void createProjectTeam(ProjectTeamBean team) {
		team.setTeamID(team.teamID);
		
	}
	@Override
	public List<ProjectTeamBean> listTeam() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ProjectTeamBean> findTeamByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ProjectTeamBean findById(String id) {
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
