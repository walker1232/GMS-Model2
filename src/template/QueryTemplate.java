package template;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import enums.Vendor;
import lombok.Data;
import pool.DBConstant;

@Data
public abstract class QueryTemplate {
	HashMap<String, Object>map;
	List<Object> list;
	PreparedStatement pstmt;
	abstract void initialize();
	abstract void startPlay();
	abstract void endPlay();

	 //template method		//final을 사용하면 후손으로 갈 수 없음
	 public final void play(HashMap<String, Object>map){
		 this.pstmt = null;
		 this.list = new ArrayList<>();
		 this.map = map;
		 this.map.put("vendor", Vendor.ORACLE);	//"v" 일수도 있음 
		 this.map.put("username", DBConstant.USER_NAME); //"id" 일수도 있음
		 this.map.put("password", DBConstant.PASSWORD);	//"pass" 일수도 있음
	    //initialize the game
	    initialize();

	    //start game
	    startPlay();

	    //end game
	    endPlay();
	 }
}
