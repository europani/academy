SELECT e.ename, d.dname
FROM emp e, dept d;

SELECT * FROM student, department;

-- equi join --

SELECT s.NAME, s.deptno1, d.dname
FROM student s, department d
WHERE s.deptno1 = d.deptno;
-- 스칼라 쿼리 --
SELECT s.NAME AS 학생이름, s.deptno1 AS 학과번호, 
  (SELECT dname FROM department
    WHERE deptno = s.deptno1) AS 학과이름
FROM student s;


SELECT s.NAME AS 학생이름, s.profno AS 교수번호, p.NAME AS 교수이름
FROM student s, professor p
WHERE s.profno = p.profno;
-- 스칼라 쿼리 --
SELECT s.NAME AS 학생이름, s.profno AS 교수번호, 
  (SELECT NAME FROM professor
   WHERE s.profno = profno) AS 교수이름
FROM student s;


SELECT s.NAME AS 학생이름, d.dname AS 학과이름, p.NAME AS 교수이름
from STUDENT S, DEPARTMENT D, PROFESSOR P
WHERE s.deptno1 = d.deptno AND s.profno = p.profno;
-- 스칼라 쿼리 --
SELECT s.NAME AS 학생이름, 
  (SELECT dname FROM department
   WHERE s.deptno1 = deptno) AS 학과이름,
  (SELECT NAME FROM professor
   WHERE s.profno = profno) AS 교수이름
FROM student s;


SELECT e.NAME, e.position, e.pay, p.s_pay, p.e_pay
FROM emp2 e, p_grade p
where e.POSITION = p.POSITION;
SELECT e.NAME, e.position, e.pay, p.s_pay, p.e_pay
FROM emp2 e JOIN p_grade p
ON (e.position = p.position);
-- 스칼라 쿼리 --
SELECT e.NAME AS 사원이름, e.position AS 현재직급, e.pay AS 현재연봉,
  (SELECT s_pay FROM p_grade
   where position = e.position) AS 하한금액,
  (SELECT e_pay FROM p_grade
   WHERE position = e.position) AS 상한금액
FROM emp2 e;


SELECT s.NAME AS 학생이름, p.NAME AS 지도교수명
FROM student s, professor p
WHERE s.profno = p.profno AND s.deptno1 = 101;
-- 스칼라 쿼리 --
SELECT s.NAME, 
  (SELECT NAME FROM professor
   WHERE s.profno = profno) AS 지도교수명
FROM student s
where deptno1 = 101;

SELECT s.NAME, s.studno, e.total
FROM student s, exam_01 e
WHERE s.studno = e.studno;
-- 스칼라 쿼리 --
SELECT s.NAME, s.studno, 
  (select total from exam_01 WHERE s.studno = studno) AS total
FROM student s;

SELECT p.p_date, p.p_code, r.p_name AS 상품명, p.p_qty, p.p_total
FROM panmae p, product r
WHERE p.p_code = r.p_code;
-- 스칼라 쿼리 --
SELECT p.p_date, p.p_code, 
  (SELECT p_name FROM product WHERE p.p_code = p_code) AS 상품명, p.p_qty, p.p_total
FROM panmae p;


-- non-Equi Join --

SELECT g.gname, g.point, i.gname
FROM gogak g, gift i
WHERE g.point BETWEEN i.g_start AND i.g_end;
-- 스칼라 쿼리 --
SELECT g.gname, g.point,
  (SELECT gname FROM gift WHERE g.point BETWEEN g_start AND g_end)
FROM gogak g
order by 2;


SELECT i.gname, count(i.gname) AS 필요수량
FROM gogak g, gift i
WHERE g.point BETWEEN i.G_START AND i.G_END
group by i.gname;

SELECT s.NAME, e.total, h.grade
FROM student s, exam_01 e, hakjum h
WHERE s.studno = e.studno 
AND e.total BETWEEN h.min_point AND h.max_point;
-- 스칼라 쿼리 --
SELECT 
  (SELECT NAME FROM student WHERE studno = e.studno) AS NAME, 
  e.total, 
  (SELECT grade FROM hakjum WHERE e.total BETWEEN min_point AND max_point) AS grade
FROM exam_01 e;



SELECT g.gname, g.point, i.gname AS 상품명
FROM gogak g, gift i
WHERE i.g_start <= g.POINT
AND i.gname = '산악용자전거';

SELECT e.NAME, trunc((to_date('20130101')-e.birthday)/365,0) AS 현재나이,
e.POSITION AS 현재직급, p.position AS 예상직급
FROM emp2 e, p_grade p
WHERE trunc((to_date('20130101')-e.birthday)/365, 0) BETWEEN p.s_age AND p.e_age;
-- 스칼라 쿼리 --
SELECT e.NAME, trunc((to_date('20130101')-e.birthday)/365,0) AS 현재나이,
  e.position AS 현재직급, 
  (SELECT position FROM p_grade 
   WHERE trunc((to_date('20130101')-e.birthday)/365, 0) BETWEEN s_age AND e_age) AS 예상직급
FROM emp2 e
ORDER BY 2;


-- outer join --
SELECT NVL(s.NAME, '*****') AS 학생이름, NVL(p.NAME, '*****') AS 교수이름
FROM student s, professor p
WHERE s.profno(+) = p.profno
UNION
SELECT NVL(s.NAME, '*****') AS 학생이름, NVL(p.NAME, '*****') AS 교수이름
FROM student s, professor p
WHERE s.profno = p.profno(+);

-- self join --
SELECT A.dcode, A.dname || ' ->'AS 부서명, a.pdept, b.dname AS 상위부서명
FROM dept2 A, dept2 B
WHERE A.pdept = b.dcode
ORDER BY 1;

SELECT a.profno, a.NAME, a.hiredate, count(b.hiredate) AS 빠른사람
FROM professor a, professor b
WHERE a.hiredate > b.hiredate(+)
GROUP BY a.profno, a.NAME, a.hiredate
ORDER BY 4;

SELECT b.ename, count(a.ename) AS 직속직원
FROM emp a, emp b
WHERE a.mgr(+) = b.empno
GROUP BY b.ename
ORDER BY 2 DESC;
-- 스칼라 쿼리 --
SELECT b.ename,
  (SELECT count(*) FROM emp WHERE mgr = b.empno) AS 직속직원
FROM emp b
ORDER BY 2 DESC;


SELECT s.NAME, s.studno, e1.total, count(e2.studno) AS 낮은점수인원
FROM student s, exam_01 e1, exam_01 e2
WHERE s.studno = e1.studno AND e1.total > e2.total(+)
GROUP BY s.NAME, s.studno, e1.total
order by 4 desc;

SELECT s.NAME, s.studno, e1.total, count(e2.studno) AS 등수
FROM student s, exam_01 e1, exam_01 e2
WHERE s.studno = e1.studno AND e1.total <= e2.total(+)
GROUP BY s.NAME, s.studno, e1.total
ORDER BY 4;
