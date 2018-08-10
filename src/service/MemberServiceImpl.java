package service;

import java.util.List;
import java.util.Map;

import dao.MemberDAOImpl;
import domain.MemberBean;

public class MemberServiceImpl implements MemberService{
	private static MemberService instance = new MemberServiceImpl();
	public static MemberService getinstance() {return instance;}
	private MemberServiceImpl() {}
	@Override
	public void create(MemberBean member) {
		System.out.println("3.MemberDAOImpl 호출");
		MemberDAOImpl.getinstance().insert(member);
		
	}
	@Override
	public List<MemberBean> search(Map<?, ?> param) {
		System.out.println("5.searchImple : "+ param);
		return MemberDAOImpl.getinstance().selectSome(param);
	}
	@Override
	public MemberBean retrieve(String id) {
		MemberDAOImpl.getinstance().selectOne(id);
		return null;
	}
	@Override
	public int count() {
		
		return MemberDAOImpl.getinstance().count();
	}
	@Override
	public void modify(Map<?, ?> param) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void remove(MemberBean member) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean login(MemberBean member) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	

}