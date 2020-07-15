--1. 2019�⿡ �ֹ��ѳ������� �ֹ� Ƚ���� �ù�� ���� ����϶�. (�ù���, �ֹ�Ƚ��)

SELECT d_name "�ù��", COUNT(d_name) "�ֹ�Ƚ��"
FROM orderlist
WHERE to_char(order_date, 'YY') = '19'
GROUP BY d_name;




--2. ���ɺ�(10������� ���)�� �ֹ��ݾ��� ���� ���� ���ɿ��� ���� ������ �����Ϸ� �Ѵ�.
--���ɺ� �ֹ���Ż�ݾ��� ����϶�. (����, �ֹ���Ż�ݾ�, ����)

-- 2-1) trunc(to_char())�� �̿��ؼ� 10������� ���ɺ��� ������ sum()�Լ��� �ֹ��ѱݾ��� ������
-- 2-2) rank() over() �Լ��� ���ɺ� �ѱݾ����� �̿������ ���Ѵ�. 
SELECT trunc(to_char(c.birthday,'YYYY'),-1) ���ɺ�, to_char(SUM(o.order_total),'999,999') "�̿�ݾ�($)"
,RANK() OVER (ORDER BY SUM(o.order_total) DESC) "�̿����"
FROM customer c, orderlist o
WHERE c.ID = o.ID
GROUP BY trunc(to_char(c.birthday,'YYYY'),-1)
ORDER BY 1;





--3. A,B,C â���� ������ �԰� �� �԰�ݾ�

SELECT substr(in_loc,1,1) â��,
sum(decode(to_char(in_date,'YY'),'19',in_qty))||'��' "19�⵵ �԰�",
'$'||sum(decode(to_char(in_date,'YY'),'19',in_price*in_qty)) "19�⵵ �԰�ݾ�",
sum(decode(to_char(in_date,'YY'),'20',in_qty))||'��' "20�⵵ �԰�",
'$'||sum(decode(to_char(in_date,'YY'),'20',in_price*in_qty)) "20�⵵ �԰�ݾ�"
FROM inven GROUP BY substr(in_loc,1,1);




--4. ���𺰷� �� ǰ���� �Ǹŷ��� �����Ͽ� ����϶�. (3,4,5�� : �� / 6,7,8�� : ���� / 9,10,11�� : ���� /  12,1,2�� : �ܿ�)

--'�Ǹŷ�'�� �ִ� orderlist���̺�, '����'�� �ִ� order_detail ���̺�, ǰ���� �ִ� product���̺��� ���� ���� ����ؾ� �Ѵ�.
-- 4-1) ���� �� ��ǰ�� ���� �Ǹŷ��� Ȯ���غ���.
select od.p_name "ǰ��",
sum(decode(to_char(o.order_date,'MM'),'01',od.order_qty)) "1��",
sum(decode(to_char(o.order_date,'MM'),'02',od.order_qty)) "2��",
sum(decode(to_char(o.order_date,'MM'),'03',od.order_qty)) "3��",
sum(decode(to_char(o.order_date,'MM'),'04',od.order_qty)) "4��",
sum(decode(to_char(o.order_date,'MM'),'05',od.order_qty)) "5��",
sum(decode(to_char(o.order_date,'MM'),'06',od.order_qty)) "6��",
sum(decode(to_char(o.order_date,'MM'),'07',od.order_qty)) "7��",
sum(decode(to_char(o.order_date,'MM'),'08',od.order_qty)) "8��",
sum(decode(to_char(o.order_date,'MM'),'09',od.order_qty)) "9��",
sum(decode(to_char(o.order_date,'MM'),'10',od.order_qty)) "10��",
sum(decode(to_char(o.order_date,'MM'),'11',od.order_qty)) "11��",
sum(decode(to_char(o.order_date,'MM'),'12',od.order_qty)) "12��" 
from orderlist o, order_detail od where o.order_no = od.order_no group by od.p_name;

