SET SERVEROUTPUT ON;  -- PL/SQL 결과 화면 출력기능 활성화
/
DECLARE
  vi_num NUMBER;
BEGIN
  vi_num := 100;
  DBMS_OUTPUT.PUT_LINE(vi_num);
END;
/
DECLARE
  A INTEGER := 2**2*3**2;
BEGIN
  DBMS_OUTPUT.PUT_LINE('a=' || to_char(A));
  DBMS_OUTPUT.PUT_LINE('a=' || a);
END;
/
BEGIN
  DBMS_OUTPUT.PUT_LINE('3 * 1 = ' || 3*1);
  DBMS_OUTPUT.PUT_LINE('3 * 2 = ' || 3*2);
  DBMS_OUTPUT.PUT_LINE('3 * 3 = ' || 3*3);
  DBMS_OUTPUT.PUT_LINE('3 * 4 = ' || 3*4);
  DBMS_OUTPUT.PUT_LINE('3 * 5 = ' || 3*5);
  DBMS_OUTPUT.PUT_LINE('3 * 6 = ' || 3*6);
  DBMS_OUTPUT.PUT_LINE('3 * 7 = ' || 3*7);
  DBMS_OUTPUT.PUT_LINE('3 * 8 = ' || 3*8);
  DBMS_OUTPUT.PUT_LINE('3 * 9 = ' || 3*9);
END;
/
DECLARE
  vno NUMBER(4);
  vname VARCHAR2(10);
BEGIN
  SELECT empno, ename INTO vno, vname
  FROM emp
  WHERE empno = 7900;
  DBMS_OUTPUT.PUT_LINE(vno || ' ' || vname);
END;
/
-- %TYPE : 존재하는 테이블에서 자료형 가져오기 / INTO : 변수에 컬럼 넣기 --
DECLARE
  v_profno  professor.profno%TYPE;
  v_pay     professor.pay%TYPE;
BEGIN
  SELECT profno, pay INTO v_profno, v_pay
  FROM professor
  WHERE profno = 1001;
  DBMS_OUTPUT.PUT_line(v_profno || '번 교수의 급여는 ' || v_pay || '입니다.');
END;
/

-- &변수 : 입력받음 --
DECLARE
  v_profno  professor.profno%TYPE;
  v_pay     professor.pay%TYPE;
BEGIN
  SELECT profno, pay INTO v_profno, v_pay
  FROM professor
  WHERE profno = &profno;
  DBMS_OUTPUT.PUT_line(v_profno || '번 교수의 급여는 ' || v_pay || '입니다.');
END;
/
DECLARE
  v_empno      emp2.empno%TYPE;
  v_name       emp2.name%type;
  v_birthday   EMP2.BIRTHDAY%TYPE;
BEGIN
  SELECT empno, name, birthday INTO v_empno, v_name, v_birthday
  FROM emp2
  WHERE empno = &empno;
  DBMS_OUTPUT.PUT_line(v_empno ||'  ' || v_name || '  ' || v_birthday);
END;
/
DECLARE
  v_profno    professor.profno%TYPE;
  v_name      professor.NAME%TYPE;
  v_deptno    professor.deptno%TYPE;
  v_hiredate  professor.hiredate%TYPE;
BEGIN
  SELECT profno, NAME, deptno, hiredate into v_profno, v_name, v_deptno, v_hiredate
  FROM professor
  WHERE profno = &profno;
  DBMS_OUTPUT.PUT_LINE('교수번호 이름 부서번호 입사일');
  DBMS_OUTPUT.PUT_LINE('==========================');
  DBMS_OUTPUT.PUT_LINE(v_profno ||'  ' || v_name || '  ' || v_deptno || '  ' || v_hiredate);
END;
/

CREATE TABLE pl_test(
  NO  NUMBER,
  NAME  VARCHAR2(10));
CREATE SEQUENCE pl_seq;
/
BEGIN
  INSERT INTO pl_test VALUES (pl_seq.nextval, 'AAA');
