-- select
select w.no, w.title, m.NAME, w.recommend, to_char(w.reg_date, 'yyyy-mm-dd') as regDate, w.accept 
			from wishbook w, member m where w.MEMBER_NO = m.NO 
			order by no desc;
select w.no, w.title, m.name, w.publisher, w.reason 
  from wishbook w, member m
  where w.MEMBER_NO = m.NO and w.no=1;
  
-- insert
insert into wishbook values(seq_wishbook.nextval, '테스트북5', '비룡소', '테스트5', sysdate, 0, 0, 25);

-- update
update wishbook set recommend=recommend+1 where no=1;
