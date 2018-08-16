package command;

import javax.servlet.http.HttpServletRequest;

import domain.ImageBean;
import domain.MemberBean;
import enums.Domain;
import service.ImageServiceImple;
import service.MemberServiceImpl;

public class LoginCommand extends Command{
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage("mypage2");
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
		
		
		MemberBean mem = new MemberBean();
		mem.setMemID(request.getParameter("memid")); // 여기서의 request는 command의 request
		mem.setPassword(request.getParameter("pass"));
		System.out.println("로그인 커맨드 진입");
		if(MemberServiceImpl.getinstance().login(mem)) {
			request.setAttribute("match", "TRUE");
			request.getSession().setAttribute("user", MemberServiceImpl.getinstance().retrieve(request.getParameter("memid")));
			ImageBean imgBean = ImageServiceImple.getInstance().retrieve(request.getParameter("memid"));
			if(imgBean != null) {
				request.setAttribute("profile", "/upload/"+imgBean.getImgName()+"."+imgBean.getExtension());
			}
		}else {
			request.setAttribute("match", "FALSE");
		}
		super.execute();
	}
}