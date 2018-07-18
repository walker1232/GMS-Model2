package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Carrier;
import command.Sentry;
import domain.MemberBean;
import enums.Action;
import service.MemberServiceImpl;

@WebServlet("/member.do")	//URL Mapping
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기는 MemberController");
		Sentry.init(request);
		System.out.println("액션:"+Sentry.cmd.getAction());
		/*String action = request.getParameter("action");	// DB 접근을 구분하기위해 사용한다.
		String page = request.getParameter("page");*/
		switch(Action.valueOf(Sentry.cmd.getAction().toUpperCase())) {
		case MOVE:
			try {
				System.out.println("무브 안으로 진입");
				System.out.println(Action.valueOf(Sentry.cmd.getAction().toUpperCase()));
				Carrier.send(request, response);
				/*request.getRequestDispatcher("/WEB-INF/view/member/"+page+".jsp").forward(request, response);*/
			}catch (Exception e){
				e.printStackTrace();
			}
			
			break;
		case JOIN:
			MemberBean mem = new MemberBean();
			mem.setMemID(request.getParameter("memid"));
			mem.setName(request.getParameter("name"));
			mem.setPassword(request.getParameter("pass"));
			mem.setSsn(request.getParameter("ssn"));
			//MemberServiceImpl.getinstance().createMember(mem);
			//System.out.println(mem);
			response.sendRedirect(request.getContextPath()+"/member.do?action=move&page=user_login_form");
			break;
		case LIST:
			List<MemberBean> memList = new ArrayList<>();
			memList = MemberServiceImpl.getinstance().listMember();
			/*MemberServiceImpl.getinstance().listMember();*/
			for(MemberBean m : memList) {
				System.out.println(m);
			}
			System.out.println(MemberServiceImpl.getinstance().listMember().size());
			break;
		case SEARCH:
			/*MemberServiceImpl.getinstance().searchByName(request.getParameter("teamid"));*/
			System.out.println(MemberServiceImpl.getinstance().searchByName(request.getParameter("teamid")));
			
			break;
		case RETRIEVE:
			/*MemberServiceImpl.getinstance().searchById(request.getParameter("memid"));*/
			System.out.println(MemberServiceImpl.getinstance().searchById(request.getParameter("memid")));
			break;
		case COUNT:
			int num = MemberServiceImpl.getinstance().countMember();
			System.out.println(num);
			break;
		case UPDATE:
			MemberBean memUpdate = new MemberBean();
			memUpdate.setMemID(request.getParameter("memid"));
			memUpdate.setPassword(request.getParameter("pass")+"/"+request.getParameter("newpass"));
			//MemberServiceImpl.getinstance().updateMember(memUpdate);
			//System.out.println(memUpdate);
			response.sendRedirect(request.getContextPath());
			break;
		case DELETE:
			MemberBean memDelete = new MemberBean();
			memDelete.setMemID(request.getParameter("memid"));
			memDelete.setPassword(request.getParameter("pass"));
			//MemberServiceImpl.getinstance().deleteMember(memDelete);
			//System.out.println(memDelete);
			response.sendRedirect(request.getContextPath());
			break;
		case LOGIN:
			MemberBean memLogin = new MemberBean();
			memLogin.setMemID(request.getParameter("memid"));
			memLogin.setPassword(request.getParameter("pass"));
			//MemberServiceImpl.getinstance().login(memLogin);
			response.sendRedirect(request.getContextPath());
			
		}
		/*request.getRequestDispatcher("/WEB-INF/view/member/"+page+".jsp").forward(request, response);*/
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}
	
}
