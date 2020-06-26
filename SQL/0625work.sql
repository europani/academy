-- 1 --
SELECT ename, sal, ROUND(sal*0.15, 1) AS 회비
FROM emp
WHERE sal BETWEEN 1500 AND 3000;

-- 2 --
SELECT ename, sal, ROUND(sal*0.15) AS 커미션
FROM emp
WHERE sal >= 2000;

-- 3 --
SELECT deptno, ename, hiredate, sysdate, ROUND(sysdate-hiredate), ROUND(MONTHS_BETWEEN(sysdate, hiredate)), TO_CHAR(sysdate, 'yyyy')-TO_CHAR(hiredate, 'yyyy')
FROM emp;

-- 4 --
SELECT ename, sal, sal*0.9 AS 실수령액
FROM emp
ORDER BY 2 DESC;

-- 5 --
SELECT ename, hiredate, hiredate+90, sal
FROM emp;

-- 6 --
SELECT ADD_MONTHS(hiredate, 6), ADD_MONTHS(sysdate, 6), sal
FROM emp;

-- 7 --
SELECT deptno, ename, ROUND(sysdate-hiredate)
FROM emp;

-- 8 --
SELECT ename, hiredate, NEXT_DAY(hiredate+60, '월')
FROM emp;

-- 9 --
SELECT ename, hiredate, ROUND(sysdate-hiredate)
FROM emp;

-- 10 --
SELECT ename, TO_CHAR(hiredate, 'yyyy')||'년'||TO_CHAR(hiredate, 'mm')||'월'||TO_CHAR(hiredate, 'dd')||'일'
FROM emp;

-- 11 --
SELECT LOWER(SUBSTR(ename, 1, 3))
FROM emp
WHERE LENGTH(ename) >= 6;

-- 12 --
SELECT ename, sal, ROUND(sal, -3) AS 반올림
FROM emp
WHERE sal >= 2000;

-- 13 --
SELECT ename, sal AS 달러급여, TO_CHAR(sal*1200, '9,999,999') AS 원화급여
FROM emp
WHERE deptno = 30;

-- 14 --
SELECT ename, hiredate, TO_CHAR(sysdate, 'yyyy')-TO_CHAR(hiredate, 'yyyy') AS 근속년수
FROM emp
WHERE TO_CHAR(sysdate, 'yyyy')-TO_CHAR(hiredate, 'yyyy') <= 35;

-- 15 --
SELECT name, birthday, TO_CHAR(sysdate, 'mm') FROM student
WHERE grade = 4 AND TO_CHAR(sysdate, 'mm') = TO_CHAR(birthday, 'mm');

-- 16 --
SELECT 
  CASE SUBSTR(jumin, 1, 2)
    WHEN '75' THEN name 
    END AS "75",
    CASE SUBSTR(jumin, 1, 2)
    WHEN '76' THEN name 
    END AS "76",
    CASE SUBSTR(jumin, 1, 2)
    WHEN '77' THEN name 
    END AS "77",
    CASE SUBSTR(jumin, 1, 2)
    WHEN '78' THEN name 
    END AS "78"
FROM student;

-- 17 --
SELECT name, SUBSTR(email, INSTR(email, '@')+1) AS "email 사이트"
FROM professor
WHERE deptno = 101;

-- 18 --
SELECT name, pay, bonus, NVL2(bonus, pay, pay*1.1)
FROM professor
WHERE deptno = 102;

-- 19 --
SELECT name, pay, bonus, TO_CHAR(NVL2(bonus, (pay*12+bonus)*10000, pay*12*10000), '99,999,999') AS 연봉
FROM professor
WHERE deptno = 103;

-- 20 --
SELECT name, 
  CASE deptno
    WHEN 101 THEN pay
    END AS "101",
  CASE deptno
    WHEN 102 THEN pay
    END AS "102",
  CASE deptno
    WHEN 103 THEN pay
    END AS "103"
FROM professor
WHERE deptno IN(101, 102, 103);