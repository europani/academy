set serveroutput on;
-- 테이블 확인
select * from customer;
select * from product;
select * from orderlist;
select * from order_detail;
select * from inven;
select * from brand;
select * from grade;
select * from category;
select * from delivery;
select * from area_code;


---------------------------------------------------------------------------------------


--1. 2019년에 주문한 내역들의 주문 횟수를 택배사 별로 출력하라. (택배사명, 주문횟수)

SELECT d_name "택배사", COUNT(d_name) "주문횟수"
FROM orderlist
WHERE to_char(order_date, 'YY') = '19'
GROUP BY d_name;




--2. 연령별(10년단위로 묵어서)로 주문금액이 제일 많은 연령에게 할인 쿠폰을 발행하려 한다.
--연령별 주문토탈금액을 출력하라. (연령, 주문토탈금액, 순위)

SELECT trunc(to_char(c.birthday,'YYYY'),-1) 연령별, to_char(SUM(o.order_total),'999,999') "이용금액($)"
,RANK() OVER (ORDER BY SUM(o.order_total) DESC) "이용순위"
FROM customer c, orderlist o
WHERE c.ID = o.ID
GROUP BY trunc(to_char(c.birthday,'YYYY'),-1)
ORDER BY 1;




--3. A,B,C 창고의 연도별 입고량 및 입고금액

SELECT substr(in_loc,1,1) 창고,
sum(decode(to_char(in_date,'YY'),'19',in_qty))||'개' "19년도 입고량",
'$'||sum(decode(to_char(in_date,'YY'),'19',in_price*in_qty)) "19년도 입고금액",
sum(decode(to_char(in_date,'YY'),'20',in_qty))||'개' "20년도 입고량",
'$'||sum(decode(to_char(in_date,'YY'),'20',in_price*in_qty)) "20년도 입고금액"
FROM inven GROUP BY substr(in_loc,1,1);




--4. 시즌별로 각 품목의 판매량을 정리하여 출력하라. (3,4,5월 : 봄 / 6,7,8월 : 여름 / 9,10,11월 : 가을 /  12,1,2월 : 겨울)

select (select c_name from category where c_code = p.c_code) "품목",
nvl(sum(decode(to_char(o.order_date,'MM'),'03',od.order_qty,'04',od.order_qty,'05',od.order_qty)),0) "봄 시즌",
nvl(sum(decode(to_char(o.order_date,'MM'),'06',od.order_qty,'07',od.order_qty,'08',od.order_qty)),0) "여름 시즌",
nvl(sum(decode(to_char(o.order_date,'MM'),'09',od.order_qty,'10',od.order_qty,'11',od.order_qty)),0) "가을 시즌",
nvl(sum(decode(to_char(o.order_date,'MM'),'12',od.order_qty,'01',od.order_qty,'02',od.order_qty)),0) "겨울 시즌"
FROM orderlist o, order_detail od, product p WHERE o.order_no = od.order_no AND od.p_name = p.p_name GROUP BY p.c_code;




--5. 이번달(7월) 생일인 회원에게 등급에 따라 생일쿠폰을 나눠주려고 한다. 생일인 회원의 ID, 이름, 생일, 등급 및 쿠폰지급갯수를 출력하라(브론즈:1, 실버:2, …, VIP:5장)

SELECT c.ID, c.name, c.birthday, g.grade, 
 decode(g.grade, 'VIP', 5, '플래티넘', 4, '골드', 3, '실버', 2, 1) AS 지급쿠폰수
FROM customer c, grade g
WHERE to_char(birthday, 'mm') = to_char(SYSDATE, 'mm')
AND c.grade = g.grade;
 



--6. 고객에게 쇼핑몰 내 제품을 추천하기 위해 고객들의 성별과 연령대를 입력 받아 판매 순위 상위 3개의 제품을 출력하라.  (입력 : 성별(M/F), 나이)

SELECT rnum.* FROM(
SELECT r.sex 성별, r.age 연령대, r.NAME 제품명, r.sum_qty 판매량, DENSE_RANK() OVER(ORDER BY r.sum_qty DESC) 순위 FROM
(SELECT c.sex sex, o2.p_name NAME, trunc((SYSDATE - birthday)/365,-1) age, sum(o2.order_qty) sum_qty
FROM customer c, orderlist o1, order_detail o2
WHERE c.ID = o1.ID AND o1.order_no = o2.order_no
GROUP BY c.sex, trunc((SYSDATE - birthday)/365,-1), o2.p_name
ORDER BY 2) r
WHERE r.sex =upper( '&sex') AND age =trunc(( '&age'),-1)) rnum
WHERE ROWNUM <= 3;




