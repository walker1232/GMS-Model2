package dao;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		List<String> lst = TestDAO.getInstance().getSsnList();
		String currentDate = new SimpleDateFormat("yyyy").format(new Date());
		for(int i = 0; i < lst.size(); i++) {
			String month = String.format("%02d", ((int)(Math.random()*13)));
			String day = String.format("%02d", ((int)(Math.random()*32)));
			String gender = String.valueOf((int)(Math.random()*2)+1);
			lst.set(i,String.valueOf(Integer.parseInt(currentDate) - Integer.parseInt(lst.get(i)) +1 - 1900 + month + day)+"-"+gender);
		}
		System.out.print(lst+" ");
		
	}

}
