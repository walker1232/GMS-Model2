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
		System.out.println("6. 서비스임플로부터 넘어온 param : "+ param);
		QueryTemplate q = new PstmtQuery();
		List<MemberBean> list = new ArrayList<>();
		HashMap<String, Object> map = new HashMap<>();
		map.put("beginRow", param.get("beginRow"));
		map.put("endRow", param.get("endRow"));
		map.put("key", param.get("pageList"));
		System.out.println("7.시작행 beginRow : " + param.get("beginRow"));
		System.out.println("8.끝나는행 endRow : " + param.get("endRow"));
		q.play(map);
		for(Object s : q.getList()) {
			list.add((MemberBean) s);
		}
		System.out.println("10.MemberDAOImpl에 있는 list : "+ list);
		return list;
	}

	@Override
	public MemberBean selectOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		int count = 0;
		QueryTemplate q = new PstmtQuery();
		HashMap<String, Object>map = new HashMap<>();
		map.put("key", "count");
		q.play(map);
		count = q.getList().size();
		return count;
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