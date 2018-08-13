package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.MemberQuery;

public class LoginQuery extends QueryTemplate{

	@Override
	void initialize() {
		System.out.println("로그인 쿼리 안에서의 정보 "+map.get("login"));
		map.put("sql", MemberQuery.LOGIN.toString());
		System.out.println(map.get("sql"));
	}

	@Override
	void startPlay() {
		try {
			MemberBean member = (MemberBean) map.get("login");
			pstmt.setString(1, member.getMemID());
			pstmt.setString(2, member.getPassword());
			System.out.println("스타트플레이 메소드에서의 정보 "+member.getMemID());
			System.out.println("스타트플레이 메소드에서의 정보 "+member.getPassword());
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
