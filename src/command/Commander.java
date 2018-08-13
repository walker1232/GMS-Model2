package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enums.Action;


public class Commander{
	public static Command order(HttpServletRequest request, HttpServletResponse response) {
		Command cmd = null;
		System.out.println("ACTION "+request.getParameter("action").toUpperCase());
		switch(Action.valueOf(request.getParameter("action").toUpperCase())) {
		case MOVE:
			System.out.println("----무브진입----");
			cmd = new MoveCommand(request);
			break;
		case ADD:
			System.out.println("----조인진입----");
			cmd = new AddCommand(request);
			break;
		case MODIFY:
			System.out.println("----수정 진입----");
			
			cmd = new ModifyCommand(request);
			break;
		case REMOVE:
			System.out.println("----삭제 진입----");
			
			cmd = new RemoveCommand(request);
			break;
		case LOGIN:
			System.out.println("----로그인 진입----");
			
			cmd = new LoginCommand(request);
			break;
		case SEARCH:
			System.out.println("----팀원 목록 진입----");
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
		case FILEUPLOAD:
			System.out.println("----무브진입----");
			cmd = new MoveCommand(request);
			break;
		default:
			break;
		}
		return cmd;
	}
	

}
