/*
Write a query to display customer names in reverse order along with 
their email domain


Refer the hint for table structure.

Sample output
-------------
ReversedName    EmailDomain                                                                                             
nosnhoJ ecilA   example.com                                                                                             
htimS boB       example.com                                                                                             
sivaD eilrahC   example.com

*/

-- use fs;
-- -- write your query below
-- select reverse(Name) as ReversedName, substring(Email, locate('@',Email)+1) as EmailDomain from Customers;





























use prefs;
select REVERSE(name) as ReversedName, substring_index(email,'@',-1) as EmailDomain from customers;