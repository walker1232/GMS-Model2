select t.mem_id
from 
    (select rownum seq, member.*
     from member
     order by seq desc) t
where t.seq between 1 and 5;




select t.*
from
    (select rownum seq, m.*
    from member m
    order by seq desc) t
where t.seq between 15 and 20
;