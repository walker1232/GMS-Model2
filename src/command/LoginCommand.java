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
		System.out.println("페이지는"+request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		/*switch(Domain.valueOf(getDomain().toUpperCase())) {
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
		}*/
		
		super.execute();
		MemberBean mem = new MemberBean();
		mem.setMemID(request.getParameter("memid")); // 여기서의 request는 command의 request
		mem.setPassword(request.getParameter("pass"));
		if(MemberServiceImpl.getinstance().login(mem)) {
			request.setAttribute("match", "TRUE");
			request.setAttribute("user", MemberServiceImpl.getinstance().searchById(request.getParameter("memid")));
		}else {
			request.setAttribute("match", "FALSE");
		}
	}
}
