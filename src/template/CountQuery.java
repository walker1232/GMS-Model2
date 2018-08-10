package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import enums.MemberQuery;
import factory.DatabaseFactory;

public class CountQuery extends QueryTemplate{

	@Override
	void initialize() {
		System.out.println("카운트 쿼리 이니셜라이즈");
		map.put("sql", MemberQuery.COUNT.toString());
	}

	@Override
	void startPlay() {
		try {
			pstmt = DatabaseFactory.createDatabase2(map).getConnection().prepareStatement((String)map.get("sql"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	void endPlay() {
		ResultSet rs;
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				number = rs.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
