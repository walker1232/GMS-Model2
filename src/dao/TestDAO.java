package dao;
import java.sql.*;
import domain.*;
import pool.DBConstant;

import java.util.*;
public class TestDAO {
	private static TestDAO instance = new TestDAO();
	public static TestDAO getInstance() {return instance;}
	private TestDAO() {}
	public List<String> getSsnList() {
		List<String> memList = new ArrayList<>();
		try {
			Class.forName(DBConstant.ORACLE_DRIVER);
			Connection conn = DriverManager.getConnection(DBConstant.CONNECTION_URL,
														  DBConstant.USER_NAME,DBConstant.PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = String.format("SELECT AGE	"+ "	FROM MEMBER		");
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				//memList = new ArrayList<>();
				memList.add(rs.getString("AGE"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memList;
		
	}
	
}