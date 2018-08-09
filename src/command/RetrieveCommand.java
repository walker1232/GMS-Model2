package command;

import javax.servlet.http.HttpServletRequest;

import service.MemberServiceImpl;

public class RetrieveCommand extends Command{
	
	public RetrieveCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		System.out.println("----회원찿기 들어옴----");
		request.setAttribute("retrieve", MemberServiceImpl.getinstance().retrieve(request.getParameter("memid")));
		System.out.println("----회원찿기 성공----");
		super.execute();
	}
}