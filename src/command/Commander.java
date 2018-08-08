package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enums.Action;


public class Commander{
	public static Command order(HttpServletRequest request, HttpServletResponse response) {
		Command cmd = null;
		switch(Action.valueOf(request.getParameter("action").toUpperCase())) {
		case MOVE:
			System.out.println("----무브진입----");
			cmd = new MoveCommand(request);
			break;
		case JOIN:
			System.out.println("----조인진입----");
			cmd = new CreateCommand(request);
			break;
		case UPDATE:
			System.out.println("----수정 진입----");
			//cmd = new UpdateCommand(domain, action, page);
			cmd = new UpdateCommand(request);
			break;
		case DELETE:
			System.out.println("----삭제 진입----");
			//cmd = new DeleteCommand(domain, action, page);
			cmd = new DeleteCommand(request);
			break;
		case LOGIN:
			System.out.println("----로그인 진입----");
			//cmd = new LoginCommand(domain, action, page);
			cmd = new LoginCommand(request);
			break;
		case LIST:
			System.out.println("----회원목록 진입----");
			cmd = new SearchCommand(request);
			break;
		case RETRIEVE:
			System.out.println("----ID로 찿기----");
			cmd = new RetrieveCommand(request);
			break;
		case COUNT:
			System.out.println("----총 인원수----");
			cmd = new CountCommand(request);
			break;
		
		default:
			break;
		}
		return cmd;
	}
	

}
