package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.MemberBean;
import enums.Domain;
import enums.MemberQuery;
import enums.Vendor;
import factory.DatabaseFactory;
import pool.DBConstant;
import template.PstmtQuery;
import template.QueryTemplate;
/*<!-- "oracle.jdbc.driver.OracleDriver" -->
<!-- "jdbc:oracle:thin:@localhost:1521:xe" -->
<!-- "kkk" -->
<!-- "a" -*/
public class MemberDAOImpl implements MemberDAO{
	private static MemberDAO instance = new MemberDAOImpl();
	public static MemberDAO getinstance() {return instance;}
	
	private MemberDAOImpl() {}

	@Override
	public void insert(MemberBean member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MemberBean> selectSome(Map<?, ?> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberBean selectOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Map<?, ?> param) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(MemberBean member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemberBean login(MemberBean member) {
		// TODO Auto-generated method stub
		return null;
	}
	


	

}
