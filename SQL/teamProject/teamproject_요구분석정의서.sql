--1. 2019년에 주문한내역들의 주문 횟수를 택배사 별로 출력하라. (택배사명, 주문횟수)

SELECT d_name "택배사", COUNT(d_name) "주문횟수"
FROM orderlist
WHERE to_char(order_date, 'YY') = '19'
GROUP BY d_name;




--2. 연령별(10년단위로 묵어서)로 주문금액이 제일 많은 연령에게 할인 쿠폰을 발행하려 한다.
--연령별 주문토탈금액을 출력하라. (연령, 주문토탈금액, 순위)

-- 2-1) trunc(to_char())를 이용해서 10년단위로 연령별을 묶은후 sum()함수로 주문총금액을 구한후
-- 2-2) rank() over() 함수로 연령별 총금액으로 이용순위를 구한다. 
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

--'판매량'이 있는 orderlist테이블, '수량'이 있는 order_detail 테이블, 품목이 있는 product테이블을 서로 엮어 출력해야 한다.
-- 4-1) 먼저 각 제품의 월별 판매량을 확인해보자.
select od.p_name "품목",
sum(decode(to_char(o.order_date,'MM'),'01',od.order_qty)) "1월",
sum(decode(to_char(o.order_date,'MM'),'02',od.order_qty)) "2월",
sum(decode(to_char(o.order_date,'MM'),'03',od.order_qty)) "3월",
sum(decode(to_char(o.order_date,'MM'),'04',od.order_qty)) "4월",
sum(decode(to_char(o.order_date,'MM'),'05',od.order_qty)) "5월",
sum(decode(to_char(o.order_date,'MM'),'06',od.order_qty)) "6월",
sum(decode(to_char(o.order_date,'MM'),'07',od.order_qty)) "7월",
sum(decode(to_char(o.order_date,'MM'),'08',od.order_qty)) "8월",
sum(decode(to_char(o.order_date,'MM'),'09',od.order_qty)) "9월",
sum(decode(to_char(o.order_date,'MM'),'10',od.order_qty)) "10월",
sum(decode(to_char(o.order_date,'MM'),'11',od.order_qty)) "11월",
sum(decode(to_char(o.order_date,'MM'),'12',od.order_qty)) "12월" 
from orderlist o, order_detail od where o.order_no = od.order_no group by od.p_name;

-- 4-2) 위의 output을 품목별로 엮어야한다. p_name으로 엮을 수 있는 product테이블을 활용하자.
select p.c_code "품목",
sum(decode(to_char(o.order_date,'MM'),'01',od.order_qty)) "1월",
sum(decode(to_char(o.order_date,'MM'),'02',od.order_qty)) "2월",
sum(decode(to_char(o.order_date,'MM'),'03',od.order_qty)) "3월",
sum(decode(to_char(o.order_date,'MM'),'04',od.order_qty)) "4월",
sum(decode(to_char(o.order_date,'MM'),'05',od.order_qty)) "5월",
sum(decode(to_char(o.order_date,'MM'),'06',od.order_qty)) "6월",
sum(decode(to_char(o.order_date,'MM'),'07',od.order_qty)) "7월",
sum(decode(to_char(o.order_date,'MM'),'08',od.order_qty)) "8월",
sum(decode(to_char(o.order_date,'MM'),'09',od.order_qty)) "9월",
sum(decode(to_char(o.order_date,'MM'),'10',od.order_qty)) "10월",
sum(decode(to_char(o.order_date,'MM'),'11',od.order_qty)) "11월",
sum(decode(to_char(o.order_date,'MM'),'12',od.order_qty)) "12월" 
from orderlist o, order_detail od, product p where o.order_no = od.order_no and od.p_name = p.p_name group by p.c_code;

-- 4-3) 위에서 요구한대로 월별 output을 시즌으로 묶고, nvl처리까지 깔끔하게 정리.
select p.c_code "품목",
nvl(sum(decode(to_char(o.order_date,'MM'),'03',od.order_qty,'04',od.order_qty,'05',od.order_qty)),0) "봄 시즌",
nvl(sum(decode(to_char(o.order_date,'MM'),'06',od.order_qty,'07',od.order_qty,'08',od.order_qty)),0) "여름 시즌",
nvl(sum(decode(to_char(o.order_date,'MM'),'09',od.order_qty,'10',od.order_qty,'11',od.order_qty)),0) "가을 시즌",
nvl(sum(decode(to_char(o.order_date,'MM'),'12',od.order_qty,'01',od.order_qty,'02',od.order_qty)),0) "겨울 시즌"
from orderlist o, order_detail od, product p where o.order_no = od.order_no and od.p_name = p.p_name group by p.c_code;

