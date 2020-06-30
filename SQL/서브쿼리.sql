SELECT ename, sal FROM emp
WHERE sal > ( SELECT sal
              FROM emp
              where ename = 'MARTIN');

SELECT s.NAME, d.dname
FROM student s, department d
WHERE s.deptno1 = d.deptno 
AND s.deptno1 = ( SELECT deptno1 FROM student
WHERE NAME = '������');
-- ��Į�� �������� --
SELECT NAME, (SELECT dname FROM department 
    WHERE s.deptno1 = deptno)
FROM student s
WHERE deptno1 = 101;


SELECT p.NAME, p.hiredate, d.dname
FROM professor p, department d
WHERE p.deptno = d.deptno
AND p.hiredate > (SELECT hiredate FROM professor
WHERE NAME = '�۵���');
-- ��Į�� �������� --
SELECT NAME, hiredate, (SELECT dname FROM department
    WHERE p.deptno = deptno) AS �а���
FROM professor p
WHERE hiredate > (SELECT hiredate FROM professor
  WHERE NAME = '�۵���');

SELECT NAME, weight
FROM student
where weight > (SELECT avg(weight) FROM student
WHERE deptno1 = 101);

SELECT NAME, pay, hiredate
FROM professor
WHERE hiredate = (SELECT hiredate FROM professor
  WHERE NAME = '�ɽ�')
AND pay < (SELECT pay FROM professor
  WHERE NAME = '������');

-- ������ �������� --
SELECT empno, NAME, deptno
FROM emp2
WHERE deptno IN ( SELECT dcode
  FROM dept2
  WHERE area = '��������');

SELECT NAME, position, TO_CHAR(pay, '999,999,999') AS �޿� 
FROM emp2
where pay > (SELECT MIN(pay) 
  FROM emp2
  WHERE position = '����')
order by 3 desc;

SELECT NAME, position, TO_CHAR(pay, '999,999,999') AS �޿� 
from EMP2
where pay > ANY (SELECT pay 
  FROM emp2
  where POSITION = '����')
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

-- ���߿� �������� --
SELECT empno, name, pay, position
FROM emp2
WHERE (pay, position) IN (SELECT MAX(pay), position
  FROM emp2
  GROUP BY position);
-- ��ȣ ���� ���� ���� --
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
-- ��ȣ ���� ���� ���� --
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
-- ��ȣ ���� ���� ���� --
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
-- ��ȣ ���� ���� ���� --
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

-- ��Į�� �������� --
SELECT NAME, (SELECT dname
    FROM dept2 d
    WHERE e.deptno = d.dcode) AS �μ��̸�
FROM emp2 e;

-- �ζ��� �� --
SELECT d.dname AS �а���, s.max_height AS �ִ�Ű, s.max_weight AS �ִ������
FROM (SELECT deptno1, MAX(height) AS max_height, MAX(weight) AS max_weight
  FROM student
  GROUP BY deptno1) s, department d
WHERE s.deptno1 = d.deptno;

-- rownum --
SELECT * FROM student WHERE ROWNUM < 5;
SELECT * FROM student WHERE ROWNUM > 5;

---- �ڡ� ----
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



SELECT ROWNUM AS ����, p.*
FROM professor p;

SELECT * FROM
(SELECT ROWNUM AS ����, p.* FROM 
  (SELECT * FROM professor ORDER BY pay) p)
WHERE ���� BETWEEN 1 AND 3;
