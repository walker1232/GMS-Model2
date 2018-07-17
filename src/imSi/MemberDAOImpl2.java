/*package imSi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import domain.MemberBean;
import enums.Vendor;
import factory.DatabaseFactory;
import pool.DBConstant;
<!-- "oracle.jdbc.driver.OracleDriver" -->
<!-- "jdbc:oracle:thin:@localhost:1521:xe" -->
<!-- "kkk" -->
<!-- "a" -
public class MemberDAOImpl2 implements MemberDAO{
	private static MemberDAO instance = new MemberDAOImpl2();
	public static MemberDAO getinstance() {return instance;}
	
	private MemberDAOImpl2() {
		
	}
	
	@Override
	public void insertMember(MemberBean member) {
		try {
				ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USER_NAME, DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(String.format("INSERT INTO member(MEM_ID, PASSWORD, NAME, SSN)	VALUES('%s', '%s', '%s', '%s')", member.getMemID(), member.getPassword(),member.getName(),member.getSsn()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<MemberBean> selectAllMemberlist() {
		List<MemberBean> memList = null;
		
		return memList;
	}

	@Override
	public List<MemberBean> selectMemberByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberBean selectById(String id) {
		MemberBean mem = null;
		
		
		return mem;
	}

	@Override
	public int countMember() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateMember(MemberBean member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMember(MemberBean member) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public MemberBean login(MemberBean member) {
		MemberBean m = null;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USER_NAME, DBConstant.PASSWORD)
					.getConnection().createStatement().executeQuery(String.format("SELECT MEM_ID MEMID ,	"
							+"	TEAM_ID TEAMID,	"
							+"	NAME,	"
							+"	AGE,	" 
							+"	ROLL,	"
							+"	PASSWORD 	PASS"
							+"	FROM MEMBER 	"
							+"	WHERE MEM_ID LIKE '%s' AND PASSWORD LIKE '%s'	", member.getMemID(), member.getPassword()));
			while(rs.next()) {
					m = new MemberBean();
					m.setMemID(rs.getString("MEMID"));
					m.setTeamID(rs.getString("TEAMID"));
					m.setName(rs.getString("NAME"));
					m.setSsn(rs.getString("SSN"));
					m.setRoll(rs.getString("ROLL"));
					m.setPassword(rs.getString("PASS"));
				};
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}

}
*/