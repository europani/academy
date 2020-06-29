-- 1 --
SELECT NVL(to_char(grade), '��ü���') AS �г�, 
  to_char(avg(decode(substr(tel, 1, instr(tel, ')')-1), 02, weight)), '99.00') AS "02",
  to_char(avg(decode(substr(tel, 1, instr(tel, ')')-1), 031, weight)), '99.00') AS "031",
  to_char(avg(decode(substr(tel, 1, instr(tel, ')')-1), 051, weight)), '99.00') AS "051",
  to_char(avg(decode(substr(tel, 1, instr(tel, ')')-1), 053, weight)), '99.00') AS "053",
  to_char(avg(decode(substr(tel, 1, instr(tel, ')')-1), 055, weight)), '99.00') AS "055"
FROM student
group by rollup(grade);

-- 2 --
SELECT NVL(to_char(deptno), '��ü�հ�') AS �μ�, NVL(JOB, '�μ��հ�') AS JOB, to_char(avg(sal), '9,999') AS �޿����
FROM emp
GROUP BY ROLLUP(deptno, JOB);

-- 3 --
SELECT to_char(deptno) AS �μ�, NVL(JOB, '�κ��հ�') AS JOB, to_char(avg(sal), '9,999') AS �޿����
FROM emp
GROUP BY cube(deptno, JOB);

-- 4 --
SELECT DECODE(substr(tel, 1, instr(tel, ')')-1), '02', '����')
|| DECODE(substr(tel, 1, instr(tel, ')')-1), '031', '���')
|| DECODE(substr(tel, 1, instr(tel, ')')-1), '051', '�λ�')
|| DECODE(substr(tel, 1, instr(tel, ')')-1), '053', '�뱸')
|| DECODE(substr(tel, 1, instr(tel, ')')-1), '055', '�泲')AS ����,
LISTAGG(NAME, '-') WITHIN GROUP(ORDER BY name) AS "LIST"
FROM student
group by substr(tel, 1, instr(tel, ')')-1);

-- 5 --
SELECT NAME, birthday, rank() OVER (PARTITION BY grade ORDER BY birthday) AS ����
from student;

-- 6 --
SELECT NVL(to_char(profno),'�������� ����') AS ������ȣ, LISTAGG(NAME, ',') WITHIN GROUP(ORDER BY name) AS "list"
FROM student
group by NVL(to_char(profno), '�������� ����');

-- 7 --
SELECT substr(email, instr(email, '@')+1) AS ����Ʈ, LISTAGG(email, ', ') WITHIN GROUP(ORDER BY email) AS "list"
FROM professor
group by substr(email, instr(email, '@')+1);

-- 8 --
SELECT NAME, pay, rank() OVER(ORDER BY pay DESC) AS ����, lead(pay, 1, 570) over(order by pay)-pay AS "�������� ����"
FROM professor
order by 2 desc;

-- 9 --
SELECT ename, sal, rank() OVER(ORDER BY sal DESC) AS ����
FROM emp
order by 3;

-- 10 --
SELECT p_date, p_code, p_qty, p_total, rownum, sum(p_total) OVER (partition by p_code ORDER BY rownum) AS ����
FROM panmae
where p_code IN (100, 101);