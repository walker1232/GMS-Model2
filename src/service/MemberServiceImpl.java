package service;

import java.util.List;

import dao.MemberDAOImpl;
import domain.MemberBean;

public class MemberServiceImpl implements MemberService{
	private static MemberService instance = new MemberServiceImpl();
	public static MemberService getinstance() {return instance;}
	private MemberServiceImpl() {}
	
	
	
	@Override
	public void createMember(MemberBean member) {
		MemberDAOImpl.getinstance().insertMember(member);
		
	}

	@Override
	public void updateMember(MemberBean member) {
		MemberDAOImpl.getinstance().updateMember(member);
		
	}

	@Override
	public void deleteMember(MemberBean member) {
		MemberDAOImpl.getinstance().deleteMember(member);
		
	}
	@Override
	public List<MemberBean> listMember() {
		/*List<MemberBean> memList = null;
		memList = MemberDAOImpl.getinstance().selectAllMemberlist();
		return memList;*/
		
		return MemberDAOImpl.getinstance().selectAllMemberlist();
	}
	@Override
	public List<MemberBean> searchByName(String name) {
		/*List<MemberBean> someName = null;
		someName = MemberDAOImpl.getinstance().selectMemberByName(name);*/
		return MemberDAOImpl.getinstance().selectMemberByName(name);
	}
	@Override
	public MemberBean searchById(String id) {
		/*MemberBean someId = null;
		someId = MemberDAOImpl.getinstance().selectById(id);*/
		/*MemberDAOImpl.getinstance().selectById(id);*/
		return MemberDAOImpl.getinstance().selectById(id);
	}
	@Override
	public int countMember() {
		
		return MemberDAOImpl.getinstance().countMember();
	}
	@Override
	public boolean login(MemberBean member) {
		return (MemberDAOImpl.getinstance().login(member)!=null);
	}

}