--** 만약 c_code를 한글로 변경하고 싶다면? category테이블을 서브쿼리로 활용하면 된다.
select (select c_name from category where c_code = p.c_code) "품목",
nvl(sum(decode(to_char(o.order_date,'MM'),'03',od.order_qty,'04',od.order_qty,'05',od.order_qty)),0) "봄 시즌",
nvl(sum(decode(to_char(o.order_date,'MM'),'06',od.order_qty,'07',od.order_qty,'08',od.order_qty)),0) "여름 시즌",
nvl(sum(decode(to_char(o.order_date,'MM'),'09',od.order_qty,'10',od.order_qty,'11',od.order_qty)),0) "가을 시즌",
nvl(sum(decode(to_char(o.order_date,'MM'),'12',od.order_qty,'01',od.order_qty,'02',od.order_qty)),0) "겨울 시즌"
from orderlist o, order_detail od, product p where o.order_no = od.order_no and od.p_name = p.p_name group by p.c_code;




--5. 이번달(7월) 생일인 회원에게 등급에 따라 생일쿠폰을 나눠주려고 한다. 생일인 회원의 ID, 이름, 생일, 등급 및 쿠폰지급갯수를 출력하라(브론즈:1, 실버:2, …, VIP:5장)

-- 5-1) customer와 grade를 조인 한 후 birthday가 7월인 customer만 뽑아 쿠폰지급갯수를 grade에 따라 지급
SELECT c.ID, c.NAME, c.birthday, g.grade, 
  decode(g.grade, 'VIP', 5, '플래티넘', 4, '골드', 3, '실버', 2, 1) AS 지급쿠폰수
FROM customer c, grade g
WHERE to_char(birthday, 'mm') = to_char(SYSDATE, 'mm')
AND c.grade = g.grade;




--6. 고객에게 쇼핑몰 내 제품을 추천하기 위해 고객들의 성별과 연령대를 입력 받아  판매 순위 상위 3개의 제품을 출력하라.  (입력 : 성별(M/F), 나이)

--   6-1) customer, orderlist, order_detail 테이블을 조인하여 고객의 성별,이름, 나이와 고객 별 주문 수량의 합계를 구하여 인라인뷰를 생성한다
--   6-2) 생성한 인라인 뷰의 성별, 연령대, 제품명, 판매량과 rank() over 를 사용한 판매 수량의 순위 출력
--   6-3) 판매량 상위 3개의 순위를 출력하기 위해 rownum을 사용하여 rank()의 rownum을 찾음
--   6-4) (3)에서 rownum을 찾으면 상위 순위부터 차례로 rownum을 가지므로 rownum <= 3 조건을 통해 상위 3개의 순위 출력
SELECT rnum.* FROM(
  SELECT r.sex 성별, r.age 연령대, r.NAME 제품명, r.sum_qty 판매량, DENSE_RANK() OVER(ORDER BY r.sum_qty DESC) 순위
  FROM 
    -- 인라인 뷰 생성
    (SELECT c.sex sex, o2.p_name NAME, trunc((SYSDATE - birthday)/365,-1) age, sum(o2.order_qty) sum_qty
      FROM customer c, orderlist o1, order_detail o2
      WHERE c.ID = o1.ID AND o1.order_no = o2.order_no
      GROUP BY c.sex, trunc((SYSDATE - birthday)/365,-1), o2.p_name
      ORDER BY 2) r
    WHERE r.sex =upper( '&sex') AND age =trunc(( '&age'),-1)) rnum
  WHERE ROWNUM <= 3;



--7. 등급별 할인이 적용된 주문금액과 택배비를 포함한 orderlist를 출력하라. (단, VIP고객에 한해 택배비면제, 제주도는 +$3 )

-- 7-1) 4개의 테이블을 조인한 후 멤버별 할인이 적용된 구매금액을 반올림해서 구한다.
-- 7-2) 배송비를 구할 때는 앞에서 구한 구매금액에서 VIP회원은 배송비 free, 제주도거주자는 +$3를 추가로 적용한다.(구매금액 + 제주도 추가배송비 + 지역별 배송비(VIP는 0))
SELECT o.order_no, o.ID, o.order_date, c.grade, 
  to_char(round(o.order_total*(1-g.discount), 0), '$99,999') AS "배송비제외(할인적용)", 
  to_char(round(o.order_total*(1-g.discount), 0) + decode(substr(c.address, 1, 2), '제주', 3, 0) + decode(c.grade, 'VIP', 0, d.d_fee), '$99,999') AS 배송비포함