-- 4-2) ���� output�� ǰ�񺰷� ������Ѵ�. p_name���� ���� �� �ִ� product���̺��� Ȱ������.
select p.c_code "ǰ��",
sum(decode(to_char(o.order_date,'MM'),'01',od.order_qty)) "1��",
sum(decode(to_char(o.order_date,'MM'),'02',od.order_qty)) "2��",
sum(decode(to_char(o.order_date,'MM'),'03',od.order_qty)) "3��",
sum(decode(to_char(o.order_date,'MM'),'04',od.order_qty)) "4��",
sum(decode(to_char(o.order_date,'MM'),'05',od.order_qty)) "5��",
sum(decode(to_char(o.order_date,'MM'),'06',od.order_qty)) "6��",
sum(decode(to_char(o.order_date,'MM'),'07',od.order_qty)) "7��",
sum(decode(to_char(o.order_date,'MM'),'08',od.order_qty)) "8��",
sum(decode(to_char(o.order_date,'MM'),'09',od.order_qty)) "9��",
sum(decode(to_char(o.order_date,'MM'),'10',od.order_qty)) "10��",
sum(decode(to_char(o.order_date,'MM'),'11',od.order_qty)) "11��",
sum(decode(to_char(o.order_date,'MM'),'12',od.order_qty)) "12��" 
from orderlist o, order_detail od, product p where o.order_no = od.order_no and od.p_name = p.p_name group by p.c_code;

-- 4-3) ������ �䱸�Ѵ�� ���� output�� �������� ����, nvló������ ����ϰ� ����.
select p.c_code "ǰ��",
nvl(sum(decode(to_char(o.order_date,'MM'),'03',od.order_qty,'04',od.order_qty,'05',od.order_qty)),0) "�� ����",
nvl(sum(decode(to_char(o.order_date,'MM'),'06',od.order_qty,'07',od.order_qty,'08',od.order_qty)),0) "���� ����",
nvl(sum(decode(to_char(o.order_date,'MM'),'09',od.order_qty,'10',od.order_qty,'11',od.order_qty)),0) "���� ����",
nvl(sum(decode(to_char(o.order_date,'MM'),'12',od.order_qty,'01',od.order_qty,'02',od.order_qty)),0) "�ܿ� ����"
from orderlist o, order_detail od, product p where o.order_no = od.order_no and od.p_name = p.p_name group by p.c_code;

--** ���� c_code�� �ѱ۷� �����ϰ� �ʹٸ�? category���̺��� ���������� Ȱ���ϸ� �ȴ�.
select (select c_name from category where c_code = p.c_code) "ǰ��",
nvl(sum(decode(to_char(o.order_date,'MM'),'03',od.order_qty,'04',od.order_qty,'05',od.order_qty)),0) "�� ����",
nvl(sum(decode(to_char(o.order_date,'MM'),'06',od.order_qty,'07',od.order_qty,'08',od.order_qty)),0) "���� ����",
nvl(sum(decode(to_char(o.order_date,'MM'),'09',od.order_qty,'10',od.order_qty,'11',od.order_qty)),0) "���� ����",
nvl(sum(decode(to_char(o.order_date,'MM'),'12',od.order_qty,'01',od.order_qty,'02',od.order_qty)),0) "�ܿ� ����"
from orderlist o, order_detail od, product p where o.order_no = od.order_no and od.p_name = p.p_name group by p.c_code;




--5. �̹���(7��) ������ ȸ������ ��޿� ���� ���������� �����ַ��� �Ѵ�. ������ ȸ���� ID, �̸�, ����, ��� �� �������ް����� ����϶�(�����:1, �ǹ�:2, ��, VIP:5��)

-- 5-1) customer�� grade�� ���� �� �� birthday�� 7���� customer�� �̾� �������ް����� grade�� ���� ����
SELECT c.ID, c.NAME, c.birthday, g.grade, 
  decode(g.grade, 'VIP', 5, '�÷�Ƽ��', 4, '���', 3, '�ǹ�', 2, 1) AS ����������
FROM customer c, grade g
WHERE to_char(birthday, 'mm') = to_char(SYSDATE, 'mm')
AND c.grade = g.grade;




--6. ������ ���θ� �� ��ǰ�� ��õ�ϱ� ���� ������ ������ ���ɴ븦 �Է� �޾�  �Ǹ� ���� ���� 3���� ��ǰ�� ����϶�.  (�Է� : ����(M/F), ����)

