



select t.*
from
    (select rownum seq, m.*
    from member m
    order by seq desc) t
where t.seq between 1 and 5
;


SELECT T.*	
FROM	
	(SELECT ROWNUM SEQ, M.*	
	FROM MEMBER M  
	ORDER BY SEQ DESC) T	
	WHERE T.SEQ BETWEEN 1 AND 5;
	
	
	CREATE SEQUENCE IMG_SEQ
	START WITH 1000
	INCREMENT BY 1;
	CREATE TABLE IMAGE(
		IMG_SEQ DECIMAL PRIMARY KEY,
		IMG_NAME VARCHAR2(20),
		EXTENSION VARCHAR2(10),
		MEMID VARCHAR2(20),
		CONSTRAINT FK_IMAGE_MEMBER
		FOREIGN KEY (MEMID)
		REFERENCES MEMBER (MEMID)
	);
	
	
	INSERT INTO IMAGE(IMG_SEQ, IMG_NAME, EXTENSION, MEMID) VALUES(IMG_SEQ.NEXTVAL, '', '', '');
	
	DROP TABLE IMAGE;
	
	SELECT * FROM IMAGE;
	
	
	select * from image;
	
	