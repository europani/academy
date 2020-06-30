SELECT e.ename, d.dname
FROM emp e, dept d;

SELECT * FROM student, department;

-- equi join --

SELECT s.NAME, s.deptno1, d.dname
FROM student s, department d
WHERE s.deptno1 = d.deptno;
-- ��Į�� ���� --
SELECT s.NAME AS �л��̸�, s.deptno1 AS �а���ȣ, 
  (SELECT dname FROM department
    WHERE deptno = s.deptno1) AS �а��̸�
FROM student s;


SELECT s.NAME AS �л��̸�, s.profno AS ������ȣ, p.NAME AS �����̸�
FROM student s, professor p
WHERE s.profno = p.profno;
-- ��Į�� ���� --
SELECT s.NAME AS �л��̸�, s.profno AS ������ȣ, 
  (SELECT NAME FROM professor
   WHERE s.profno = profno) AS �����̸�
FROM student s;


SELECT s.NAME AS �л��̸�, d.dname AS �а��̸�, p.NAME AS �����̸�
from STUDENT S, DEPARTMENT D, PROFESSOR P
WHERE s.deptno1 = d.deptno AND s.profno = p.profno;
-- ��Į�� ���� --
SELECT s.NAME AS �л��̸�, 
  (SELECT dname FROM department
   WHERE s.deptno1 = deptno) AS �а��̸�,
  (SELECT NAME FROM professor
   WHERE s.profno = profno) AS �����̸�
FROM student s;


SELECT e.NAME, e.position, e.pay, p.s_pay, p.e_pay
FROM emp2 e, p_grade p
where e.POSITION = p.POSITION;
SELECT e.NAME, e.position, e.pay, p.s_pay, p.e_pay
FROM emp2 e JOIN p_grade p
ON (e.position = p.position);
-- ��Į�� ���� --
SELECT e.NAME AS ����̸�, e.position AS ��������, e.pay AS ���翬��,
  (SELECT s_pay FROM p_grade
   where position = e.position) AS ���ѱݾ�,
  (SELECT e_pay FROM p_grade
   WHERE position = e.position) AS ���ѱݾ�
FROM emp2 e;


SELECT s.NAME AS �л��̸�, p.NAME AS ����������
FROM student s, professor p
WHERE s.profno = p.profno AND s.deptno1 = 101;
-- ��Į�� ���� --
SELECT s.NAME, 
  (SELECT NAME FROM professor
   WHERE s.profno = profno) AS ����������
FROM student s
where deptno1 = 101;

SELECT s.NAME, s.studno, e.total
FROM student s, exam_01 e
WHERE s.studno = e.studno;
-- ��Į�� ���� --
SELECT s.NAME, s.studno, 
  (select total from exam_01 WHERE s.studno = studno) AS total
FROM student s;

SELECT p.p_date, p.p_code, r.p_name AS ��ǰ��, p.p_qty, p.p_total
FROM panmae p, product r
WHERE p.p_code = r.p_code;
-- ��Į�� ���� --
SELECT p.p_date, p.p_code, 
  (SELECT p_name FROM product WHERE p.p_code = p_code) AS ��ǰ��, p.p_qty, p.p_total
FROM panmae p;


-- non-Equi Join --

SELECT g.gname, g.point, i.gname
FROM gogak g, gift i
WHERE g.point BETWEEN i.g_start AND i.g_end;
-- ��Į�� ���� --
SELECT g.gname, g.point,
  (SELECT gname FROM gift WHERE g.point BETWEEN g_start AND g_end)
FROM gogak g
order by 2;


SELECT i.gname, count(i.gname) AS �ʿ����
FROM gogak g, gift i
WHERE g.point BETWEEN i.G_START AND i.G_END
group by i.gname;

SELECT s.NAME, e.total, h.grade
FROM student s, exam_01 e, hakjum h
WHERE s.studno = e.studno 
AND e.total BETWEEN h.min_point AND h.max_point;
-- ��Į�� ���� --
SELECT 
  (SELECT NAME FROM student WHERE studno = e.studno) AS NAME, 
  e.total, 
  (SELECT grade FROM hakjum WHERE e.total BETWEEN min_point AND max_point) AS grade
FROM exam_01 e;



SELECT g.gname, g.point, i.gname AS ��ǰ��
FROM gogak g, gift i
WHERE i.g_start <= g.POINT
AND i.gname = '��ǿ�������';

SELECT e.NAME, trunc((to_date('20130101')-e.birthday)/365,0) AS ���糪��,
e.POSITION AS ��������, p.position AS ��������
FROM emp2 e, p_grade p
WHERE trunc((to_date('20130101')-e.birthday)/365, 0) BETWEEN p.s_age AND p.e_age;
-- ��Į�� ���� --
SELECT e.NAME, trunc((to_date('20130101')-e.birthday)/365,0) AS ���糪��,
  e.position AS ��������, 
  (SELECT position FROM p_grade 
   WHERE trunc((to_date('20130101')-e.birthday)/365, 0) BETWEEN s_age AND e_age) AS ��������
FROM emp2 e
ORDER BY 2;


-- outer join --
SELECT NVL(s.NAME, '*****') AS �л��̸�, NVL(p.NAME, '*****') AS �����̸�
FROM student s, professor p
WHERE s.profno(+) = p.profno
UNION
SELECT NVL(s.NAME, '*****') AS �л��̸�, NVL(p.NAME, '*****') AS �����̸�
FROM student s, professor p
WHERE s.profno = p.profno(+);

-- self join --
SELECT A.dcode, A.dname || ' ->'AS �μ���, a.pdept, b.dname AS �����μ���
FROM dept2 A, dept2 B
WHERE A.pdept = b.dcode
ORDER BY 1;

SELECT a.profno, a.NAME, a.hiredate, count(b.hiredate) AS �������
FROM professor a, professor b
WHERE a.hiredate > b.hiredate(+)
GROUP BY a.profno, a.NAME, a.hiredate
ORDER BY 4;

SELECT b.ename, count(a.ename) AS ��������
FROM emp a, emp b
WHERE a.mgr(+) = b.empno
GROUP BY b.ename
ORDER BY 2 DESC;
-- ��Į�� ���� --
SELECT b.ename,
  (SELECT count(*) FROM emp WHERE mgr = b.empno) AS ��������
FROM emp b
ORDER BY 2 DESC;


SELECT s.NAME, s.studno, e1.total, count(e2.studno) AS ���������ο�
FROM student s, exam_01 e1, exam_01 e2
WHERE s.studno = e1.studno AND e1.total > e2.total(+)
GROUP BY s.NAME, s.studno, e1.total
order by 4 desc;

SELECT s.NAME, s.studno, e1.total, count(e2.studno) AS ���
FROM student s, exam_01 e1, exam_01 e2
WHERE s.studno = e1.studno AND e1.total <= e2.total(+)
GROUP BY s.NAME, s.studno, e1.total
ORDER BY 4;
