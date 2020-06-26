-- UPPER, LOWER, INITCAP --
SELECT INITCAP(student.ID),
  student.STUDNO
  FROM student;

SELECT LOWER('Pretty girl') FROM dual;
SELECT UPPER('Pretty girl') FROM dual;

-- LENGTH, LENGTHB --
SELECT name AS �̸�, id, LENGTH(id) AS ���ڼ�
  FROM student
  WHERE LENGTH(id) >9;

SELECT name AS �̸�, LENGTH(name), LENGTHB(name)
  FROM student
  WHERE deptno1 = 201;

SELECT CONCAT(name, position)
  FROM professor
  WHERE deptno = 101;

-- SUBSTR --
SELECT SUBSTR('ABCDE', 2, 3) FROM dual;
SELECT SUBSTR('ABCDE', -2, 3) FROM dual;

SELECT name, SUBSTR(jumin,1,6) AS �������
  FROM student
  WHERE deptno1 = 101;

SELECT name, SUBSTR(jumin, 1,6) FROM student
  WHERE SUBSTR(jumin,3,2) = 08;

-- INSTR --
SELECT INSTR('A*B*C*', '*', 1, 2) FROM dual;
SELECT INSTR('A*B*C*', '*', 3, 2) FROM dual;

SELECT name, tel, SUBSTR(tel, 1, INSTR(tel, ')')-1) AS ������ȣ FROM student
  WHERE deptno1 = 101;

-- LPAD, RPAD --
SELECT LPAD(name, 10, '*') FROM student;
SELECT RPAD(name, 10, '*') FROM student;

-- LTRIM, RTRIM --
SELECT LTRIM(dname, '��')
  FROM dept2;

SELECT RTRIM(dname, '��')
  FROM dept2;

SELECT REPLACE(name, SUBSTR(name, 1, 1), '#')
  FROM student
  WHERE deptno1 = 101;

-- REPLACE --
SELECT REPLACE(name, SUBSTR(name, 2, 1), '#')
  FROM student
  WHERE deptno1 = 101;
  SELECT SUBSTR(name, 1, 1) || '#' || SUBSTR(name, 3, 1) 
  FROM student
  WHERE deptno1 = 101;

SELECT name, REPLACE(jumin, SUBSTR(jumin, 7), '*******') AS jumin 
  FROM student
  WHERE deptno1 = 101;
SELECT name, SUBSTR(jumin, 1, 6)||'*******' AS jumin 
  FROM student
  WHERE deptno1 = 101;
SELECT name, RPAD(SUBSTR(jumin, 1, 6), 13, '*') AS jumin
  FROM student
  WHERE deptno1 = 101;

SELECT name, SUBSTR(tel, 1, INSTR(tel, ')')) || '***' || subSTR(tel, INSTR(tel, '-'))
  FROM student
  WHERE deptno1 = 101;

SELECT name, SUBSTR(tel, 1, INSTR(tel, ')')) || SUBSTR('*******', 1, INSTR(tel, '-')-INSTR(tel, ')')-1)
  || SUBSTR(tel, INSTR(tel, '-'), 5) AS tel
  FROM student
  WHERE deptno1 = 101;

-- ROUND --
SELECT ROUND(12.345) AS round1, ROUND(12.345, 2) AS round2, ROUND(12.345, -1) AS round3
FROM dual;
-- TRUNC --
SELECT TRUNC(12.345,1) AS trunc1, TRUNC(12.345, 2) AS trunc2, TRUNC(12.3456, -1) AS trunc3
FROM dual;
-- MOD --
SELECT MOD(12,10) AS mod, CEIL(12.345) AS ceil, FLOOR(12.345) AS floor
FROM dual;
-- POWER --
SELECT POWER(3, 2) FROM dual;

