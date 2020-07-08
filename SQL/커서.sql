DECLARE
  v_empno NUMBER(4);
  v_ename VARCHAR2(20);
  v_sal   NUMBER(7);
  
  CURSOR cl IS 
    SELECT empno, ename, sal
    FROM emp
    WHERE deptno = 20;
BEGIN
  OPEN cl;
  dbms_output.put_line('번호  이름  급여');
  loop
    fetch cl INTO v_empno, v_ename, v_sal;
    exit WHEN cl%notfound;
    dbms_output.put_line(v_empno || ' ' || v_ename || ' ' || v_sal);
  END loop;
  CLOSE cl;
END;
/
-- 문제 --
DECLARE
  v_name  student.NAME%TYPE;
  v_dname department.dname%TYPE;
  v_tel   student.tel%type;
  
  CURSOR c IS
    SELECT s.NAME, d.dname, s.tel
    FROM student s, department d
    WHERE s.deptno1 = d.deptno
    AND substr(tel, 1, instr(tel, ')')-1) = (select substr(tel, 1, instr(tel, ')')-1) from student where name = '&name'); 
BEGIN
  OPEN c;
  dbms_output.put_line('이름       학과        전화번호');
  loop
    fetch c INTO v_name, v_dname, v_tel;
    exit WHEN c%notfound;
    dbms_output.put_line(v_name || '   ' || v_dname || '   ' || v_tel);
  END loop;
  CLOSE c;
END;
/
-- 수정버전
DECLARE
  CURSOR c IS
    SELECT s.NAME, d.dname, s.tel
    FROM student s, department d
    WHERE s.deptno1 = d.deptno
    AND substr(tel, 1, instr(tel, ')')-1) = (select substr(tel, 1, instr(tel, ')')-1) from student where name = '&name'); 
BEGIN
  dbms_output.put_line('이름       학과        전화번호');
  for v_rec in c loop
    exit WHEN c%notfound;
    dbms_output.put_line(v_rec.name || '   ' || v_rec.dname || '   ' || v_rec.tel);
  END loop;
END;
/
-- 파라미터버전
DECLARE
  CURSOR c(p_name student.name%type) IS
    SELECT s.NAME, d.dname, s.tel
    FROM student s, department d
    WHERE s.deptno1 = d.deptno
    AND substr(tel, 1, instr(tel, ')')-1) = (select substr(tel, 1, instr(tel, ')')-1) from student where name = p_name); 
BEGIN
  dbms_output.put_line('이름       학과        전화번호');
  FOR v_rec IN c('이윤나') loop
    exit WHEN c%notfound;
    dbms_output.put_line(v_rec.NAME || ' ' || v_rec.dname || ' ' ||v_rec.tel);
  END loop;
  dbms_output.put_line('');
  dbms_output.put_line('이름       학과        전화번호');
  FOR v_rec IN c('김재수') loop
    exit WHEN c%notfound;
    dbms_output.put_line(v_rec.NAME || ' ' || v_rec.dname || ' ' ||v_rec.tel);
  END loop;
end;
/


-- 1) 커서만 사용 ★ 
DECLARE
  cursor emp_cur is       -- 커서 선언
    SELECT empno, ename
    from emp;
BEGIN
  FOR emp_rec IN emp_cur loop   -- 커서의 데이터를 저장할 emp_rec 변수 선언
    dbms_output.put_line(emp_rec.empno || ' ' || emp_rec.ename);
  END loop;
END;
/
-- 2) 커서와 변수 사용
DECLARE
  v_emp emp%rowtype;
  
  CURSOR c IS       -- 커서 선언
    SELECT empno, ename
    from emp;
BEGIN
  FOR v_emp IN c loop 
    exit WHEN c%notfound;
    dbms_output.put_line(v_emp.empno || ' ' || v_emp.ename);
  END loop;
END;      
/
-- 3) 커서를 직접 FOR문에 입력
DECLARE
BEGIN
  FOR emp_rec IN (SELECT empno, ename, sal FROM emp)
  loop
    dbms_output.put_line(emp_rec.empno || ' ' || emp_rec.ename);
  END loop;
