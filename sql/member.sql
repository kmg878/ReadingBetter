-- select
select no, name from member where id='ysi1246' and pw='abcd1234';
select title from school order by title asc;
select title from school where title like '%' || '테스트' || '%' order by title asc;

select id from member where id='kmg878';
select email from member where email='kmg878@naver.com';

select no from school where title='성결초등학교';

select m.name, m.email, m.tel, m.grade, m.class_no as classNo, s.TITLE as schoolName 
  from member m, school s 
  where m.SCHOOL_NO = s.NO and m.no=25;

-- insert
insert into member values(seq_member.nextval, 'test01', 'aaaa', 'test', 'test01@naver.com', '01000001111', sysdate, 1, 0, '', '', (select no from school where title='성결초등학교'));
insert into member values(seq_member.nextval, 'test7', 'aaaa', '테스트7', 'test07@naver.com', '0100000000', sysdate, 1, 0, null, null, null);

-- update
update member set name='GM숙', email='kg00003@hanmail.net', tel='0100001111', school_no=(select no from school where title='성결초등학교'), grade=5, class_no=1 where no=25;
update member set pw='aaaa', name='GM숙', email='kg00003@hanmail.net', tel='0100001111', school_no=(select no from school where title='성결초등학교'), grade=5, class_no=1 where no=25;