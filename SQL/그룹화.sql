SELECT name, bonus FROM professor;

SELECT COUNT(*), COUNT(bonus)
FROM professor;

SELECT COUNT(bonus), SUM(bonus), AVG(bonus) -- Wrong
FROM professor;
SELECT COUNT(bonus), SUM(bonus), AVG(nvl(bonus, 0))
FROM professor;

SELECT MAX(sal), MIN(sal) FROM emp;

SELECT STDDEV(pay), VARIANCE(pay) FROM professor;

SELECT deptno, ROUND(AVG(NVL(bonus, 0)), 2) AS ��պ��ʽ�
FROM professor
GROUP BY deptno
ORDER BY 1;

SELECT deptno, position, AVG(NVL(bonus, 0)) AS ��պ��ʽ� 
FROM professor
GROUP BY deptno, position
ORDER BY deptno, position;

--SELECT deptno AS dno, AVG(NVL(bonus, 0)) AS ��ձ޿�
--FROM professor
--GROUP BY dno;

SELECT deptno AS �μ�, ROUND(AVG(NVL(pay, 0))) AS ���
FROM professor
GROUP BY deptno;

SELECT deptno, COUNT(pay), ROUND(AVG(NVL(pay,0))), MAX(pay), MIN(pay)
FROM professor
GROUP BY deptno;

SELECT SUBSTR(jumin, 3, 2) AS ���Ͽ�, COUNT(*) AS �ο���
FROM student
GROUP BY SUBSTR(jumin,3,2)
ORDER BY 1;

SELECT TRUNC(pay, -2) || '������' AS �з�, COUNT(*) AS �ο�
FROM professor
GROUP BY TRUNC(pay, -2)
ORDER BY 1 DESC;

SELECT SUBSTR(email,INSTR(email, '@')+1) AS ����Ʈ, count(*) AS �ο���
FROM professor
GROUP BY SUBSTR(email,INSTR(email, '@')+1)
ORDER BY 1;

SELECT deptno, AVG(NVL(pay, 0)) 
FROM professor
GROUP BY deptno
HAVING AVG(NVL(pay, 0)) >= 350;

SELECT deptno, COUNT(pay), TO_CHAR((AVG(NVL(pay,0))), '999.00') AS avg, MAX(pay), MIN(pay)
FROM professor
GROUP BY deptno
HAVING AVG(NVL(pay, 0)) >= 300;

SELECT SUBSTR(birthday, 6, 2) AS ��, COUNT(*) AS �ο���
FROM student
GROUP BY SUBSTR(birthday, 6, 2)
HAVING COUNT(*) = 1
ORDER BY 1;

ALTER SESSION SET NLS_DATE_FORMAT = 'yyyy-mm-dd';

SELECT SUBSTR(hiredate, 1, 4) AS YEAR, COUNT(*) AS �ο�, MAX(pay) AS �ְ�ݾ�, MIN(pay) AS �����ݾ�, TO_CHAR(AVG(pay), '999.00') AS ���
FROM professor
GROUP BY SUBSTR(hiredate, 1, 4)
HAVING AVG(pay) >= 300
ORDER BY 1;

SELECT rownum, rowid, ename
FROM emp
ORDER BY ename;

-- ROLLUP --
SELECT deptno, position, COUNT(*), SUM(pay)
FROM professor
GROUP BY ROLLUP(deptno, position);
-- CUBE --
SELECT deptno, position, COUNT(*), SUM(pay)
FROM professor
GROUP BY CUBE(deptno, position);

--------------------- Question ------------------------
SELECT deptno,
  count(decode(JOB, 'CLERK', 1)) AS CLERK,
  count(decode(JOB, 'MANAGER', 1)) AS MANAGER,
  count(decode(JOB, 'PRESIDENT', 1)) AS PRESIDENT,
  count(decode(JOB, 'ANALYST', 1)) AS ANALYST,
  count(decode(JOB, 'SALESMAN', 1)) AS SALESMAN
FROM emp
GROUP BY deptno
ORDER BY 1;

-- deptno���� count --
SELECT deptno,
  COUNT(decode(JOB, 'CLERK', 1)) AS CLERK,
  COUNT(decode(JOB, 'MANAGER', 1)) AS MANAGER,
  COUNT(decode(JOB, 'PRESIDENT', 1)) AS PRESIDENT,
  COUNT(decode(JOB, 'ANALYST', 1)) AS ANALYST,
  COUNT(decode(JOB, 'SALESMAN', 1)) AS SALESMAN
FROM emp
GROUP BY deptno
order by 1;

SELECT MAX(pay+bonus), MIN(pay+nvl(bonus, 0)), round(avg(pay+nvl(bonus, 0)),1)
FROM professor;

