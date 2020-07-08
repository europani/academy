-- 1 --
DECLARE
  CURSOR c IS
    SELECT NAME,
      sum(decode(mon, 1, qty)) AS A,
      sum(decode(mon, 2, qty)) AS B,
      sum(decode(mon, 3, qty)) AS C,
      sum(decode(mon, 4, qty)) AS D,
      sum(decode(mon, 5, qty)) AS E,
      sum(decode(mon, 6, qty)) AS F,
      sum(decode(mon, 7, qty)) AS G,
      sum(decode(mon, 8, qty)) AS h,
      sum(decode(mon, 9, qty)) AS I,
      sum(decode(mon, 10, qty)) AS J,
      sum(decode(mon, 11, qty)) AS K,
      sum(decode(mon, 12, qty)) AS L
      FROM product2
      WHERE con = &con
      group by name;
BEGIN
  dbms_output.put_line('NAME 1�� 2�� 3�� 4�� 5�� 6�� 7�� 8�� 9�� 10�� 11�� 12��');
  FOR p_rec IN c loop
  dbms_output.put_line(p_rec.NAME || ' ' || p_rec.A || '  ' || p_rec.b || '  ' || p_rec.c || '  ' || p_rec.d || '  ' || p_rec.e || '  ' || p_rec.f
                      || '  ' || p_rec.G || '  ' || p_rec.H || '  ' || p_rec.I || '  ' || p_rec.J || '  ' || p_rec.K || '  ' || p_rec.L);
  end loop;
END;
/
-- 2 --
DECLARE
  CURSOR c IS
    SELECT NAME, 
      decode(con, 1, decode(con, 2, -qty, qty)) AS ����,
      decode(con, 2, decode(con, 2, -qty, qty)) AS ���, 
      decode(con, 3, decode(con, 2, -qty, qty)) AS ��ǰ,
      decode(con, 2, -qty, qty) AS ����,
      sum(decode(con, 2, -qty, qty)) over(order by rownum) AS ����
    FROM product2
    WHERE NAME = '&name'
    AND mon = &mon;
BEGIN
  dbms_output.put_line('NAME ���� ��� ��ǰ ���� ����');
  FOR t_pro IN c loop
    dbms_output.put_line(t_pro.NAME || ' ' || t_pro.���� || ' ' ||t_pro.��� || ' ' ||t_pro.��ǰ || ' ' ||t_pro.���� || ' ' ||t_pro.����);
  end loop;
END;
/
-- 3 --
DECLARE
  CURSOR c IS
    SELECT mon, NAME, sum(decode(con, 2, -qty, qty)) AS sum
    FROM product2
    where mon = &mon
    group by name, mon;
BEGIN
  dbms_output.put_line('�� NAME �����ǸŹ�ǰ');
  FOR t_pro IN c loop
    dbms_output.put_line(t_pro.mon || ' ' || t_pro.NAME || ' ' || t_pro.sum);
  END loop;
END;
 / 
  