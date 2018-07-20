package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class UpdateCommand extends Command{
	public UpdateCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		switch(Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			System.out.println("------------------회원 수정에 들오옴------------------");
			MemberBean mem = new MemberBean();
			mem.setMemID(request.getParameter("memid"));
			mem.setPassword(request.getParameter("pass")+"/"+request.getParameter("newpass"));
			MemberServiceImpl.getinstance().updateMember(mem);
			System.out.println("회원정보 수정 성공");
			break;
		default:
			break;
		}
		super.execute();
	}
}
