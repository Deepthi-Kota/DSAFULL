package DAA.Day17;
/* You are given an undirected graph that represents a set of cities, where each city is connected to other cities by direct routes. 
The graph is represented using an adjacency list. 
Your task is to remove a specific city (vertex), which will be provided as input by the user, and its associated routes (edges) from the graph.

Write a program that:
    -Takes the list of cities and direct routes between them as input.
    -Removes the city and its connections (if it exists) as specified by the user.
    -Prints the adjacency list of the graph before and after removing the vertex.

Input Format:
-------------
The first line contains an integer n (the number of cities).
The next n lines contain the names of the cities.
The following integer m represents the number of direct routes (edges) between cities.
The next m lines contain pairs of strings (v1, v2) representing a direct route between two cities.
The last line contains the name of the city to be removed.

Output Format:
--------------
First, print the adjacency list of the graph before removing the city.
Then, remove the city (if it exists) and print the adjacency list after removing the city.

Constraints:
------------
*There are no duplicate cities in the list.
*There are no duplicate edges in the graph.
*1 ≤ n ≤ 100
*1 ≤ m ≤ 500

Sample Input-1:
---------------
5
Dallas
Tokyo
Aspen
LosAngeles
HongKong
6
Dallas Tokyo
Dallas Aspen
HongKong Dallas
LosAngeles HongKong
LosAngeles Aspen
HongKong Tokyo
Aspen

Sample Output-1:
----------------
Before removing vertex Aspen
HongKong: [Dallas, LosAngeles, Tokyo]
Tokyo: [Dallas, HongKong]
LosAngeles: [HongKong, Aspen]
Dallas: [Tokyo, Aspen, HongKong]
Aspen: [Dallas, LosAngeles]

After removing vertex Aspen
HongKong: [Dallas, LosAngeles, Tokyo]
Tokyo: [Dallas, HongKong]
LosAngeles: [HongKong]
Dallas: [Tokyo, HongKong]
*/
public class AP24_Remove_Vertex {
    
}
