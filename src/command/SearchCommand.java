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
        System.out.println("searchCommand에서의 param "+paramMap);
        request.setAttribute("page", page);
        request.setAttribute("list", MemberServiceImpl.getinstance().search(paramMap));
        
		/*System.out.println("1. SearchCommand ENTER");
		Map<String,Object> paramMap = new HashMap<>();
        String pageNumber = request.getParameter("pageNumber");
        PageProxy pxy = new PageProxy();
        int pn = (pageNumber==null)? 1: Integer.parseInt(pageNumber);
        pxy.carrayOut(pn);
        System.out.println("2 PageNum : "+ pxy.getPagination().getPageNumber());
        Pagination page = pxy.getPagination();
        paramMap.put("beginRow", String.valueOf(page.getBeginRow()));
        paramMap.put("endRow", String.valueOf(page.getEndRow()));
        paramMap.put("table", Domain.MEMBER);
        paramMap.put("searchOption", request.getParameter("searchOption"));
        paramMap.put("searchWord", request.getParameter("searchWord"));
        System.out.println("3. PageNum beginRow : "+paramMap.get("beginRow"));
        System.out.println("4. PageNum endRow : "+paramMap.get("endRow"));
        request.setAttribute("page", page);
        System.out.println("searchCommand에서의 param "+paramMap);
        request.setAttribute("list", MemberServiceImpl.getinstance().search(paramMap));*/
        super.execute();
		
		
		
		
	}
}