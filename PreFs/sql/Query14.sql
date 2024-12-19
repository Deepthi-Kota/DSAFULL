/*
Write a query to find orders placed in October 2024.

Refer the hint for table structure.

Sample output
-------------
OrderID  CustomerID   OrderDate                                                                                       
1001     1            2024-10-10                                                                                              
1002     2            2024-10-12                                                                                              
1003     1            2024-10-15                                                                                              
1004     3            2024-10-14                                                                                              
1005     4            2024-10-13                                                                                              

*/

-- use fs;
-- -- write your query below
-- select OrderID, CustomerID, OrderDate 
-- from Orders
-- where orderDate between '2024-10-01' and '2024-10-30';

use prefs;
select orderId, customerid, orderdate from orders
where Month(orderdate)=10 and year(orderdate)=2024
