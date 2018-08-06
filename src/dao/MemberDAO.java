package dao;

import java.util.List;
import java.util.Map;

import domain.*;

public interface MemberDAO {
	public void insertMember(MemberBean member);
	public List<MemberBean> selectAllMemberlist();
	public List<MemberBean> selectList(Map<?,?>param);
	public List<MemberBean> selectMemberByName(String name);
	public MemberBean selectById(String id);
	public int countMember();
	public void updateMember(MemberBean member);
	public void deleteMember(MemberBean member);
	public MemberBean login(MemberBean member);
}
