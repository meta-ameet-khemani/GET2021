Assignment 1
============

create database storefront;

use storefront;

create table category (
id int unique not null auto_increment,
name varchar(30) primary key,
parentId int,
foreign key(parentId) references category(id)
);

create table user (
id int primary key auto_increment,
name varchar(40),
email varchar(30),
password varchar(20),
contact bigint
);

create table product (
id int primary key auto_increment,
price int,
name varchar(30),
categoryId int,
foreign key(categoryId) references category(id)
);

create table image (
id int primary key auto_increment,
productId int,
image blob,
foreign key (productId) references product (id)
);

create table address (
id int primary key auto_increment,
userId int,
address varchar (30),
foreign key (userId) references user(id)
);

create table role (
id int primary key not null auto_increment,
roleType varchar(10) check (status in ('Shopper', 'Administrator')),
foreign key (id) references user (id)
);

create table orders (
id int primary key auto_increment,
dateOfOrder date,
amount int,
shippingAddress int,
userId int
);

create table oderderItems (
id int primary key auto_increment,
productId int,
orderNumber int,
status varchar (10) check (status in ('Shipped', 'Cancelled', 'Returned'))
);

create table stock (
productId int,
quantity int,
foreign key (productId) references product (id)
);

show tables;

drop table product;

create table product (
id int primary key auto_increment,
price int,
name varchar(30),
categoryId int,
foreign key(categoryId) references category(id)
);



Assignment 2
============

first
=====

insert into user (name, email, password, contact) values 
('Ameet', 'ameet.khemani@metacube.com', 'ameet', 1234567890),
('Amar', 'amar.chouhan@metacube.com', 'amar', 1234567890),
('Ajay', 'ajay.rathore@metacube.com', 'ajay', 1234567890)
;

alter table role modify roleType varchar (30);

insert into role (roleType) values ('Administrator'), ('Shopper'), ('Shopper');

insert into category (name, parentId) values
('clothes', null),
('electronics', null);

insert into category (name, parentId) values
('shirt', 1),
('trouser', 1),
('refrigerator', 2),
('smart phone', 2);

insert into product (price, name, categoryId) values 
(1000, 'First Shirt', 3),
(1400, 'Second Shirt', 3),
(8000, 'BB Trouser', 4),
(10000, 'LEE Trouser', 4);

insert into image (productId, image) values
(1, 'C:\Users\ameet.khemani_metacu\Pictures\Shirt 1'),
(2, 'C:\Users\ameet.khemani_metacu\Pictures\Shirt 2'),
(3, 'C:\Users\ameet.khemani_metacu\Pictures\Trouser 1'),
(4, 'C:\Users\ameet.khemani_metacu\Pictures\Trouser 2');

insert into address (userId, address) values 
(1, 'Jodhpur'),
(2, 'Jaipur'),
(3, 'Pushkar');

alter table product add column active int check (active in (1, 0));

alter table product add column createTime timestamp;

update product set active = 1 where id = 1;

update product set active = 1 where id = 3;

update product set active = 0 where id = 2;

update product set active = 0 where id = 4;

update product set active = 0 where id = 3;

select current_timestamp;

update product set createTime = '2021-03-15 19:51:45' where id = 3;

insert into stock (productId, quantity) values (1, 2), (2, 2), (3, 4);

insert into orders (dateOfOrder, amount, shippingAddress, userId) values 
(curdate(), 1000, 1, 1);

insert into orders (dateOfOrder, amount, shippingAddress, userId) values 
(curdate(), 1200, 1, 1);

select curdate();

insert into oderderitems (productId, orderNumber, status) values 
(2, 1, 'Cancelled'),
(3, 2, 'Cancelled');

second
=======

select p.price, p.name, c.name, p.createTime from product p inner join category c on p.categoryId = c.id where p.active = 1 order by p.createTime desc;

DELETE FROM image WHERE id = 4;


third
=======

select * from product where id not in ( select productId from image );


fourth
=======

select c.id, c.name, ifnull (p.name, 'Top Category') as Parent from category c left join category
p on c.parentId = p.id order by p.name asc;


select p.price, p.name, c.name, p.createTime from product p inner join category c on p.categoryId = c.id where p.active = 1 order by p.createTime desc;

fifth
=======

select c.id, c.name, p.name as Parent from category c left join category p on c.parentId = p.id where
c.id not in ( select distinct parentId from category);

sixth
=======

select id, name, price from product where categoryId = (select id from category where name = 'smart phone');

seventh
========

select id, name, price from product where id in (select productId from stock where quantity < 50);


Assignment 3
==============

first
======

select * from orders order by dateOfOrder limit 50;

second
======

select * from orders order by amount limit 10;

third
======

select * from orders order by amount limit 10;

fourth
======

insert into orders (dateOfOrder, amount, shippingAddress, userId) values 
('2021-03-01', 3500, 1, 1);

insert into orders (dateOfOrder, amount, shippingAddress, userId) values 
('2021-03-10', 13500, 1, 1);

insert into orders (dateOfOrder, amount, shippingAddress, userId) values 
('2021-03-05', 32500, 1, 1);

select o.* from orders o where datediff (curdate(), o.dateOfOrder) > 10;

select o.id, o.dateOfOrder, o.userId, o.amount from orders as o, oderderitems as i where datediff(curdate(), o.dateOfOrder) > 10 and o.id = i.orderNumber and i.status != 'Shipped';

fifth
======

select u.name from user u, role r where u.id = r.id and u.id not in (select userId from orders where dateOfOrder > curdate() - 15);

select u.id, u.name, o.amount, o.dateOfOrder, o.id from user as u, orders as o where u.id = o.userId
and datediff (curdate(), o.dateOfOrder) <= 15;

sixth
======

select i.id, i.orderNumber, i.status, o.dateOfOrder from oderderitems i, orders o where o.id = i.orderNumber and i.status = 'Shipped';

seventh
========

select p.name, p.price, o.dateOfOrder from orders as o, product as p, oderderitems as i where
i.orderNumber = o.id and i.productId = p.id and p.price between 20 and 50;
