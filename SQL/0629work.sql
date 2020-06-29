-- 1 --
SELECT NVL(to_char(grade), '전체평균') AS 학년, 
  to_char(avg(decode(substr(tel, 1, instr(tel, ')')-1), 02, weight)), '99.00') AS "02",
  to_char(avg(decode(substr(tel, 1, instr(tel, ')')-1), 031, weight)), '99.00') AS "031",
  to_char(avg(decode(substr(tel, 1, instr(tel, ')')-1), 051, weight)), '99.00') AS "051",
  to_char(avg(decode(substr(tel, 1, instr(tel, ')')-1), 053, weight)), '99.00') AS "053",
  to_char(avg(decode(substr(tel, 1, instr(tel, ')')-1), 055, weight)), '99.00') AS "055"
FROM student
group by rollup(grade);

-- 2 --
SELECT NVL(to_char(deptno), '전체합계') AS 부서, NVL(JOB, '부서합계') AS JOB, to_char(avg(sal), '9,999') AS 급여평균
FROM emp
GROUP BY ROLLUP(deptno, JOB);

-- 3 --
SELECT to_char(deptno) AS 부서, NVL(JOB, '부분합계') AS JOB, to_char(avg(sal), '9,999') AS 급여평균
FROM emp
GROUP BY cube(deptno, JOB);

-- 4 --
SELECT DECODE(substr(tel, 1, instr(tel, ')')-1), '02', '서울')
|| DECODE(substr(tel, 1, instr(tel, ')')-1), '031', '경기')
|| DECODE(substr(tel, 1, instr(tel, ')')-1), '051', '부산')
|| DECODE(substr(tel, 1, instr(tel, ')')-1), '053', '대구')
|| DECODE(substr(tel, 1, instr(tel, ')')-1), '055', '경남')AS 지역,
LISTAGG(NAME, '-') WITHIN GROUP(ORDER BY name) AS "LIST"
FROM student
group by substr(tel, 1, instr(tel, ')')-1);

-- 5 --
SELECT NAME, birthday, rank() OVER (PARTITION BY grade ORDER BY birthday) AS 순위
from student;

-- 6 --
SELECT NVL(to_char(profno),'지도교수 없음') AS 교수번호, LISTAGG(NAME, ',') WITHIN GROUP(ORDER BY name) AS "list"
FROM student
group by NVL(to_char(profno), '지도교수 없음');

-- 7 --
SELECT substr(email, instr(email, '@')+1) AS 사이트, LISTAGG(email, ', ') WITHIN GROUP(ORDER BY email) AS "list"
FROM professor
group by substr(email, instr(email, '@')+1);

-- 8 --
SELECT NAME, pay, rank() OVER(ORDER BY pay DESC) AS 순위, lead(pay, 1, 570) over(order by pay)-pay AS "전순위와 차이"
FROM professor
order by 2 desc;

-- 9 --
SELECT ename, sal, rank() OVER(ORDER BY sal DESC) AS 순위
FROM emp
order by 3;

-- 10 --
SELECT p_date, p_code, p_qty, p_total, rownum, sum(p_total) OVER (partition by p_code ORDER BY rownum) AS 누계
FROM panmae
where p_code IN (100, 101);