package enums;

public enum MemberQuery {
	LOGIN, INSERT_MEMBER, COUNT_MEMBER, UPDATE_MEMBER, DELETE_MEMBER, SELECT_ALL, SELECT_NAME, SELECT_ID;
	@Override
	public String toString() {
		String query = "";
		switch(this) {
		case LOGIN:
			query = "SELECT MEM_ID MEMID ,	"
					+"	TEAM_ID TEAMID,	"
					+"	NAME,	"
					+"	AGE,	" 
					+"	ROLL,	"
					+"	PASSWORD 	PASS"
					+"	FROM MEMBER 	"
					+"	WHERE MEM_ID LIKE '%s' AND PASSWORD LIKE '%s'	";
			break;
		case INSERT_MEMBER:
			query = "INSERT INTO member(MEM_ID, PASSWORD, NAME, SSN)	VALUES('%s', '%s', '%s', '%s')";
			break;
		case COUNT_MEMBER:
			query = " SELECT COUNT(*) AS count FROM MEMBER ";
			break;
		case UPDATE_MEMBER:
			query = " UPDATE MEMBER SET PASSWORD = '%s' " + 
					"	WHERE MEM_ID LIKE '%s'	" +
					"	AND PASSWORD LIKE '%s'	";
			break;
		case DELETE_MEMBER:
			query = " DELETE FROM MEMBER WHERE MEM_ID LIKE '%s' and PASSWORD LIKE '%s' ";
			break;
		case SELECT_ALL:
			query = "SELECT MEM_ID MEMID ,	"
					+"	TEAM_ID TEAMID,	"
					+"	NAME,	"
					+"	AGE,	" 
					+"	ROLL,	"
					+"  SSN,	"
					+"	PASSWORD 	PASS"
					+"	FROM MEMBER ";
			break;
		case SELECT_NAME:
			query = " SELECT MEM_ID MEMID, TEAM_ID TEAMID, AGE, ROLL, NAME, PASSWORD PASS, SSN " + 
					" FROM MEMBER " + 
					" WHERE TEAM_ID LIKE '%s' ";
			break;
		case SELECT_ID:
			query = " SELECT MEM_ID MEMID, TEAM_ID TEAMID, AGE, ROLL, NAME, PASSWORD PASS, SSN " +
					" FROM MEMBER " +
					" WHERE MEM_ID LIKE '%s' ";
		}
		return query;
	}
}