--   6-1) customer, orderlist, order_detail ���̺��� �����Ͽ� ���� ����,�̸�, ���̿� �� �� �ֹ� ������ �հ踦 ���Ͽ� �ζ��κ並 �����Ѵ�
--   6-2) ������ �ζ��� ���� ����, ���ɴ�, ��ǰ��, �Ǹŷ��� rank() over �� ����� �Ǹ� ������ ���� ���
--   6-3) �Ǹŷ� ���� 3���� ������ ����ϱ� ���� rownum�� ����Ͽ� rank()�� rownum�� ã��
--   6-4) (3)���� rownum�� ã���� ���� �������� ���ʷ� rownum�� �����Ƿ� rownum <= 3 ������ ���� ���� 3���� ���� ���
SELECT rnum.* FROM(
  SELECT r.sex ����, r.age ���ɴ�, r.NAME ��ǰ��, r.sum_qty �Ǹŷ�, DENSE_RANK() OVER(ORDER BY r.sum_qty DESC) ����
  FROM 
    -- �ζ��� �� ����
    (SELECT c.sex sex, o2.p_name NAME, trunc((SYSDATE - birthday)/365,-1) age, sum(o2.order_qty) sum_qty
      FROM customer c, orderlist o1, order_detail o2
      WHERE c.ID = o1.ID AND o1.order_no = o2.order_no
      GROUP BY c.sex, trunc((SYSDATE - birthday)/365,-1), o2.p_name
      ORDER BY 2) r
    WHERE r.sex =upper( '&sex') AND age =trunc(( '&age'),-1)) rnum
  WHERE ROWNUM <= 3;



--7. ��޺� ������ ����� �ֹ��ݾװ� �ù�� ������ orderlist�� ����϶�. (��, VIP���� ���� �ù�����, ���ֵ��� +$3 )

-- 7-1) 4���� ���̺��� ������ �� ����� ������ ����� ���űݾ��� �ݿø��ؼ� ���Ѵ�.
-- 7-2) ��ۺ� ���� ���� �տ��� ���� ���űݾ׿��� VIPȸ���� ��ۺ� free, ���ֵ������ڴ� +$3�� �߰��� �����Ѵ�.(���űݾ� + ���ֵ� �߰���ۺ� + ������ ��ۺ�(VIP�� 0))
SELECT o.order_no, o.ID, o.order_date, c.grade, 
  to_char(round(o.order_total*(1-g.discount), 0), '$99,999') AS "��ۺ�����(��������)", 
  to_char(round(o.order_total*(1-g.discount), 0) + decode(substr(c.address, 1, 2), '����', 3, 0) + decode(c.grade, 'VIP', 0, d.d_fee), '$99,999') AS ��ۺ�����
FROM orderlist o, delivery d, customer c, grade g
WHERE o.d_name = d.d_name
AND c.ID = o.ID
AND g.grade = c.grade
ORDER BY 1;






--8. ���� ���� �ù�� ������������ �λ꿡 ���� �����Ͽ�, �Ǵ� 2�޷���� ������ ���ݿ� ��ü��� ��۰���� ü�����ְ� �ִ�.  
-- ���� ��� �����ù��� ����� �����ϰ� ���Ӱ� ����� ü���� ���� ������ ����ϰ��� �Ѵ�.
-- ���ݱ����� ���θ� ��Ⱓ�� �������� ��� ����� ���� �� ���� 10���� ���� ��ۺ���� ���Ͽ�, ���� ������� ���ϴ� �÷��� �ۼ�����. 
-- (������� �Ҽ��� ������� �� ��)

-- �ù��,��۱ݾ� �� ������ �ִ� delivery���̺�, �ֹ������� �ִ� orderlist���̺� Ȱ���ؼ� ���� �����س� �� �ִ�.
-- 8-1) ���� ��� ������ �ù�� ������ Ȯ���غ���. ��� ������ a_code�� 5���� Ȯ���� �� �ִ�.
select a.a_name, a.a_code, d.d_area from delivery d, AREA_CODE a where d.d_area = a.a_code;

-- 8-2) orderlist ���̺�� delivery ���̺��� �����Ͽ�, d_area�� 5�� ���� �Ͽ��� �� �ֹ��� �ù��� �ù�� Ȯ���غ���. 
--   (d_area�� a_code�� foreign key�� ����Ȼ���. ��,���ΰ��� �ڵ�)
select o.order_no, o.d_name, d.d_fee from orderlist o, delivery d 
where d.d_name = o.d_name and d.d_area = 5; --> �����ù�, 5�޷� Ȯ��

