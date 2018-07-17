package factory;
import enums.Test;
import pool.DBConstant;
import java.sql.*;
public class TempFactory {
	
	public static TestFactory createJoin (Test t, String id, String pass) {
		TestFactory imSi = null;
		switch(t) {
		case JOIN:
			imSi = new Temp(DBConstant.MARIADB_DRIVER, DBConstant.CONNECTION_URL, id, pass);
			break;
		}
		return imSi;
	}
}
