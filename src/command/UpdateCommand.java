package command;

import java.util.HashMap;
import java.util.Map;

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
			Map<?,?> param = new HashMap<>();
			MemberBean mem = new MemberBean();
			mem.setMemID(((MemberBean)request.getSession().getAttribute("user")).getMemID());
			mem.setPassword(request.getParameter("pass"));
			mem.setTeamID(request.getParameter("teamid"));
			mem.setRoll(request.getParameter("roll"));
			MemberServiceImpl.getinstance().modify(param);
			System.out.println("회원정보 수정 성공");
			break;
		default:
			break;
		}
		super.execute();
	}
}
