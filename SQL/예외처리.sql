DECLARE
  v_ename emp.ename%TYPE;
BEGIN
  select ename into v_ename
  FROM emp
  WHERE ename LIKE 'A%';
  
  dbms_output.put_line('������� ' || v_ename || ' �Դϴ�.');
exception
  WHEN no_data_found THEN
     dbms_output.put_line('�ش� ����� �����ϴ�.');
  WHEN too_many_rows THEN
     dbms_output.put_line('����� �θ� �̻��Դϴ�.');
END;
/
-- ����� ���� ����ó�� --
DECLARE
  sawon_exist exception;
  pragma exception_init(sawon_exist, -2292);
BEGIN
  DELETE FROM dept WHERE deptno = &dno;
  
  dbms_output.put_line('������ �Ǽ� : ' || SQL%rowcount);
  ROLLBACK;
exception
  WHEN sawon_exist THEN
    dbms_output.put_line('����� �����մϴ�');
END;
/

CREATE TABLE t_pragma(
  no number primary key,
  NAME VARCHAR2(10));
INSERT INTO t_pragma VALUES (1, 'BBB');
/
DECLARE
  new_msg exception;
  pragma exception_init(new_msg, -1);
BEGIN
  INSERT INTO t_pragma VALUES (1, 'CCC');
exception
  WHEN new_msg THEN
    dbms_output.put_line('�����ϴ� ��ȣ�Դϴ�.');
END;
/
CREATE TABLE t_con(
  NO NUMBER NOT NULL,
  NAME VARCHAR2(10));
INSERT INTO t_con VALUES (NULL, 'AAA');
DECLARE
   new_msg exception;
   pragma exception_init( new_msg , -1400);
BEGIN
  INSERT INTO t_con VALUES (NULL, 'AAA');
exception
  WHEN new_msg THEN
    dbms_output.put_line('NULL���� �Է��� �� �����ϴ�.');
end;
/
DECLARE
  v_empno emp.empno%TYPE;
  v_name emp.ename%TYPE;
  no_empno  exception;
BEGIN
  DELETE FROM emp WHERE empno = &empno;
  
  IF SQL%notfound THEN
    raise no_empno;
  END IF;
exception
  WHEN no_empno THEN
    dbms_output.put_line('����� �����ϴ�.');
END;
/
DECLARE
  v_empno emp.empno%TYPE;
  v_name emp.ename%TYPE;
BEGIN
  DELETE FROM emp WHERE empno = &empno;
  
  IF SQL%notfound THEN
    raise_application_error (-20100, '����� �����ϴ�.');
  END IF;
END;
/