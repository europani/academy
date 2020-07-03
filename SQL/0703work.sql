CREATE TABLE board(
  ser NUMBER(10) PRIMARY KEY,
  ID  VARCHAR2(8) REFERENCES MEMBER(id),
  subject VARCHAR2(200),
  CONTENT VARCHAR2(3000),
  readcount NUMBER(10),
  passwd  VARCHAR2(8));
  
-- 1 --
INSERT INTO board(ser, ID, subject) VALUES (1, 'simson', '快府唱扼');
INSERT INTO board(ser, ID) VALUES (2, 'simson');
insert into board(ser, id) values (3, 'simson');
insert into board(ser, id) values (4, 'simson');
INSERT INTO board(ser, ID) VALUES (5, 'simson');

-- 2 --
SELECT * FROM board WHERE ser = 3;

-- 3 --
UPDATE board SET subject = '快府付阑', CONTENT = '快府涝聪促.' where ser = 3;

-- 4 --
SELECT * FROM board WHERE subject LIKE '%快府%' AND CONTENT LIKE '%快府%'; 

-- 5 --
UPDATE board SET READCOUNT = readcount +1 WHERE ser = 3;

-- 6 --
DELETE FROM board WHERE ser = 3 
AND (ID, passwd) IN (SELECT ID, passwd FROM MEMBER);

-- 7 --
SELECT * FROM (
SELECT ROWNUM AS r, A.*
FROM (SELECT * FROM board ORDER BY subject) A)
WHERE r BETWEEN 2 AND 4;


