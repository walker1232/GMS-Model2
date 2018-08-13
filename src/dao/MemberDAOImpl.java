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
import template.*;
/*<!-- "oracle.jdbc.driver.OracleDriver" -->
<!-- "jdbc:oracle:thin:@localhost:1521:xe" -->
<!-- "kkk" -->
<!-- "a" -*/
public class MemberDAOImpl implements MemberDAO{
	private static MemberDAO instance = new MemberDAOImpl();
	public static MemberDAO getinstance() {return instance;}
	private QueryTemplate q;
	private MemberDAOImpl() {}

	@Override
	public void insert(MemberBean member) {
		System.out.println("DAO에서의 member "+member);
		q = new AddQuery();
		Map<String, Object> param = new HashMap<>();
		param.put("member", member);
		q.play(param);
		
	}

	@Override
	public List<MemberBean> selectSome(Map<?, ?> param) {
		/*System.out.println("6. 서비스임플로부터 넘어온 param : "+ param);*/
		//List<MemberBean> list = new ArrayList<>();
		System.out.println("DAO에서의 param: "+ param);
		q = new SearchQuery();
		q.play(param);
		/*for(Object s : q.getList()) {
			list.add((MemberBean) s);
		}*/
		System.out.println("DAO에서 리턴 직전 "+(List<MemberBean>)(Object)q.getList());
		return (List<MemberBean>)(Object)q.getList();
	}

	@Override
	public MemberBean selectOne(String id) {
		System.out.println("DAO에서의 아이디 "+id);
		q = new RetrieveQuery();
		Map<String, Object> param = new HashMap<>();
		param.put("memid", id);
		q.play(param);
		System.out.println("DAO에서 리턴 직전  "+(MemberBean)q.getO());
		return (MemberBean)q.getO();
	}

	@Override
	public int count() {
		System.out.println("DAO count 진입");
		q = new CountQuery();
		q.play();
		System.out.println("DAO에서의 카운트: "+ q.getNumber());
		return q.getNumber();
	}

	@Override
	public void update(Map<?, ?> param) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(MemberBean member) {
		System.out.println("DAO에서 받은 삭제 정보 "+member);
		q = new RemoveQuery();
		Map<String, Object> param = new HashMap<>();
		param.put("member", member);
		q.play(param);
	}

	@Override
	public MemberBean login(MemberBean member) {
		System.out.println("DAO에서의 로그인 정보 "+member);
		q = new LoginQuery();
		Map<String, Object> param = new HashMap<>();
		param.put("login", member);
		q.play(param);
		return (MemberBean)q.getO();
	}
	


	

}