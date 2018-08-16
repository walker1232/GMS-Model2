package enums;


public enum ImageQuery {
	IMGADD, IMGRETRIEVE;
	
	@Override
	public String toString() {
		String query = "";
		switch(this) {
		case IMGADD:
			query = "INSERT INTO image( IMG_SEQ, IMG_NAME, EXTENSION, MEMID )"+	" VALUES " + "(IMG_SEQ.NEXTVAL, ?, ?, ?)";
			break;
		/*case INSERT_MEMBER:
			query = "INSERT INTO member(MEM_ID, PASSWORD, NAME, SSN)	VALUES('%s', '%s', '%s', '%s')";
			break;*/
		case IMGRETRIEVE:
			query =
					 " SELECT ROWNUM, A.* "
					+" FROM "
					+"	(SELECT * "
					+"	FROM IMAGE "
					+"	WHERE MEMID LIKE ? "
					+"	ORDER BY IMG_SEQ DESC) A "
					+" WHERE ROWNUM < 2 ";
			break;
		}
		return query;
	}
}

