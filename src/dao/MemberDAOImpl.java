package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import domain.MemberBean;
import enums.Domain;
import enums.MemberQuery;
import enums.Vendor;
import factory.DatabaseFactory;
import pool.DBConstant;
import template.PstmtQuery;
import template.QueryTemplate;
/*<!-- "oracle.jdbc.driver.OracleDriver" -->
<!-- "jdbc:oracle:thin:@localhost:1521:xe" -->
<!-- "kkk" -->
<!-- "a" -*/
public class MemberDAOImpl implements MemberDAO{
	private static MemberDAO instance = new MemberDAOImpl();
	public static MemberDAO getinstance() {return instance;}
	
	private MemberDAOImpl() {
		
	}
	
	@Override
	public void insertMember(MemberBean member) {
		try {
				DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USER_NAME, DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeUpdate(String.format(MemberQuery.INSERT_MEMBER.toString(), member.getMemID(), 
																					   member.getPassword(), 
																					   member.getName(), 
																					   member.getSsn(),
																					   member.getTeamID(),
																					   member.getAge(),
																					   member.getRoll(),
																					   member.getGender()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MemberBean> selectAllMemberlist() {
		List<MemberBean> memList = new ArrayList<>();
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USER_NAME, DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(MemberQuery.SELECT_ALL.toString());
			MemberBean mem = null;
			while(rs.next()) {
				mem = new MemberBean();
				mem.setAge(rs.getString("AGE"));
				mem.setMemID(rs.getString("MEMID"));
				mem.setName(rs.getString("NAME"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setSsn(rs.getString("SSN"));
				mem.setTeamID(rs.getString("TEAMID"));
				mem.setGender(rs.getString("GENDER"));
				memList.add(mem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(countMember()==memList.size()) {
			/*System.out.println("전체 리스트 인원 호출 성공\n");*/
		}
		return memList;
	}

	@Override
	public List<MemberBean> selectMemberByName(String name) {
		QueryTemplate q = new PstmtQuery();
		List<MemberBean> list = new ArrayList<>();
		HashMap<String, Object> map = new HashMap<>();
		map.put("column", name.split("/")[0]);
		map.put("value", name.split("/")[1]);
		map.put("table", Domain.MEMBER);
		System.out.println("이름 :"+name);
		q.play(map);
		for(Object s: q.getList()) {
			list.add((MemberBean)s);
		}
		return list;
	}

	@Override
	public MemberBean selectById(String id) {
		MemberBean mem = null;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USER_NAME, DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(String.format(MemberQuery.SELECT_ID.toString(), id));
			while(rs.next()) {
				mem = new MemberBean();
				mem.setAge(rs.getString("AGE"));
				mem.setMemID(rs.getString("MEMID"));
				mem.setName(rs.getString("NAME"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setSsn(rs.getString("SSN"));
				mem.setTeamID(rs.getString("TEAMID"));
				mem.setGender(rs.getString("GENDER"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return mem;
	}

	@Override
	public int countMember() {
		int count = 0;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USER_NAME, DBConstant.PASSWORD)
			.getConnection()
			.createStatement()
			.executeQuery(MemberQuery.COUNT_MEMBER.toString());
			while(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public void updateMember(MemberBean member) {
		System.out.println("업데이트"+ member.getPassword());
		System.out.println("업데이트"+ member.getMemID());
		try {
			
			DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USER_NAME, DBConstant.PASSWORD)
			.getConnection()
			.createStatement()
			.executeUpdate(String.format(MemberQuery.UPDATE_MEMBER.toString()
					, member.getPassword()
					, member.getTeamID()
					, member.getRoll()
					, member.getMemID()));
			System.out.println("완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteMember(MemberBean member) {
		try {
			DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USER_NAME, DBConstant.PASSWORD)
			.getConnection()
			.createStatement()
			.executeUpdate(String.format(MemberQuery.DELETE_MEMBER.toString(), member.getMemID(), member.getPassword()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public MemberBean login(MemberBean member) {
		MemberBean m = null;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USER_NAME, DBConstant.PASSWORD)
					.getConnection().createStatement().executeQuery(String.format(MemberQuery.LOGIN.toString(), member.getMemID(), member.getPassword()));
			while(rs.next()) {
					m = new MemberBean();
					m.setMemID(rs.getString("MEMID"));
					m.setTeamID(rs.getString("TEAMID"));
					m.setName(rs.getString("NAME"));
					m.setSsn(rs.getString("SSN"));
					m.setRoll(rs.getString("ROLL"));
					m.setPassword(rs.getString("PASSWORD"));
				};
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}

}
