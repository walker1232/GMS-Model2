package factory;

import java.sql.Connection;

public class MariaDB implements Database{
	private Connection conn;
	private String driver, url, id, pass;
	public MariaDB(String driver, String url, String id, String pass) {
		this.driver = driver;
		this.url = url;
		this.id = id;
		this.pass = pass;
	}
	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

}
