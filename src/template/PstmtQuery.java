package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.Domain;
import factory.DatabaseFactory;

public class PstmtQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql", String.format(
				" SELECT "
				+ ColumnFinder.find(Domain.MEMBER)
				+ " FROM %s "
				+ " WHERE %s "
				+ " LIKE ? ", map.get("table"), map.get("column")));
		
	}

	@Override
	void startPlay() {
		System.out.println("==============");
		System.out.println(map.get("sql"));
		try {
			pstmt = DatabaseFactory.createDatabase2(map).getConnection().prepareStatement((String)map.get("sql"));
			pstmt.setString(1, "%"+map.get("value").toString()+"%");
			System.out.println("스타트플레이 메소드 :" + "%"+map.get("value").toString()+"%");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	void endPlay() {
		System.out.println("-----endpaly");
		try {
			ResultSet rs = pstmt.executeQuery();
			MemberBean mem = null;
				while(rs.next()) {
					mem = new MemberBean();
					mem.setMemID(rs.getString("MEMID"));
					mem.setTeamID(rs.getString("TEAMID"));
					mem.setName(rs.getString("NAME"));
					mem.setAge(rs.getString("AGE"));
					mem.setGender(rs.getString("GENDER"));
					mem.setRoll(rs.getString("ROLL"));
					mem.setPassword(rs.getString("PASSWORD"));
					mem.setSsn(rs.getString("SSN"));
					list.add(mem);
				}
				System.out.println("list"+list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
