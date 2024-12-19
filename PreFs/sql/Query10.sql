/*
write a Query to List Customers Who Never Placed an Order

Refer the hint for table structure.

Sample output
-------------
CustomerID      Name                                                                                                    
8              Henry Taylor                                                                                                    
9              Irene Green 

*/

-- use fs;
-- -- write your query below
-- select CustomerID, Name from Customers 
-- where CustomerID not in (select CustomerID from Orders);


















use prefs;
select CustomerID, Name from customers
where CustomerID not in(select CustomerID from orders);