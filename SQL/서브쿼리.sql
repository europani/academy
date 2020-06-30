SELECT ename, sal FROM emp
WHERE sal > ( SELECT sal
              FROM emp
              where ename = 'MARTIN');

SELECT s.NAME, d.dname
FROM student s, department d
WHERE s.deptno1 = d.deptno 
AND s.deptno1 = ( SELECT deptno1 FROM student
WHERE NAME = '이윤나');
-- 스칼라 서브쿼리 --
SELECT NAME, (SELECT dname FROM department 
    WHERE s.deptno1 = deptno)
FROM student s
WHERE deptno1 = 101;


SELECT p.NAME, p.hiredate, d.dname
FROM professor p, department d
WHERE p.deptno = d.deptno
AND p.hiredate > (SELECT hiredate FROM professor
WHERE NAME = '송도권');
-- 스칼라 서브쿼리 --
SELECT NAME, hiredate, (SELECT dname FROM department
    WHERE p.deptno = deptno) AS 학과명
FROM professor p
WHERE hiredate > (SELECT hiredate FROM professor
  WHERE NAME = '송도권');

SELECT NAME, weight
FROM student
where weight > (SELECT avg(weight) FROM student
WHERE deptno1 = 101);

SELECT NAME, pay, hiredate
FROM professor
WHERE hiredate = (SELECT hiredate FROM professor
  WHERE NAME = '심슨')
AND pay < (SELECT pay FROM professor
  WHERE NAME = '조인형');

-- 다중행 서브쿼리 --
SELECT empno, NAME, deptno
FROM emp2
WHERE deptno IN ( SELECT dcode
  FROM dept2
  WHERE area = '서울지사');

SELECT NAME, position, TO_CHAR(pay, '999,999,999') AS 급여 
FROM emp2
where pay > (SELECT MIN(pay) 
  FROM emp2
  WHERE position = '과장')
order by 3 desc;

SELECT NAME, position, TO_CHAR(pay, '999,999,999') AS 급여 
from EMP2
where pay > ANY (SELECT pay 
  FROM emp2
  where POSITION = '과장')
ORDER BY 3 DESC;

SELECT NAME, grade, weight
FROM student
WHERE weight < (SELECT MIN(weight)
  FROM student
  WHERE grade = 4)
ORDER BY 3 DESC;

SELECT NAME, grade, weight
FROM student
WHERE weight < (SELECT MIN(weight)
  FROM student
  WHERE grade = 4)
ORDER BY 3 DESC;

SELECT NAME, grade, weight
FROM student
WHERE weight < ALL (SELECT weight
  FROM student
  WHERE grade = 4)
ORDER BY 3 DESC;

-- 다중열 서브쿼리 --
SELECT empno, name, pay, position
FROM emp2
WHERE (pay, position) IN (SELECT MAX(pay), position
  FROM emp2
  GROUP BY position);
-- 상호 연관 서브 쿼리 --
SELECT empno, NAME, pay, position
FROM emp2 m
WHERE pay = (SELECT MAX(pay)
  FROM emp2
  WHERE m.position = position);
  
SELECT grade, NAME, height
FROM student
WHERE (grade, height) IN (SELECT grade, MAX(height)
  FROM student
  group by grade)
ORDER BY 1;
-- 상호 연관 서브 쿼리 --
SELECT grade, NAME, height
FROM student m
WHERE height = (SELECT MAX(height)
  FROM student
  WHERE m.grade = grade)
ORDER BY 1;

SELECT p.profno, p.NAME, p.hiredate, d.dname
FROM professor p, department d
WHERE (p.hiredate, d.deptno) IN (SELECT MIN(hiredate), deptno 
  FROM professor
  GROUP BY deptno)
AND p.deptno = d.deptno
ORDER BY 4;
-- 상호 연관 서브 쿼리 --
SELECT p.profno, p.NAME, p.hiredate, d.dname
FROM professor p, department d
WHERE p.hiredate = (SELECT MIN(hiredate) 
  FROM professor
  WHERE p.deptno = deptno)
AND p.deptno = d.deptno
ORDER BY 4;

SELECT NAME, position, pay
FROM emp2
WHERE (position, pay) IN (SELECT position, MAX(pay)
FROM emp2
GROUP BY position)
order by 3;
-- 상호 연관 서브 쿼리 --
SELECT NAME, position, pay
FROM emp2 m
WHERE pay >= (SELECT MAX(pay)
FROM emp2
where m.position = position)
order by 3;

SELECT d.dname, e.NAME, e.pay
FROM dept2 d, emp2 e
WHERE d.dcode = e.deptno
AND e.pay < ALL(SELECT avg(pay)
  FROM emp2
  GROUP BY deptno)
order by 3;

-- 스칼라 서브쿼리 --
SELECT NAME, (SELECT dname
    FROM dept2 d
    WHERE e.deptno = d.dcode) AS 부서이름
FROM emp2 e;

-- 인라인 뷰 --
SELECT d.dname AS 학과명, s.max_height AS 최대키, s.max_weight AS 최대몸무게
FROM (SELECT deptno1, MAX(height) AS max_height, MAX(weight) AS max_weight
  FROM student
  GROUP BY deptno1) s, department d
WHERE s.deptno1 = d.deptno;

-- rownum --
SELECT * FROM student WHERE ROWNUM < 5;
SELECT * FROM student WHERE ROWNUM > 5;

---- ★★ ----
SELECT * FROM(
SELECT ROWNUM AS rnum, a.* FROM
 (SELECT s.NAME, e.total
  FROM student s, exam_01 e
  WHERE s.studno = e.studno
  ORDER BY e.total DESC) a)
WHERE rnum BETWEEN 3 AND 5;
------------------------------------

-- exists --
SELECT * FROM emp
WHERE EXISTS (SELECT 1 FROM emp
  where ename = 'FORD' AND empno = 333);
SELECT * FROM emp
WHERE NOT EXISTS (SELECT 1 FROM emp
  where ename = 'FORD' AND empno = 333);



SELECT ROWNUM AS 순위, p.*
FROM professor p;

SELECT * FROM
(SELECT ROWNUM AS 순위, p.* FROM 
  (SELECT * FROM professor ORDER BY pay) p)
WHERE 순위 BETWEEN 1 AND 3;
