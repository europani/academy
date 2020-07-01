-- INSERT INTO ~~ VALUES ~~ --
INSERT INTO dept2(dcode, dname, pdept, area)
  VALUES (9001, 'Ư��1��', '������', '�ӽ�����');
INSERT INTO dept2
  VALUES (9001, 'Ư��2��', '������', '�ӽ�����');
INSERT INTO dept2(dcode, dname, pdept)
  values (9002, 'Ư��3��', '������');
  
ALTER TABLE dept2 MODIFY (pdept VARCHAR2(9));
UPDATE dept2 SET pdept = 1006 where pdept = '������';
SELECT * FROM dept2;

INSERT INTO professor (profno, NAME, ID, position, pay, hiredate)
  VALUES (5001, '�輳��', 'Love_me', '������', 510, '20111114');
SELECT * FROM professor;
INSERT INTO professor (profno, NAME, ID, position, pay, hiredate)
  VALUES (5002, '�輳��', 'Love_me', '������', 510, '2011-11-14');
INSERT INTO professor (profno, NAME, ID, position, pay, hiredate)
  VALUES (5003, '�輳��', 'Love_me', '������', 510, '2011/11/14');

ALTER SESSION SET NLS_DATE_FORMAT = 'yyyy-mon-dd';  
INSERT INTO professor (profno, NAME, ID, position, pay, hiredate)
  VALUES (5004, '�輳��', 'Love_me', '������', 510, '2011/11��/14');

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
  WHERE position = '������';
  
UPDATE professor SET pay = pay*1.15
  WHERE pay < 250 AND position = 
    (SELECT position FROM professor WHERE NAME = '����ö');

-- DELETE FROM ~~ --
DELETE FROM dept2 WHERE dcode BETWEEN 9000 AND 9100;

-- MERGE --
MERGE INTO p_total total
USING pt_01 p01
ON (total.�ǸŹ�ȣ = p01.�ǸŹ�ȣ)
WHEN MATCHED THEN
UPDATE SET total.��ǰ��ȣ = p01.��ǰ��ȣ
WHEN NOT MATCHED THEN
INSERT VALUES (p01.�ǸŹ�ȣ, p01.��ǰ��ȣ, p01.����, p01.�ݾ�);

MERGE INTO p_total total
USING pt_02 p02
ON (total.�ǸŹ�ȣ = p02.�ǸŹ�ȣ)
WHEN MATCHED THEN
UPDATE SET total.��ǰ��ȣ = p02.��ǰ��ȣ
WHEN NOT MATCHED THEN
INSERT VALUES (p02.�ǸŹ�ȣ, p02.��ǰ��ȣ, p02.����, p02.�ݾ�);