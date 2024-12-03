/*
write a Query to List Products with No Orders.

Refer the hint for table structure.

Sample output
-------------
ProductID       Name                                                                                                    
103            Headphones  
*/

use fs;
-- write your query below
select p.ProductID, p.Name 
from Products p
where p.ProductID not in(select ProductID from OrderItems);
