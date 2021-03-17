Assignment 1
=============

Question 1
=============

drop function if exists calculateOrders;

DELIMITER $$

CREATE function calculateOrders(month int, year int) returns int deterministic
BEGIN
    declare result int;
    set result = 0;
    select count(id) into result from orders where extract(Month from dateOfOrder) = month and
    extract(Year from dateOfOrder) = year;
    return result;
END$$

DELIMITER ;

select calculateOrders(03, 2021);


Question 2
=============

drop function if exists getOrders;

DELIMITER $$

CREATE function getOrders(year int) returns int deterministic
BEGIN
    declare month int;
    
    select max.maxMonth into month from (
    select count(dateOfOrder) as count, month(dateOfOrder) as maxMonth from orders where
    extract(Year from dateOfOrder) = year
    group by month(dateOfOrder))max
    order by max.count desc limit 1;
    
    return month;
END$$

DELIMITER ;

select getOrders(2021);

Assignment 2
=============

Question 1
=============

drop procedure if exists avgMonthSales;

DELIMITER $$

CREATE procedure avgMonthSales(month int, year int)
BEGIN
    
    select p.id, p.name, o.dateOfOrder, sum(o.amount), avg(o.amount) from orders o join orderitems 
    oi join product p on oi.orderNumber = o.id and oi.productId = p.id where month(o.dateOfOrder) = 
    03 and year(o.dateOfOrder) = 2021 group by p.id;
    
END$$

DELIMITER ;

call avgMonthSales(03, 2021);



Question 2 
=============

drop procedure if exists orderDetails;

DELIMITER $$

CREATE procedure orderDetails(startDate date, endDate date)
BEGIN
    
    select p.name, oi.status from orders o join orderItems oi join product p where o.id = oi.orderNumber
    and oi.productId = p.id and o.dateOfOrder between startDate and endDate;
    
END$$

DELIMITER ;

call orderDetails('2021-03-01', '2021-12-31');
