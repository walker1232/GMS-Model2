package template;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import enums.Vendor;
import factory.DatabaseFactory;
import lombok.Data;
import pool.DBConstant;

@Data
public abstract class QueryTemplate {
	int number;
	HashMap<String, Object>map;
	Object o;
	List<Object> list;
	PreparedStatement pstmt;
	abstract void initialize();
	abstract void startPlay();
	abstract void endPlay();
	 //template method		
	 //final을 사용하면 후손으로 갈 수 없음
	 public final void play(Map<?, ?>param){
		/* System.out.println("9.QueryTemplate에서 받은 map: "+map);*/
		 this.number = 0;
		 this.o = null;
		 this.list = new ArrayList<>();
		 this.pstmt = null;
		 this.map = new HashMap<>();
		 this.map.put("vendor", Vendor.ORACLE);	//"v" 일수도 있음 
		 this.map.put("username", DBConstant.USER_NAME); //"id" 일수도 있음
		 this.map.put("password", DBConstant.PASSWORD);	//"pass" 일수도 있음
		 Iterator<?> keys = param.keySet().iterator();
		 while(keys.hasNext()) {
			 String key = (String) keys.next();
			 this.map.put(key, param.get(key));
		 }
		 
		
	    //initialize the game
	    initialize();

	    pstmtInit();
	    //start game
	    startPlay();

	    //end game
	    endPlay();
	 }
	public void play() {
		this.number = 0;
		this.pstmt = null;
		this.map = new HashMap<>();
		this.map.put("vendor",Vendor.ORACLE);
		this.map.put("username", DBConstant.USER_NAME);
		this.map.put("password", DBConstant.PASSWORD);
		initialize();
		pstmtInit();
		startPlay();
		endPlay();
		
	}
	public void pstmtInit() {
		try {
			this.pstmt = DatabaseFactory.createDatabase2(map).getConnection().prepareStatement((String)map.get("sql"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