END;
/

CREATE TABLE pl_test2(
  NO    NUMBER,
  NAME  VARCHAR2(10),
  addr  VARCHAR2(10));
/
DECLARE
  v_no    NUMBER := '&no';
  v_name  VARCHAR2(10) := '&name';
  v_addr  VARCHAR2(10) := '&addr';
BEGIN
  INSERT INTO pl_test2 VALUES (v_no, v_name, v_addr);
END;
/
UPDATE pl_test2 SET NAME = 'bbb', addr = 'abd' WHERE NO = 1;
select * from pl_test2;
  
CREATE TABLE pl_merge1(
  NO    NUMBER,
  NAME  VARCHAR2(10));
CREATE TABLE pl_merge2(
  NO    NUMBER,
  NAME  VARCHAR2(10));
INSERT INTO pl_merge1 VALUES(1, 'AAA');
INSERT INTO pl_merge1 VALUES(2, 'BBB');
INSERT INTO pl_merge2 VALUES(1, 'CCC');
INSERT INTO pl_merge2 VALUES(3, 'DDD');
/
BEGIN
  MERGE INTO pl_merge2 m2
  USING pl_merge1 m1
  ON (m1.NO= m2.NO)
  WHEN MATCHED THEN 
    UPDATE SET m2.NAME = m1.NAME
  WHEN NOT MATCHED THEN 
    INSERT VALUES(m1.NO, m1.NAME);
END;
/
DECLARE
  "Pi" NUMBER := 3.14;
  "table" NUMBER := 20;
  "select no" NUMBER := 999;
BEGIN
  dbms_output.put_line("Pi" || '  ' || "table" || '  ' || "select no");
END;
/

DECLARE
  v_empno constant  NUMBER(1) := 3;
BEGIN
--  v_empno := 5;
  dbms_output.put_line('v_empno : ' || v_empno);
END;
/

DECLARE
  v_code  NUMBER(2) NOT NULL DEFAULT 10;
BEGIN
  v_code := 20;
  dbms_output.put_line('v_code : ' || v_code);
END;
/
-- %type --
DECLARE
  vno emp.empno%TYPE;
  vname emp.ename%TYPE;
  vsal  emp.sal%type;
BEGIN
  SELECT empno, ename, sal INTO vno, vname, vsal
  FROM emp
  WHERE empno = 7900;
  
  dbms_output.put_line(vno || ' ' || vname || ' '|| vsal);
END;
/
-- %rowtype --
DECLARE
  v_row emp%rowtype;
BEGIN
  SELECT * INTO v_row FROM emp
  WHERE empno = 7900;
  
  dbms_output.put_line(v_row.empno || ' ' || v_row.ename || ' '|| v_row.sal);
END;
/

CREATE TABLE row_test(
  NO    NUMBER,
  NAME  VARCHAR2(10),
  hdate DATE);
CREATE TABLE row_test2 AS SELECT * FROM row_test;
INSERT INTO row_test VALUES (1, 'AAA', SYSDATE);
INSERT INTO row_test VALUES (2, 'BBB', SYSDATE);
INSERT INTO row_test VALUES (3, 'CCC', SYSDATE);

DECLARE
  v_record  row_test%rowtype;
BEGIN
  SELECT * INTO v_record
  FROM row_test
  WHERE NO = 1;
  insert into row_test2 values v_record;
END;
/
SELECT * FROM row_test2;

DECLARE
  v_record  row_test%rowtype;
BEGIN
  SELECT * INTO v_record
  FROM row_test
  WHERE NO = 1;
  
  v_record.NAME := 'DDD';
  UPDATE row_test2 SET ROW=v_record
  where no = 1;
END;
/

DECLARE
  v_empno   emp.empno%TYPE;
  v_ename   emp.ename%TYPE;
  v_deptno  dept.deptno%TYPE;
  v_dname   dept.dname%type;