FROM orderlist o, delivery d, customer c, grade g
WHERE o.d_name = d.d_name
AND c.ID = o.ID
AND g.grade = c.grade
ORDER BY 1;






--8. 유명 국제 택배사 ‘빠덱스’가 부산에 새로 진출하여, 건당 2달러라는 저렴한 가격에 업체들과 배송계약을 체결해주고 있다.  
-- 기존 경상도 지역택배사와 계약을 해지하고 새롭게 계약을 체결할 시의 이익을 계산하고자 한다.
-- 지금까지의 쇼핑몰 운영기간을 바탕으로 배송 비용을 구한 뒤 향후 10년의 예상 배송비용을 구하여, 서로 결과값을 비교하는 컬럼을 작성하자. 
-- (결과값은 소수점 허용하지 말 것)

-- 택배사,배송금액 등 정보가 있는 delivery테이블, 주문정보가 있는 orderlist테이블 활용해서 값을 도출해낼 수 있다.
-- 8-1) 먼저 경상도 지역의 택배사 정보를 확인해보자. 경상도 지역의 a_code가 5임을 확인할 수 있다.
select a.a_name, a.a_code, d.d_area from delivery d, AREA_CODE a where d.d_area = a.a_code;

-- 8-2) orderlist 테이블과 delivery 테이블을 조인하여, d_area가 5인 조건 하에서 각 주문별 택배사와 택배비를 확인해보자. 
--   (d_area는 a_code와 foreign key로 연결된상태. 즉,서로같은 코드)
select o.order_no, o.d_name, d.d_fee from orderlist o, delivery d 
where d.d_name = o.d_name and d.d_area = 5; --> 한진택배, 5달러 확인

-- 8-3) 위의 결과물을 count로 묶어서, 여태까지 한진택배 배송비용을 확인해보자.
select count(*) 택배량, o.d_name "택배사", sum(d.d_fee) 금액 from orderlist o, delivery d 
where d.d_name = o.d_name and d.d_area = 5 group by o.d_name;

-- 8-4) 위와같은 방법으로, 새 택배사(빠덱스) 이용시의 예상금액을 출력하자.
select count(*) 택배량, '빠덱스' "택배사", sum(2) 새금액 from orderlist o, delivery d 
where d.d_name = o.d_name and d.d_area = 5 group by o.d_name;

-- 8-5) 문제는, 쇼핑몰이 경상도 지역에서 이용된 기간을 구하는 것이다. 이를 바탕으로 '10년'과 비교해야 한다.
--    먼저 현재까지 경상도 지역에서 고객이 상품을 주문한 기간을 구하자.
select d.d_area "지역코드", max(o.order_date)-min(o.order_date) 운영일 -->> max orderdate에서 min orderdate를 뺀 날짜. 즉, 실질적인 쇼핑몰 운영기간.
from orderlist o, delivery d where d.d_area = 5 and d.d_name = o.d_name group by d.d_area; --> 494일 확인

-- 8-6) 현재까지의 운영기간(494일)을 기준으로 10년의 예상배송금액을 구하는 식은 '현재까지의 배송비 * (10년 / 현재운영기간)' 이다. 이를 대입하여 배송비를 구해보자.
select 3650/(max(o.order_date)-min(o.order_date)) from orderlist o, delivery d where d.d_name = o.d_name and d.d_area = 5 group by o.d_name; -- (3650일/494일) 확인
select o.d_name "택배사", '$'||round(sum(d.d_fee)*(3650/(max(o.order_date)-min(o.order_date)))) "예상 배송비용"
from orderlist o, delivery d where d.d_name = o.d_name and d.d_area = 5 group by o.d_name --> 현재택배사 향후10년 예상배송비용
union all
select '빠덱스' "택배사", '$'||round(sum(2)*(3650/(max(o.order_date)-min(o.order_date)))) "예상 배송비용"
from orderlist o, delivery d where d.d_name = o.d_name and d.d_area = 5 group by o.d_name --> 빠덱스 향후10년 예상배송비용
union all
select '예상이익금' "택배사", 
'$'||round((sum(d.d_fee)*(3650/(max(o.order_date)-min(o.order_date))))-(sum(2)*(3650/(max(o.order_date)-min(o.order_date))))) "예상 배송비용"
from orderlist o, delivery d where d.d_name = o.d_name and d.d_area = 5 group by o.d_name; --> 위 두개 결과비용을 서로 뺀 금액.





