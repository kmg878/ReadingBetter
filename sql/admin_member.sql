-- 시퀀스
drop sequence seq_member;

create sequence seq_member
start with 3
Increment by 1;

drop sequence seq_school;

create sequence seq_school
start with 1
Increment by 1;

-- insert
select * from member;
insert into member values(seq_member.nextval, 'kmg878', 'monki8783349', 'GM민', 'kmg878@naver.com', '0100000000', sysdate, 0, 0, 2, 4, 1);
insert into member values(seq_member.nextval, 'ysi1246', 'abcd1234', 'GM송', 'ysi1246@daum.net', '0100000000', sysdate, 0, 0, null, null, null);
insert into member values(seq_member.nextval, 'deleteTest', 'aaaa', 'aa', 'aa@daum.net', '0100000000', sysdate, 0, 0, null, null, null);

select * from school;
insert into school values(seq_school.nextval, '성결초등학교');

select * from register;
insert into register values(seq_register.nextval, 2, 4, 1);

-- admin list select
select no, id, name, penalty from member where id like '%' || 'k' || '%' order by no asc;

delete from member where no=23;
commit;