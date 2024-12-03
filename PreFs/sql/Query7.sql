/*

write a Query to Get All Cancelled Orders with Product Details
 
Refer the hint for table structure.

Sample output
-------------
OrderID Name       Quantity        UnitPrice                                                                               
1004    Mouse        1               40.00                                                                                           
1007    Smartwatch   1               250.00                                                                                  
                                                                                         

*/

use fs;
-- write your query below
select o.OrderID, p.Name, o1.Quantity, p.Price as UnitPrice
from Orders o, OrderItems o1, Products p
where p.ProductID = o1.productID and o1.orderID = o.OrderID and o.Status = 'Cancelled';
