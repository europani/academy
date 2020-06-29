-- 1 --
SELECT avg(nvl(sal, 0)), MAX(nvl(sal, 0)), MIN(nvl(sal, 0)), count(*)
FROM emp
WHERE deptno = 10;

-- 2 --
SELECT deptno, avg(nvl(sal, 0)), MAX(nvl(sal, 0)), MIN(nvl(sal, 0)), count(*)
FROM emp
GROUP by deptno;

-- 3 --
SELECT deptno, JOB, count(JOB)
FROM emp
group by deptno, job;

-- 4 --
SELECT JOB, TO_CHAR(avg(nvl(sal, 0)), '9999.00') AS 평균급여
FROM emp
GROUP BY JOB;

-- 5 --
SELECT JOB, count(JOB)
FROM emp
GROUP BY JOB
having count(job) >= 4;

-- 6 --
SELECT JOB, 
  TO_CHAR(avg(CASE
    WHEN sal <= 1000 THEN sal
  END), '999.00') AS "1000이하",
  TO_CHAR(avg(CASE
    WHEN sal BETWEEN 1001 AND 1500 THEN sal 
  END), '9999.00') AS "1001~1500",
  TO_CHAR(avg(CASE
    WHEN sal BETWEEN 1501 AND 2000 THEN sal 
  END ), '9999.00')AS "1501~2000",
  TO_CHAR(avg(CASE
    WHEN sal BETWEEN 2001 AND 2500 THEN sal 
  END), '9999.00') AS "2001~2500",
  TO_CHAR(avg(CASE
    WHEN sal BETWEEN 2501 AND 3000 THEN sal
  END), '9999.00') AS "2501~3000",
  TO_CHAR(avg(CASE
    WHEN sal >= 3001 THEN sal
  END), '9999.00') AS "3000이상"
FROM emp
GROUP BY JOB;

-- 7 --
SELECT job, avg(sal), sum(sal), MAX(sal), MIN(sal)
FROM emp
GROUP BY JOB
ORDER BY 2 DESC;

-- 8 --
SELECT position, count(position) AS 인원, MAX(pay) AS 최고금액, MIN(pay) AS 최저금액, TO_CHAR(avg(pay), '999.00') AS 평균
FROM professor
GROUP BY position;

-- 9 --
SELECT substr(NAME, 1, 1) AS 성, count(*) AS 인원수, avg(pay) AS 평균, MAX(pay) AS 평균급여, MIN(pay) AS 최소급여
FROM professor
GROUP BY substr(NAME, 1, 1);

-- 10 --
SELECT count(*),
  count(decode(substr(tel, 1, 2), '02', 1)) AS 서울,
  count(decode(substr(tel, 1, 3), '031', 1)) AS 경기,
  count(decode(substr(tel, 1, 3), '051', 1)) AS 부산,
  count(decode(substr(tel, 1, 3), '052', 1)) AS 울산,
  count(decode(substr(tel, 1, 3), '053', 1)) AS 대구,
  count(decode(substr(tel, 1, 3), '055', 1)) AS 경남
FROM student;

-- 11 --
--to_char(birthday, 'mm')
select substr(birthday, 6, 2)||'월' AS 월, to_char(avg(weight), '999.00') AS weight, to_char(avg(height), '999.00') AS height
FROM student
GROUP BY substr(birthday, 6, 2);

-- 12 --
SELECT grade, substr(tel, 1, instr(tel, ')')-1) AS 지역, to_char(avg(weight), '99.00') AS weight, to_char(avg(height), '999.00') AS height
FROM student
GROUP BY grade, substr(tel, 1, instr(tel, ')')-1)
ORDER BY grade;

-- 13 --
SELECT grade, 
  TO_Char(avg(CASE substr(tel, 1, instr(tel, ')')-1)
    WHEN '02' THEN weight
  END ), '99.00')AS "02",
  TO_Char(avg(CASE substr(tel, 1, instr(tel, ')')-1)
    WHEN '031' THEN weight
  END ), '99.00')AS "031",
  TO_Char(avg(CASE substr(tel, 1, instr(tel, ')')-1)
    WHEN '051' THEN weight
  END ), '99.00')AS "051",
  TO_Char(avg(CASE substr(tel, 1, instr(tel, ')')-1)
    WHEN '053' THEN weight
  END ), '99.00')AS "053",
  TO_Char(avg(CASE substr(tel, 1, instr(tel, ')')-1)
    WHEN '055' THEN weight
  END ), '99.00')AS "055"
FROM student
GROUP BY grade;

-- 14 --
SELECT grade, trunc((ROWNUM-1)/3) AS NO,
  NVL(MAX(decode(mod(rownum, 3), 1, NAME)), '******') AS "a",
  NVL(MAX(decode(mod(rownum, 3), 2, NAME)), '******') AS "b",
  NVL(max(decode(mod(rownum, 3), 0, NAME)), '******') AS "c"
FROM student
WHERE grade = 1
GROUP BY grade, trunc((ROWNUM-1)/3)
UNION ALL
SELECT grade, trunc((ROWNUM-1)/3) AS NO,
  NVL(MAX(decode(mod(rownum, 3), 1, NAME)), '******') AS "a",
  NVL(MAX(decode(mod(rownum, 3), 2, NAME)), '******') AS "b",
  NVL(max(decode(mod(rownum, 3), 0, NAME)), '******') AS "c"
FROM student
WHERE grade = 2
GROUP BY grade, trunc((ROWNUM-1)/3)
UNION ALL
SELECT grade, trunc((ROWNUM-1)/3) AS NO,
  NVL(MAX(decode(mod(rownum, 3), 1, NAME)), '******') AS "a",
  NVL(MAX(decode(mod(rownum, 3), 2, NAME)), '******') AS "b",
  NVL(max(decode(mod(rownum, 3), 0, NAME)), '******') AS "c"
FROM student
WHERE grade = 3
GROUP BY grade, trunc((ROWNUM-1)/3)
UNION ALL
SELECT grade, trunc((ROWNUM-1)/3) AS NO,
  NVL(MAX(decode(mod(rownum, 3), 1, NAME)), '******') AS "a",
  NVL(MAX(decode(mod(rownum, 3), 2, NAME)), '******') AS "b",
  NVL(max(decode(mod(rownum, 3), 0, NAME)), '******') AS "c"
FROM student
WHERE grade = 4
GROUP BY grade, trunc((ROWNUM-1)/3)
ORDER BY 1, 2;
