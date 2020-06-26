-- (1) --
SELECT empno, ename FROM emp
WHERE ename LIKE '%A%';

-- (2) --
SELECT ename FROM emp
WHERE ename LIKE 'S%T';

-- (3) --
SELECT ename FROM emp
WHERE ename LIKE '_A%';
SELECT  ename FROM emp
WHERE ename LIKE '__A%';

-- (4) --
SELECT ename, comm FROM emp
WHERE comm IS NULL;

-- (5) --
SELECT ename, comm FROM emp
WHERE comm IS NOT NULL; 

-- (6) --
SELECT ename, deptno, sal FROM emp
WHERE deptno = 30 AND sal >= 1500; 

-- (7) --
SELECT empno, ename, deptno FROM emp
WHERE deptno = 30 OR ename LIKE 'K%'; 

-- (8) --
SELECT sal, deptno, job FROM emp
WHERE deptno = 30 AND sal >= 1500 AND job='MANAGER'; 

-- (9) --
SELECT ename, empno, deptno FROM emp
WHERE deptno = 30 
ORDER BY 2; 

-- (10) --
SELECT ename, sal FROM emp
ORDER BY 2 DESC; 

-- (11) --
SELECT ename, deptno, sal FROM emp
ORDER BY 2, 3 DESC; 

-- (12) --
SELECT deptno, job, sal FROM emp
ORDER BY 1 DESC, 2, 3 DESC; 