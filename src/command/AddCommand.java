package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class AddCommand extends Command{
	public AddCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		switch(Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			System.out.println("1.ADDCOMMAND수행 초기진입");
			Map<String, Object> paramMap = new HashMap<>();
			MemberBean mem = new MemberBean();
			mem.setMemID(request.getParameter("memid"));
			mem.setTeamID(request.getParameter("teamid"));
			mem.setName(request.getParameter("name"));
			mem.setSsn(request.getParameter("ssn"));
			mem.setAge(request.getParameter("age"));
			mem.setRoll(request.getParameter("roll"));
			mem.setPassword(request.getParameter("pass"));
			/*mem.setSubject(ParamMap.getValues(request, "subject"));*/
			mem.setSubject(request.getParameter("subject"));
			mem.setGender(request.getParameter("gender"));
			System.out.println("*%^&*%*"+request.getParameter("subject"));
			System.out.println("2.ADDCOMMAND MemberServiceImpl 호출 "+ mem);
			MemberServiceImpl.getinstance().create(mem);
			
			break;
		default:
			break;
		}
		super.execute();
	}
}