BEGIN
  SELECT e.empno, e.ename, d.deptno, d.dname INTO v_empno, v_ename, v_deptno, v_dname
  FROM emp e, dept d
  WHERE e.empno = 7900 AND e.deptno = d.deptno;
  
  dbms_output.put_line(v_empno || ' ' || v_ename || ' '|| v_deptno || ' ' || v_dname);
END;
/

DECLARE
  v_first NUMBER := '&first';
  v_second NUMBER := '&second';
  v_sum NUMBER;
BEGIN
  v_sum := v_first + v_second;
  dbms_output.put_line('첫번째 수 : ' || v_first || ', 두번째 수 : ' || v_second || ', 합은 : ' || v_sum || ' 입니다.' );
  dbms_output.put_line('첫번째 수 : ' || v_first || ', 두번째 수 : ' || v_second || ', 합은 : ' ||(v_first + v_second) || ' 입니다.' );
END;
/

-- 레코드 --
DECLARE
  TYPE emp_record_type IS record(
    emp_no    emp.empno%TYPE,
    emp_name  emp.ename%TYPE,
    JOB       emp.JOB%TYPE);
  v_recl  emp_record_type;
BEGIN
  SELECT empno, ename, JOB INTO v_recl
  FROM emp
  WHERE empno = 7499;
  dbms_output.put_line('사원번호   사원명   업무');
  dbms_output.put_line(v_recl.emp_no || '     ' || v_recl.emp_name || '  ' || v_recl.JOB);
end;
/

DECLARE
  TYPE dept_record_type IS record(
    dept_no    dept.deptno%TYPE,
    dept_dname dept.dname%TYPE,
    dept_loc   dept.loc%TYPE);
    v_dept dept_record_type;
BEGIN
  SELECT deptno, dname, loc INTO v_dept
  FROM dept
  WHERE deptno = 30;
  
  dbms_output.put_line('부서번호  부서명  위치');
  dbms_output.put_line(v_dept.dept_no || '     ' || v_dept.dept_dname || '  ' || v_dept.dept_loc);
END;
/

DECLARE
  TYPE emp_recore_type IS record(
     v_empno   emp.empno%TYPE,
     v_ename   emp.ename%TYPE,
     v_deptno  dept.deptno%TYPE,
     v_dname   dept.dname%TYPE);
     v_rec emp_recore_type;
BEGIN
  SELECT e.empno, e.ename, d.deptno, d.dname into v_rec
  FROM emp e, dept d
  WHERE e.deptno = d.deptno AND e.empno = 7900;
  
  dbms_output.put_line(v_rec.v_empno || ' ' || v_rec.v_ename || '  ' || v_rec.v_deptno ||
                      ' '|| v_rec.v_dname);
END;
/

DECLARE
  TYPE emp2_record_type IS record(
    v_empno   emp2.empno%TYPE,
    v_name    emp2.NAME%TYPE,
    v_position  emp2.position%TYPE,
    v_birthday emp2.birthday%TYPE,
    v_tel      emp2.tel%TYPE,
    v_pay      emp2.pay%TYPE);
    v_rec emp2_record_type;
BEGIN
  SELECT empno, NAME, NVL(position, '사원'), birthday, tel, pay INTO v_rec
  FROM emp2
  WHERE empno = '&empno';
  
  dbms_output.put_line('사원번호 : ' || v_rec.v_empno);
  dbms_output.put_line('사원명 : ' || v_rec.v_name);
  dbms_output.put_line('직급 : ' || v_rec.v_position);
  dbms_output.put_line('생일 : '|| v_rec.v_birthday);
  dbms_output.put_line('연락처 : ' || v_rec.v_tel);
  dbms_output.put_line('급여 : ' || v_rec.v_pay); 
END;
/

DECLARE
  type emp22_record_type is record
   (v_empno   emp2.empno%TYPE,
    v_dname   dept2.dname%TYPE,
    v_name    emp2.NAME%TYPE,
    v_position  emp2.position%TYPE,
    v_birthday emp2.birthday%TYPE,
    v_tel      emp2.tel%TYPE,
    v_pay      emp2.pay%TYPE);
    v_rec emp22_record_type;