--9. 이벤트를 맞아 특정 금액(5000) 이상 구매시 카테고리 별 할인에 들어간다. 할인을 적용받을 수 있는 회원의 이름과, 아이디, 전화번호, 할인 전 금액과 할인 후 금액을 출력하라
--(할인 카테고리 : 상의 10%, 하의 20%, 모자 30%)

--   9-1) customer, product, orderlist, order_detail 테이블을 조인하여
--     고객의 이름, 아이디, 전화번호,  제품 코드, 주문 수량, 총 가격을 출력하는 인라인 뷰 생성
--     이 때 카테고리 별 할인을 적용하기 위해 case를 사용하여 할인 후 가격 계산
--   9-2) (1)의 인라인 뷰을 이용하여 조건에 맞는 고객 별 정보와 할인 전후 가격을 출력

SELECT s.이름, s.아이디, s.전화,  to_char(sum(s.total),'$999,999') "할인 전 가격",  to_char(round(sum(s.할인가격),0),'$999,999') "할인 후 가격"
FROM(
    -- 인라인 뷰
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

-- 10-1) orderlist와 customer 테이블을 조인하여 2020년 2월 이전에 주문한 유저의 grade를 그룹핑
-- 10-2) 주문합계(order_total)를 카운트하여 삭제된 주문건 수 출력
-- 10-3) 주문합계(order_total)를 합하여 삭제된 데이터의 주문 총액 출력
SELECT nvl(c.grade, '총합계') "등급", count(o.order_total) "삭제된 주문 건수", to_char(sum(o.order_total),'$999,999') "주문 총액"
FROM orderlist o, customer c
WHERE order_date < '20/02/01' AND c.ID=o.ID
GROUP BY CUBE(grade)
ORDER BY grade;




--11. 2019년/2020년의 결제방법별 수수료를 출력하시오
-- (결제 방법별 수수료율 -> 무통장입금=2%, 카드=3%, 전자결제=5%, 계좌이체=1%, 상품권=10%)

-- 11-1) 결제 방법별 구매금액 대비 수수료를 구하는 함수 구현
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

-- 11-2) order_date 데이터에서 연도를 추출하여 컬럼별로 출력하고 결제방법별로 그룹핑하여 로우 출력
SELECT nvl(o.payment,'총합계') "결제방법",
to_char(sum(decode(to_char(o.order_date,'yyyy'),'2019',howtopay(o.payment,o.order_no))),'$999,999,999') "19년도 수수료",
to_char(sum(decode(to_char(o.order_date,'yyyy'),'2020',howtopay(o.payment,o.order_no))),'$999,999,999') "20년도 수수료"
FROM product p, brand b, orderlist o, order_detail od 
WHERE p.b_code = b.b_code AND o.order_no = od.order_no AND od.p_name = p.p_name
GROUP BY cube(o.payment);




--12. 브랜드별로 이익률 컬럼을 추가하고 연도별 브랜드별 순익 출력하시오 (브랜드별 이익률은 판매금액 대비 아래 퍼센트와 같다 
--메종마르지엘라 = 50%, 구찌 = 50%, 커스텀멜로우= 65%, 루이비통= 30%, 디올= 20%, 발렌시아가= 40%, 반클리프앤아펠= 10%, 프라다= 10%, 셀린느= 35%, 휴고보스= 85%, 스톤아일랜드= 25%, 버버리= 50%, 닥스= 45%, 입생로랑= 25%, 불가리= 50%, 보테가베네타= 40%, 몽블랑= 30%, 롤렉스= 25%, 스와로브스키= 25%, 에르메스= 10%)

-- 12-1) brand 테이블에 순익(benefit) 컬럼 추가
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

-- 12-2) 상품 금액에 이익률(benefit)을 곱한 후 브랜드별로 그룹핑하여 로우 출력
SELECT b.b_name, 
to_char(round(sum(decode(to_char(o.order_date,'YY'),'19',(p.price*b.benefit)))),'$999,999') "19년도 순익",
to_char(round(nvl(sum(decode(to_char(o.order_date,'YY'),'20',(p.price*b.benefit))),0)),'$999,999') "20년도 순익"
FROM product p, brand b, orderlist o, order_detail od 
WHERE p.b_code = b.b_code AND o.order_no = od.order_no AND od.p_name = p.p_name
GROUP BY b.b_name;




