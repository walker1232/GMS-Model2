package enums;

public enum MemberQuery {
	LOGIN, INSERT_MEMBER, COUNT_MEMBER, UPDATE_MEMBER, DELETE_MEMBER, SELECT_ALL, SELECT_NAME, SELECT_ID;
	@Override
	public String toString() {
		String query = "";
		switch(this) {
		case LOGIN:
			query = "SELECT MEMID ,	"
					+"	TEAMID,	"
					+"	NAME,	"
					+"	AGE,	" 
					+"	ROLL,	"
					+"	PASSWORD 	"
					+"	FROM MEMBER 	"
					+"	WHERE MEMID LIKE '%s' AND PASSWORD LIKE '%s'	";
			break;
		case INSERT_MEMBER:
			query = "INSERT INTO member(MEMID, PASSWORD, NAME, SSN, TEAMID, AGE, ROLL, GENDER)	VALUES('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')";
			break;
		/*case INSERT_MEMBER:
			query = "INSERT INTO member(MEM_ID, PASSWORD, NAME, SSN)	VALUES('%s', '%s', '%s', '%s')";
			break;*/
		case COUNT_MEMBER:
			query = " SELECT COUNT(*) AS count FROM MEMBER ";
			break;
		case UPDATE_MEMBER:
			query = " UPDATE MEMBER SET PASSWORD = '%s', TEAMID = '%s', ROLL = '%s' " + 
					"	WHERE MEMID LIKE '%s' ";
			break;
		case DELETE_MEMBER:
			query = " DELETE FROM MEMBER WHERE MEMID LIKE '%s' and PASSWORD LIKE '%s' ";
			break;
		case SELECT_ALL:
			query = "SELECT MEMID,	"
					+"	TEAMID,	"
					+"	NAME,	"
					+"	AGE,	" 
					+"	ROLL,	"
					+"  SSN,	"
					+"	PASSWORD,	"
					+"  GENDER	"
					+"	FROM MEMBER ";
			break;
		case SELECT_NAME:
			query = " SELECT MEMID, TEAMID, AGE, ROLL, NAME, PASSWORD, SSN, GENDER " + 
					" FROM MEMBER " + 
					" WHERE  %s  LIKE '%%%s%%' "; 
			break;
		case SELECT_ID:
			query = " SELECT MEMID, TEAMID, AGE, ROLL, NAME, PASSWORD , SSN, GENDER " +
					" FROM MEMBER " +
					" WHERE MEMID LIKE '%s' ";
		}
		return query;
	}
}
