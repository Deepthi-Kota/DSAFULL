/*
write a Query to Get the Top 3 Customers by Total Spending.

Refer the hint for table structure.

Sample output
-------------
Name            TotalSpent                                                                                                      
Alice Johnson   1625.00                                                                                                 
George Clark    1200.00                                                                                             

*/

use fs;
-- write your query below
select c.Name, sum(o.TotalCost) as TotalSpent 
from Customers c, Orders o
where c.CustomerID=o.CustomerID
group by c.CustomerID
order by TotalSpent desc
limit 3;
