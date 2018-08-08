package proxy;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import service.MemberServiceImpl;

@Data
public class Pagination implements Proxy{
	private int pageNumber, pageSize, blockSize, rowCount, pageCount, blockCount,
		beginRow, endRow, prevBlock, nextBlock, beginPage, endPage;
	boolean existPrev, existNext;
	@Override
	public void carrayOut(Object o) {
		this.pageNumber = (int)o;
		this.pageSize = 5;
		this.blockSize = 5;
		this.rowCount = MemberServiceImpl.getinstance().countMember();
		/*this.pageCount = 0;
		if(rowCount%pageSize==0){
			pageCount=rowCount/pageSize;
		}else{
			pageCount=rowCount/pageSize+1;
		} 위의 if문을 아래의 삼항으로 처리 가능*/
		this.pageCount = rowCount%pageSize == 0? rowCount/pageSize: rowCount/pageSize+1;
		/*this.blockCount = 0;
		if(pageCount%blockSize==0){
			blockCount=pageCount/blockSize;
		}else{
			blockCount=pageCount/blockSize+1;
		} 위의 if문을 아래의 삼항으로 처리 가능*/
		this.blockCount = pageCount%blockSize == 0? pageCount/blockSize: pageCount/blockSize+1;
		this.beginRow = pageNumber*pageSize-(pageSize-1);
		this.endRow = pageNumber*pageSize;
		this.beginPage = pageNumber-((pageNumber-1)%blockSize);
		this.endPage = ((beginPage)+pageSize-1)<pageCount? beginPage+blockSize-1:pageCount;
		this.prevBlock = beginPage - blockSize;
		this.nextBlock = beginPage + blockSize;
		this.existPrev = false;
		if(prevBlock >= 0) {
			existPrev = true;
		}
		this.existNext = false;
		if(nextBlock <= pageCount) {
			existNext = true;
		}
		System.out.println("======================");
		System.out.println(">>>>>"+existNext);
	}
	
	
}