END;
/

-- 파라미터 --
DECLARE
  r_emp emp%rowtype;
  
  CURSOR c_emp(dno NUMBER) IS 
    SELECT * FROM emp
    WHERE deptno = dno;
BEGIN
  dbms_output.put_line('=============================');
  OPEN c_emp(20);
  loop
    fetch c_emp INTO r_emp;
    exit WHEN c_emp%notfound;
    dbms_output.put_line(r_emp.ename || ' ' || r_emp.deptno);
  END loop;
  CLOSE c_emp;
  
  dbms_output.put_line('=============================');
  OPEN c_emp(30);
  loop
    fetch c_emp INTO r_emp;
    exit WHEN c_emp%notfound;
    dbms_output.put_line(r_emp.ename || ' ' || r_emp.deptno);
  END loop;
  CLOSE c_emp;
END;
/

DECLARE
  CURSOR emp_cur(p_dno emp.deptno%TYPE) IS
    SELECT empno, ename, sal, deptno FROM emp
    WHERE deptno = p_dno;
BEGIN
  FOR emp_rec IN emp_cur(10) loop
    exit when emp_cur%notfound;
    dbms_output.put_line(emp_rec.empno || ' ' || emp_rec.ename);
  END loop;
END;
/ 

CREATE TABLE f(
  num   NUMBER,
  NAME  VARCHAR2(10));
INSERT INTO f VALUES (5, 'five');
INSERT INTO f VALUES (6, 'six');
INSERT INTO f VALUES (7, 'seven');
INSERT INTO f VALUES (8, 'eight');
INSERT INTO f VALUES (9, 'nine');
/
DECLARE
  v_num   f.num%TYPE;
  v_name  f.NAME%TYPE;

  CURSOR c_f IS
    SELECT num, NAME FROM f
    WHERE LENGTH(NAME) = 5
  FOR UPDATE;
BEGIN
  open c_f;
  loop
    fetch c_f INTO v_num, v_name;
    exit WHEN c_f%notfound;
    UPDATE f SET num = v_num * v_num
--  DELETE f  
    WHERE CURRENT OF c_f;
  END loop;
  CLOSE c_f;
END;
/

-- 묵시적 커서 --
DECLARE
  v_deptno NUMBER := &dno;
BEGIN
  DELETE emp WHERE deptno = v_deptno;
  dbms_output.put_line('삭제된 건수는 ' || SQL%rowcount || ' 입니다.');
  ROLLBACK;
END;
/

DECLARE
  v_ename emp.ename%TYPE;
  v_sal   emp.sal%type;
  
  CURSOR c IS 
    SELECT ename, sal FROM emp 
    WHERE deptno = &deptno;
BEGIN
  open c;
  loop
    fetch c INTO v_ename, v_sal;
    exit when c%notfound;
    dbms_output.put_line(v_ename || ' ' || v_sal);
  END loop;
  CLOSE c;
END;
/
-- case 별 update --
DECLARE
  v_ename   emp.ename%TYPE;
  v_deptno  emp.deptno%TYPE;
  v_sal     emp.sal%TYPE;
  v_temp    number := 0;
    
  CURSOR c IS
    SELECT ename, deptno, sal FROM emp
  FOR UPDATE;
BEGIN
  OPEN c;
  loop
    fetch c INTO v_ename, v_deptno, v_sal;
    exit WHEN c%notfound;

    CASE v_deptno
    WHEN 10 THEN v_temp := 1.1;
    WHEN 20 THEN v_temp := 1.2;
    WHEN 30 THEN v_temp := 1.3;
    END CASE;
    
    dbms_output.put_line(v_ename || ' ' || v_deptno || '->' || v_deptno || '% ' || v_sal*v_temp);
--    update emp set sal = v_sal*v_temp;
   
  END loop;
  CLOSE c;
END;
/
    
    
    
    