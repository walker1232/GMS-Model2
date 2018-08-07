package command;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import service.MemberServiceImpl;

public class ListCommand extends Command{
	
	public ListCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		/*switch(Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
		System.out.println("회원목록 들어옴");
		List<MemberBean> memList = new ArrayList<>();
		memList = MemberServiceImpl.getinstance().listMember();
		for(MemberBean m : memList) {
			System.out.println(m);
		}
		//request.setAttribute("list", memList);
		request.setAttribute("list", MemberServiceImpl.getinstance().listMember());
		System.out.println("회원목록 출력 성공");
		break;
		case ADMIN:
			System.out.println("어드민에서 회원목록 들어옴");
			List<MemberBean> adminList = new ArrayList<>();
			adminList = MemberServiceImpl.getinstance().listMember();
			for(MemberBean m : adminList) {
				System.out.println(m);
			}
			request.setAttribute("list", MemberServiceImpl.getinstance().listMember());
			System.out.println("어드민에서 회원목록 출력 성공");
			break;
		default:
			break;
		}*/
		System.out.println("list 커맨드 들어옴");
		request.setAttribute("list", MemberServiceImpl.getinstance().listMember());
		/*request.setAttribute("count", MemberServiceImpl.getinstance().countMember());*/
		
		//int count = (int)request.getAttribute("count");
		//count = count % 5 > 0 ? count/5+1 : count/5;dd
		
		int count = 25;
		
		int beginPage = 1;
		int endPage = 0;
		if(count/5 < 6) {
			if(count%5 > 0) {
				endPage = count/5+1;
			}else {
				endPage = count/5;
			}
		}else {
			endPage = 5;
		}
		Map<String, Object> param = new HashMap<>();
		String beginRow = "1";
		String endRow = "5";
		param.put("beginRow", beginRow);
		param.put("endRow", endRow);
		System.out.println("param:"+beginRow);
		System.out.println("param:"+endRow);
		List<MemberBean> mems = MemberServiceImpl.getinstance().getList(param);
		request.setAttribute("count", count);
		request.setAttribute("beginPage", "1");
		request.setAttribute("endPage", endPage);
		request.setAttribute("list2", MemberServiceImpl.getinstance().getList(param));
		//request.setAttribute("end", end);
		//request.setAttribute("endPage", "count % 5 > 0 ? count/5+1 : count/5");
		super.execute();
	}
}
