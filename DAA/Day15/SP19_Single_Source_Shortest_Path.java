package DAA.Day15;
/* Given a directed graph represented by an adjacency matrix, where each entry graph[i][j] represents the weight of the edge from vertex i to vertex j. If graph[i][j] is 0, it means there is no direct edge between i and j.

Your task is to determine the shortest paths from a given source vertex to all other vertices using Dijkstra’s algorithm.

Input Format:
-------------
Line-1: An integer N, representing the number of vertices in the graph.
Next-N lines: Each line contains N space-separated integers representing the adjacency matrix graph.
Last-line: An integer src, representing the source vertex.

Output Format:
--------------
A line that says: "Vertex 		Distance from Source".
Followed by N lines, each containing the vertex number and its shortest distance from the source.

Constraints:
------------
*1 <= N <= 100
*0 <= graph[i][j] <= 1000
*0 <= src < N
*All weights are non-negative integers.

Sample Input-1:
---------------
5
0 6 5 0 13
6 0 12 9 5
5 12 0 0 0
0 9 0 0 7
13 5 0 7 0
2

Sample Output-1:
----------------
Vertex           Distance from Source
0                5
1                11
2                0
3                20
4                16

Sample Input-2:
---------------
9
0 4 0 0 0 0 0 8 0
4 0 8 0 0 0 0 11 0
0 8 0 7 0 4 0 0 2
0 0 7 0 9 14 0 0 0
0 0 0 9 0 10 0 0 0
0 0 4 14 10 0 2 0 0
0 0 0 0 0 2 0 1 6
8 11 0 0 0 0 1 0 7
0 0 2 0 0 0 6 7 0
5

Sample Output-2:
----------------
Vertex           Distance from Source
0                11
1                12
2                4
3                11
4                10
5                0
6                2
7                3
8                6*/
import java.util.*;
public class SP19_Single_Source_Shortest_Path {
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
        int start = sc.nextInt();
        // int[] ans = shortest(arr, start);
        int[] ans = find(arr, start);
        System.out.println("Vertex\t\tDistance from Source");
        for(int i=0; i<ans.length; i++){
            System.out.println(i+"\t\t"+ans[i]);
        }
        sc.close();
    }
    static int[] shortest(int[][]arr, int start){
        int[] dist = new int[v];
        boolean[] vis = new boolean[v];
        for(int i=0; i<v; i++){
            dist[i]=Integer.MAX_VALUE;
            vis[i]=false;
        }
        dist[start] = 0;
        for(int i=0; i<v; i++){
            if(arr[start][i]>0){
                dist[i]= arr[start][i];
            }
        }
        vis[start]=true;
        for(int i=0; i<v; i++){
            for(int j=0; j<v; j++){
                if(arr[i][j]>0 && !vis[i] && dist[i]+arr[i][j] < dist[j]){
                    dist[j] = dist[i]+arr[i][j];
                }
            }
            vis[i]=true;
        }
        return dist;
    }

    static int[] find(int[][] arr, int s){
        int[] dist = new int[v];
        boolean[] vis = new boolean[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s]=0;
        for(int i=0; i<v-1; i++){
            int u = getMinIndex(dist, vis);
            vis[u]=true;
            for(int j=0; j<v; j++){
                if(arr[u][j]>0 && !vis[j] && dist[u]!=Integer.MAX_VALUE && dist[u]+arr[u][j]<dist[j]){
                    dist[j]=dist[u]+arr[u][j];
                }
            }
        }
        return dist;
    }
    static int getMinIndex(int[] dist, boolean[] vis){
        int mini = Integer.MAX_VALUE;
        int index = -1;
        for(int i=0; i<v; i++){
            if(!vis[i] && dist[i]<mini){
                mini = dist[i];
                index = i;
                // System.out.println(mini);
            }
        }
        return index;
    }
}

