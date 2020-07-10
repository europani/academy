create table reserv(
ser number(10)  primary key,
roomno  varchar(10),  -- room key 
startdate date,
enddate date,
revdate date);

Insert into RESERV  values (1,'a01','20/07/08','20/07/10',sysdate);
Insert into RESERV  values (2,'a01','20/07/10','20/07/12',sysdate);
Insert into RESERV  values (3,'a01','20/07/13','20/07/14',sysdate);
Insert into RESERV  values (4,'a01','20/07/17','20/07/20',sysdate);
Insert into RESERV  values (5,'a01','20/07/22','20/08/06',sysdate);
Insert into RESERV  values (6,'a01','20/08/09','20/08/11',sysdate);
Insert into RESERV  values (7,'a01','20/08/12','20/08/14',sysdate);
Insert into RESERV  values (8,'a01','20/08/14','20/08/16',sysdate);
Insert into RESERV  values (9,'a01','20/08/16','20/08/18',sysdate);
INSERT INTO reserv  VALUES (10,'a01','20/08/31','20/09/05',SYSDATE);
/
--------------------------------------------------------------------------
DECLARE 
  CURSOR c IS
    SELECT startdate, enddate, enddate-startdate AS nights
    FROM reserv
    WHERE to_char(startdate, 'mm') = 7;
BEGIN 
  dbms_output.put_line('  입실일    퇴실일   박');
  FOR t_resev IN c loop
    IF (to_char(t_resev.enddate, 'yymmdd') > 200801) THEN
    t_resev.enddate := to_date(200801, 'yymmdd');
    t_resev.nights := t_resev.enddate-t_resev.startdate;
    elsif (to_char(t_resev.startdate, 'yymmdd') < 200701) THEN
    t_resev.startdate := to_date(200701, 'yymmdd');
    t_resev.nights := t_resev.enddate-t_resev.startdate;
  end if;
  dbms_output.put_line(t_resev.startdate || ' ' || t_resev.enddate || ' ' || t_resev.nights);
  end loop;
  END;
/
DECLARE 
  CURSOR c IS
    SELECT startdate, enddate, enddate-startdate AS nights
    FROM reserv
    WHERE to_char(startdate, 'mm') = 8;
BEGIN 
  dbms_output.put_line('  입실일    퇴실일   박');
  FOR t_resev IN c loop
    IF (to_char(t_resev.enddate, 'yymmdd') > 200901) THEN
    t_resev.enddate := to_date(200901, 'yymmdd');
    t_resev.nights := t_resev.enddate-t_resev.startdate;
    elsif (to_char(t_resev.startdate, 'yymmdd') < 200801) THEN
    t_resev.startdate := to_date(200801, 'yymmdd');
    t_resev.nights := t_resev.enddate-t_resev.startdate;
  end if;
  dbms_output.put_line(t_resev.startdate || ' ' || t_resev.enddate || ' ' || t_resev.nights);
  END loop;
  END;
