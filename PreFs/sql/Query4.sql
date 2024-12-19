/*
write a Query Using Subquery to Get Customers with More Than 2 Orders.


Refer the hint for table structure.

Sample output
-------------
Name            Email                                                                                                           
Alice Johnson   alice.johnson@example.com                                                                               
Bob Smith       bob.smith@example.com 
*/

-- use fs;
-- -- write your query below
-- select Name, Email from Customers 
-- where CustomerID in (select CustomerID from Orders group by CustomerID having count(*)>2);


use prefs;
select c.Name, c.Email FROM customers c
where c.customerID in (select customerID from orders group by CustomerID having count(*)>2)