package command;

import javax.servlet.http.HttpServletRequest;

import domain.ImageBean;
import domain.MemberBean;
import service.ImageServiceImple;
import service.MemberServiceImpl;

public class RetrieveCommand extends Command{
	
	public RetrieveCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
		
	}
	@Override
	public void execute() {
		
		System.out.println("1.RetrieveCommand 진입");
		request.setAttribute("user", MemberServiceImpl.getinstance().retrieve(request.getParameter("memid")));
		ImageBean imgBean = ImageServiceImple.getInstance().retrieve(request.getParameter("memid"));
		if(imgBean != null) {
			request.setAttribute("profile", "/upload/"+imgBean.getImgName()+"."+imgBean.getExtension());
		}
		request.setAttribute("pagename", request.getParameter("page"));
		/*String img = "";
		// ImageServiceImpl.getInstance().retrieve();
		String imgPath = "/upload/"+img;
		request.setAttribute("img", imgPath);*/
		System.out.println("2.RetrieveCommand에서 받은 아이디"+request.getParameter("memid"));
		
		super.execute();
	}
}