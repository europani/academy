SELECT e.ename, d.dname
FROM emp e, dept d;

SELECT * FROM student, department;

-- equi join --
SELECT s.NAME, s.deptno1, d.dname
FROM student s, department d
WHERE s.deptno1 = d.deptno;

SELECT s.NAME AS �л��̸�, s.profno AS ������ȣ, p.NAME AS �����̸�
FROM student s, professor p
WHERE s.profno = p.profno;

SELECT s.NAME AS �л��̸�, d.dname AS �а��̸�, p.NAME AS �����̸�
from STUDENT S, DEPARTMENT D, PROFESSOR P
where s.deptno1 = d.deptno AND s.profno = p.profno;

SELECT e.NAME, e.position, e.pay, p.s_pay, p.e_pay
FROM emp2 e, p_grade p
where e.POSITION = p.POSITION;
SELECT e.NAME, e.position, e.pay, p.s_pay, p.e_pay
FROM emp2 e JOIN p_grade p
ON (e.POSITION = p.POSITION);

SELECT s.NAME AS �л��̸�, p.NAME AS ����������
FROM student s, professor p
WHERE s.profno = p.profno AND s.deptno1 = 101;
SELECT s.NAME AS �л��̸�, p.NAME AS ����������
FROM student s JOIN professor p
ON (s.profno = p.profno AND s.deptno1 = 101);

SELECT s.NAME, s.studno, e.total
FROM student s, exam_01 e
where s.studno = e.studno;

SELECT p.p_date, p.p_code, r.p_name, p.p_qty, p.p_total
FROM panmae p, product r
WHERE p.p_code = r.P_CODE;

-- non-Equi Join --
SELECT g.gname, g.point, i.gname
FROM gogak g, gift i
where g.point between i.G_START and i.G_END;

SELECT i.gname, count(i.gname) AS �ʿ����
FROM gogak g, gift i
WHERE g.point BETWEEN i.G_START AND i.G_END
group by i.gname;

SELECT s.NAME, e.total, h.grade
FROM student s, exam_01 e, hakjum h
WHERE s.studno = e.studno 
AND e.total BETWEEN h.MIN_POINT AND h.MAX_POINT;

SELECT g.gname, g.point, i.gname AS ��ǰ��
FROM gogak g, gift i
WHERE i.g_start <= g.POINT
AND i.gname = '��ǿ�������';

SELECT e.NAME, trunc((to_date('20130101')-e.birthday)/365,0) AS ���糪��,
e.POSITION AS ��������, p.position AS ��������
FROM emp2 e, p_grade p
WHERE trunc((to_date('20130101')-e.birthday)/365, 0) BETWEEN p.s_age AND p.e_age;

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
