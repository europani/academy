CREATE OR REPLACE PROCEDURE update_20 
IS
BEGIN
  UPDATE emp SET JOB = 'CLERK'
  WHERE deptno = 20;
END;
/
exec update_20;
/

CREATE OR REPLACE PROCEDURE up_sal(
  v_empno   emp.empno%TYPE)
IS
BEGIN
  UPDATE emp SET sal = 5000
  WHERE empno = v_empno;
END;
/
exec up_sal(7902);
/

CREATE OR REPLACE PROCEDURE ename_sal(
  v_empno   emp.empno%TYPE)
IS
  v_ename   emp.ename%TYPE;
  v_sal     emp.sal%TYPE;

BEGIN
  select ename, sal into v_ename, v_sal
  FROM emp
  where empno = v_empno;
  
  dbms_output.put_line('��� ���� ' || v_ename || ' �Դϴ�.');
  dbms_output.put_line('�޿��� ' || v_sal || ' �Դϴ�.');
END;
/
exec ename_sal(7902);
/

-- out ���� --
CREATE OR REPLACE PROCEDURE info_prof(
  v_profno  IN professor.profno%TYPE,
  v_name    out professor.NAME%TYPE,
  v_pay     out professor.pay%type)
IS
BEGIN
  SELECT NAME, pay INTO v_name, v_pay
  FROM professor
  WHERE profno = v_profno;
END;
/
-- out ���� --
DECLARE
  v_name  professor.NAME%TYPE;
  v_pay professor.pay%type;
BEGIN
  info_prof(1001, v_name, v_pay);
  dbms_output.put_line(v_name || ' ������ �޿��� ' || v_pay);
END;
/

-- bind ���� --
variable NAME VARCHAR2(10)
variable pay NUMBER
exec info_prof(1001, :NAME, :pay);
print NAME pay;
/

-- �Ķ���� �� ���� --
DECLARE 
  v_name2   professor.NAME%TYPE;
  v_pay2    professor.pay%TYPE;
BEGIN
  info_prof(1001, v_name2, v_pay2);   -- ��ġ ����
  info_prof(v_profno => 1001, v_name => v_name2, v_pay => v_pay2);  -- �̸� ����
  dbms_output.put_line(v_name2 || ' ������ �޿��� ' || v_pay2);
END;
/

-- ����)
CREATE OR REPLACE PROCEDURE emp_insert(
  v_empno emp.empno%TYPE,
  v_name  emp.eNAME%TYPE,
  v_job   emp.JOB%TYPE,
  v_mgr   emp.mgr%TYPE,
  v_sal   emp.sal%TYPE)
IS
BEGIN
  INSERT INTO emp VALUES (v_empno, v_name, v_job, v_mgr, null, v_sal, null, null);
END;
/
exec emp_insert(4000, 'Smith', 'Clerk', 7900, 3500);
/

CREATE OR REPLACE PROCEDURE emp_pro01(
  v_deptno  emp.deptno%TYPE)
IS
  v_comp  number := 0;
BEGIN
  v_comp :=
    CASE v_deptno
      WHEN 10 THEN 0.2
      WHEN 20 THEN 0.3
      WHEN 30 THEN 0.1
    END;

  UPDATE emp SET comm = sal*v_comp WHERE deptno = v_deptno;
END;
/
exec emp_pro01(10);
ROLLBACK;
/

-- ����) ������ Ŀ�� �̿� --
CREATE OR REPLACE PROCEDURE emp4_del(
  v_empno  emp4.empno%TYPE)
IS
BEGIN
  DELETE FROM emp4 WHERE empno = v_empno;
  IF (SQL%notfound) THEN
    dbms_output.put_line(v_empno || ' ����� �����ϴ�.');
  ELSE
    dbms_output.put_line(v_empno || ' ���� �Ǿ����ϴ�.');
  END IF;
END;
/
-- ����� ���� ����ó�� �̿� --
CREATE OR REPLACE PROCEDURE emp4_del(
  v_empno  emp4.empno%TYPE)
IS
  no_data exception;
BEGIN
  DELETE FROM emp4 WHERE empno = v_empno;
  IF (SQL%notfound) THEN
    raise no_data;
  ELSE
    dbms_output.put_line(v_empno || ' ���� �Ǿ����ϴ�.');
  END IF;
exception
  when no_data then
    dbms_output.put_line(v_empno || ' ����� �����ϴ�.');
END;
/

CREATE OR REPLACE PROCEDURE print_emp(
  v_empno   emp.empno%TYPE)
IS
  v_ename   emp.ename%TYPE;
  v_dname   dept.dname%TYPE;
  v_sal     emp.sal%TYPE;
  v_comm    emp.comm%TYPE;
BEGIN
  SELECT e.ename, d.dname, e.sal, nvl(e.comm, 0)
  into v_ename, v_dname, v_sal, v_comm
  FROM emp e, dept d
  WHERE e.deptno = d.deptno
  AND e.empno = v_empno;

    dbms_output.put_line('���: ' || v_empno);
    dbms_output.put_line('�̸�: ' || v_ename);
    dbms_output.put_line('�μ���: ' || v_dname);
    dbms_output.put_line('�޿�: ' || v_sal);
    dbms_output.put_line('�󿩱�: ' || v_comm);
exception
  WHEN no_data_found THEN
    dbms_output.put_line('����� �������� �ʽ��ϴ�.');
END;
/
exec print_emp(7369);
