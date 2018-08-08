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
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<MemberBean> search(Map<?, ?> param) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public MemberBean retrieve(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
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
