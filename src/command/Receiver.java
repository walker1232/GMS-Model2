package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Receiver {
	public static Command cmd = new Command();
	public static void init(HttpServletRequest request, HttpServletResponse response) {
		/*String servletPath = request.getServletPath();
		System.out.println("센트리:"+ servletPath.substring(1, servletPath.indexOf(".")));*/
		/*cmd = Commander.order(servletPath.substring(1, servletPath.indexOf(".")),	// (시작값, 끝값) /member.do~ 이기에 1부터니 m부터 시작하여 .전까지기에 member가 추출된다.
					          request.getParameter("action"),
					          request.getParameter("page"));*/
		cmd = Commander.order(request, response);
	}
}