--7. 등급별 할인이 적용된 주문금액과 택배비를 포함한 orderlist를 출력하라. (단, VIP고객에 한해 택배비 무료 이벤트로 택배비면제, 제주도는 +$3 )

SELECT o.order_no, o.ID, o.order_date, c.grade,
  to_char(round(o.order_total*(1-g.discount), 0), '$9,999') AS "배송비제외(할인적용)", 
  to_char(round(o.order_total*(1-g.discount), 0) + decode(substr(c.address, 1, 2), '제주', 3, 0) + decode(c.grade, 'VIP', 0, d.d_fee), '$9,999') AS 배송비포함
FROM orderlist o, delivery d, customer c, grade g
WHERE o.d_name = d.d_name
AND c.ID = o.ID
AND g.grade = c.grade
ORDER BY 1;




--8. 유명 국제 택배사 ‘빠덱스’가 부산에 새로 진출하여, 건당 2달러라는 저렴한 가격에 업체들과 배송계약을 체결해주고 있다.  
-- 기존 경상도 지역택배사와 계약을 해지하고 새롭게 계약을 체결할 시의 이익을 계산하고자 한다.
-- 지금까지의 쇼핑몰 운영기간을 바탕으로 배송 비용을 구한 뒤 향후 10년의 예상 배송비용을 구하여, 서로 결과값을 비교하는 컬럼을 작성하자. 
-- (결과값은 소수점 허용하지 말 것)

select o.d_name "택배사", '$'||round(sum(d.d_fee)*(3650/(max(o.order_date)-min(o.order_date)))) "예상 배송비용"
from orderlist o, delivery d where d.d_name = o.d_name and d.d_area = 5 group by o.d_name union all
select '빠덱스' "택배사", 
'$'||round(sum(2)*(3650/(max(o.order_date)-min(o.order_date)))) "예상 배송비용"
from orderlist o, delivery d where d.d_name = o.d_name and d.d_area = 5 group by o.d_name 
union all
select '예상이익금' "택배사", 
'$'||round((sum(d.d_fee)*(3650/(max(o.order_date)-min(o.order_date))))-(sum(2)*(3650/(max(o.order_date)-min(o.order_date))))) "예상 배송비용"
from orderlist o, delivery d where d.d_name = o.d_name and d.d_area = 5 group by o.d_name; 





--9. 이벤트를 맞아 특정 금액(5000) 이상 구매시 카테고리 별 할인에 들어간다.  할인을 적용받을 수 있는 회원의 이름과, 아이디, 전화번호, 할인 전 금액과 할인 후 금액을 출력하라
--(할인 카테고리 : 상의 10%, 하의 20%, 모자 30%) 
SELECT s.이름, s.아이디, s.전화,  to_char(sum(s.total),'$'||'999,999') "할인 전 가격",  to_char(round(sum(s.할인가격),0),'$'||'999,999') "할인 후 가격" FROM(
SELECT c.NAME 이름, c.ID 아이디, c.tel 전화, p.c_code, o2.price, o2.order_qty, sum(o2.order_subtotal) total,
  CASE 
    WHEN p.c_code = 'TO' THEN o2.price * 0.9 * o2.order_qty
    WHEN p.c_code = 'BO' THEN o2.price * 0.8 * o2.order_qty
    WHEN p.c_code = 'HA' THEN o2.price * 0.7 * o2.order_qty
    ELSE o2.order_subtotal
  END AS 할인가격
FROM customer c, product p, orderlist o1, order_detail o2
WHERE c.ID = o1.ID AND o1.order_no = o2.order_no AND o2.p_name = p.p_name
GROUP BY c.NAME, p.c_code , c.ID, c.tel, o2.price, o2.order_qty,o2.order_subtotal 
ORDER BY 1
) s
GROUP BY s.이름, s.아이디, s.전화
HAVING sum(s.total)>=5000
ORDER BY 1;





--10. 주문 테이블에 자료가 너무 쌓여 2020년 2월 이전에 등록된 데이터는 다 지우려고 한다. 지워진 장바구니 목록을 회원등급 기준으로 묶어 출력하여라.(등급, 삭제된 주문 건수, 주문 총액)

