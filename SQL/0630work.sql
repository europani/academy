-- 1 --
SELECT s.NAME, s.deptno1, d.dname
FROM student s, department d
WHERE s.deptno1 = d.deptno
AND s.grade = 4;

-- 2 --
SELECT s.NAME, s.deptno1, d.dname, d.BUILD
FROM student s, department d
WHERE s.deptno1 = d.deptno
AND s.name like '김%';

-- 3 --
SELECT d1.dname, d2.dname
FROM dept2 d1, dept2 d2
where d1.pdept = d2.dcode(+);

-- 4 --
SELECT s.NAME, d.dname
FROM student s, department d
WHERE s.deptno1 = d.deptno
AND s.NAME = '오나라';

-- 5 --
SELECT d1.deptno, d1.dname , d2.dname 
FROM department d1, department d2
WHERE d1.part = d2.deptno
AND d1.deptno > 201;

-- 6 --
SELECT p.NAME, count(s.profno) AS 학생수
FROM professor p, student s
where p.profno = s.profno
group by p.name;

-- 7 --
SELECT d.dname, listagg(s.NAME ,',') WITHIN GROUP (ORDER  BY d.dname) AS listagg
FROM department d, student s
where d.deptno = s.deptno1
group by d.dname;

-- 8 --
SELECT p.NAME, listagg(s.NAME|| '(' || s.grade || ')',',') WITHIN GROUP (ORDER BY p.NAME) 
    AS LIST
FROM professor p, student s
WHERE p.profno = s.profno
group by p.name;

-- 9 --
SELECT NVL(h.grade, '전체인원') AS 학점, count(s.name)
FROM hakjum h, exam_01 e, student s
WHERE s.studno = e.studno 
AND e.total BETWEEN h.min_point AND h.max_point
GROUP BY cube(h.grade)
ORDER BY 1;

-- 10 --
SELECT g.gname, g.point, listagg(i.gname, ',') within group (order by g.point)
FROM gogak g, gift i
where g.point >= i.g_start
group by g.gname, g.point
order by 2 desc;

