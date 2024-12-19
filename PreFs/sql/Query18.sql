/*
write a query to Calculate the time difference in hours between 
two orders by the same customer and print the records in sorted order by 
their ID and time difference in hours of two orders.


Refer the hint for table structure.

Sample output
-------------
OrderID  OrderID  HoursDifference                                                                                         
1003     1011     24                                                                                                      
1011     1012     24                                                                                                      
1003     1012     48                                                                                                      

   

*/

-- write your query below
-- use fs;
-- -- write your query below
-- select o1.OrderID, o2.orderID, abs(timestampdiff(hour,o1.Orderdate, o2.orderdate)) as HoursDifference
-- from Orders o1 join Orders o2
-- on o1.CustomerID = o2.CustomerID
-- where o1.orderID < o2.orderID
-- order by o1.CustomerID, HoursDifference;











use prefs;
select o1.orderid, o2.orderid, TIMESTAMPDIFF(hour,o1.orderdate,o2.orderdate) as HoursDifference
from orders o1
join orders o2
on o1.CustomerID=o2.CustomerID
and o1.orderdate<o2.OrderDate
order by o1.CustomerID, HoursDifference; 