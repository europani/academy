-- ��Ī --
SELECT name AS �����̸�, profno AS ������ȣ
FROM professor;

SELECT empno AS �����ȣ, ename AS �����, JOB AS ����
FROM emp;

SELECT deptno AS �μ�#, dname AS �μ���, loc AS �μ���ġ 
FROM dept;

-- ���Ῥ����(||) --
SELECT name || position AS ���� 
FROM professor;

SELECT name || '����' || position || '�Դϴ�' 
FROM professor;

SELECT name || '-' || position 
FROM professor;

SELECT name || '�� Ű�� ' || height || ', �����Դ� ' || weight || '�Դϴ�.' AS Ű�͸����� 
FROM student;

SELECT name || '(' || position || '), ' || name || '''' || position || '''' 
FROM professor;

-- DISTINCT --
SELECT DISTINCT deptno 
FROM professor;

SELECT DISTINCT deptno1, deptno2 
FROM student;

SELECT DISTINCT profno 
FROM student;

SELECT DISTINCT position 
FROM professor;

SELECT DISTINCT deptno1 
FROM student;

SELECT name AS �̸�, birthday AS �������, height AS "Ű(cm)", weight 
FROM student;

SELECT grade || '�г� �л� ' || name 
FROM student;

DESC student;

SELECT name, deptno FROM professor;

SELECT * FROM professor;

-- WHERE ������ --
SELECT * FROM student 
WHERE grade = 1;

SELECT ename, sal, deptno FROM emp 
WHERE deptno = 10;

SELECT ename, sal FROM emp 
WHERE sal >= 4000;

-- ��������� --
SELECT ename, sal, sal*1.1 
FROM emp;

SELECT ename, sal, sal*1.1 
FROM emp 
WHERE sal*1.1<1000;

SELECT sal, sal+100/2, (sal+100)/2 
FROM emp;

SELECT ename, empno, sal FROM emp 
WHERE ename = 'SCOTT';

SELECT SYSDATE FROM dual;
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MON-DD';
ALTER SESSION SET NLS_LANGUAGE = 'AMERICAN';
ALTER SESSION SET NLS_LANGUAGE = 'KOREAN';

SELECT name, height 
FROM student 
WHERE height >= 180;

SELECT name, weight 
FROM student 
WHERE weight BETWEEN 60 AND 80;

SELECT name, deptno1 
FROM student 
WHERE deptno1 IN (101,201);

SELECT name 
FROM student 
WHERE name LIKE '��%';  

SELECT name, bonus 
FROM professor 
WHERE bonus IS NULL;

SELECT name, pay, hiredate 
FROM professor 
WHERE hiredate = '1980-6��-23';

SELECT name, grade, height 
FROM student 
WHERE grade = 4 AND height > 170;

SELECT name, height, grade, weight 
FROM student 
WHERE grade = 1 OR weight >= 80;

SELECT name, grade, height, weight 
FROM student 
WHERE grade = 2 AND height > 180 AND weight > 70;

SELECT name, grade, height, weight
FROM student
WHERE grade = 2
AND (height > 180 OR weight > 70);

-- ORDER BY --
SELECT name, grade 
FROM student 
WHERE grade <= 3 
ORDER BY grade;

SELECT name, hiredate FROM professor 
WHERE name >= '��' AND name < '��' 
ORDER BY 1; 

SELECT name, height 
FROM student 
WHERE grade = 1
ORDER BY height;

SELECT name, height, weight
FROM STUDENT
WHERE grade = 1
ORDER BY height ASC, weight DESC;

SELECT name, birthday, height, weight
FROM student
WHERE grade = 1
ORDER BY 2;

SELECT name AS �̸�, height AS Ű
FROM student
WHERE grade =1 
ORDER BY 1;


-- ���� ������ --
SELECT studno, name, deptno1
FROM student
WHERE deptno1 = 101
UNION
SELECT profno, name, deptno
FROM professor
WHERE deptno = 101;

SELECT studno, name, deptno1
FROM student
WHERE deptno1 = 101
UNION ALL
SELECT profno, name, deptno
FROM professor
WHERE deptno = 101;

SELECT name
FROM student
WHERE deptno1 = 101
UNION
SELECT name
FROM student
WHERE deptno2 = 201;

SELECT name
FROM student
WHERE DEPTNO1 = 101
UNION ALL
SELECT name
FROM student
WHERE DEPTNO2 = 201;

SELECT name
FROM student
WHERE DEPTNO1 = 101
INTERSECT
SELECT name
FROM student
WHERE DEPTNO2 = 201;

SELECT name, position
FROM professor
MINUS
SELECT name, position
FROM professor
WHERE position = '���Ӱ���';

SELECT studno, name
FROM student
UNION
SELECT profno
FROM professor;
