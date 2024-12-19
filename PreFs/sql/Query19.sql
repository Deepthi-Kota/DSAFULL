/*
Write a query to find customers whose email domain is 'example.com'


Refer the hint for table structure.

Sample output
-------------
CustomerID      Name    Email                                                                                           
1       Alice Johnson   alice.johnson@example.com                                                                       
2       Bob Smith       bob.smith@example.com                                                                           

*/

use prefs;
-- write your query below
select CustomerID, Name, Email from Customers
where Email like '%@example.com';