-- 8-3) ���� ������� count�� ���, ���±��� �����ù� ��ۺ���� Ȯ���غ���.
select count(*) �ù跮, o.d_name "�ù��", sum(d.d_fee) �ݾ� from orderlist o, delivery d 
where d.d_name = o.d_name and d.d_area = 5 group by o.d_name;

-- 8-4) ���Ͱ��� �������, �� �ù��(������) �̿���� ����ݾ��� �������.
select count(*) �ù跮, '������' "�ù��", sum(2) ���ݾ� from orderlist o, delivery d 
where d.d_name = o.d_name and d.d_area = 5 group by o.d_name;

-- 8-5) ������, ���θ��� ��� �������� �̿�� �Ⱓ�� ���ϴ� ���̴�. �̸� �������� '10��'�� ���ؾ� �Ѵ�.
--    ���� ������� ��� �������� ���� ��ǰ�� �ֹ��� �Ⱓ�� ������.
select d.d_area "�����ڵ�", max(o.order_date)-min(o.order_date) ��� -->> max orderdate���� min orderdate�� �� ��¥. ��, �������� ���θ� ��Ⱓ.
from orderlist o, delivery d where d.d_area = 5 and d.d_name = o.d_name group by d.d_area; --> 494�� Ȯ��

-- 8-6) ��������� ��Ⱓ(494��)�� �������� 10���� �����۱ݾ��� ���ϴ� ���� '��������� ��ۺ� * (10�� / �����Ⱓ)' �̴�. �̸� �����Ͽ� ��ۺ� ���غ���.
select 3650/(max(o.order_date)-min(o.order_date)) from orderlist o, delivery d where d.d_name = o.d_name and d.d_area = 5 group by o.d_name; -- (3650��/494��) Ȯ��
select o.d_name "�ù��", '$'||round(sum(d.d_fee)*(3650/(max(o.order_date)-min(o.order_date)))) "���� ��ۺ��"
from orderlist o, delivery d where d.d_name = o.d_name and d.d_area = 5 group by o.d_name --> �����ù�� ����10�� �����ۺ��
union all
select '������' "�ù��", '$'||round(sum(2)*(3650/(max(o.order_date)-min(o.order_date)))) "���� ��ۺ��"
from orderlist o, delivery d where d.d_name = o.d_name and d.d_area = 5 group by o.d_name --> ������ ����10�� �����ۺ��
union all
select '�������ͱ�' "�ù��", 
'$'||round((sum(d.d_fee)*(3650/(max(o.order_date)-min(o.order_date))))-(sum(2)*(3650/(max(o.order_date)-min(o.order_date))))) "���� ��ۺ��"
from orderlist o, delivery d where d.d_name = o.d_name and d.d_area = 5 group by o.d_name; --> �� �ΰ� �������� ���� �� �ݾ�.





--9. �̺�Ʈ�� �¾� Ư�� �ݾ�(5000) �̻� ���Ž� ī�װ� �� ���ο� ����. ������ ������� �� �ִ� ȸ���� �̸���, ���̵�, ��ȭ��ȣ, ���� �� �ݾװ� ���� �� �ݾ��� ����϶�
--(���� ī�װ� : ���� 10%, ���� 20%, ���� 30%)

--   9-1) customer, product, orderlist, order_detail ���̺��� �����Ͽ�
--     ���� �̸�, ���̵�, ��ȭ��ȣ,  ��ǰ �ڵ�, �ֹ� ����, �� ������ ����ϴ� �ζ��� �� ����
--     �� �� ī�װ� �� ������ �����ϱ� ���� case�� ����Ͽ� ���� �� ���� ���
--   9-2) (1)�� �ζ��� ���� �̿��Ͽ� ���ǿ� �´� �� �� ������ ���� ���� ������ ���

SELECT s.�̸�, s.���̵�, s.��ȭ,  to_char(sum(s.total),'$999,999') "���� �� ����",  to_char(round(sum(s.���ΰ���),0),'$999,999') "���� �� ����"
FROM(
    -- �ζ��� ��
  SELECT c.NAME �̸�, c.ID ���̵�, c.tel ��ȭ, p.c_code, o2.price, o2.order_qty, sum(o2.order_subtotal) total,
    CASE 
      WHEN p.c_code = 'TO' THEN o2.price * 0.9 * o2.order_qty
      WHEN p.c_code = 'BO' THEN o2.price * 0.8 * o2.order_qty
      WHEN p.c_code = 'HA' THEN o2.price * 0.7 * o2.order_qty
      ELSE o2.order_subtotal
    END AS ���ΰ���
  FROM customer c, product p, orderlist o1, order_detail o2
  WHERE c.ID = o1.ID AND o1.order_no = o2.order_no AND o2.p_name = p.p_name
  GROUP BY c.NAME, p.c_code , c.ID, c.tel, o2.price, o2.order_qty,o2.order_subtotal 
  ORDER BY 1
  ) s
