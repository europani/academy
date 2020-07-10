CREATE TABLE t_order(
  NO  NUMBER,
  ord_code  VARCHAR2(10),
  ord_date  DATE);
/
CREATE OR REPLACE TRIGGER t_order
BEFORE INSERT ON t_order
BEGIN
  IF (to_char(SYSDATE, 'hh24:mi') NOT BETWEEN '08:40' AND '19:00') THEN
    raise_application_error(-20100, '허용시간이 아닙니다.');
  END IF;
END;
/
INSERT INTO t_order VALUES (10, 'aaa', SYSDATE);
/

CREATE OR REPLACE TRIGGER t_order2
BEFORE INSERT ON t_order
FOR EACH ROW
when (new.ord_code = 'c01')
BEGIN
  IF (to_char(SYSDATE, 'hh24:mi') NOT BETWEEN '18:40' AND '19:00') THEN
    raise_application_error(-20100, 'c1 제품의 입력 허용시간이 아닙니다.');
  END IF;
END;
/
INSERT INTO t_order VALUES (10, 'c01', SYSDATE);
/
CREATE OR REPLACE TRIGGER t_order2
BEFORE INSERT ON t_order
FOR EACH ROW
BEGIN
  IF (:NEW.ord_code NOT IN ('c01', 'c02')) THEN
    raise_application_error(-20200, '허용된 제품 코드가 아닙니다.');
  END IF;
END;
/

CREATE TABLE t_test1(
  NO NUMBER,
  name varchar2(10));
CREATE TABLE t_test2(
  NO NUMBER,
  NAME VARCHAR2(10));
INSERT INTO t_test1 VALUES (1, 'AAA');
INSERT INTO t_test1 VALUES (2, 'BBB');
/
CREATE OR REPLACE TRIGGER t_move1
BEFORE UPDATE ON t_test1
for each row
BEGIN
  INSERT INTO t_test2 VALUES (:OLD.NO, :OLD.NAME);
  dbms_output.put_line('T_TEST2에 입력되었습니다.');
END;
/
UPDATE t_test1 SET NAME = 'CCC' WHERE NO = 1;
/

-- 문제 1)
CREATE OR REPLACE TRIGGER t_initem
AFTER INSERT ON in_item
FOR EACH ROW
BEGIN
  UPDATE stock SET qty = qty + :NEW.qty, price = price + :NEW.price
  WHERE NO = :NEW.NO;
  dbms_output.put_line('자료가 입력되었습니다.');
END;
/
INSERT INTO in_item VALUES (100, 2, 1800);
/

-- 문제 2)
CREATE OR REPLACE TRIGGER t_initem2
after insert on in_item
FOR EACH ROW
BEGIN
  INSERT INTO item VALUES(:NEW.NO, ' ', :NEW.price);
  INSERT INTO stock VALUES(:NEW.NO, :NEW.qty, :NEW.price);
  dbms_output.put_line('새로운 품목이 입력되었습니다.');
END;
/
INSERT INTO in_item VALUES (400, 3, 3000);
/
-- 문제 3)
CREATE OR REPLACE TRIGGER t_outitem
AFTER INSERT ON out_item
for each row
BEGIN
  UPDATE stock SET qty = qty - :NEW.qty, price = price - :NEW.price
  WHERE NO = :NEW.NO;
  dbms_output.put_line('자료가 입력되었습니다.');
END;
/
INSERT INTO out_item VALUES (100, 3, 2700);

CREATE TABLE emp_trg_log(
  tablename VARCHAR2(10),
  dml_type VARCHAR2(10),
  empno NUMBER(4),
  user_name VARCHAR2(30),
  change_date DATE);
CREATE TABLE emp_trg AS SELECT * FROM emp;



