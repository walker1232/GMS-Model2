package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.MemberQuery;
import factory.DatabaseFactory;

public class AddQuery extends QueryTemplate{

	@Override
	void initialize() {
		System.out.println("AddQuery 시작 진입");
		map.put("sql", MemberQuery.ADD.toString());
		System.out.println(map.get("sql"));
	}
	
	@Override
	void startPlay() {
		try {
			pstmt = DatabaseFactory.createDatabase2(map).getConnection().prepareStatement((String)map.get("sql"));
			MemberBean member = (MemberBean)map.get("member");
			pstmt.setString(1, (String)member.getMemID());
			pstmt.setString(2, (String)member.getTeamID());
			pstmt.setString(3, (String)member.getName());
			pstmt.setString(4, (String)member.getSsn());
			pstmt.setString(5, (String)member.getAge());
			pstmt.setString(6, (String)member.getRoll());
			pstmt.setString(7, (String)member.getPassword());
			pstmt.setString(8, (String)member.getSubject());
			pstmt.setString(9, (String)member.getGender());
			System.out.println("@@@@@@@@@"+member.getMemID());
			System.out.println("@@@@@@@@@"+member.getTeamID());
			System.out.println("@@@@@@@@@"+member.getName());
			System.out.println("@@@@@@@@@"+member.getSsn());
			System.out.println("@@@@@@@@@"+member.getAge());
			System.out.println("@@@@@@@@@"+member.getRoll());
			System.out.println("@@@@@@@@@"+member.getPassword());
			System.out.println("@@@@@@@@@"+member.getSubject());
			System.out.println("@@@@@@@@@"+member.getGender());
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			MemberBean mem = null;
			while(rs.next()) {
				mem = new MemberBean();
				mem.setMemID(rs.getString("MEMID"));
				mem.setTeamID(rs.getString("TEAMID"));
				mem.setName(rs.getString("NAME"));
				mem.setSsn(rs.getString("SSN"));
				mem.setAge(rs.getString("AGE"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setSubject(rs.getString("SUBJECT"));
				mem.setGender(rs.getString("GENDER"));
				System.out.println(mem);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
