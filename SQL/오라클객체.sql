-- 인덱스 --
SELECT ROWID, empno, ename FROM emp WHERE empno = 7902;

CREATE INDEX idx_prof_position
ON professor(position desc);

-- 고유 인덱스--
CREATE UNIQUE INDEX idx_dept2_dname
ON dept2(dname);

INSERT INTO dept2 VALUES (9100, '임시매장', 1006, '서울지사');
--INSERT INTO dept2 VALUES (9101, '임시매장', 1006, '부산지사');

-- 결합 인덱스 --
CREATE INDEX idx_professor
on professor(name, deptno);


-- 뷰 --
CREATE OR REPLACE VIEW v_prof2
AS (SELECT profno, NAME, email, hpage
  FROM professor);
-- 단일 뷰 --  
CREATE INDEX idx_v_prof_name
ON v_prof(NAME);
-- 복합 뷰 --
CREATE VIEW v_prof_dept
AS (SELECT p.profno AS 교수번호, p.NAME AS 교수명, d.dname AS 소속학과명
    FROM professor p ,department d
    WHERE p.deptno = d.deptno);
    
-- 인라인 뷰 --
SELECT d.dname, s.max_height, s.max_weight
FROM (SELECT deptno1, MAX(height) AS max_height, MAX(weight) AS max_weight FROM student GROUP BY deptno1) s, department d
WHERE d.deptno = s.deptno1;
-- 서브쿼리 --
SELECT d.dname, s.height, s.NAME, s.height 
FROM student s, department d
WHERE s.height = (SELECT MAX(height) FROM student WHERE s.deptno1 = deptno1
AND s.deptno1 = d.deptno);

-- 서브쿼리 + 스칼라쿼리 --
SELECT s.grade, s.NAME, s.height, 
  (SELECT avg(height) FROM student s2
    where s2.grade = s.grade) AS 평균
FROM student s
WHERE s.height > (SELECT avg(height) FROM student s WHERE s.grade = grade)
ORDER BY 1;   
-- 서브쿼리 + 조인 + 인라인 뷰로 변경 --
SELECT s.grade, s.NAME, s.height, s2.avg_height AS 평균
FROM student s, (SELECT grade, avg(height) AS avg_height FROM student GROUP BY grade) s2
WHERE s.height > (SELECT avg(height) FROM student WHERE s.grade = grade)
AND s2.grade = s.grade
order by 1;


-- Materialized View --
CREATE MATERIALIZED VIEW mv_prof
BUILD IMMEDIATE
REFRESH
ON DEMAND
COMPLETE
ENABLE QUERY REWRITE
AS  
  SELECT profno, NAME, pay
  FROM professor
  WHERE deptno IN (101, 102, 103);

-- 시퀀스 --
CREATE SEQUENCE seq_jumun_no
INCREMENT BY 1
START WITH 1000
MAXVALUE 1010
MINVALUE 990
CYCLE
CACHE 2;

CREATE TABLE jumun (
  j_no NUMBER(4),
  j_name VARCHAR2(10));
  
INSERT INTO jumun VALUES (seq_jumun_no.currval, 'AAAA');

CREATE SEQUENCE s_rev
START WITH 5
INCREMENT BY -1
MINVALUE 0
MAXVALUE 10;

INSERT INTO jumun VALUES (s_rev.nextval, 'AAAA');

SELECT sequence_name AS 이름, min_value AS min값, max_value "최대값", increment_by AS 증가값, cycle_flag "cycle?", 
  order_flag "정렬", cache_size AS 캐싱값, last_number AS 마지막생성값 
FROM user_sequences
WHERE sequence_name = 'SEQ_JUMUN_NO';

ALTER SEQUENCE seq_jumun_no
  MAXVALUE 1100
  cache 5;

-- synonym --
CREATE SYNONYM e2
FOR emp2;
CREATE PUBLIC SYNONYM d2 FOR department;

SELECT * FROM e2;
SELECT * FROM d2;




