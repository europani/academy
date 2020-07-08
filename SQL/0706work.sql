CREATE TABLE pname(
  NAME  VARCHAR2(26),
  factory VARCHAR2(200));
  
-- 3 --  
INSERT INTO pname VALUES ('�׷���', '����');
INSERT INTO pname VALUES ('����', '��õ');
INSERT INTO pname VALUES ('BMW', '����');
INSERT INTO pname VALUES ('�ƹݶ�', '����');
INSERT INTO pname VALUES ('�󼼶�', '�λ�');

-- 4 --
alter table pname add CONSTRAINT pname_name_pk primary key(name);

-- 5 --
ALTER TABLE product2 ADD CONSTRAINT product2_name_fk FOREIGN KEY(NAME) REFERENCES pname(name);

-- 6 --
INSERT INTO product2 VALUES(3, 1, '�׷���', '10');

-- 7 --
insert into product2 values(4, 3, 'BMW', '3');

-- 8 --
SELECT NAME, 
  sum(decode(mon, 1, decode(con, 1, qty))) AS "1��",
  sum(decode(mon, 2, decode(con, 1, qty))) AS "2��",
  sum(decode(mon, 3, decode(con, 1, qty))) AS "3��",
  sum(decode(mon, 4, decode(con, 1, qty))) AS "4��",
  sum(decode(mon, 5, decode(con, 1, qty))) AS "5��",
  sum(decode(mon, 6, decode(con, 1, qty))) AS "6��",
  sum(decode(mon, 7, decode(con, 1, qty))) AS "7��",
  sum(decode(mon, 8, decode(con, 1, qty))) AS "8��",
  sum(decode(mon, 9, decode(con, 1, qty))) AS "9��",
  sum(decode(mon, 10, decode(con, 1, qty))) AS "10��",
  sum(decode(mon, 11, decode(con, 1, qty))) AS "11��",
  sum(decode(mon, 12, decode(con, 1, qty))) AS "12��"
  FROM product2
  GROUP BY NAME;
  
-- 9 --
SELECT NAME, 
  decode(con, 1, qty) AS ����,
  decode(con, 2, -qty) AS ���,
  decode(con, 3, qty) AS ��ǰ,
  decode(con, 2, -qty, qty) AS ����,
  sum(decode(con, 2, -qty, qty)) over(order by rownum) AS ����
FROM product2
WHERE NAME = '�ƹݶ�' AND mon = 10;


-- 10 --
SELECT NAME, 
  sum(decode(con, 2, -qty, qty)) AS �����ǸŹ�ǰ
FROM product2
where mon = 10
group by name;

-- 11 --
SELECT NAME, 
  decode(con, 1, qty) AS ����,
  decode(con, 2, -qty) AS ���,
  decode(con, 3, qty) AS ��ǰ,
  decode(con, 1, qty, 2, -qty, 3, qty) AS qty
FROM product2
where mon = 10 AND name = '�ƹݶ�';