package command;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;

public class LogoutCommand extends Command{
	public LogoutCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage("login");
		execute();
	}
	@Override
	public void execute() {
		System.out.println("로그아웃 커맨드 진입");
		request.getSession().invalidate();
		super.execute();
	}
}
