-- 1 --
CREATE TABLE MEMBER22(
  userid VARCHAR2(8) PRIMARY KEY,
  passwd VARCHAR2(8) NOT NULL,
  NAME VARCHAR2(20) NOT NULL,
  tel VARCHAR2(15) CHECK (length(tel) BETWEEN 10 AND 11),
  addr1 VARCHAR2(200),
  addr2 VARCHAR2(200),
  zipcode VARCHAR2(8),
  jumin VARCHAR2(13) CHECK (jumin = 13),
  gid varchar2(8) references membergroup(gid), 
  rdate DATE DEFAULT SYSDATE);
CREATE TABLE membergroup(
  gid VARCHAR2(8) unique,
  gname VARCHAR2(20));

-- 2 --
INSERT INTO membergroup VALUES ('1', '1');

INSERT INTO member22(userid, passwd, NAME, gid, tel, addr1)
  VALUES ('sist01', '1111', '김쌍용', '1', '0200000000', '서울시');

-- 3 --
SELECT * FROM member22 WHERE userid = 'sist01';

-- 4 --
SELECT * FROM member22 WHERE userid = 'sist01' AND passwd = '1111';

-- 5 --
UPDATE member22 SET tel = '0001112222', addr1 = '서울', addr2 = '서울'
WHERE userid = 'sist01' AND passwd = '1111';

-- 6 --
delete from member22 where userid = 'sist01' AND passwd = '1111';

-- 7 --
SELECT * FROM member22 ORDER BY NAME;

-- 8 --
SELECT * FROM member22 WHERE substr(tel, 1, 2) = '02';
SELECT * FROM member22 WHERE tel LIKE '02%';

-- 9 --
SELECT * FROM member22 WHERE addr1 LIKE '서울%' OR addr2 LIKE '서울%';