package command;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
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
		request.setAttribute("count", MemberServiceImpl.getinstance().countMember());
		super.execute();
	}
}
