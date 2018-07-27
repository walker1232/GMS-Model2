package command;

import javax.servlet.http.HttpServletRequest;
// 체크박스 가져오는 유틸
public class ParamMap {
	public static String getValues(HttpServletRequest request, String name) {
		String rs = "";
		String[] values = request.getParameterMap().get(name);
		StringBuffer buff = new StringBuffer();	// buffer 메세지 보낼때 계속 모아두고 있는 것 전송하기 전까지
		for(String s : values) {
			buff.append(s+",");
		}
		return buff.toString().substring(0,buff.toString().length()-1);
	}
}
