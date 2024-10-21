package DAA.Day16;
/* You are given an undirected, connected graph with N vertices and M edges, represented as an adjacency matrix. 
Your task is to construct the Minimum Spanning Tree (MST) of this graph using Prim's algorithm. 
The MST is a subgraph that connects all the vertices together, without any cycles, and with the minimum possible total edge weight.

The adjacency matrix of the graph is a 2D array, where graph[i][j] represents the weight of the edge between vertex i and vertex j. 
If there is no edge between vertex i and vertex j, the value will be 0.

Your goal is to write a program that reads the adjacency matrix from input and outputs the edges in the MST along with their respective weights.

Input Format:
-------------
Line-1: Line-1 contains an integer N, the number of vertices in the graph.
Line-2 to N: Each line contain N integers representing the adjacency matrix of the graph.

Output Format:
--------------
Print the edges of the MST and their corresponding weights in the format: Vertex1 - Vertex2 Weight.

Sample Input-1:
---------------
5
0 2 0 6 0
2 0 3 8 5
0 3 0 0 7
6 8 0 0 9
0 5 7 9 0

Sample Output-1:
----------------
Edge 	Weight
0 - 1	2
1 - 2	3
0 - 3	6
1 - 4	5

Explanation:
The graph has 5 vertices, and the minimum spanning tree is constructed by connecting the vertices with the least total weight.
The algorithm starts from the vertex with the smallest weight and continues to add edges with the least cost that connect the remaining unvisited vertices.

Constraints:
-------------
*1 <= N <= 1000
*0 <= weight of edge <= 10^4
*The graph is connected and undirected.
*/

import java.util.*;
public class SP21_Prims_MST{
    static int v = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        v=sc.nextInt();
        int[][] arr = new int [v][v];
        for(int i=0; i<v; i++){
            for(int j=0; j<v; j++){
                arr[i][j]=sc.nextInt();
            }
        }
        int[] parent = find(arr);
        System.out.println("Edge\tWeight");
        for(int i=1; i<v; i++){
            System.out.println(parent[i]+"-"+i+"\t"+arr[i][parent[i]]);
        }
        sc.close();
    }
    static int[] find(int[][]arr){
        int[] dist = new int[v];
        int[] parent = new int[v];
        boolean[] vis = new boolean[v];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        parent[0]=-1;
        for(int i=0; i<v-1; i++){
            int u = minindex(dist,vis);
            System.out.println(u);
            vis[u]=true;
            // System.out.println(Arrays.toString(vis));
            for(int j=0; j<v; j++){
                if(arr[u][j]>0 && !vis[j] && arr[u][j]<dist[j]){
                    parent[j] = u;
                    dist[j] = arr[u][j];
                }
                // System.out.println("here");
            }
            // System.out.println(Arrays.toString(parent));
        }
        return parent;
    }
    static int minindex(int[] dist, boolean[] vis){
        int mini = Integer.MAX_VALUE;
        int index = -1;
        for(int i=0; i<v; i++){
            if(!vis[i] && dist[i]<mini){
                mini = dist[i];
                index = i;
            }
        }
        return index;
    }
}