GROUP BY s.�̸�, s.���̵�, s.��ȭ
HAVING sum(s.total)>=5000
ORDER BY 1;





--10. �ֹ� ���̺� �ڷᰡ �ʹ� �׿� 2020�� 2�� ������ ��ϵ� �����ʹ� �� ������� �Ѵ�. ������ ��ٱ��� ����� ȸ����� �������� ���� ����Ͽ���.(���, ������ �ֹ� �Ǽ�, �ֹ� �Ѿ�)

-- 10-1) orderlist�� customer ���̺��� �����Ͽ� 2020�� 2�� ������ �ֹ��� ������ grade�� �׷���
-- 10-2) �ֹ��հ�(order_total)�� ī��Ʈ�Ͽ� ������ �ֹ��� �� ���
-- 10-3) �ֹ��հ�(order_total)�� ���Ͽ� ������ �������� �ֹ� �Ѿ� ���
SELECT nvl(c.grade, '���հ�') "���", count(o.order_total) "������ �ֹ� �Ǽ�", to_char(sum(o.order_total),'$999,999') "�ֹ� �Ѿ�"
FROM orderlist o, customer c
WHERE order_date < '20/02/01' AND c.ID=o.ID
GROUP BY CUBE(grade)
ORDER BY grade;




--11. 2019��/2020���� ��������� �����Ḧ ����Ͻÿ�
-- (���� ����� �������� -> �������Ա�=2%, ī��=3%, ���ڰ���=5%, ������ü=1%, ��ǰ��=10%)

-- 11-1) ���� ����� ���űݾ� ��� �����Ḧ ���ϴ� �Լ� ����
/
CREATE OR REPLACE FUNCTION howtopay(vpayment orderlist.payment%TYPE, vorder_no orderlist.order_no%TYPE)
RETURN NUMBER
IS
  vtotal NUMBER(10);
BEGIN
  SELECT
    CASE vpayment
    WHEN '�������Ա�' THEN order_total*0.02
    WHEN 'ī��' THEN order_total*0.03
    WHEN '���ڰ���' THEN order_total*0.05
    WHEN '������ü' THEN order_total*0.01
    WHEN '��ǰ��' THEN order_total*0.1
    ELSE 0
  END
  INTO vtotal
  FROM orderlist o
  WHERE o.order_no = vorder_no;
  RETURN vtotal; 
END;
/

-- 11-2) order_date �����Ϳ��� ������ �����Ͽ� �÷����� ����ϰ� ����������� �׷����Ͽ� �ο� ���
SELECT nvl(o.payment,'���հ�') "�������",
to_char(sum(decode(to_char(o.order_date,'yyyy'),'2019',howtopay(o.payment,o.order_no))),'$999,999,999') "19�⵵ ������",
to_char(sum(decode(to_char(o.order_date,'yyyy'),'2020',howtopay(o.payment,o.order_no))),'$999,999,999') "20�⵵ ������"
FROM product p, brand b, orderlist o, order_detail od 
WHERE p.b_code = b.b_code AND o.order_no = od.order_no AND od.p_name = p.p_name
GROUP BY cube(o.payment);




--12. �귣�庰�� ���ͷ� �÷��� �߰��ϰ� ������ �귣�庰 ���� ����Ͻÿ� (�귣�庰 ���ͷ��� �Ǹűݾ� ��� �Ʒ� �ۼ�Ʈ�� ���� 
--�������������� = 50%, ���� = 50%, Ŀ���Ҹ�ο�= 65%, ���̺���= 30%, ���= 20%, �߷��þư�= 40%, ��Ŭ�����ؾ���= 10%, �����= 10%, ������= 35%, �ް���= 85%, ������Ϸ���= 25%, ������= 50%, �ڽ�= 45%, �Ի��ζ�= 25%, �Ұ���= 50%, ���װ�����Ÿ= 40%, �����= 30%, �ѷ���= 25%, ���ͷκ꽺Ű= 25%, �����޽�= 10%)

