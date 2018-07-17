package dao;
import java.util.List;
import domain.*;
public interface ProjectTeamDAO {
	public void insertProjectTeam(ProjectTeamBean team);
	public List<ProjectTeamBean> selectAllTeamlist();
	public List<ProjectTeamBean> selectByName(String name);
	public ProjectTeamBean selectById(String id);
	public int countProjectTeam();
	public void updateAccount(ProjectTeamBean account);
	public void deleteAccount(ProjectTeamBean account);
}
