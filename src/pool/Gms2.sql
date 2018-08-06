



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