--13. 전자결제업체 빠이코가 그동안 전자결제로 결제한 금액의 50%를 포인트로 지급하는 이벤트를 열었다. 이번 이벤트의 포인트 지급으로 인해 등급변경 된 고객의 리스트를 출력하라
--   (ID, 이름, 포인트, 등급변경(변경전등급 -> 변경후등급))

-- 13-1) 커서에 customer와 orderlist를 조인해서 넣어놓고 등업된 grade를 넣을 변수 v_upgrade 선언
-- 13-2) 커서 루프를 사용하여 50%가 추가된 포인트를 등급조건에 따라 v_upgrade에 새로 지정
-- 13-3) 기존의 등급과 새로지정된 등급이 갖을 때는 등급변화가 일어나지 않았므로 등급이 같지 않을때만 출력
set serveroutput on;
/
DECLARE
  v_upgrade customer.grade%TYPE; 
  
  CURSOR c IS
    SELECT c.ID AS id, c.name AS name, c.grade AS grade, c.point AS point, o.order_total AS total, o.payment
    FROM customer c, orderlist o
    WHERE c.ID = o.ID
    AND o.payment = '전자결제';
BEGIN
  DBMS_OUTPUT.put_line(' ID      이름    포인트        등급변경');
  FOR rec IN c loop
    rec.point := rec.point + rec.total * 0.5;
    
    CASE 
    WHEN rec.point BETWEEN 0 AND 100 THEN v_upgrade := '브론즈';
    WHEN rec.point BETWEEN 101 AND 500 THEN v_upgrade := '실버';
    WHEN rec.point BETWEEN 501 AND 2000 THEN v_upgrade := '골드';
    WHEN rec.point BETWEEN 2001 AND 5000 THEN v_upgrade := '플래티넘';
    WHEN rec.point >= 5001 THEN v_upgrade := 'VIP';
    END CASE;
    
    if (rec.grade != v_upgrade) then
    DBMS_OUTPUT.put_line(rec.ID || '  ' || rec.NAME || '    ' || rec.point || '     ' || rec.grade || ' -> ' || v_upgrade);
    end if;
  end loop;
END;
/





-- 14. PL/SQL 상품테이블(Product)의 가격(price)이 평균 가격 보다 높은 상품들을 브랜드명을 입력받아 상품명, 상품코드, 상품의 가격을 출력하는데
--  그중 가장 많이 팔린 상품은 <Best> 상품이라고 표시하라.

-- 14-1) 커서를 이용하여 커서속에서 데이터를 가져올때 브랜드명을 입력받아 해당하는 브랜드상품들을 출력한다.
-- 14-2) <BEST>상품의 경우 rank() over함수를 이용해 순위를 만든다음, 디코드를 이용해 순위가 1이면 출력이 되도록 한다.
declare
cursor v1 is( 
select b.b_name as bname, p.p_name as pname, p.c_code as code, p.price as price, sum(o.ORDER_QTY) as qty,
rank() over(order by sum(order_qty) desc) as 순위,
decode(rank() over(order by sum(order_qty) desc),1,' ★<Best> 인기상품!!!') as 베스트
from product p, brand b, order_detail o
where p.b_CODE = b.B_CODE
and o.P_NAME = p.P_NAME
and b.b_name = '&브랜드명'
group by b.b_name, p.p_name, p.c_code, p.price, o.order_qty
);
begin
 dbms_output.put_line('브랜드명/  상품명/       상품코드/ 가격/ 판매갯수');
for emp_rec in v1 
 loop
 dbms_output.put_line(emp_rec.bname||' '||emp_rec.pname||' '||emp_rec.code||' '||emp_rec.price||' '||emp_rec.qty||
 ' '||emp_rec.베스트);
 end loop;
end;
/




--15. 아이디를 입력받아 (주문번호 / 상품명 / 주문날짜 / 주문금액) 주문목록을 출력하는 프로시저와
--    15-1) 아이디와 주문번호를 입력받아 (주문번호 / 상품명 / 금액($) / 갯수)주문번호에 해당하는 상세 주문내역을 출력하는 프로시저를 가지고있는 패키지를 작성하라.
--    15-2) 첫번째 search_id 프로시저는 아이디 하나를 입력받아 커서속에서 데이터를 추출해서 출력하는 형식이다.
--    15-3) 두번째 search_od 프로시저는 위에서 추출한 데이터중 주문번호와 아이디를 입력받아 이또한 커서를 활용해 데이터를 추출하는 형식이다.
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



