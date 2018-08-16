package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.ImageBean;
import domain.MemberBean;
import enums.Domain;
import service.ImageServiceImple;
import service.MemberServiceImpl;

public class ModifyCommand extends Command{
	public ModifyCommand(HttpServletRequest request) {
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
			/*System.out.println("------------------회원 수정에 들오옴------------------");
			Map<String,Object> param = new HashMap<>();
			MemberBean mem = new MemberBean();
			mem.setMemID(((MemberBean)request.getSession().getAttribute("user")).getMemID());
			mem.setPassword(request.getParameter("pass"));
			mem.setTeamID(request.getParameter("teamid"));
			mem.setRoll(request.getParameter("roll"));
			MemberServiceImpl.getinstance().modify(param);
			System.out.println("회원정보 수정 성공");*/
			
			System.out.println("1.회원 수정 커맨드 진입");
			Map<String,Object> param = new HashMap<>();
			param.put("id", ((MemberBean)request.getSession().getAttribute("user")).getMemID());
			System.out.println("2.회원 아이디 "+param.get("id"));
			if(!((MemberBean)request.getSession().getAttribute("user")).getPassword().equals(request.getParameter("pass"))) {
				param.put("column", "password");
				param.put("value", request.getParameter("pass"));
				System.out.println("4.패스워드 수정 조건문 진입");
				System.out.println("5.수정된 패스워드 값 "+param.get("value"));
				MemberServiceImpl.getinstance().modify(param);
			}
			if(!((MemberBean)request.getSession().getAttribute("user")).getTeamID().equals(request.getParameter("teamid"))) {
				param.put("column", "teamid");
				param.put("value", request.getParameter("teamid"));
				System.out.println("6.팀 수정 조건문 진입");
				System.out.println("7.수정된 팀 "+param.get("value"));
				MemberServiceImpl.getinstance().modify(param);
			}
			if(!((MemberBean)request.getSession().getAttribute("user")).getRoll().equals(request.getParameter("roll"))) {
				param.put("column", "roll");
				param.put("value", request.getParameter("roll"));
				System.out.println("8.역할 수정 조건문 진입");
				System.out.println("9.수정된 역할 "+param.get("value"));
				MemberServiceImpl.getinstance().modify(param);
			}
			break;
		default:
			break;
		}
		super.execute();
	}
}