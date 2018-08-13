package template;

import java.sql.SQLException;

import enums.MemberQuery;

public class RemoveQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql", MemberQuery.DELETE.toString());
		
	}

	@Override
	void startPlay() {
		try {
			pstmt.setString(1, (String)map.get("memid"));
			pstmt.setString(2, (String)map.get("pass"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	void endPlay() {
		// TODO Auto-generated method stub
		
	}

}
