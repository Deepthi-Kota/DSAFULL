package DAA.Day18;
/* You are given a directed graph represented by vertices and edges. 
Your task is to implement Depth-First Search (DFS) traversal from a given starting vertex. 
The graph is represented using an adjacency list, and you need to traverse the graph starting from a specified vertex using an iterative approach (using a stack).

Input Format:
-------------
Line-1: An integer V, the number of vertices in the graph.
Line-2: An integer E, the number of edges in the graph.
Line3 to E: The next E lines each contain two integers source and destination, representing an edge from the source vertex to the destination vertex.
Line-E+1: The starting vertex S from which DFS traversal should begin.

Output Format:
--------------
Line-1" Print the vertices visited in DFS order starting from the given vertex S.

Constraints:
------------
*1 ≤ V ≤ 100
*0 ≤ E ≤ V * (V - 1)
*0 ≤ source, destination, S < V

Sample Input-1:
----------------
5
8
0 1
0 4
1 0
1 2
1 3
1 4
2 3
3 4
0

Sample Output-1:
----------------
0 1 2 3 4 


Sample Input-2:
----------------
7
9
0 1
0 2
1 3
2 3
3 4
3 5
4 6
5 6
6 1
2

Sample Output-2:
----------------
2 3 4 6 1 5 */
import java.util.*;

public class AP27_DFS{
    
    static void link(List<List<Integer>> adjlist, int src, int dest){
        adjlist.get(src).add(dest);
        // if(src!=dest){
        //     adjlist.get(dest).add(src);
        // }
    }
    static int v;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        int e = sc.nextInt();
        List<List<Integer>> adjlist = new ArrayList<>();
        for(int i=0; i<v; i++){
            adjlist.add(new ArrayList<>());
        }
        for(int i=0; i<e; i++){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            link(adjlist,src,dest);
        }
        int s = sc.nextInt();
        dfs(adjlist,s);
        sc.close();
    }
    static void dfs(List<List<Integer>> arr, int start){
        boolean vis[] = new boolean[v];
        Stack<Integer> s = new Stack<>();
        s.push(start);
        while(!s.isEmpty()){
            int curr = s.pop();
            List<Integer> list = arr.get(curr);
            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr]=true;
            }
            for(int i=list.size()-1; i>=0; i--){
                if(!vis[arr.get(curr).get(i)]){
                    s.push(arr.get(curr).get(i));
                }
            }
        }
    }
}