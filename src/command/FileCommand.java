package command;

import javax.servlet.http.HttpServletRequest;

import service.MemberServiceImpl;

public class FileCommand extends Command{
	public FileCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
		
	}
	@Override
	public void execute() {
		
		System.out.println("1.RetrieveCommand 진입");
		request.setAttribute("retrieve", MemberServiceImpl.getinstance().retrieve(request.getParameter("memid")));
		request.setAttribute("pagename", request.getParameter("page"));
		System.out.println("2.RetrieveCommand에서 받은 아이디"+request.getParameter("memid"));
		
		super.execute();
	}
}
