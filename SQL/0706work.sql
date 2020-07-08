CREATE TABLE pname(
  NAME  VARCHAR2(26),
  factory VARCHAR2(200));
  
-- 3 --  
INSERT INTO pname VALUES ('그랜저', '서울');
INSERT INTO pname VALUES ('밴즈', '인천');
INSERT INTO pname VALUES ('BMW', '대전');
INSERT INTO pname VALUES ('아반떼', '강릉');
INSERT INTO pname VALUES ('라세띠', '부산');

-- 4 --
alter table pname add CONSTRAINT pname_name_pk primary key(name);

-- 5 --
ALTER TABLE product2 ADD CONSTRAINT product2_name_fk FOREIGN KEY(NAME) REFERENCES pname(name);

-- 6 --
INSERT INTO product2 VALUES(3, 1, '그랜저', '10');

-- 7 --
insert into product2 values(4, 3, 'BMW', '3');

-- 8 --
SELECT NAME, 
  sum(decode(mon, 1, decode(con, 1, qty))) AS "1월",
  sum(decode(mon, 2, decode(con, 1, qty))) AS "2월",
  sum(decode(mon, 3, decode(con, 1, qty))) AS "3월",
  sum(decode(mon, 4, decode(con, 1, qty))) AS "4월",
  sum(decode(mon, 5, decode(con, 1, qty))) AS "5월",
  sum(decode(mon, 6, decode(con, 1, qty))) AS "6월",
  sum(decode(mon, 7, decode(con, 1, qty))) AS "7월",
  sum(decode(mon, 8, decode(con, 1, qty))) AS "8월",
  sum(decode(mon, 9, decode(con, 1, qty))) AS "9월",
  sum(decode(mon, 10, decode(con, 1, qty))) AS "10월",
  sum(decode(mon, 11, decode(con, 1, qty))) AS "11월",
  sum(decode(mon, 12, decode(con, 1, qty))) AS "12월"
  FROM product2
  GROUP BY NAME;
  
-- 9 --
SELECT NAME, 
  decode(con, 1, qty) AS 생산,
  decode(con, 2, -qty) AS 출고,
  decode(con, 3, qty) AS 반품,
  decode(con, 2, -qty, qty) AS 수량,
  sum(decode(con, 2, -qty, qty)) over(order by rownum) AS 누계
FROM product2
WHERE NAME = '아반떼' AND mon = 10;


-- 10 --
SELECT NAME, 
  sum(decode(con, 2, -qty, qty)) AS 생산판매반품
FROM product2
where mon = 10
group by name;

-- 11 --
SELECT NAME, 
  decode(con, 1, qty) AS 생산,
  decode(con, 2, -qty) AS 출고,
  decode(con, 3, qty) AS 반품,
  decode(con, 1, qty, 2, -qty, 3, qty) AS qty
FROM product2
where mon = 10 AND name = '아반떼';