package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.MemberQuery;

public class RetrieveQuery extends QueryTemplate{

	@Override
	void initialize() {
		System.out.println("리트리브 쿼리 안에서의 아이디 "+map.get("memid"));
		map.put("sql", MemberQuery.RETRIEVE.toString());
		System.out.println(map.get("sql"));
	}

	@Override
	void startPlay() {
		try {
			System.out.println("STARTPLAY에서의 정보 "+map.get("memid"));
			pstmt.setString(1, (String)map.get("memid"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				o = new MemberBean();
				((MemberBean)o).setAge(rs.getString("AGE"));
				((MemberBean)o).setGender(rs.getString("GENDER"));
				((MemberBean)o).setMemID(rs.getString("MEMID"));
				((MemberBean)o).setName(rs.getString("NAME"));
				((MemberBean)o).setPassword(rs.getString("PASSWORD"));
				((MemberBean)o).setRoll(rs.getString("ROLL"));
				((MemberBean)o).setSsn(rs.getString("SSN"));
				((MemberBean)o).setTeamID(rs.getString("TEAMID"));
				System.out.println(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
