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
		int pageNumber = 0;
		int pageSize = 5;
		int blockSize = 5;
		String pageNum = request.getParameter("pageNumber");
		if(pageNum==null){
			System.out.println("넘어온 pageNumber 가 없어요 !!!");
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
		System.out.println("beginPage::"+beginPage);
		System.out.println("endPage::"+endPage);
		System.out.println("prevBlock::"+prevBlock);
		System.out.println("nextBlock::"+nextBlock);
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
		super.execute();
	}
}
