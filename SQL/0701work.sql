-- 1 --
SELECT s.name
FROM student s
WHERE s.deptno1 = (SELECT deptno FROM department WHERE dname = '컴퓨터공학과');

-- 2 --
SELECT s.NAME, s.deptno1
FROM student s
WHERE s.deptno1 IN (SELECT deptno FROM department WHERE part = '100')
order by 2;

-- 3 --
SELECT s.NAME, 
  (select dname from department where deptno = s.deptno1) As 학과, s.tel
FROM student s
where substr(tel, 1, instr(tel, ')')-1) = (select substr(tel, 1, instr(tel, ')')-1) from student where name = '이윤나');

-- 4 --
select name, birthday
FROM student
WHERE birthday > (SELECT max(birthday) FROM student where deptno1 = 201);

-- 5 --
SELECT s.NAME, s.grade, s.height
FROM student s
WHERE height = (SELECT MAX(height) FROM student 
  WHERE s.grade = grade)
order by 2;

-- 6 --
SELECT NAME, grade, weight
FROM student
where weight > ALL(select max(weight) from student where grade = 1);

-- 7 --
SELECT m.NAME, m.pay, m.hiredate, m.position
FROM professor m
where pay = (select max(pay) from professor where m.position = position);

-- 8 --
SELECT p.NAME, p.deptno, 
  (select dname from department where p.deptno = deptno) AS dname
FROM professor p
WHERE p.deptno IN (SELECT deptno FROM professor WHERE position = '정교수');

-- 9 --
SELECT ename, hiredate
FROM emp
where hiredate > (select max(hiredate) from emp where deptno = 30);

-- 10 --
SELECT m.empno, m.NAME, m.pay, m.emp_type
FROM emp2 m
where m.pay IN (select min(pay) from emp2 where m.emp_type = emp_type);

-- 11 --
SELECT m.NAME, m.emp_type, m.birthday, m.pay
FROM emp2 m
WHERE m.birthday IN (SELECT MIN(birthday) FROM emp2 WHERE m.emp_type = emp_type);

-- 12 --
SELECT 
  (select dname from dept2 where dcode = m.deptno) AS dname, m.name, m.pay
FROM emp2 m
WHERE m.pay < ALL(SELECT avg(pay) FROM emp2 GROUP BY deptno)
ORDER BY 3;


