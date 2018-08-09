package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class DeleteCommand extends Command{
	public DeleteCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		//setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		switch(Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			System.out.println("-------------------회원탈퇴 들어옴----------------------");
			MemberBean mem = new MemberBean();
			mem.setMemID(((MemberBean)request.getSession().getAttribute("user")).getMemID());
			mem.setPassword(request.getParameter("pass"));
			MemberServiceImpl.getinstance().remove(mem);
			request.getSession().invalidate();
			System.out.println("-----------------회원탈퇴 성공--------------------------");
			break;
		default:
			break;
		}
		super.execute();
	}
}