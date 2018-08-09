package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.Carrier;


import command.Receiver;

import enums.Action;
import service.MemberServiceImpl;

@WebServlet({"/member.do"/*,"/admin.do"*/})	//URL Mapping
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기는 MemberController");
		System.out.println("contextpath----"+request.getContextPath());
		System.out.println("servlet----"+request.getServletPath());
		Receiver.init(request, response);
		System.out.println("액션:"+Receiver.cmd.getAction());
		switch(Action.valueOf(Receiver.cmd.getAction().toUpperCase())) {
		case ADD:
			System.out.println("JOIN");
			System.out.println("=========js를 통한 JOIN=======");
			Carrier.redirect(request, response, "/member.do?action=move&page=user_login_form");
			break;
		/*case SEARCH:
			System.out.println(MemberServiceImpl.getinstance().searchByName(request.getParameter("teamid")));
			Carrier.redirect(request, response, "");
			break;*/
		case RETRIEVE:
			System.out.println(MemberServiceImpl.getinstance().retrieve(request.getParameter("memid")));
			Carrier.redirect(request, response, "");
			break;
		case MODIFY:
			/*Receiver.cmd.setPage("user_login_form");
			Receiver.cmd.execute();*/
			Carrier.forward(request, response);
			//Carrier.redirect(request, response, "");
			break;
		case REMOVE:
			Carrier.redirect(request, response, "");
			break;
		case LOGIN:
			System.out.println("=============js login===============");
			if(request.getAttribute("match").equals("TRUE")){
				//request.getSession().setAttribute("user", request.getAttribute("user"));	// 세션은 톰캣이 관리하는 것이기에 여기에서 세션을 걸어줘야 한다
				Carrier.forward(request, response);
			}else {
				Carrier.redirect(request, response, "/member.do?action=move&page=user_login_form");
			}
			break;
		case MOVE:
			System.out.println("MOVE");
			System.out.println(Action.valueOf(Receiver.cmd.getAction().toUpperCase()));
			Carrier.forward(request, response);
		break;
		default:
			break;
		}

	}
	

	
}
