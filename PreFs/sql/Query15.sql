/*
Write a query to find orders that were placed on weekends

Refer the hint for table structure.

Sample output
-------------
OrderID  CustomerID   OrderDate                                                                                       
1002     2            2024-10-12                                                                                              
1005     4            2024-10-13                                                                                              
                                                                                              
*/

-- use fs;
-- -- write your query below
-- select OrderId, CustomerID, OrderDate 
-- from Orders
-- where dayname(OrderDate) in ('Saturday','Sunday');


use prefs;
select orderId, customerid, orderdate from orders
where dayname(orderdate) in ('saturday','sunday');