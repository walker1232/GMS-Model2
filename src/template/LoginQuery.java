package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.MemberQuery;

public class LoginQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql", MemberQuery.LOGIN.toString());
		
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
		try {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				o = (MemberBean)map.get("login");
				((MemberBean)o).setMemID(rs.getString("MEMID"));
				((MemberBean)o).setPassword(rs.getString("PASSWORD"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
