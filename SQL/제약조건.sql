CREATE TABLE emp3(
  NO NUMBER(4) CONSTRAINT emp3_no_pk PRIMARY KEY,
  NAME VARCHAR2(10) CONSTRAINT emp3_name_nn NOT NULL,
  jumin VARCHAR2(13) CONSTRAINT emp3_jumin_nn NOT NULL
                     CONSTRAINT emp3_jumin_unq UNIQUE,
  area NUMBER(1) CONSTRAINT emp3_area_ck check (area <5),
  deptno VARCHAR2(6) CONSTRAINT emp3_deptno_fk REFERENCES dept2(dcode));

CREATE TABLE emp4(
  NO NUMBER(4) PRIMARY KEY,
  NAME VARCHAR2(10) NOT NULL,
  jumin VARCHAR2(13) NOT NULL UNIQUE,
  area NUMBER(1) CHECK(area < 5),
  deptno VARCHAR2(6) REFERENCES dept2(dcode));
  
SELECT owner, constraint_name, constraint_type, status
FROM user_constraints
WHERE table_name = 'EMP3';

ALTER TABLE emp4 ADD CONSTRAINT emp4_name_uk UNIQUE(NAME);
ALTER TABLE emp4 MODIFY (area CONSTRAINT emp4_area_nn not NULL);

ALTER TABLE emp4 ADD CONSTRAINT emp4_no_fk FOREIGN KEY(NO) REFERENCES emp2(empno);

ALTER TABLE emp2 ADD CONSTRAINT emp2_name_uk UNIQUE(NAME); -- 부모테이블의 레퍼런스키를 Unique 지정
ALTER TABLE emp4 ADD CONSTRAINT emp4_name_fk FOREIGN KEY(NAME) REFERENCES emp2(NAME);

INSERT INTO emp4 VALUES (111, '1111', 112, 1, 1000); --X name_fk때문에
INSERT INTO emp4 VALUES (112, '나사장', 111, 1, 1000);
INSERT INTO emp4 VALUES (113, '전부장', 113, 1, 1000);
insert into emp4 values (114, '최일도', 114, 1, 1011);

ALTER TABLE emp4 DROP CONSTRAINT emp4_name_fk;
ALTER TABLE emp4 ADD CONSTRAINT emp4_name_fk FOREIGN KEY(NAME) REFERENCES emp2(NAME) ON DELETE SET NULL;

SELECT A.table_name AS 자식테이블, c.column_name, a.constraint_name, b.table_name AS 부모테이블,  d.column_name, A.r_constraint_name
FROM user_constraints A, user_constraints b, user_cons_columns c,
  (SELECT constraint_name, column_name, table_name FROM user_cons_columns) d
WHERE A.r_constraint_name = b.constraint_name
AND A.constraint_name = c.constraint_name
AND A.r_constraint_name = d.constraint_name
AND a.constraint_type = 'R';

CREATE TABLE parent (    -- 부모 먼저 생성 후 제약조건 설정
  NO NUMBER(2) PRIMARY KEY);
INSERT INTO parent VALUES (11);

CREATE TABLE child1(    -- 자식 생성
  NAME VARCHAR2(10),
  NO NUMBER(2) REFERENCES PARENT(NO));
INSERT INTO child1 VALUES ('aaa', 11);


  