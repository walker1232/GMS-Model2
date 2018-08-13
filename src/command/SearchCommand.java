package command;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import proxy.PageProxy;
import proxy.Pagination;
import service.MemberServiceImpl;

public class SearchCommand extends Command{
	
	public SearchCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		System.out.println("1. SearchCommand ENTER");
		Map<String,Object> paramMap = new HashMap<>();
        String pageNumber = request.getParameter("pageNumber");
        PageProxy pxy = new PageProxy();
        int pn = (pageNumber==null)? 1: Integer.parseInt(pageNumber);
        pxy.carrayOut(pn);
        Pagination page = pxy.getPagination();
        if(request.getParameter("searchOption")!=null) {
        	paramMap.put("column", String.valueOf(request.getParameter("searchOption")));
        }
        String[] arr1 = {"domain", "beginRow", "endRow", "searchWord"};
        String[] arr2 = {domain, 
        				 String.valueOf(page.getBeginRow()), 
        				 String.valueOf(page.getEndRow()), 
        				 String.valueOf(request.getParameter("searchWord"))
        				 };
        for(int i=0; i<arr1.length; i++) {
        	paramMap.put(arr1[i], arr2[i]);
        }
        System.out.println("SEARCH COMMAND 에서의 PARAMMAP "+paramMap);
        request.setAttribute("page", page);
        request.setAttribute("list", MemberServiceImpl.getinstance().search(paramMap));
        
		
        super.execute();
		
		
		
		
	}
}