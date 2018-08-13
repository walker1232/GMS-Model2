package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.MemberQuery;
import factory.DatabaseFactory;

public class SearchQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql", (!map.containsKey("column"))? MemberQuery.LIST.toString() : MemberQuery.SEARCH.toString());
		/*if(map.get("searchOption")!=null) {
			map.put("sql", MemberQuery.SEARCH.toString());
		}else {
			map.put("sql", MemberQuery.LIST.toString());
		}*/
	}

	@Override
	void startPlay() {
		try {
			int i = 0;
			if(map.containsKey("column")) {
				i++;
				pstmt.setString(i, "%"+(String)map.get("searchWord").toString()+"%");
			}
			i++;
			pstmt.setString(i, (String)map.get("beginRow").toString());
			i++;
			pstmt.setString(i, (String)map.get("endRow").toString());
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*if(map.get("searchOption")!=null) {
			try {
				pstmt = DatabaseFactory.createDatabase2(map).getConnection().prepareStatement((String)map.get("sql"));
				pstmt.setString(1, (String)map.get("searchOption").toString());
				pstmt.setString(2, (String)map.get("searchWord").toString());
				pstmt.setString(3, (String)map.get("beginRow").toString());
				pstmt.setString(4, (String)map.get("endRow").toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				pstmt = DatabaseFactory.createDatabase2(map).getConnection().prepareStatement((String)map.get("sql"));
				pstmt.setString(1, (String)map.get("beginRow").toString());
				pstmt.setString(2, (String)map.get("endRow").toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
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
				mem.setAge(rs.getString("AGE"));
				mem.setGender(rs.getString("GENDER"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setSsn(rs.getString("SSN"));
				list.add(mem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
