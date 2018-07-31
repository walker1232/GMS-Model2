package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.Carrier;


import command.Sentry;

import enums.Action;
import service.MemberServiceImpl;

@WebServlet({"/admin.do"})	//URL Mapping
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기는 AdminController");
		System.out.println("contextpath----"+request.getContextPath());
		System.out.println("servlet----"+request.getServletPath());
		Sentry.init(request, response);
		System.out.println("액션:"+Sentry.cmd.getAction());
		switch(Action.valueOf(Sentry.cmd.getAction().toUpperCase())) {
		case MOVE:
				System.out.println("MOVE");
				System.out.println(Action.valueOf(Sentry.cmd.getAction().toUpperCase()));
				Carrier.forward(request, response);
			break;
		default:
			break;
		}

	}
	

	
}
