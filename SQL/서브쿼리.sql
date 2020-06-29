SELECT ename, sal FROM emp
WHERE sal > ( SELECT sal
              FROM emp
              where ename = 'MARTIN');

SELECT s.NAME, d.dname
FROM student s, department d
WHERE s.deptno1 = d.deptno 
AND s.deptno1 = ( SELECT deptno1 FROM student
WHERE NAME = '이윤나');

SELECT p.NAME, p.hiredate, d.dname
FROM professor p, department d
WHERE p.deptno = d.deptno
AND p.hiredate > (SELECT hiredate FROM professor
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

SELECT empno, NAME, deptno
FROM emp2
WHERE deptno IN ( SELECT dcode
  FROM dept2
  WHERE area = '서울지사');
