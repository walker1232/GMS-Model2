package command;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
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
        System.out.println("2 PageNum : "+ pxy.getPagination().getPageNumber());
        Pagination page = pxy.getPagination();
        paramMap.put("beginRow", String.valueOf(page.getBeginRow()));
        paramMap.put("endRow", String.valueOf(page.getEndRow()));
        paramMap.put("key", "pageList");
        System.out.println("3. PageNum beginRow : "+paramMap.get("beginRow"));
        System.out.println("4.. PageNum endRow : "+paramMap.get("endRow"));
        request.setAttribute("page", page);
        request.setAttribute("list", MemberServiceImpl.getinstance().search(paramMap));
        super.execute();
		
		
		
		/*if(pageNum==null){
			System.out.println("넘어온 pageNumber 가 없어요 !!!"); 주석
			pageNumber = 1;
		}else{
			System.out.println("넘어온 pageNumber :"+pageNum);
			pageNumber = Integer.parseInt(pageNum);
		}
		int rowCount = MemberServiceImpl.getinstance()
				.countMember();
		System.out.println("rowCount::"+rowCount);
		int pageCount = 0;
		if(rowCount%pageSize==0){
			pageCount=rowCount/pageSize;
		}else{
			pageCount=rowCount/pageSize+1;
		}
		System.out.println("pageCount::"+pageCount);
		int blockCount = 0;
		if(pageCount%blockSize==0){
			blockCount=pageCount/blockSize;
		}else{
			blockCount=pageCount/blockSize+1;
		}
		System.out.println("blockCount:::"+blockCount);
		int beginRow = pageNumber*pageSize - (pageSize -1);
		int endRow = pageNumber*pageSize; 
		int beginPage = pageNumber -((pageNumber-1)%blockSize);
		int endPage = 
				((beginPage + pageSize -1)<pageCount)?
				beginPage+blockSize-1:pageCount;
		int prevBlock = beginPage - blockSize;
		int nextBlock = beginPage + blockSize;
		
		boolean existPrev = false;
		if(prevBlock >= 0){
			existPrev = true;
		}
		boolean existNext = false;
		if(nextBlock <= pageCount){
			existNext = true;
		}
		Map<String,Object> map = new HashMap<>();
		map.put("beginRow", String.valueOf(beginRow));
		map.put("endRow", String.valueOf(endRow));
		request.setAttribute("existPrev",existPrev);
		request.setAttribute("existNext",existNext);
		request.setAttribute("count",rowCount);
		request.setAttribute("beginPage",beginPage);
		request.setAttribute("endPage",endPage);
		List<MemberBean>list = MemberServiceImpl.getinstance().getList(map);
		request.setAttribute("list",list);
		super.execute();*/
	}
}