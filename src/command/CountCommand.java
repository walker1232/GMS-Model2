package command;

import javax.servlet.http.HttpServletRequest;

import enums.Domain;
import service.MemberServiceImpl;

public class CountCommand extends Command{
	
	public CountCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		System.out.println(request.getParameter("action"));
		System.out.println(request.getParameter("page"));
		System.out.println(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		System.out.println("도메인"+getDomain());
		execute();
		
	}
	@Override
	public void execute() {
		System.out.println("----총인원수 들어옴----");
		System.out.println("총 인원:"+MemberServiceImpl.getinstance().count());
		System.out.println("----총인원수 성공----");
		System.out.println("카운트 커맨드 진입========================");
		request.setAttribute("count", MemberServiceImpl.getinstance().count());
		super.execute();
	}
}