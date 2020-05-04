insert into projectdetails (id  , name, start_date, end_date) values (1, 'Medi Switch', TO_DATE('2003/05/03', 'yyyy/mm/dd'),TO_DATE('2013/05/03', 'yyyy/mm/dd'));
insert into projectdetails (id  , name, start_date, end_date) values (2, 'NIMS', TO_DATE('2003/05/03', 'yyyy/mm/dd'),TO_DATE('2013/05/03', 'yyyy/mm/dd'));
insert into projectdetails (id  , name, start_date, end_date) values (3, 'Fundamo', TO_DATE('2003/05/03', 'yyyy/mm/dd'),TO_DATE('2013/05/03', 'yyyy/mm/dd'));
insert into projectdetails (id  , name, start_date, end_date) values (4, 'Multi Choice', TO_DATE('2003/05/03', 'yyyy/mm/dd'),TO_DATE('2013/05/03', 'yyyy/mm/dd'));
insert into projectdetails (id  , name, start_date, end_date) values (5, 'Facebook', TO_DATE('2003/05/03', 'yyyy/mm/dd'),TO_DATE('2013/05/03', 'yyyy/mm/dd'));
insert into projectdetails (id  , name, start_date, end_date) values (6, 'Google', TO_DATE('2003/05/03', 'yyyy/mm/dd'),TO_DATE('2013/05/03', 'yyyy/mm/dd'));

insert into employeeprojectdetails (id  , name, allocation_date, de_allocation_date, project_details_id) values (6, 'Google', TO_DATE('2003/05/03', 'yyyy/mm/dd'),TO_DATE('2013/05/03', 'yyyy/mm/dd'),1);

insert into product(id , title, description, in_stock, product_type,price,cost,package_type) values
                  (1, 'Lettuce', 'Ice Berg Lettuce', 20, 'VEGETABLE' , 40.0, 20.0,'PIECE');
insert into product(id , title, description, in_stock, product_type,price,cost,package_type) values
                  (2, 'Basil', 'Baby Basil', 30, 'VEGETABLE' , 60.0, 25.0,'PIECE');

insert into address(id,address_line1,address_line2,city,postal_code,state) values
                   (1, 'o waterstone east','Century City', 'Cape Town','7441','Western Cape');

insert into customer(id , first_name, last_name, email, number,agreed_to_marketting,address_id) values
                  (1, 'Hunaid', 'husain', 'hunaide005@gmail.com', '+27-062341192',1 ,1);

