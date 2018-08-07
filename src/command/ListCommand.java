package command;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import service.MemberServiceImpl;

public class ListCommand extends Command{
	
	public ListCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		
		//request.setAttribute("list", MemberServiceImpl.getinstance().listMember()); 주석
		String pageNumber = "";
		String pageNum = request.getParameter("pageNumber"); 
		if(pageNum == null) {
			System.out.println("넘어온 pageNumber 없음");
			pageNumber = "1";
		}else {
			System.out.println("넘어온 pageNumber :" + pageNum);
			pageNumber = pageNum;
		}
		
		int rowCount = MemberServiceImpl.getinstance().countMember();
		int pageSize = 5;
		int blockSize = 5;
		int beginPage = 1;
		int endPage = 0;
		if(rowCount/pageSize < pageSize+1) {
			if(rowCount%pageSize > 0) {
				endPage = rowCount/pageSize+1;
			}else {
				endPage = rowCount/pageSize;
			}
		}else {
			endPage = blockSize;
		}
		int prevBlock = beginPage - blockSize;
		int nextBlock = beginPage + blockSize;
		boolean existPrev = false;
		if(prevBlock >= 0) {
			existPrev = true;
		}
		boolean existNext = false;
		if(nextBlock <= endPage) {
			existNext = true;
		}
		
		Map<String, Object> param = new HashMap<>();
		String beginRow = String.valueOf(Integer.parseInt(pageNumber)*pageSize-(pageSize-1));
		String endRow = String.valueOf(Integer.parseInt(pageNumber)*pageSize);
		
		param.put("beginRow", beginRow);
		param.put("endRow", endRow);
		request.setAttribute("count", rowCount);
		request.setAttribute("beginPage", beginPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("list2", MemberServiceImpl.getinstance().getList(param));
		super.execute();
	}
}