SELECT nvl(c.grade, '총합계') "등급", count(o.order_total) "삭제된 주문 건수", to_char(sum(o.order_total),'$999,999') "주문 총액(달러)"
FROM orderlist o, customer c
WHERE order_date < '20/02/01' AND c.ID=o.ID
GROUP BY CUBE(grade)
ORDER BY grade;




--11. 2019년/2020년의 결제방법별 수수료를 출력하시오
-- (결제 방법별 수수료율 -> 무통장입금=2%, 카드=3%, 전자결제=5%, 계좌이체=1%, 상품권=10%)
/
CREATE OR REPLACE FUNCTION howtopay(vpayment orderlist.payment%TYPE, vorder_no orderlist.order_no%TYPE)
RETURN NUMBER
IS
  vtotal NUMBER(10);
BEGIN
  SELECT
    CASE vpayment
    WHEN '무통장입금' THEN order_total*0.02
    WHEN '카드' THEN order_total*0.03
    WHEN '전자결제' THEN order_total*0.05
    WHEN '계좌이체' THEN order_total*0.01
    WHEN '상품권' THEN order_total*0.1
    ELSE 0
  END
  INTO vtotal
  FROM orderlist o
  WHERE o.order_no = vorder_no;
  RETURN vtotal; 
END;
/

SELECT nvl(o.payment,'총합계') "결제방법",
to_char(sum(decode(to_char(o.order_date,'yyyy'),'2019',howtopay(o.payment,o.order_no))),'$999,999,999') "19년도 수수료",
to_char(sum(decode(to_char(o.order_date,'yyyy'),'2020',howtopay(o.payment,o.order_no))),'$999,999,999') "20년도 수수료"
FROM product p, brand b, orderlist o, order_detail od 
WHERE p.b_code = b.b_code AND o.order_no = od.order_no AND od.p_name = p.p_name
GROUP BY cube(o.payment);




--12. 브랜드별로 이익률 컬럼을 추가하고 연도별 브랜드별 순익 출력하시오 (브랜드별 이익률은 판매금액 대비 아래 퍼센트와 같다 
--메종마르지엘라 = 50%, 구찌 = 50%, 커스텀멜로우= 65%, 루이비통= 30%, 디올= 20%, 발렌시아가= 40%, 반클리프앤아펠= 10%, 프라다= 10%, 셀린느= 35%, 휴고보스= 85%, 스톤아일랜드= 25%, 버버리= 50%, 닥스= 45%, 입생로랑= 25%, 불가리= 50%, 보테가베네타= 40%, 몽블랑= 30%, 롤렉스= 25%, 스와로브스키= 25%, 에르메스= 10%)

ALTER TABLE brand ADD(benefit NUMBER(10,3)
GENERATED ALWAYS AS(
  CASE b_name WHEN '메종마르지엘라' THEN 0.5
  WHEN '구찌' THEN 0.5
  WHEN '커스텀멜로우' THEN 0.65
  WHEN '루이비통' THEN 0.3
  WHEN '디올' THEN 0.2
  WHEN '발렌시아가' THEN 0.4
  WHEN '반클리프앤아펠' THEN 0.1
  WHEN '프라다' THEN 0.1
  WHEN '셀린느' THEN 0.35
  WHEN '휴고보스' THEN 0.85
  WHEN '스톤아일랜드' THEN 0.25
  WHEN '버버리' THEN 0.5
  WHEN '닥스' THEN 0.45
  WHEN '입생로랑' THEN 0.25
  WHEN '불가리' THEN 0.5
  WHEN '보테가베네타' THEN 0.4
  WHEN '몽블랑' THEN 0.3
  WHEN '롤렉스' THEN 0.25
  WHEN '스와로브스키' THEN 0.25
  WHEN '에르메스' THEN 0.1 END
));

SELECT b.b_name, 
to_char(round(sum(decode(to_char(o.order_date,'YY'),'19',(p.price*b.benefit)))),'$999,999') "19년도 순익",
to_char(round(nvl(sum(decode(to_char(o.order_date,'YY'),'20',(p.price*b.benefit))),0)),'$999,999') "20년도 순익"
FROM product p, brand b, orderlist o, order_detail od 
WHERE p.b_code = b.b_code AND o.order_no = od.order_no AND od.p_name = p.p_name
GROUP BY b.b_name;




