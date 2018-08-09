package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Carrier;


import command.Receiver;

import enums.Action;
import service.MemberServiceImpl;

@WebServlet({"/admin.do"})	//URL Mapping
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기는 AdminController");
		System.out.println("contextpath----"+request.getContextPath());
		System.out.println("servlet----"+request.getServletPath());
		Receiver.init(request, response);
		System.out.println("액션:"+Receiver.cmd.getAction());
		switch(Action.valueOf(Receiver.cmd.getAction().toUpperCase())) {
		case RETRIEVE:
			System.out.println("#####admin Retrieve#######");
			System.out.println(MemberServiceImpl.getinstance().retrieve(request.getParameter("memid")));
			Carrier.forward(request, response);
			break;
		case SEARCH:
			System.out.println("########admin Search########");
			Carrier.forward(request, response);
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
