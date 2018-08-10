package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.Domain;
import enums.MemberQuery;
import factory.Database;
import factory.DatabaseFactory;

public class PstmtQuery extends QueryTemplate{

	@Override
	void initialize() {
		switch((String)map.get("key")) {
		case "list":
			if(map.get("searchOption")!=null) {
				map.put("sql", MemberQuery.SEARCH.toString());
			}else {
				map.put("sql", MemberQuery.LIST.toString());
			}
			break;
		case "count":
			map.put("sql", MemberQuery.COUNT.toString());
			break;
		}
		/*if(map.get("column") != null) {
			map.put("sql", String.format(
					" SELECT "
					+ ColumnFinder.find(Domain.MEMBER)
					+ " FROM %s "
					+ " WHERE %s "
					+ " LIKE ? ", map.get("table"), map.get("column")));
		}*/
		
		
	}

	@Override
	void startPlay() {
		switch((String)map.get("key")) {
		case "list":
			/*System.out.println("pagenagin하는 템플릿 startPlay");
			System.out.println(map.get("sql"));*/
			if(map.get("searchOption")!=null) {
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
					/*System.out.println("StartPlay 안에서의 beginRow: "+ map.get("beginRow"));
					System.out.println("StartPlay 안에서의 endRow: "+ map.get("endRow"));*/
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			break;
		case "count":
			try {
				pstmt = DatabaseFactory.createDatabase2(map).getConnection().prepareStatement((String)map.get("sql"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		/*if(map.get("value")!=null) {
			System.out.println("==============");
			System.out.println(map.get("sql"));
			try {
				pstmt = DatabaseFactory.createDatabase2(map).getConnection().prepareStatement((String)map.get("sql"));
				pstmt.setString(1, "%"+map.get("value").toString()+"%");
				System.out.println("스타트플레이 메소드 :" + "%"+map.get("value").toString()+"%");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*/
		
		
	}

	@Override
	void endPlay() {
		System.out.println("-----endpaly");
		ResultSet rs;
		MemberBean mem;
		switch((String)map.get("key")) {
		case "list":
			try {
				rs = pstmt.executeQuery();
				mem = null;
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
		break;
		case "count":
			try {
				rs = pstmt.executeQuery();
				while(rs.next()) {
					list.add(rs.getInt("count"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		
		
	}
	
}
