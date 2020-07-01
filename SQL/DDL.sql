-- CREATE --
CREATE TABLE ddl_test (
  NO NUMBER(3),
  NAME VARCHAR2(10),
  birth date default sysdate);
  
CREATE TABLE exddl01 (
  employee_id NUMBER(6),
  emp_name VARCHAR2(80),
  salary NUMBER(8, 2),
  manager_id NUMBER(6));
  
INSERT INTO exddl01
  SELECT empno, ename, sal, mgr FROM emp e
  WHERE e.mgr=7566 AND e.sal BETWEEN 1000 AND 3000;
  
-- 가상 컬럼 --
CREATE TABLE vt001(
  no1 number,
  no2 NUMBER,
  no3 NUMBER GENERATED ALWAYS AS (no1 + no2) virtual);
  
INSERT INTO vt001(no1, no2) VALUES(1, 2);
UPDATE vt001 SET no1 = 10;
SELECT * FROM vt001;
  
ALTER TABLE vt001 ADD UNIQUE(no3);
INSERT INTO vt001(no1, no2) VALUES(3,4);

ALTER TABLE vt001 ADD (no4 GENERATED ALWAYS AS ((no1*12)+no2));

SELECT column_name, data_type, data_default
FROM user_tab_columns
WHERE table_name = 'VT001'
ORDER BY column_id;

CREATE TABLE panmae10(
  NO NUMBER,
  pcode CHAR(4),
  pdate char(8),
  pqty NUMBER,
  pbungi NUMBER(1) GENERATED ALWAYS AS (
    CASE
    WHEN substr(pdate, 5, 2) IN ('01', '02', '03') THEN 1
    WHEN substr(pdate, 5, 2) IN ('04', '05', '06') THEN 2
    WHEN substr(pdate, 5, 2) IN ('07', '08', '09') THEN 3
    WHEN substr(pdate, 5, 2) IN ('10', '11', '12') THEN 4
    ELSE 4
    END));
INSERT INTO panmae10 (NO, pcode, pdate, pqty) VALUES (1, '100', '20110112', 10);
INSERT INTO panmae10 (NO, pcode, pdate, pqty) VALUES (2, '200', '20110505', 20);
INSERT INTO panmae10 (NO, pcode, pdate, pqty) VALUES (3, '300', '20110812', 30);
INSERT INTO panmae10 (NO, pcode, pdate, pqty) VALUES (3, '400', '20110124', 40);
SELECT * FROM panmae10;

-- ALTER --
CREATE TABLE dept6
  AS SELECT dcode, dname 
  FROM dept2
  WHERE dcode IN(1000, 1001, 1002);
--ADD--  
ALTER TABLE dept6 ADD (loc2 VARCHAR2(10) DEFAULT '서울');
--RENAME--
ALTER TABLE dept6 RENAME COLUMN loc2 TO area;
RENAME dept6 TO dept7;
--MODIFY--
ALTER TABLE dept7 MODIFY (dcode VARCHAR2(10));
--DROP--
ALTER TABLE dept7 DROP COLUMN loc;

-- 읽기 전용 --
CREATE TABLE t_read (
  NO NUMBER,
  NAME VARCHAR(10));
INSERT INTO t_read VALUES (1, 'AAA');
ALTER TABLE t_read READ ONLY;
ALTER TABLE t_read READ WRITE;
CREATE TABLE t_read (
  NO NUMBER);  
DROP TABLE t_read;  


select * from tab;

  