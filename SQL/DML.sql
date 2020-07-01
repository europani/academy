-- INSERT INTO ~~ VALUES ~~ --
INSERT INTO dept2(dcode, dname, pdept, area)
  VALUES (9001, '특판1팀', '영업부', '임시지역');
INSERT INTO dept2
  VALUES (9001, '특판2팀', '영업부', '임시지역');
INSERT INTO dept2(dcode, dname, pdept)
  values (9002, '특판3팀', '영업부');
  
ALTER TABLE dept2 MODIFY (pdept VARCHAR2(9));
UPDATE dept2 SET pdept = 1006 where pdept = '영업부';
SELECT * FROM dept2;

INSERT INTO professor (profno, NAME, ID, position, pay, hiredate)
  VALUES (5001, '김설희', 'Love_me', '정교수', 510, '20111114');
SELECT * FROM professor;
INSERT INTO professor (profno, NAME, ID, position, pay, hiredate)
  VALUES (5002, '김설희', 'Love_me', '정교수', 510, '2011-11-14');
INSERT INTO professor (profno, NAME, ID, position, pay, hiredate)
  VALUES (5003, '김설희', 'Love_me', '정교수', 510, '2011/11/14');

ALTER SESSION SET NLS_DATE_FORMAT = 'yyyy-mon-dd';  
INSERT INTO professor (profno, NAME, ID, position, pay, hiredate)
  VALUES (5004, '김설희', 'Love_me', '정교수', 510, '2011/11월/14');

CREATE TABLE professor2 AS SELECT * FROM professor;
CREATE TABLE professor3 AS SELECT * FROM professor WHERE 1=2;
INSERT INTO professor3
  SELECT * FROM professor;

-- INSERT ALL INTO --
INSERT ALL INTO p_01(NO, NAME)
  VALUES (1, 'AAA')
  INTO p_02(NO, NAME)
  VALUES (2, 'BBB')
  SELECT * FROM dual;
  
INSERT ALL
    when profno between 1000 and 1999 then
    INTO p_01 VALUES(profno, NAME)
    when profno between 2000 and 2999 then
    INTO p_02 VALUES(profno, NAME)
  SELECT profno, NAME FROM professor;
INSERT ALL
    INTO p_01 VALUES(profno, NAME)
    INTO p_02 VALUES(profno, NAME)
  SELECT profno, NAME FROM professor 
  WHERE profno BETWEEN 3000 AND 3999;

-- UPDATE ~~ SET ~~ --
UPDATE professor SET bonus = 100
  WHERE position = '정교수';
  
UPDATE professor SET pay = pay*1.15
  WHERE pay < 250 AND position = 
    (SELECT position FROM professor WHERE NAME = '차범철');

-- DELETE FROM ~~ --
DELETE FROM dept2 WHERE dcode BETWEEN 9000 AND 9100;

-- MERGE --
MERGE INTO p_total total
USING pt_01 p01
ON (total.판매번호 = p01.판매번호)
WHEN MATCHED THEN
UPDATE SET total.제품번호 = p01.제품번호
WHEN NOT MATCHED THEN
INSERT VALUES (p01.판매번호, p01.제품번호, p01.수량, p01.금액);

MERGE INTO p_total total
USING pt_02 p02
ON (total.판매번호 = p02.판매번호)
WHEN MATCHED THEN
UPDATE SET total.제품번호 = p02.제품번호
WHEN NOT MATCHED THEN
INSERT VALUES (p02.판매번호, p02.제품번호, p02.수량, p02.금액);