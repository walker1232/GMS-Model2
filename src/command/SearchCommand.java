package command;



import javax.servlet.http.HttpServletRequest;

import enums.Domain;
import service.MemberService;
import service.MemberServiceImpl;

public class SearchCommand extends Command{
	public SearchCommand(HttpServletRequest request) {
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
			System.out.println("----팀원 찿기 들어옴----");
			MemberServiceImpl.getinstance().searchByName("teamid");
			System.out.println("----팀원 찿기 성공----");
			break;
		default:
			break;
		}*/
		System.out.println("----팀원 찿기 들어옴----");
		
		System.out.println(request.getParameter("searchOption"));
		System.out.println(request.getParameter("searchWord"));
		
		
		/*
		 * select *
		 * from domain
		 * where searchOption like '%searchWord%'
		 * */
		
		request.setAttribute("list", MemberServiceImpl.getinstance().searchByName(request.getParameter("searchOption")+"/"+request.getParameter("searchWord")));
		//request.setAttribute("list", MemberServiceImpl.getinstance().searchByName(request.getParameter("searchWord")));
		System.out.println("----팀원 찿기 성공----");
		super.execute();
		
	}
}
