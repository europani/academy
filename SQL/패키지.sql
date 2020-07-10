CREATE OR REPLACE PACKAGE emp_total
IS
  PROCEDURE emp_sum;
  PROCEDURE emp_avg;
END;
/

CREATE OR REPLACE PACKAGE BODY emp_total 
IS
PROCEDURE emp_sum IS
  CURSOR emp_total_sum IS
    SELECT count(*), sum(nvl(sal,0)) FROM emp;
    total_num NUMBER;
    total_sum NUMBER;
BEGIN
  OPEN emp_total_sum;
  fetch emp_total_sum INTO total_num, total_sum;
  dbms_output.put_line('총인원수 :' || total_num || '급여 합계 : ' || total_sum);
  CLOSE emp_total_sum;
END emp_sum;

PROCEDURE emp_avg
IS
  CURSOR emp_total_avg IS
    SELECT count(*), avg(nvl(sal,0)) FROM emp;
    total_num NUMBER;
    total_sum NUMBER;
BEGIN
  OPEN emp_total_avg;
  fetch emp_total_avg INTO total_num, total_sum;
  dbms_output.put_line('총인원수 :' || total_num || '급여 합계 : ' || total_sum);
  CLOSE emp_total_avg;
END emp_avg;
END emp_total;
/
exec emp_total.emp_sum;
exec emp_total.emp_avg;
/

-- 문제)
CREATE OR REPLACE PACKAGE member_total
IS
  PROCEDURE pro_gender(v_name MEMBER.NAME%TYPE);
  PROCEDURE pro_find_id(v_name MEMBER.NAME%TYPE, v_jumin MEMBER.jumin%TYPE);
  PROCEDURE pro_find_pw(v_id member.ID%TYPE, v_an member.an_key%TYPE);
END;
/
create or replace package body member_total
IS
    PROCEDURE pro_gender(
     v_name MEMBER.NAME%TYPE)
    IS
      v_gender  member.name%type;
    BEGIN
      SELECT substr(jumin, 7, 1) INTO v_gender FROM MEMBER
      where name = v_name;
        IF (v_gender IN ('1', '3')) THEN
          v_gender := '남자';
        ELSE
          v_gender := '여자';
        END IF;
        dbms_output.put_line('이름 : ' || v_name || ', 성별 : ' || v_gender);
      
  END pro_gender11; 
  /
  PROCEDURE pro_find_id(
    v_name MEMBER.NAME%TYPE, 
    v_jumin MEMBER.jumin%TYPE)
    IS
      v_id member.id%type;
    BEGIN
     SELECT id  into v_id FROM MEMBER
     WHERE NAME = v_name AND jumin = v_jumin;
      dbms_output.put_line('아이디 : ' || v_ID);
    END pro_find_id;
  /
  
  PROCEDURE pro_find_pw(
    v_id MEMBER.ID%TYPE, 
    v_an MEMBER.an_key%TYPE)
  IS 
    v_pw  MEMBER.passwd%type;
  BEGIN
    SELECT passwd INTO v_pw FROM MEMBER
    WHERE ID = v_id AND an_key = v_an;
    dbms_output.put_line('비밀번호 : ' || v_pw);
  END pro_find_pw;
END member_total;
/

-- 문제2)
create or replace package pkg_example
IS
  spec_no NUMBER := 10;
  
  FUNCTION func_aftertax(sal NUMBER) RETURN NUMBER;
  PROCEDURE pro_emp(in_empno emp.empno%TYPE);
  PROCEDURE pro_dept(in_deptno  dept.deptno%TYPE);
end;
/
CREATE OR REPLACE PACKAGE BODY pkg_example
IS
  FUNCTION func_aftertax(sal NUMBER) RETURN NUMBER
    IS
      tax number := 0.05;
    BEGIN
      RETURN sal-sal*tax;
    END func_aftertax;
    
  PROCEDURE pro_emp(in_empno emp.empno%TYPE)
  IS
    out_name  emp.eNAME%TYPE;
    out_sal   emp.sal%TYPE;
  BEGIN
    select ename, sal into out_name, out_sal
    FROM emp
    WHERE empno = in_empno;
    dbms_output.put_line('이름 : ' || out_name || ', 급여 : ' || out_sal);
  end pro_emp;
  
  PROCEDURE pro_dept(in_deptno dept.deptno%TYPE)
  IS
    out_dname dept.dname%TYPE;
    out_loc dept.loc%TYPE;
  BEGIN
    select dname, loc into out_dname, out_loc
    FROM dept
    WHERE deptno = in_deptno;
    dbms_output.put_line('부서명 : ' || out_dname || ', 위치 : ' || out_loc);
  END pro_dept;
END pkg_example;
/

select pkg_example.func_aftertax(1000) from dual;
exec pkg_example.pro_emp(7369);
exec pkg_example.pro_dept(10);