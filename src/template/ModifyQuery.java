package template;

import java.sql.SQLException;

import enums.MemberQuery;

public class ModifyQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql", String.format(MemberQuery.UPDATE.toString(), map.get("column")));
		System.out.println(map.get("sql"));
	}

	@Override
	void startPlay() {
		try {
			pstmt.setString(1, (String) map.get("value"));
			pstmt.setString(2, (String) map.get("id"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	void endPlay() {
		try {
			pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
