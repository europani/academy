-- 별칭 --
SELECT name AS 교수이름, profno AS 교수번호
FROM professor;

SELECT empno AS 사원번호, ename AS 사원명, JOB AS 직업
FROM emp;

SELECT deptno AS 부서#, dname AS 부서명, loc AS 부서위치 
FROM dept;

-- 연결연산자(||) --
SELECT name || position AS 교수 
FROM professor;

SELECT name || '님은' || position || '입니다' 
FROM professor;

SELECT name || '-' || position 
FROM professor;

SELECT name || '의 키는 ' || height || ', 몸무게는 ' || weight || '입니다.' AS 키와몸무게 
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

SELECT name AS 이름, birthday AS 생년월일, height AS "키(cm)", weight 
FROM student;

SELECT grade || '학년 학생 ' || name 
FROM student;

DESC student;

SELECT name, deptno FROM professor;

SELECT * FROM professor;

-- WHERE 조건절 --
SELECT * FROM student 
WHERE grade = 1;

SELECT ename, sal, deptno FROM emp 
WHERE deptno = 10;

SELECT ename, sal FROM emp 
WHERE sal >= 4000;

-- 산술연산자 --
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
WHERE name LIKE '김%';  

SELECT name, bonus 
FROM professor 
WHERE bonus IS NULL;

SELECT name, pay, hiredate 
FROM professor 
WHERE hiredate = '1980-6월-23';

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
WHERE name >= '자' AND name < '차' 
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

SELECT name AS 이름, height AS 키
FROM student
WHERE grade =1 
ORDER BY 1;


-- 집합 연산자 --
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
WHERE position = '전임강사';

SELECT studno, name
FROM student
UNION
SELECT profno
FROM professor;
