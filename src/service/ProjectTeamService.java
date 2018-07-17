package service;
import domain.*;
import java.util.List;
public interface ProjectTeamService {
	public void createProjectTeam(ProjectTeamBean team);
	public List<ProjectTeamBean> listTeam();
	public List<ProjectTeamBean> findTeamByName(String name);
	public ProjectTeamBean findById(String id);
	public int countProjectTeam();
	public void updateAccount(ProjectTeamBean account);
	public void deleteAccount(ProjectTeamBean account);
	
}
