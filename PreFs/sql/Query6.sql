/*
write a Query to Get Products Ordered More Than 3 Times

Refer the hint for table structure.

Sample output
-------------
Name        TimesOrdered                                                                                                    
Keyboard        4                                                                                                       
Mouse           6                                                                                                               

*/

use fs;
-- write your query below
select p.Name, count(*) as TimesOrdered
from Products p, OrderItems o
where p.ProductID = o.ProductID
group by p.ProductID
having TimesOrdered>3;