BEGIN
  SELECT e.empno, d.dname, e.NAME, nvl(e.position, '사원'), e.birthday, e.tel, e.pay INTO v_rec
  FROM emp2 e, dept2 d
  WHERE empno = '&empno' AND e.deptno = d.dcode; 
  
  dbms_output.put_line('사원번호 : ' || v_rec.v_empno);
  dbms_output.put_line('부서명 : ' || v_rec.v_dname);
  dbms_output.put_line('사원명 : ' || v_rec.v_name);
  dbms_output.put_line('직급 : ' || v_rec.v_position);
  dbms_output.put_line('생일 : '|| v_rec.v_birthday);
  dbms_output.put_line('연락처 : ' || v_rec.v_tel);
  dbms_output.put_line('급여 : ' || v_rec.v_pay); 
 END;
 /
-- 컬렉션 --
DECLARE
  t_name  VARCHAR2(20);
  
  TYPE tbl_emp_name IS TABLE OF emp.ename%TYPE
  INDEX BY binary_integer;
  
  v_name tbl_emp_name;
BEGIN
  SELECT ename INTO t_name
  FROM emp
  WHERE empno = 7499;
  
  v_name(0) := t_name;
  dbms_output.put_line(v_name(0));
END;
/

var v_bind number;
BEGIN
  SELECT (pay*12) + nvl(bonus, 0) INTO :v_bind
  FROM professor
  WHERE profno = 1001;
END;
/

DECLARE
  vempno  emp.empno%TYPE;
  vename emp.ename%TYPE;
  vdeptno emp.deptno%TYPE;
  vdname varchar2(20) := null;
BEGIN
  select empno, ename, deptno into vempno, vename, vdeptno
  FROM emp
  WHERE empno = 7900;
  IF (vdeptno = 10) THEN
    vdname := 'ACCOUNT';
  END IF;
  IF (vdeptno = 20) THEN
    vdname := 'RESEARCH';
  END IF;
  IF (vdeptno = 30) THEN
    vdname := 'SALES';
  END IF;
  IF (vdeptno = 40) THEN
    vdname := 'OPERATIONS';
  END IF;
  
  dbms_output.put_line(vempno || ' ' || vename || ' ' || vdeptno || ' ' || vdname);
end;
/

DECLARE
  vempno  emp.empno%TYPE;
  vename emp.ename%TYPE;
  vdeptno emp.deptno%TYPE;
  vdname varchar2(20) := null;
BEGIN
  select empno, ename, deptno into vempno, vename, vdeptno
  FROM emp
  WHERE empno = 7900;
  IF (vdeptno = 10) THEN
    vdname := 'ACCOUNT';
  ELSIF (vdeptno = 20) THEN
    vdname := 'RESEARCH';
  ELSIF (vdeptno = 30) THEN
    vdname := 'SALES';
  ELSIF (vdeptno = 40) THEN
    vdname := 'OPERATIONS';
  END IF;
  
  dbms_output.put_line(vempno || ' ' || vename || ' ' || vdeptno || ' ' || vdname);
END;
/

DECLARE
  v_empno emp.empno%TYPE;
  v_ename emp.ename%TYPE;
  v_comm  emp.comm%type;
BEGIN
  SELECT empno, ename, comm INTO v_empno, v_ename, v_comm
  FROM emp
  WHERE empno = 7900;
  IF (v_comm >0) THEN
    dbms_output.put_line(v_comm);
  ELSE
    dbms_output.put_line(v_ename || ' 사원의 보너스는 없습니다.');
  END IF;
end;
/

DECLARE
  v_empno emp.empno%type;
  v_ename emp.ename%TYPE;
  v_sal   emp.sal%TYPE;
  v_tax   emp.sal%TYPE;
