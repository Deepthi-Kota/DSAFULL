/*
write a Query to Get Total Sales for Each Product

Refer the hint for table structure.

Sample output
-------------
Name          TotalSales                                                                                                      
Laptop           2400.00                                                                                                         
Keyboard         375.00                                                                                                  
Smartphone       1600.00                                                                                                 
Mouse            320.00                                                                                                          
 
*/

-- use fs;
-- -- write your query below
-- select p.Name, sum(o.Quantity)*p.price as TotalSales
-- from Products p join OrderItems o
-- on p.productID = o.productID
-- group by o.productID;



-- use prefs;
-- select p.Name, sum(o.Quantity*o.UnitPrice) from products p
-- join orderitems o
-- on p.ProductID = o.ProductID
-- group by o.productID;

use prefs;
select p.Name, sum(o.Quantity*o.UnitPrice) 
from products p, orderitems o where p.ProductID = o.ProductID
group by o.productID;
