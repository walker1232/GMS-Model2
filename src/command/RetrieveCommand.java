package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
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
		System.out.println("1.RetrieveCommand 진입");
		request.setAttribute("retrieve", MemberServiceImpl.getinstance().retrieve(request.getParameter("memid")));
		System.out.println("2.RetrieveCommand에서 받은 아이디"+request.getParameter("memid"));
		super.execute();
	}
}