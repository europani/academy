SET SERVEROUTPUT ON;  -- PL/SQL 결과 화면 출력기능 활성화

DECLARE
  vi_num NUMBER;
BEGIN
  vi_num := 100;
  DBMS_OUTPUT.PUT_LINE(vi_num);
END;

DECLARE
  A INTEGER := 2**2*3**2;
BEGIN
  DBMS_OUTPUT.PUT_LINE('a=' || to_char(A));
  DBMS_OUTPUT.PUT_LINE('a=' || a);
END;

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

DECLARE
  vno NUMBER(4);
  vname VARCHAR2(10);
BEGIN
  SELECT empno, ename INTO vno, vname
  FROM emp
  WHERE empno = 7900;
  DBMS_OUTPUT.PUT_LINE(vno || ' ' || vname);
END;

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
