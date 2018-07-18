package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 보내는 역할만 행함. 어디로 가야하는지만 관심있음.
public class Carrier {
	public static void send(HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("뷰:" + Sentry.cmd.getView());
		request.getRequestDispatcher(Sentry.cmd.getView()).forward(request, response);
	}
}
