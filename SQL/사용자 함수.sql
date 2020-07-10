CREATE OR REPLACE FUNCTION s_max_sal(
  s_deptno  emp.deptno%TYPE)
return number
IS
  max_sal emp.sal%type;
BEGIN
  SELECT MAX(sal) INTO max_sal
  FROM emp
  WHERE deptno = s_deptno;
  RETURN max_sal;
END;
/
select s_max_sal(10) from dual;
/

CREATE OR REPLACE FUNCTION count_mem(
  v_deptno  emp.deptno%TYPE)
  return number
IS
  count_p NUMBER;
BEGIN
  SELECT count(*) INTO count_p
  FROM emp
  WHERE deptno = v_deptno;
  RETURN count_p;
END;
/
CREATE TABLE c_test(
  num NUMBER);
INSERT INTO c_test VALUES (count_mem(10));
SELECT * FROM c_test;
SELECT DISTINCT deptno, count_mem(deptno) FROM emp;
/

CREATE OR REPLACE FUNCTION avg_sal(
  v_deptno  emp.deptno%TYPE)
  return number
IS
  v_avg   number;
BEGIN
  SELECT round(avg(sal), 2) INTO v_avg
  FROM emp
  where deptno = v_deptno;
  return v_avg;
END;
/
SELECT DISTINCT deptno, avg_sal(deptno) FROM emp;
/

CREATE OR REPLACE FUNCTION f_dname(
  v_empno emp.empno%TYPE)
  return varchar2
IS
  v_dname dept.dname%type;
BEGIN
  SELECT d.dname INTO v_dname
  FROM dept d, emp e
  WHERE e.empno= v_empno
  AND d.deptno = e.deptno;
  return v_dname;
END;
/
SELECT ename, deptno, f_dname(empno) FROM emp;
/

SELECT text FROM user_source
WHERE TYPE = 'FUNCTION'
AND name = 'S_MAX_SAL';