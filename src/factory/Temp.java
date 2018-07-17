package factory;

import java.sql.Connection;
import java.sql.DriverManager;

import pool.DBConstant;

public class Temp implements TestFactory{
	private Connection con;
	private String driver, url, id, pass;
	public Temp(String driver, String url, String id, String pass) {
		this.driver = driver;
		this.url = url;
		this.id = id;
		this.pass = pass;
	}
	@Override
	public Connection getConnection() {
		Connection temp = null;
		try {
			Class.forName(driver);
			temp = DriverManager.getConnection(url, id, pass);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return temp;
	}
	
}