-- 12-1) brand ���̺� ����(benefit) �÷� �߰�
ALTER TABLE brand ADD(benefit NUMBER(10,3)
GENERATED ALWAYS AS(
  CASE b_name WHEN '��������������' THEN 0.5
  WHEN '����' THEN 0.5
  WHEN 'Ŀ���Ҹ�ο�' THEN 0.65
  WHEN '���̺���' THEN 0.3
  WHEN '���' THEN 0.2
  WHEN '�߷��þư�' THEN 0.4
  WHEN '��Ŭ�����ؾ���' THEN 0.1
  WHEN '�����' THEN 0.1
  WHEN '������' THEN 0.35
  WHEN '�ް���' THEN 0.85
  WHEN '������Ϸ���' THEN 0.25
  WHEN '������' THEN 0.5
  WHEN '�ڽ�' THEN 0.45
  WHEN '�Ի��ζ�' THEN 0.25
  WHEN '�Ұ���' THEN 0.5
  WHEN '���װ�����Ÿ' THEN 0.4
  WHEN '�����' THEN 0.3
  WHEN '�ѷ���' THEN 0.25
  WHEN '���ͷκ꽺Ű' THEN 0.25
  WHEN '�����޽�' THEN 0.1 END
));

-- 12-2) ��ǰ �ݾ׿� ���ͷ�(benefit)�� ���� �� �귣�庰�� �׷����Ͽ� �ο� ���
SELECT b.b_name, 
to_char(round(sum(decode(to_char(o.order_date,'YY'),'19',(p.price*b.benefit)))),'$999,999') "19�⵵ ����",
to_char(round(nvl(sum(decode(to_char(o.order_date,'YY'),'20',(p.price*b.benefit))),0)),'$999,999') "20�⵵ ����"
FROM product p, brand b, orderlist o, order_detail od 
WHERE p.b_code = b.b_code AND o.order_no = od.order_no AND od.p_name = p.p_name
GROUP BY b.b_name;




--13. ���ڰ�����ü �����ڰ� �׵��� ���ڰ����� ������ �ݾ��� 50%�� ����Ʈ�� �����ϴ� �̺�Ʈ�� ������. �̹� �̺�Ʈ�� ����Ʈ �������� ���� ��޺��� �� ���� ����Ʈ�� ����϶�
--   (ID, �̸�, ����Ʈ, ��޺���(��������� -> �����ĵ��))

-- 13-1) Ŀ���� customer�� orderlist�� �����ؼ� �־���� ����� grade�� ���� ���� v_upgrade ����
-- 13-2) Ŀ�� ������ ����Ͽ� 50%�� �߰��� ����Ʈ�� ������ǿ� ���� v_upgrade�� ���� ����
-- 13-3) ������ ��ް� ���������� ����� ���� ���� ��޺�ȭ�� �Ͼ�� �ʾҹǷ� ����� ���� �������� ���
set serveroutput on;
/
DECLARE
  v_upgrade customer.grade%TYPE; 
  
  CURSOR c IS
    SELECT c.ID AS id, c.name AS name, c.grade AS grade, c.point AS point, o.order_total AS total, o.payment
    FROM customer c, orderlist o
    WHERE c.ID = o.ID
    AND o.payment = '���ڰ���';
BEGIN
  DBMS_OUTPUT.put_line(' ID      �̸�    ����Ʈ        ��޺���');
  FOR rec IN c loop
    rec.point := rec.point + rec.total * 0.5;
    
    CASE 
    WHEN rec.point BETWEEN 0 AND 100 THEN v_upgrade := '�����';
    WHEN rec.point BETWEEN 101 AND 500 THEN v_upgrade := '�ǹ�';
    WHEN rec.point BETWEEN 501 AND 2000 THEN v_upgrade := '���';
    WHEN rec.point BETWEEN 2001 AND 5000 THEN v_upgrade := '�÷�Ƽ��';
    WHEN rec.point >= 5001 THEN v_upgrade := 'VIP';
    END CASE;
    
    if (rec.grade != v_upgrade) then
    DBMS_OUTPUT.put_line(rec.ID || '  ' || rec.NAME || '    ' || rec.point || '     ' || rec.grade || ' -> ' || v_upgrade);
    end if;
  end loop;
END;
/