-- SYSDATE --
SELECT SYSDATE FROM dual;
ALTER SESSION SET nls_date_format = 'YYYY-MM-DD:HH24:MI:SS';
ALTER SESSION SET nls_date_format = 'YYYY/MM/DD';
-- MONTHS_BETWEEN --
SELECT MONTHS_BETWEEN('2012-12-01', '2012-02-01') FROM dual;
SELECT MONTHS_BETWEEN('2012-02-01', '2012-12-01') FROM dual;

SELECT name, hiredate, ROUND(MONTHS_BETWEEN(SYSDATE, hiredate), 2) AS date_1,
  ROUND(((SYSDATE - hiredate)/31), 2) AS date_2
  FROM professor
  WHERE deptno = 101;
  
-- ADD_MONTHS, NEXT_DAY, LAST_DAY --
SELECT SYSDATE, ADD_MONTHS(SYSDATE, 3) FROM dual;
SELECT SYSDATE, NEXT_DAY(SYSDATE, '��') FROM dual;
SELECT '2019/04/22', NEXT_DAY('2019/04/22', '��') FROM dual;
SELECT LAST_DAY('2012/02/01') FROM dual;

-- ROUND, TRUNC --
SELECT SYSDATE, ROUND(SYSDATE), TRUNC(SYSDATE) FROM dual;
SELECT ROUND(SYSDATE, 'year'), ROUND(SYSDATE, 'month') FROM dual;

-- TO_NUMBER --
SELECT 1+ TO_NUMBER('1') FROM dual; 

SELECT '1' + 1 FROM dual;
/* SELECT '23,444' + 1 FROM dual; */
SELECT TO_NUMBER('23,444', '99,999') +1
FROM dual;

-- TO_CHAR --
SELECT TO_CHAR(SYSDATE, 'YYYY'),
  TO_CHAR(SYSDATE, 'YY'),
  TO_CHAR(SYSDATE, 'RRRR'),
  TO_CHAR(SYSDATE, 'YEAR')
FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'MM'),
  TO_CHAR(SYSDATE, 'MONTH'),
  TO_CHAR(SYSDATE, 'MON')
FROM dual;
SELECT TO_CHAR(SYSDATE, 'MON', 'NLS_DATE_LANGUAGE = JAPANESE')
FROM dual;

SELECT TO_CHAR(SYSDATE, 'DD'),
  TO_CHAR(SYSDATE, 'DAY'),
  TO_CHAR(SYSDATE, 'DDTH')
FROM dual;

SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY-MM-DD:HH24:MI:SS')
FROM dual;

SELECT name AS �̸�, TO_CHAR(birthday, 'DD-MON-YY') AS ����
FROM student
WHERE TO_CHAR(birthday, 'MM') = '03';

SELECT name, TO_CHAR(NVL((pay*12)+bonus,'0'), '9,999') AS ����
FROM professor
WHERE deptno = 101;

-- TO_DATE --
SELECT TO_DATE('2012/01/01', 'YYYY-MM-DD')
FROM dual;
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';

SELECT TO_DATE('2012/3��/01', 'YYYY:MON:DD') FROM dual;
SELECT TO_DATE('2012/03/01', 'YYYY:MM:DD') FROM dual;
--SELECT TO_DATE('2012/3��/01', 'YYYY:MM:DD') FROM dual;
SELECT TO_DATE('20120301', 'YYYY:MM:DD') FROM dual;
--SELECT TO_DATE('120301', 'YYYY:MM:DD') FROM dual;
SELECT TO_DATE('120301', 'YY:MM:DD') FROM dual;
SELECT TO_DATE('20120301', 'YY:MM:DD') FROM dual;

CREATE TABLE sss (ddd DATE);
INSERT INTO sss VALUES (TO_DATE('2012.03.01', 'YYYY/MM/DD'));
INSERT INTO sss VALUES ('2012.01.01');
INSERT INTO sss VALUES (TO_DATE('2012.3��.01', 'YYYY/MON/DD'));
SELECT * FROM sss;
DELETE FROM sss WHERE DDD = '20120301';

