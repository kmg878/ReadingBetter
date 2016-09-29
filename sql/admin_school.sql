select * from school;

-- insert
insert into school values(seq_school.nextval, '테스트1초등학교');

-- select
select * from school where title like '%' || '테' || '%' order by no asc;