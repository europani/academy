SELECT e.ename, d.dname
FROM emp e, dept d;

SELECT * FROM student, department;

-- equi join --
SELECT s.NAME, s.deptno1, d.dname
FROM student s, department d
WHERE s.deptno1 = d.deptno;
