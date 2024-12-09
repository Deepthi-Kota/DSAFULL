package DAA.Day31;
/* Mr Abdul planned to visit all the tourist paths in a city.
There are P number of tourist places connected using some routes 
in a city, the routes are one-directional.

Your task is to help Mr Abdul, to find the shortest routes between every pair 
of tourist-places in the city.

Input Format:
------------------
Line-1: An integer P, number of places.
Next P lines: P space separated integers, the routes[][].

Value 99 represents infinity (Large value)

Output Format:
--------------------
Print the shortest distance routes[][].

Sample Input-1:
--------------------
4
0 5 99 10
99 0 3 99
99 99 0 1
99 99 99 0

Sample Output-1:
----------------------
0 5 8 9
INF 0 3 4
INF INF 0 1
INF INF INF 0


Sample Input-2:
--------------------
5
0 4 5 6 99
99 0 5 99 10
1 99 0 3 99
2 99 99 0 1
1 99 99 99 0

Sample Output-2:
----------------------
0 4 5 6 7
6 0 5 8 9
1 5 0 3 4
2 6 7 0 1
1 5 6 7 0*/
public class SP47_All_Pairs_Shortest_Path {

    
}