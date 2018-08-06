package service;
import java.util.List;
import java.util.Map;

import domain.MemberBean;
public interface MemberService {
	public void createMember(MemberBean member);
	public List<MemberBean> listMember();
	public List<MemberBean> getList(Map<?,?>param);	// ?는 와일드 카드 무언가 하나라는 의미를 갖는다
	public List<MemberBean> searchByName(String name);
	public MemberBean searchById(String id);
	public int countMember();
	public void updateMember(MemberBean member);
	public void deleteMember(MemberBean member);
	public boolean login(MemberBean member);
}