SELECT name, hiredate AS �Ի���, TO_CHAR(pay*12, '9,999') AS ����, TO_CHAR((pay*1.1)*12, '9,999') AS �λ���
FROM professor
WHERE TO_CHAR(hiredate, 'YYYY') <= '1990';

SELECT name AS �̸�, hiredate AS �Ի���, pay AS ����, pay*1.1 AS Ư���޿�
FROM professor
WHERE TO_CHAR(SYSDATE, 'mm') = TO_CHAR(hiredate, 'mm');

-- NULL --
SELECT name, pay, bonus, NVL(pay*12+bonus, pay*12) AS ����
FROM professor
WHERE deptno = 101;

SELECT name, pay, bonus, NVL2(bonus, pay*12+bonus, pay*12) AS ����
FROM professor;
SELECT name, pay, bonus, NVL2(bonus, TO_CHAR(pay*12+bonus), TO_CHAR(pay*12)) AS ����
FROM professor;

-- DECODE --
SELECT name, deptno, decode(deptno, 101, '�İ�', 102, '�濵', 0)
FROM professor;

SELECT name, decode(TRUNC(pay, -2), 500, pay) AS "500������",
  decode(TRUNC(pay, -2), 400, pay) AS "400������",
  decode(TRUNC(pay, -2), 300, pay) AS "300������",
  decode(TRUNC(pay, -2), 200, pay) AS "200������",
  pay
FROM professor
ORDER BY pay DESC;

SELECT name, deptno, DECODE(deptno, 101, DECODE(name, '������', '���±����ĺ�')) AS DECODE
FROM professor;

SELECT name, jumin, DECODE(SUBSTR(jumin, 7, 1), '1', '����', '2', '����') AS ��
FROM student
WHERE deptno1 = 101;

SELECT name, tel, DECODE(SUBSTR(tel, 1, INSTR(tel, ')')-1), '02', '����', '031', '���', '051', '�λ�', '052,', '���', '055', '�泲') AS ����
FROM student
WHERE deptno1 = 101;

-- CASE --
SELECT name, tel, 
  CASE(SUBSTR(tel, 1, INSTR(tel, ')')-1))
    WHEN '02' THEN '����'
    WHEN '031 'THEN '���'
    WHEN '051' THEN '�λ�'
    ELSE '��Ÿ'
    END AS ������
FROM student;

SELECT name, SUBSTR(jumin, 3, 2) AS �����,
  CASE
    WHEN SUBSTR(jumin, 3, 2) BETWEEN '01' AND '03' THEN '1/4'
    WHEN SUBSTR(jumin, 3, 2) BETWEEN '04' AND '06' THEN '2/4'
    WHEN SUBSTR(jumin, 3, 2) BETWEEN '07' AND '09' THEN '3/4'
    WHEN SUBSTR(jumin, 3, 2) BETWEEN '10' AND '12' THEN '4/4'
    ELSE '���¾'
    END AS �б⺰
FROM student;

SELECT profno, name, pay,
  CASE 
   WHEN pay < 200 THEN '4��'
   WHEN pay BETWEEN 201 AND 300 THEN '3��'
   WHEN pay BETWEEN 301 AND 400 THEN '2��'
   WHEN pay > 400 THEN '1��'
   END AS ���
FROM professor
ORDER BY 3 DESC;

SELECT birthday, 
  CASE
    WHEN SUBSTR(birthday, 4, 2) BETWEEN 01 AND 03 THEN name 
  END AS "1/4",
  CASE
    WHEN SUBSTR(birthday, 4, 2) BETWEEN 04 AND 06 THEN name 
  END AS "2/4",
  CASE
    WHEN SUBSTR(birthday, 4, 2) BETWEEN 07 AND 09 THEN name 
  END AS "3/4",
  CASE
    WHEN SUBSTR(birthday, 4, 2) BETWEEN 10 AND 12 THEN name 
  END AS "4/4"
FROM student;
ALTER session SET NLS_DATE_FORMAT = 'YY/mm/dd';

