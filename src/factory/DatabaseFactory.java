package factory;

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
}
