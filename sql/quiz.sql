-- 시퀀스
drop sequence seq_certification;

create sequence seq_certification
start with 1
Increment by 1;

drop sequence seq_history;

create sequence seq_history
start with 1
Increment by 1;

-- select
select * from quiz order by no asc;
select quiz, ex1, ex2, ex3, ex4 
  from (select * 
          from quiz 
          where accept=1 and book_no=1 
          order by dbms_random.value)
  where rownum <= 5;
  
select * from quiz where no=1 and answer='나';
select no from certification where member_no=25 and book_no=1;
select title, content, skill, bonus, cover from (select no, title, content, skill, bonus, cover from card order by dbms_random.value) where rownum=1;

-- insert
insert into certification values(seq_certification.nextval, 25, 1);
insert into history values(seq_history.nextval, 61, 3, 25, 0, 1);

-- update
update scores set score=score+1 , point=point+1 where member_no=1;