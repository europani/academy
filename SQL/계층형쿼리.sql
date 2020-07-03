SELECT level, lpad(dname, LEVEL*6, '*') AS �μ���
FROM dept2
CONNECT BY dcode = PRIOR pdept    -- ����
START WITH dcode = 0001;

SELECT lpad(dname, LEVEL*6, '*') AS �μ���
FROM dept2
CONNECT BY PRIOR dcode =  pdept   -- ����
START WITH dcode = 0001;

SELECT lpad(e.NAME || ' ' ||d.dname || ' ' || e.position, level*22, '-') AS "�̸��� ����"
FROM emp2 e, dept2 d
WHERE e.deptno = d.dcode
CONNECT BY d.pdept = PRIOR d.dcode
START WITH dcode = 0001;

SELECT lpad(e.NAME || ' ' ||d.dname || ' ' || NVL(e.position, '���'), level*18, '-') AS "�̸��� ����"
FROM emp2 e, dept2 d
WHERE e.deptno = d.dcode
CONNECT BY e.empno = prior e.pempno
START WITH dcode = (select deptno from emp2 where name = '������');

SELECT lpad(e.NAME || ' ' ||d.dname || ' ' || NVL(e.position, '���'), level*16, '-') AS "�̸��� ����"
FROM emp2 e, dept2 d
WHERE e.deptno = d.dcode
CONNECT BY e.empno = prior e.pempno
START WITH dcode = (select deptno from emp2 where name = '������');
