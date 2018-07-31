package command;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 보내는 역할만 행함. 어디로 가야하는지만 관심있음.
public class Carrier {
	public static void forward(HttpServletRequest request, HttpServletResponse response){
		
		try {
			System.out.println("뷰:" + Sentry.cmd.getView());
			request.getRequestDispatcher(Sentry.cmd.getView()).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void redirect(HttpServletRequest request,HttpServletResponse response, String url) {
		try {
			System.out.println("리다이렉트 들어옴");
			response.sendRedirect(request.getContextPath()+url);
			System.out.println("dddddd"+request.getContextPath()+url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