--13. 빠이코 업체의 이벤트로 그동안 전자결제로 결제한 금액의 50%를 포인트로 지급,
-- 이번 이벤트의 포인트 변동에 의한 등급변경 된 고객의 리스트를 변경전 등급, 변경 후 등급까지 PL/SQL 사용하여 출력 -> ID, 이름, 포인트, 변경전등급, 변경후등급

/
DECLARE
  v_upgrade customer.grade%TYPE; 
  
  CURSOR c IS
    SELECT c.ID AS id, c.name AS name, c.grade AS grade, c.point AS point, o.order_total AS total, o.payment
    FROM customer c, orderlist o
    WHERE c.ID = o.ID
    AND o.payment = '전자결제';
BEGIN
  DBMS_OUTPUT.put_line(' ID      이름     포인트        등급변경');
  FOR rec IN c loop
    rec.point := rec.point + rec.total * 0.5;
    
    CASE 
    WHEN rec.point BETWEEN 0 AND 100 THEN v_upgrade := '브론즈';
    WHEN rec.point BETWEEN 101 AND 500 THEN v_upgrade := '실버';
    WHEN rec.point BETWEEN 501 AND 2000 THEN v_upgrade := '골드';
    WHEN rec.point BETWEEN 2001 AND 5000 THEN v_upgrade := '플래티넘';
    WHEN rec.point >= 5001 THEN v_upgrade := 'VIP';
    END CASE;
    
    IF (rec.grade != v_upgrade) THEN
    DBMS_OUTPUT.put_line(rec.ID || '  ' || rec.NAME || '    ' || rec.point || '     ' || rec.grade || ' -> ' || v_upgrade);
    END IF;
  END loop;
END;
/




-- 14. PL/SQL 상품테이블(Product)의 가격(price)이 평균 가격 보다 높은 상품들을 브랜드명을 입력받아 상품명, 상품코드, 상품의 가격을 출력하는데
--  그중 가장 많이 팔린 상품은 <Best> 상품이라고 표시하라.
DECLARE
  CURSOR v1 IS(
    SELECT b.b_name AS bname, p.p_name AS pname, p.c_code AS code, p.price AS price, sum(o.order_qty) AS qty,
    rank() OVER(ORDER BY sum(order_qty) DESC) AS 순위,
    decode(rank() OVER(ORDER BY sum(order_qty) DESC),1,' ★<Best> 인기상품!!!') AS 베스트
    FROM product p, brand b, order_detail o
    WHERE p.b_code = b.b_code
    AND o.p_name = p.p_name
    AND b.b_name = '&브랜드명'
    GROUP BY b.b_name, p.p_name, p.c_code, p.price, o.order_qty
    );
BEGIN
  dbms_output.put_line('브랜드명/  상품명/       상품코드/ 가격/ 판매갯수');
  FOR emp_rec IN v1 
  loop
   dbms_output.put_line(emp_rec.bname||' '||emp_rec.pname||' '||emp_rec.code||' '||emp_rec.price||' '||emp_rec.qty||
   ' '||emp_rec.베스트);
   END loop;
END;
/




--15. 아이디를 입력받아 (주문번호 / 상품명 / 주문날짜 / 주문금액) 주문목록을 출력하는 프로시저와
--    아이디와 주문번호를 입력받아 (주문번호 / 상품명 / 금액($) / 갯수) 주문내역을 출력하는 프로시저를 가지고있는 패키지를 작성하라.

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
--1번 함수
procedure search_id
(in_id in orderlist.ID%type)
is
cursor iu is(
select order_no as a, id as b, ORDER_DATE as c, ORDER_TOTAL as d
from orderlist
where id = in_id
);
begin
 dbms_output.put_line('주문번호 / 상품명 / 주문날짜 / 주문금액 ');
for emp_rec in iu 
 loop
 dbms_output.put_line(emp_rec.a||' '||emp_rec.b||' '||emp_rec.c||' '||emp_rec.d);
 end loop;
end search_id;
--2번 프로시저
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
 dbms_output.put_line('주문번호 / 상품명 / 금액($) / 갯수');
for boo in iu 
 loop
 dbms_output.put_line(boo.a||' '||boo.b||' '||'($)'||boo.c||' '||boo.d);
 end loop;
end search_od;
end goguma;
/

exec goguma.search_id('sist02');
exec goguma.search_od('sist02','OD0019');