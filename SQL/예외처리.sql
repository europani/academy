DECLARE
  v_ename emp.ename%TYPE;
BEGIN
  select ename into v_ename
  FROM emp
  WHERE ename LIKE 'A%';
  
  dbms_output.put_line('사원명은 ' || v_ename || ' 입니다.');
exception
  WHEN no_data_found THEN
     dbms_output.put_line('해당 사원이 없습니다.');
  WHEN too_many_rows THEN
     dbms_output.put_line('사원이 두명 이상입니다.');
END;
/
-- 사용자 정의 예외처리 --
DECLARE
  sawon_exist exception;
  pragma exception_init(sawon_exist, -2292);
BEGIN
  DELETE FROM dept WHERE deptno = &dno;
  
  dbms_output.put_line('삭제된 건수 : ' || SQL%rowcount);
  ROLLBACK;
exception
  WHEN sawon_exist THEN
    dbms_output.put_line('사원이 존재합니다');
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
    dbms_output.put_line('존재하는 번호입니다.');
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
    dbms_output.put_line('NULL값을 입력할 수 없습니다.');
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
    dbms_output.put_line('사원이 없습니다.');
END;
/
DECLARE
  v_empno emp.empno%TYPE;
  v_name emp.ename%TYPE;
BEGIN
  DELETE FROM emp WHERE empno = &empno;
  
  IF SQL%notfound THEN
    raise_application_error (-20100, '사원이 없습니다.');
  END IF;
END;
/