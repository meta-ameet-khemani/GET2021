use storefront2;

Assignment 2
=============

Question 1
===========

create table productCategory (id int primary key not null auto_increment, productId int, categoryId int,
foreign key (productId) references product(id),
foreign key (categoryId) references category(id));

insert into productCategory (productId, categoryId) values 
(1, 3), (2, 3), (3, 6), (3, 7);

select pc.productId, p.name, count(pc.categoryId) from productCategory pc join product p on
pc.productId = p.id group by pc.productId having count(pc.categoryId) > 1;

Question 2
===========

select count(id) from product where price between 0 and 100;

select count(id) from product where price between 101 and 500;

select count(id) from product where price > 500;

Question 3
===========

select c.name, count(pc.id) from productCategory pc join category c on pc.categoryId = c.id group by pc.categoryId;


Assignment 3
=============

Question 1
===========

select u.name, count(o.id) from orders o join user u on o.userId = u.id 
where datediff(curdate(), o.dateOfOrder) <= 30 group by o.userId;

Question 2
===========

select * from orders where datediff(curdate(), dateOfOrder) <= 30 order by amount desc limit 2;

Question 3
===========

select count(oi.id), p.name from orderitems oi join orders o join product p on 
o.id = oi.orderNumber and oi.productId = p.id
where datediff(curdate(), o.dateOfOrder) <= 160 group by oi.productId;

Question 4
===========

select date_format(o.dateOfOrder, '%M-%Y'), sum(o.amount) from orders o where 
datediff(now(), o.dateOfOrder) <= 180 group by date_format(o.dateOfOrder, '%M-%Y') order by 
o.dateOfOrder desc;

Question 5
===========

update product set product.active = 0 where product.id not in (
    select * from (
        (select p.id from product p join orders o join orderitems oi where p.id = oi.productId and
        oi.orderNumber = o.id and datediff(curdate(), o.dateOfOrder) <= 30) as T
    )
);

Question 6
===========

select p.id, p.name, p.price from product p join productcategory pc join category c where
p.id = pc.productId and c.id = pc.categoryId and c.name = 'shirt';

Question 7
===========

select p.id, p.name, count(p.id) from product p join orderitems oi where p.id = oi.productId and 
status = 'Cancelled' group by oi.productId order by count(p.id) desc limit 10;

Assignment 4
===========

Question 1
===========

create table state (id int primary key auto_increment, name varchar(50));

create table city (id int primary key auto_increment, name varchar(50), stateId int,
foreign key (stateId) references state(id));

create table zipcode (id int primary key auto_increment, code varchar(10), cityId int,
foreign key (cityId) references city(id));

insert into state (name) values ('Rajasthan'), ('Himachal Pradesh'), ('Goa');

insert into city (name, stateId) values ('Jodhpur', 1), ('Jaipur', 1), ('Udaipur', 1),
('Shimla', 2), ('Manali', 2), ('Panaji', 3);

insert into zipcode (code, cityId) values (342001, 1), (342003, 1), (342004, 1), (312001, 2),
(234001, 3);

select z.code, c.name, s.name from zipcode z join city c join state s where z.cityId = c.id and
c.stateId = s.id order by s.name, c.name;


Assignment 5
===========

Question 1
===========

create view orderInfo as select p.id, p.name as title, p.price, u.name, u.email, o.dateOfOrder, oi.status
from product p join orderitems oi join orders o join user u where p.id = oi.productId and
oi.orderNumber = o.id and o.userId = u.id and datediff(curdate(), o.dateOfOrder) <= 60 order by
o.dateOfOrder desc;

select * from orderInfo;

Question 2
===========

select id, title from orderInfo where status = 'Shipped';

Question 3
===========

select id, title, count(id) from orderInfo group by id order by count(id) desc limit 5;
























