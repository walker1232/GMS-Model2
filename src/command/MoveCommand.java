package command;

import javax.servlet.http.HttpServletRequest;

public class MoveCommand extends Command{
	public MoveCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	@Override
	public void execute() {
		super.execute();
		System.out.println("++++++++++++++++");
		System.out.println(request.getParameter("page"));
		request.setAttribute("pagename", request.getParameter("page"));
	}
}