SELECT MAX(pay+bonus), MIN(nvl(pay+bonus, 0)), round(avg(nvl(pay+bonus, 0)),1)
FROM professor; 

SELECT count(birthday),
  count(decode(to_char(birthday, 'mm'), '01', 1)) AS "1��",
  count(decode(to_char(birthday, 'mm'), '02', 1)) AS "2��",
  count(decode(to_char(birthday, 'mm'), '03', 1)) AS "3��",
  count(decode(to_char(birthday, 'mm'), '04', 1)) AS "4��",
  count(decode(to_char(birthday, 'mm'), '05', 1)) AS "5��",
  count(decode(to_char(birthday, 'mm'), '06', 1)) AS "6��",
  count(decode(to_char(birthday, 'mm'), '07', 1)) AS "7��",
  count(decode(to_char(birthday, 'mm'), '08', 1)) AS "8��",
  count(decode(to_char(birthday, 'mm'), '09', 1)) AS "9��",
  count(decode(to_char(birthday, 'mm'), '10', 1)) AS "10��",
  count(decode(to_char(birthday, 'mm'), '11', 1)) AS "11��",
  count(decode(to_char(birthday, 'mm'), '12', 1)) AS "12��"
FROM student;

select DEPTNO, 
  NVL(SUM(DECODE(job, 'CLERK', SAL)), 0) as CLERK,
  NVL(SUM(DECODE(job, 'MANAGER', SAL)), 0) as MANAGER,
  NVL(SUM(DECODE(job, 'ANALYST', SAL)), 0) as ANALYST,
  NVL(SUM(DECODE(job, 'SALESMAN', SAL)), 0) as SALESMAN,
  sum(sal) AS �հ�
FROM emp
GROUP BY ROLLUP(DEPTNO);

SELECT decode(DEPTNO, '', '    �հ�', to_char(deptno, '999999')) AS deptno, SUM(PAY)
FROM PROFESSOR
GROUP BY ROLLUP(deptno)
ORDER BY 1;

SELECT trunc((ROWNUM-1)/3), mod((ROWNUM-1), 3), profno, NAME FROM professor;

SELECT trunc((ROWNUM-1)/3) AS NO,
  NVL(MAX(decode(mod((ROWNUM-1), 3), 0, profno||NAME)), '******') AS ���1�̸�1,
  NVL(MAX(decode(mod((ROWNUM-1), 3), 1, profno||NAME)), '******') AS ���2�̸�2,
  NVL(max(decode(mod((ROWNUM-1), 3), 2, profno||NAME)), '******') AS ���3�̸�3
FROM professor
GROUP BY trunc((ROWNUM-1)/3)
ORDER BY 1;

SELECT 
  MAX(DECODE(DAY, '��', num_day)) AS ��,
  max(DECODE(DAY, '��', num_day)) AS ��,
  max(DECODE(DAY, 'ȭ', num_day)) AS ȭ,
  max(DECODE(DAY, '��', num_day)) AS ��,
  max(DECODE(DAY, '��', num_day)) AS ��,
  MAX(DECODE(DAY, '��', num_day)) AS ��,
  max(DECODE(DAY, '��', num_day)) AS ��
FROM cal
GROUP BY WEEK
order by WEEK;
----------------------------------------------------------------

-- LISTAGG --
SELECT deptno, LISTAGG(NAME, ', ') WITHIN GROUP(ORDER BY hiredate) AS listagg
FROM professor
GROUP BY deptno;
-- RANK --
SELECT rank('�۵���') WITHIN GROUP(ORDER BY NAME) AS rank
FROM professor;

select name, PAY, 
  RANK() OVER(ORDER BY pay) AS "rank asc",
  RANK() OVER(ORDER BY pay DESC) AS "rank desc"
FROM professor;

SELECT empno, ename, sal, rank() OVER(ORDER BY sal) AS ����
FROM emp
where deptno = 10;

SELECT empno, ename, sal, deptno, rank() OVER (PARTITION BY deptno ORDER BY sal DESC) AS rank
FROM emp;

SELECT empno, ename, sal, deptno, job, rank() OVER (PARTITION BY deptno, job ORDER BY sal DESC) AS rank
FROM emp;

SELECT p_date, p_code, p_qty, p_total,
  sum(p_total) OVER (ORDER BY p_date) AS ����
FROM panmae
WHERE p_store = 1000;

SELECT p_date, p_code, p_qty, p_total,
  sum(p_total) OVER (PARTITION BY p_code ORDER BY p_date) AS ����
FROM panmae
WHERE p_store=1000;

  
-- LAG --
SELECT NAME, hiredate, pay, lag(pay, 3, 2) OVER(ORDER BY hiredate) AS lag
FROM professor;
-- LEAD --
SELECT NAME, hiredate, pay, lead(pay, 3, 2) OVER(ORDER BY hiredate) AS lead
FROM professor;

