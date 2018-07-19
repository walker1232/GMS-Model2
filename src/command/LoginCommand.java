package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class LoginCommand extends Command{
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		switch(Domain.valueOf(Sentry.cmd.domain.toUpperCase())) {
		case MEMBER:
			System.out.println("------------------로그인에 들오옴------------------");
			MemberBean mem = new MemberBean();
			mem.setMemID(request.getParameter("memid"));
			mem.setPassword(request.getParameter("pass"));
			if(MemberServiceImpl.getinstance().login(mem)) {
				System.out.println("로그인 성공");
			}else {
				System.out.println("로그인 실패");
			}
			//System.out.println("로그인 성공");
			break;
		default:
			break;
		}
		super.execute();
	}
}
