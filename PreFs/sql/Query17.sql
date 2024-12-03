/*
write a query to calculate the time difference in days between two orders 
by the same customer and print the records in sorted order by their ID  
and time difference in days of two orders.



Refer the hint for table structure.

Sample output
-------------
OrderID  OrderID  DaysDifference                                                                                          
1003     1011     1                                                                                                       
1011     1012     1                                                                                                       
1003     1012     2                                                                                                       


*/

use fs;
-- write your query below
select o1.OrderID, o2.OrderID, timestampdiff(day, o1.OrderDate, o2.OrderDate) as DaysDifference from Orders o1, Orders o2
where o1.customerID=o2.customerID and o1.OrderID < o2.OrderID
order by o1.CustomerID,DaysDifference;
