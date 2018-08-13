package template;

import java.sql.SQLException;

import domain.MemberBean;
import enums.MemberQuery;

public class RemoveQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql", MemberQuery.DELETE.toString());
		System.out.println(map.get("sql"));
	}

	@Override
	void startPlay() {
		try {
			MemberBean member = (MemberBean) map.get("member");
			pstmt.setString(1, member.getMemID());
			pstmt.setString(2, member.getPassword());
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
