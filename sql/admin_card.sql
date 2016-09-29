-- card 시퀀스 생성
CREATE SEQUENCE SEQ_CARD
START WITH 3
INCREMENT BY 1;

-- card 시퀀스 제거
DROP SEQUENCE SEQ_CARD;

-- DB commit
COMMIT;

-- 최근에 커밋한 상태로 되돌리기
ROLLBACK;

-- card 정보 출력
SELECT * FROM CARD; -- 전체 출력
SELECT NO, TITLE, SKILL, BONUS, COVER FROM CARD; -- 카드 목록 출력 (웹사이트)
SELECT NO, TITLE, CONTENT, SKILL, BONUS, COVER FROM CARD where no = 1; -- 번호로 카드 조회 (웹사이트_수정 폼에서 사용)

-- card 등록
INSERT INTO "CARD" VALUES(SEQ_CARD.NEXTVAL, '뒤집어엎기', '깔라마네로의 뒤집어엎기 (점수 자릿수 뒤집기)', '(+)', '100', 'http://ec2-52-34-170-68.us-west-2.compute.amazonaws.com/images/reverse.png');
INSERT INTO "CARD" VALUES(SEQ_CARD.NEXTVAL, '튀어오르기', '잉어킹의 튀어오르기 (아무 일도 일어나지 않습니다.)', '(0)', '0', 'http://ec2-52-34-170-68.us-west-2.compute.amazonaws.com/images/reverse.png');
INSERT INTO "CARD" VALUES(SEQ_CARD.NEXTVAL, '마지막 일침', '독침붕의 마지막 일침 (1점 추가)', '(+)', '1', 'http://ec2-52-34-170-68.us-west-2.compute.amazonaws.com/images/reverse.png');

-- card 삭제
DELETE FROM "CARD" WHERE NO=1;

-- card 수정
UPDATE "CARD" SET TITLE = '마지막 일침', CONTENT = '독침붕의 마지막 일침 (현재 점수에 1점 추가)', SKILL = '(+)', BONUS = '1', COVER = 'http://ec2-52-34-170-68.us-west-2.compute.amazonaws.com/images/reverse.png' WHERE NO = '3';