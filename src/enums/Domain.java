package enums;

public enum Domain {
	MEMBER, EXAM, PROJECTTEAM, RECORD, SUBJECT, CTX, WEBPATH, MAIN, ADMIN;
	@Override
	public String toString() {
		String res = "";
		switch(this) {
		case CTX: res ="ctx"; break;
		case WEBPATH: res = "/WEB-INF/view/"; break;
		case MAIN: res = "/main.jsp"; break;
		default: break;
		}
		return res;
	}
}
