-- 시퀀스
drop sequence seq_wishbook;

create sequence seq_wishbook
start with 1
Increment by 1;

select * from wishbook;
select * from publisher;
select * from book;

-- insert
insert into wishbook values(seq_wishbook.nextval, '테스트북1', '비룡소', '테스트', sysdate, 0, 0, 1);
insert into wishbook values(seq_wishbook.nextval, '테스트북2', '테스트출판사1', '테스트2', sysdate, 0, 0, 2);
insert into wishbook values(seq_wishbook.nextval, '테스트북3', '웅진주니어', '테스트3', sysdate, 2, 0, 2);
insert into wishbook values(seq_wishbook.nextval, '테스트북4', '테스트출판사2', '테스트4', sysdate, 2, 1, 2);

-- select
select w.no, w.title, m.NAME, w.recommend, w.accept from wishbook w, member m where w.MEMBER_NO = m.NO order by w.recommend desc;
select * from publisher where title like '비룡소';
select w.title, w.publisher, w.reason, w.reg_date as regDate, w.recommend, w.accept, m.name
  from wishbook w, member m 
  where w.MEMBER_NO = m.NO and w.no=1;
select * from publisher where title like '%' || '웅진주니어' || '%' order by no asc;
select * from book where title like '%' || '가' || '%' order by no asc;

-- alter
alter table wishbook modify(publisher_no varchar(10));

-- 승인 버튼 클릭시 동작
select * from publisher where title='테스트출판사1';
insert into publisher values(seq_publisher.nextval, '테스트출판사1');
select publisher from wishbook where no=2;
select no from publisher where title=(select publisher from wishbook where no=2);
insert into book 
  values(seq_book.nextval, '테스트북2', 0, '', (select no 
                                                from publisher 
                                                where title=(select publisher 
                                                              from wishbook 
                                                              where no=2)), null);
update wishbook set accept=1 where no=2;

-- 반려 버튼 클릭시 동작
update wishbook set accept=2 where no=1;