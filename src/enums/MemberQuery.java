package enums;

import template.ColumnFinder;

public enum MemberQuery {
	ADD, IMGADD, 
	LIST, SEARCH, RETRIEVE, COUNT, 
	UPDATE, DELETE, 
	LOGIN;
	@Override
	public String toString() {
		String query = "";
		switch(this) {
		case LOGIN:
			query = "SELECT " + ColumnFinder.find(Domain.MEMBER)
					+"	FROM MEMBER 	"
					+"	WHERE MEMID LIKE ? AND PASSWORD LIKE ?	";
			/*query = "SELECT MEMID ,	"
					+"	TEAMID,	"
					+"	NAME,	"
					+"	AGE,	" 
					+"	ROLL,	"
					+"	PASSWORD 	"
					+"	FROM MEMBER 	"
					+"	WHERE MEMID LIKE '%s' AND PASSWORD LIKE '%s'	";*/
			break;
		case ADD:
			query = "INSERT INTO member("+ColumnFinder.find(Domain.MEMBER)+")"+	" VALUES " + "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			/*query = "INSERT INTO member(MEMID, PASSWORD, NAME, SSN, TEAMID, AGE, ROLL, GENDER)	VALUES(?, ?, ?, ?, ?, ?, ?, ?)";*/
			break;
		case IMGADD:
			query = "INSERT INTO image( IMG_SEQ, IMG_NAME, EXTENSION, MEMID )"+	" VALUES " + "(IMG_SEQ.NEXTVAL, ?, ?, ?)";
			break;
		/*case INSERT_MEMBER:
			query = "INSERT INTO member(MEM_ID, PASSWORD, NAME, SSN)	VALUES('%s', '%s', '%s', '%s')";
			break;*/
		case COUNT:
			query = " SELECT COUNT(*) AS count FROM MEMBER ";
			break;
		case UPDATE:
			query = " UPDATE MEMBER SET PASSWORD = '%s', TEAMID = '%s', ROLL = '%s' " + 
					"	WHERE MEMID LIKE '%s' ";
			break;
		case DELETE:
			query = " DELETE FROM MEMBER WHERE MEMID LIKE ? and PASSWORD LIKE ? ";
			break;
		case SEARCH:
			query = "	SELECT T.*	" + 
					"	FROM	" + 
					"    	(SELECT ROWNUM SEQ, M.*	" + 
					"    	FROM MEMBER M " + 
					"       WHERE %s LIKE ?	"+	
					"    	ORDER BY SEQ DESC) T	" + 
					"	WHERE T.SEQ BETWEEN ? AND ?	";
			break;
		/*case SEARCH:
			query = " SELECT MEMID, TEAMID, AGE, ROLL, NAME, PASSWORD, SSN, GENDER " + 
					" FROM MEMBER " + 
					" WHERE  %s  LIKE '%%%s%%' "; 
			break;*/
		case RETRIEVE:
			query = " SELECT MEMID, TEAMID, AGE, ROLL, NAME, PASSWORD , SSN, GENDER " +
					" FROM MEMBER " +
					" WHERE MEMID LIKE ? ";
			break;
		case LIST:
			query = "	SELECT T.*	" + 
					"	FROM	" + 
					"    	(SELECT ROWNUM SEQ, M.*	" + 
					"    	FROM MEMBER M " + 
					"    	ORDER BY SEQ DESC) T	" + 
					"	WHERE T.SEQ BETWEEN ? AND ?	";
		}
		
		return query;
	}
}
