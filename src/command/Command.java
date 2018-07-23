package command;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;
@Data
public class Command implements Order{
	protected HttpServletRequest request;
	protected String action, domain, page, view;
	/*public String getAction() {
		return action;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}*/
	@Override
	public void execute() {
		this.view = "/WEB-INF/view/"+domain+"/"+page+".jsp";
		
	}
	
}
