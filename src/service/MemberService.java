package service;
import java.util.List;
import java.util.Map;

import domain.MemberBean;
public interface MemberService {
	public void create(MemberBean member);
	public List<MemberBean> search(Map<?,?>param);	// ?는 와일드 카드 무언가 하나라는 의미를 갖는다
	public MemberBean retrieve(String id);
	public int count();
	public void modify(Map<?,?>param);
	public void remove(MemberBean member);
	public boolean login(MemberBean member);
}
