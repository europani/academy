alter table brand rename column website to b_website;

-- CUSTOMER ���̺� --
ALTER TABLE customer ADD CONSTRAINT customer_id_pk PRIMARY KEY(ID);
ALTER TABLE customer ADD CONSTRAINT customer_pw_ck CHECK(LENGTH(pw) <= 10);
ALTER TABLE customer ADD CONSTRAINT customer_sex_ck CHECK(sex IN ('M', 'F'));
ALTER TABLE customer MODIFY (point DEFAULT 0);
ALTER TABLE customer MODIFY (grade DEFAULT '�����');

-- PRODUCT ���̺� --
ALTER TABLE product ADD CONSTRAINT product_pcode_pk PRIMARY KEY(p_code);
ALTER TABLE product ADD CONSTRAINT product_pname_unq UNIQUE(p_name);

--ORDERLIST ���̺� --
ALTER TABLE orderlist ADD CONSTRAINT orderlist_orderno_pk PRIMARY KEY(order_no); 
ALTER TABLE orderlist ADD CONSTRAINT orderlist_payment_ck CHECK(payment IN ('�������Ա�', 'ī��', '��ǰ��', '������ü', '���ڰ���'));

-- ORDER_DETAIL ���̺� --
ALTER TABLE order_detail ADD CONSTRAINT orderdetail_id_pk PRIMARY KEY(order_detail_id);

-- GRADE ���̺� --
alter table grade add constraint grade_pk PRIMARY key(grade);

-- INVEN ���̺� --
ALTER TABLE inven ADD CONSTRAINT inven_no_pk PRIMARY KEY(in_no);
alter table inven modify (state default '�԰�');

-- BRAND ���̺� --
ALTER TABLE brand ADD CONSTRAINT brand_code_pk PRIMARY KEY(b_code);
ALTER TABLE brand ADD CONSTRAINT brand_name_unq UNIQUE(b_name);

-- CATEGORY ���̺� --
ALTER TABLE CATEGORY ADD CONSTRAINT category_code_pk PRIMARY KEY(c_code);

-- �ܷ�Ű �׽�Ʈ --
ALTER TABLE customer ADD CONSTRAINT customer_grade_fk FOREIGN KEY(grade) REFERENCES grade(grade);
ALTER TABLE customer DROP CONSTRAINT customer_grade_fk;

ALTER TABLE product ADD CONSTRAINT product_code_fk FOREIGN KEY(b_code) REFERENCES brand(b_code);
ALTER TABLE product DROP CONSTRAINT product_code_fk;

ALTER TABLE product ADD CONSTRAINT product_ccode_fk FOREIGN KEY(c_code) REFERENCES category(c_code);
ALTER TABLE product DROP CONSTRAINT product_ccode_fk;

ALTER TABLE inven ADD CONSTRAINT inven_brand_fk FOREIGN KEY(in_brand) REFERENCES brand(b_name);
ALTER TABLE inven DROP CONSTRAINT inven_brand_fk;
ALTER TABLE inven ADD CONSTRAINT inven_pcode_fk FOREIGN KEY(in_pcode) REFERENCES product(p_code);
ALTER TABLE inven DROP CONSTRAINT inven_pcode_fk;

SELECT id FROM customer MINUS SELECT id FROM orderlist;







