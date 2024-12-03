/*
write a Query Using a Correlated Subquery to Get the Latest Order for Each Customer

Refer the hint for table structure.

Sample output
-------------
OrderID   CustomerID      OrderDate       TotalCost                                                                       
1006        5            2024-10-12        550.00                                                                                  
1007        6            2024-10-14        250.00                                                                                  
1008        7            2024-10-15        1200.00                                                                                 


*/

use fs;
-- write your query below
select OrderID, CustomerID, OrderDate, TotalCost from Orders o
where (CustomerID, OrderDate) in (select CustomerID,MAX(OrderDate) from Orders group by CustomerID);

