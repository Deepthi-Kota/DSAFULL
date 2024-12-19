/*
Write a Query to show all orders along with the customer name and email.

Refer the hint for table structure.

Sample Output:
--------------
OrderID CustomerName    Email                       OrderDate   TotalCost   Status                                                  
1001    Alice Johnson   alice.johnson@example.com   2024-10-10  1250.00     Shipped                                 
1002    Bob Smith       bob.smith@example.com       2024-10-12  850.00      Processing                                      
1003    Alice Johnson   alice.johnson@example.com   2024-10-15  75.00       Delivered

*/

use prefs;

-- write your query below
select o.OrderID, c.Name as CustomerName, c.Email, o.OrderDate, o.TotalCost, o.Status 
from Orders o, Customers c
where o.CustomerID=c.CustomerID;


