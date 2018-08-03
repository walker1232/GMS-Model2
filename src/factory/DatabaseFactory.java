package factory;

import java.util.Map;

import enums.Vendor;
import pool.DBConstant;

public class DatabaseFactory {
	
	public static Database createDatabase (Vendor v, String id, String pass) {
		Database db = null;
		String driver = "", url = "";
		switch(v) {
		case ORACLE:
			db = new Oracle(DBConstant.ORACLE_DRIVER, DBConstant.CONNECTION_URL, id, pass);
			break;
		case MYSQL:
			db = new MySQL(DBConstant.MySQL_DRIVER, DBConstant.CONNECTION_URL, id, pass);
			break;
		case MARIADB:
			db = new MariaDB(DBConstant.MARIADB_DRIVER, DBConstant.CONNECTION_URL, id, pass);
			break;
		case MSSQL:
			driver = DBConstant.MSSQL_DRIVER;
			url = DBConstant.CONNECTION_URL;
			break;
			
		}
		return db;
		
	}
	// 안될시 (Map<String, ?> map) { 으로 바꿔보기
	public static Database createDatabase2 (Map<String,Object> map) {
		Database db = null;
		String driver = "", url = "";
		switch((Vendor)map.get("vendor")) {
		case ORACLE:
			driver = DBConstant.ORACLE_DRIVER;
			url = DBConstant.CONNECTION_URL;
			db = new Oracle(driver, url, (String)map.get("username"), (String)map.get("password"));
			break;
		case MYSQL:
			driver = DBConstant.ORACLE_DRIVER;
			url = DBConstant.CONNECTION_URL;
			db = new MySQL(DBConstant.MySQL_DRIVER, DBConstant.CONNECTION_URL, (String)map.get("username"), (String)map.get("password"));
			break;
		case MARIADB:
			driver = DBConstant.ORACLE_DRIVER;
			url = DBConstant.CONNECTION_URL;
			db = new MariaDB(DBConstant.MARIADB_DRIVER, DBConstant.CONNECTION_URL, (String)map.get("username"), (String)map.get("password"));
			break;
		case MSSQL:
			driver = DBConstant.MSSQL_DRIVER;
			url = DBConstant.CONNECTION_URL;
			break;
			
		}
		return db;
}
}
