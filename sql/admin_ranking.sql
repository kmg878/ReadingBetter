-- 커밋
commit;

SELECT  no, name, school_no, grade FROM member ORDER by no asc;

-- 테이블 전체 조회
Select * From scores;
Select no, id, pw, school_no, grade From member order by no asc;
select * from school;

-- 점수 삽입
INSERT INTO "SCORES" VALUES(1, '100', '10', '1215');
INSERT INTO "SCORES" VALUES(2, '70', '5', '713');
INSERT INTO "SCORES" VALUES(25, '610', '40', '1125');
INSERT INTO "SCORES" VALUES(43, '320', '10', '2700');

-- 점수 테스트 회원 삽입
INSERT INTO "SCORES" VALUES(63, '300', '10', '2000');
INSERT INTO "SCORES" VALUES(64, '200', '10', '1500');
INSERT INTO "SCORES" VALUES(65, '150', '10', '1000');
INSERT INTO "SCORES" VALUES(66, '100', '10', '900');
INSERT INTO "SCORES" VALUES(67, '90', '10', '800');
INSERT INTO "SCORES" VALUES(68, '80', '10', '700');
INSERT INTO "SCORES" VALUES(69, '350', '10', '600');

INSERT INTO "SCORES" VALUES(88, '123', '4', '567');
INSERT INTO "SCORES" VALUES(87, '765', '4', '3210');
INSERT INTO "SCORES" VALUES(86, '13', '1', '167');
INSERT INTO "SCORES" VALUES(85, '111', '22', '333');
INSERT INTO "SCORES" VALUES(84, '999', '9', '9999');

/* 한 달 순위 */

-- 한 달 순위 (상위 10명)
SELECT rank() OVER(ORDER BY score DESC) as rank,ID, score as monthlyScore FROM scores, MEMBER WHERE MEMBER.NO = scores.member_no;
select rank, id, monthlyscore from (SELECT rank() OVER(ORDER BY score DESC) as rank,ID, score as monthlyScore FROM scores, MEMBER WHERE MEMBER.NO = scores.member_no) where rownum<=10;

-- 한 달 순위 (해당 회원)
select rank, id, myMonthlyscore from (SELECT rank() OVER(ORDER BY score DESC) rank, ID, no, score as myMonthlyScore FROM scores, MEMBER WHERE MEMBER.NO = scores.member_no) where no=2;

/* 명예의 전당 */

-- 전체 순위 (명예의 전당_상위 10명)
select rank, id, totalscore from (SELECT rank() OVER(ORDER BY scores.total_score DESC) as rank,ID, scores.total_score as totalscore FROM scores, MEMBER WHERE MEMBER.NO = scores.member_no) where rownum<=10;

-- 전체 순위 (명예의 전당_해당 회원)
select rank, id, myTotalScore from (SELECT rank() OVER(ORDER BY scores.total_score DESC) rank, ID, no, scores.total_score as myTotalScore FROM scores, MEMBER WHERE MEMBER.NO = scores.member_no) where no=2;

-- 전체 순위 (명예의 전당_Top3)
select rank, id from (SELECT rank() OVER(ORDER BY scores.total_score DESC) as rank,ID, scores.total_score as totalscore FROM scores, MEMBER WHERE MEMBER.NO = scores.member_no) where rownum<=3 order by rank asc;

/* 학교 */

-- 학교별 순위 (상위 10곳)
select rank, title, schoolscore
from (select rank() OVER(ORDER BY SchoolScore DESC) as rank, title, schoolscore
      from (select
                     b.school_no,sum(a.score) as SchoolScore
            from     scores a, member b
            where    b.no=a.member_no
            group by school_no, b.school_no) a,school b
where b.no=a.school_no and NOT(title='기타')
order by rank asc) where rownum <= 10;

-- 우리 학교 순위 
select sno, rank, title, mySchoolScore
  from(select b.no as schoolno, rank() OVER(ORDER BY mySchoolScore DESC) as rank, title, mySchoolScore, b.NO as sno
			   from (select    b.school_no, sum(a.score) as mySchoolScore
                 from    scores a, member b
                where    b.no=a.member_no
             group by school_no, b.school_no) a, school b
                where b.no=a.school_no and NOT(title='기타')), member
  where MEMBER.school_no=sno and id='ysi1246';

/* 학년별 순위 */

-- 학년별 순위 (상위 10명)
select grade, rank, id, score
from (select rank() over(order by score desc) rank,
             b.id as id,
             b.grade as grade,
             a.score as score
        from scores a,member b
       where b.no=a.member_no
         and grade = 3)
where rownum <= 10;

-- 요약 페이지 (회원의 학년 순위)
select grade, rank, id, score
from (select rank() over(order by score desc) rank,
             b.id as id,
             b.grade as grade,
             a.score as score
        from scores a,member b
       where b.no=a.member_no
         and grade = (select grade from member where id='kg00003'))
where rownum <= 10;

-- 로그인 한 회원의 해당 학년 내 순위
select grade, rank, id, score
from (select rank() over(order by score desc) rank,
             b.id as id,
             b.grade as grade,
             a.score as score
        from scores a,member b
       where b.no=a.member_no
         and grade = (select grade from member where id='ysi1246'))
where id = 'ysi1246';