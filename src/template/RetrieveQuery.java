package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.ImageBean;
import domain.MemberBean;
import enums.MemberQuery;

public class RetrieveQuery extends QueryTemplate{

	@Override
	void initialize() {
		System.out.println("리트리브 쿼리 안에서의 아이디 "+map.get("memid"));
		if(map.get("id") != null) {
			map.put("sql", MemberQuery.IMGRETRIEVE.toString());
			System.out.println(map.get("sql"));
		}else {
			map.put("sql", MemberQuery.RETRIEVE.toString());
			System.out.println(map.get("sql"));
		}
		
	}

	@Override
	void startPlay() {
		try {
			if(map.get("id") != null) {
				pstmt.setString(1, (String) map.get("id"));
			}else {
				System.out.println("STARTPLAY에서의 정보 "+map.get("memid"));
				pstmt.setString(1, (String)map.get("memid"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	void endPlay() {
		try {
			if(map.get("id") != null) {
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					o = new ImageBean();
					((ImageBean)o).setExtension(rs.getString("EXTENSION"));
					((ImageBean)o).setImgName(rs.getString("IMG_NAME"));
					((ImageBean)o).setMemId(rs.getString("MEMID"));
				}
			}else {
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
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