BEGIN
  select empno, ename, sal into v_empno, v_ename, v_sal
  FROM emp
  WHERE empno = '&empno';
  IF (v_sal >= 5000) THEN
    v_tax := v_sal*0.05;
  elsif (v_sal BETWEEN 4000 AND 4999) THEN
    v_tax := v_sal*0.04;
  elsif (v_sal BETWEEN 3000 AND 3999) then
    v_tax := v_sal*0.03;
  elsif (v_sal BETWEEN 2000 AND 2999) then
    v_tax := v_sal*0.02;
  ELSE
    v_tax := v_sal*0.01;
  END IF;
  
  dbms_output.put_line('Empno에 대한 값 입력 : ');
  dbms_output.put_line(v_ename || ' ' || v_sal || ' ' || v_tax);
end;
/

DECLARE
  v_empno    emp.empno%TYPE;
  v_ename    emp.ename%TYPE;
  v_deptno   emp.deptno%TYPE;
  v_dname    dept.dname%TYPE;
BEGIN
  SELECT empno, ename, deptno INTO v_empno, v_ename, v_deptno
  FROM emp
  WHERE empno = '&empno';
  v_dname := 
    CASE v_deptno
      WHEN 10 THEN 'ACCOUNTING'
      WHEN 20 THEN 'RESEARCH'
      WHEN 30 THEN 'SALES'
      WHEN 40 THEN 'OPERATIONS'
    END;
  
  dbms_output.put_line(v_empno || ' ' || v_ename || ' ' || v_deptno || ' ' || v_dname);
END; 
/

DECLARE
  v_empno emp.empno%TYPE;
  v_ename emp.ename%TYPE;
  v_sal   emp.sal%TYPE;
  v_deptno  emp.deptno%TYPE;
  v_up_sal  emp.sal%TYPE;
BEGIN
  SELECT empno, ename, sal, deptno INTO v_empno, v_ename, v_sal, v_deptno
  FROM emp
  WHERE empno = '&empno';
  v_up_sal :=
    CASE
      WHEN v_deptno = 10 THEN v_sal*1.1
      WHEN v_deptno BETWEEN 20 AND 30 THEN v_sal*1.2
      WHEN v_deptno > 30 THEN v_sal*1.3
    END;
    
    dbms_output.put_line('Enter value for empno : ');
    dbms_output.put_line('사원번호 이름   급여 부서번호 인상후급여');
    dbms_output.put_line(v_empno || '  ' || v_ename || '   ' || v_sal || '   ' || v_deptno || '     ' || v_up_sal); 
end;
/
      
-- 반복문 --
DECLARE
  num number := 0;
BEGIN 
  loop
    dbms_output.put_line(num);
    num := num +1;
    exit WHEN num > 5;
  END loop;
END;
/

-- while Loop --
declare
  num number := 0;
BEGIN
  while (num < 6) loop
    dbms_output.put_line(num);
    num := num +1;
  END loop;
END;
/

DECLARE
  num NUMBER := 6;
BEGIN
  loop
    num := num - 1;
    dbms_output.put_line(num);
    exit WHEN num = 0;
  END loop;
END;
/
-- for Loop --
BEGIN
  FOR i IN 0..5 loop
    dbms_output.put_line(i);
  END loop;
END;
/
BEGIN
  FOR i IN REVERSE 0..5 loop
    dbms_output.put_line(i);
  END loop;
END;
/

DECLARE
  v_name emp.ename%type;
BEGIN
  SELECT ename INTO v_name FROM emp
  WHERE empno = '&empno';
  
  FOR i IN 1..LENGTH(v_name) loop
    FOR j IN 1..i loop
      dbms_output.put('*');
    END loop;
  dbms_output.put_line(' ');  
  END loop;
END;
/  

DECLARE
  total NUMBER := 0;
BEGIN
  FOR i IN 1..10 loop
    total := total +1;
    dbms_output.put_line('total : ' || total);
    CONTINUE WHEN i >5;
    total := total + i;
    dbms_output.put_line('Out total : ' || total);
  end loop;
END;
/
