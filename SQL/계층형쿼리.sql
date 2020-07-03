SELECT level, lpad(dname, LEVEL*6, '*') AS 부서명
FROM dept2
CONNECT BY dcode = PRIOR pdept    -- 상향
START WITH dcode = 0001;

SELECT lpad(dname, LEVEL*6, '*') AS 부서명
FROM dept2
CONNECT BY PRIOR dcode =  pdept   -- 하향
START WITH dcode = 0001;

SELECT lpad(e.NAME || ' ' ||d.dname || ' ' || e.position, level*22, '-') AS "이름과 직급"
FROM emp2 e, dept2 d
WHERE e.deptno = d.dcode
CONNECT BY d.pdept = PRIOR d.dcode
START WITH dcode = 0001;

SELECT lpad(e.NAME || ' ' ||d.dname || ' ' || NVL(e.position, '사원'), level*18, '-') AS "이름과 직급"
FROM emp2 e, dept2 d
WHERE e.deptno = d.dcode
CONNECT BY e.empno = prior e.pempno
START WITH dcode = (select deptno from emp2 where name = '일지매');

SELECT lpad(e.NAME || ' ' ||d.dname || ' ' || NVL(e.position, '사원'), level*16, '-') AS "이름과 직급"
FROM emp2 e, dept2 d
WHERE e.deptno = d.dcode
CONNECT BY e.empno = prior e.pempno
START WITH dcode = (select deptno from emp2 where name = '박지리');