-- 14. PL/SQL ��ǰ���̺�(Product)�� ����(price)�� ��� ���� ���� ���� ��ǰ���� �귣����� �Է¹޾� ��ǰ��, ��ǰ�ڵ�, ��ǰ�� ������ ����ϴµ�
--  ���� ���� ���� �ȸ� ��ǰ�� <Best> ��ǰ�̶�� ǥ���϶�.

-- 14-1) Ŀ���� �̿��Ͽ� Ŀ���ӿ��� �����͸� �����ö� �귣����� �Է¹޾� �ش��ϴ� �귣���ǰ���� ����Ѵ�.
-- 14-2) <BEST>��ǰ�� ��� rank() over�Լ��� �̿��� ������ �������, ���ڵ带 �̿��� ������ 1�̸� ����� �ǵ��� �Ѵ�.
declare
cursor v1 is( 
select b.b_name as bname, p.p_name as pname, p.c_code as code, p.price as price, sum(o.ORDER_QTY) as qty,
rank() over(order by sum(order_qty) desc) as ����,
decode(rank() over(order by sum(order_qty) desc),1,' ��<Best> �α��ǰ!!!') as ����Ʈ
from product p, brand b, order_detail o
where p.b_CODE = b.B_CODE
and o.P_NAME = p.P_NAME
and b.b_name = '&�귣���'
group by b.b_name, p.p_name, p.c_code, p.price, o.order_qty
);
begin
 dbms_output.put_line('�귣���/  ��ǰ��/       ��ǰ�ڵ�/ ����/ �ǸŰ���');
for emp_rec in v1 
 loop
 dbms_output.put_line(emp_rec.bname||' '||emp_rec.pname||' '||emp_rec.code||' '||emp_rec.price||' '||emp_rec.qty||
 ' '||emp_rec.����Ʈ);
 end loop;
end;
/




--15. ���̵� �Է¹޾� (�ֹ���ȣ / ��ǰ�� / �ֹ���¥ / �ֹ��ݾ�) �ֹ������ ����ϴ� ���ν�����
--    15-1) ���̵�� �ֹ���ȣ�� �Է¹޾� (�ֹ���ȣ / ��ǰ�� / �ݾ�($) / ����)�ֹ���ȣ�� �ش��ϴ� �� �ֹ������� ����ϴ� ���ν����� �������ִ� ��Ű���� �ۼ��϶�.
--    15-2) ù��° search_id ���ν����� ���̵� �ϳ��� �Է¹޾� Ŀ���ӿ��� �����͸� �����ؼ� ����ϴ� �����̴�.
--    15-3) �ι�° search_od ���ν����� ������ ������ �������� �ֹ���ȣ�� ���̵� �Է¹޾� �̶��� Ŀ���� Ȱ���� �����͸� �����ϴ� �����̴�.
create or replace package goguma
as
procedure search_id
(in_id in orderlist.ID%type);
procedure search_od
(in_id in orderlist.ID%type,
 in_no in orderlist.order_no%type);
end goguma;
/
create or replace package body goguma as
--1�� �Լ�
procedure search_id
(in_id in orderlist.ID%type)
is
cursor iu is(
select order_no as a, id as b, ORDER_DATE as c, ORDER_TOTAL as d
from orderlist
where id = in_id
);
begin
 dbms_output.put_line('�ֹ���ȣ / ��ǰ�� / �ֹ���¥ / �ֹ��ݾ� ');
for emp_rec in iu 
 loop
 dbms_output.put_line(emp_rec.a||' '||emp_rec.b||' '||emp_rec.c||' '||emp_rec.d);
 end loop;
end search_id;
--2�� ���ν���
procedure search_od
(in_id in orderlist.ID%type,
 in_no in orderlist.order_no%type)
is
cursor iu is(
select o.ORDER_NO as a,o2.p_name as b, o2.PRICE*o2.ORDER_QTY as c, o2.ORDER_QTY as d
from orderlist o, order_detail o2
where o.ORDER_NO = o2.ORDER_NO
and o.id = in_id
and o.order_no = in_no
);
begin
 dbms_output.put_line('�ֹ���ȣ / ��ǰ�� / �ݾ�($) / ����');
for boo in iu 
 loop
 dbms_output.put_line(boo.a||' '||boo.b||' '||'($)'||boo.c||' '||boo.d);
 end loop;
end search_od;
end goguma;
/

exec goguma.search_id('sist02');
exec goguma.search_od('sist02','OD0019');



