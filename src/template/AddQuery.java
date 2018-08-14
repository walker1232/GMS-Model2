package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.ImageBean;
import domain.MemberBean;
import enums.MemberQuery;
import factory.DatabaseFactory;

public class AddQuery extends QueryTemplate{

	@Override
	void initialize() {
		System.out.println("AddQuery 시작 진입");
		if(map.get("image")!=null) {
			map.put("sql", MemberQuery.IMGADD.toString());
			System.out.println(map.get("sql"));
		}else {
			map.put("sql", MemberQuery.ADD.toString());
			System.out.println(map.get("sql"));
		}
		
	}
	
	@Override
	void startPlay() {
		try {
			if(map.get("image")!=null) {
				ImageBean image = (ImageBean) map.get("image");
				pstmt.setString(1, image.getImgName());
				pstmt.setString(2, image.getExtension());
				pstmt.setString(3, image.getMemId());
			}else {
				pstmt = DatabaseFactory.createDatabase2(map).getConnection().prepareStatement((String)map.get("sql"));
				MemberBean member = (MemberBean)map.get("member");
				pstmt.setString(1, (String)member.getMemID());
				pstmt.setString(2, (String)member.getTeamID());
				pstmt.setString(3, (String)member.getName());
				pstmt.setString(4, (String)member.getSsn());
				pstmt.setString(5, (String)member.getAge());
				pstmt.setString(6, (String)member.getRoll());
				pstmt.setString(7, (String)member.getPassword());
				pstmt.setString(8, (String)member.getSubject());
				pstmt.setString(9, (String)member.getGender());

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	void endPlay() {
		try {
			if(map.get("image")!=null) {
				
				pstmt.executeQuery();
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
