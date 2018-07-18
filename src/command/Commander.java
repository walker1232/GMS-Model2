package command;

import enums.Action;

public class Commander{
	public static Command order(String domain, String action, String page) {
		Command cmd = null;
		switch(Action.valueOf(action.toUpperCase())) {
		case MOVE:
			System.out.println("----무브진입----");
			cmd = new MoveCommand(domain, action, page);
			break;
		case JOIN:
			System.out.println("----조인진입----");
			cmd = new CreateCommand(domain, action, page);
			break;
		case UPDATE:
			System.out.println("----수정 진입----");
			cmd = new UpdateCommand(domain, action, page);
			break;
		case DELETE:
			System.out.println("----삭제 진입----");
			cmd = new DeleteCommand(domain, action, page);
			break;
		case LOGIN:
			System.out.println("----로그인 진입----");
			cmd = new LoginCommand(domain, action, page);
			break;
		}
		return cmd;
	}
	

}
