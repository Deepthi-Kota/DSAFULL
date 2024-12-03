/*
Write a query to count the number of people above 35 years living in 
"Bangalore" or "Mumbai".

Sample output
-------------
total_people
2                                                                                


Table:   
======
indianPeople
    - name VARCHAR(100),
    - age INT,
    - gender VARCHAR(10),
    - phone_number VARCHAR(15),
    - location VARCHAR(50),
    - salary DECIMAL(10, 2)
    
table data
    name    age     gender  phone_number    location        salary                                                          
    Priya Kumar     32      Female  9876543210      Mumbai  50000.00                                                        
    Rohan Gupta     28      Male    9876501234      Delhi   55000.00                                                        
    Anita Reddy     45      Female  9872101234      Bangalore       75000.00                                                
    Suresh Singh    37      Male    9123456789      Kolkata 48000.00                                                        
    Lata Kulkarni   29      Female  9000055555      Pune    62000.00                                                        
    Karan Malhotra  33      Male    9222334455      Chennai 58000.00                                                        
    Jyoti Mishra    41      Female  9555666777      Hyderabad       68000.00                                                
    Aman Chawla     39      Male    9888777665      Ahmedabad       64000.00                                                
    Reshma Rai      30      Female  9666335522      Surat   61000.00                                                        
    Nikhil Mathur   34      Male    9778889990      Jaipur  53000.00                                                        
    Arjun Patel     26      Male    9765432109      Mumbai  62000.00                                                        
    Meera Chopra    31      Female  9765454321      Delhi   67000.00                                                        
    Vikas Jain      42      Male    9876543222      Bangalore       89000.00                                                
    Anita Goyal     38      Female  9123451234      Kolkata 49000.00                                                        
    Rahul Mehta     27      Male    9000099999      Pune    60000.00   

*/

use fs;
-- write your query below
select * from indianPeople;
select count(*) as total_people from indianPeople 
where age>35 and location in ('Bangalore' ,'Mumbai') ;

