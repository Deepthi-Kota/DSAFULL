package PreFs.Day24;
/* In a township of size N×N, each 1x1 area is either a villa or a swimming pool. 
The layout of the township is represented as a 2D matrix of size N×N, 
filled with 0's and 1's, where:
    - 0 represents a swimming pool,
    - 1 represents a villa.

Your task is to identify a swimming pool such that its distance to the nearest 
villa(s) is maximized, and return this distance.

If the township contains only villas or only swimming pools, return -1.

Note: The distance used in this problem is the Manhattan distance: the distance 
between two cells (a0, b0) and (a1, b1) is defined as |a0 - a1| + |b0 - b1|

Input Format:
-------------
- The first line contains an integer N, the size of the 2D matrix
- The next N lines each contain N space-separated integers, either 0 or 1, 
  representing the township matrix.

Output Format:
--------------
Print an integer, representing the maximum distance from any swimming pool to 
the nearest villa.


Sample Input-1:
---------------
4
1 0 1 1
0 0 0 0
1 0 1 0
1 0 0 1

Sample Output-1:
----------------
2

Explanation: 
------------
The swimming pool at (1, 1) is with distance 2 from the nearest villas.


Sample Input-2:
---------------
4
1 0 0 0
0 0 0 0
1 0 0 0
0 1 0 1

Sample Output-2:
----------------
3

Explanation: 
------------
The swimming pool at (0,3) or (1, 2) are with distance 3 from the nearest villas.
*/

import java.util.*;
public class p1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j]=sc.nextInt();
            }
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j]==0){
                    ans = Math.max(ans, bfs(arr, i, j));
                }
            }
        }
        if(ans==0){
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }
        sc.close();
    }
    static int bfs(int[][] arr, int i, int j){
        int n = arr.length;
        int m = arr[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j,0));
        int res = 0;
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;
            int dist = p.dist;
            res = Math.max(dist, res);
            for(int k=0; k<4; k++){
                int nrow = r +drow[k];
                int ncol = c +dcol[k];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && !vis[nrow][ncol]){
                    if(arr[nrow][ncol]==1){
                        return dist+1;
                    }else if(arr[nrow][ncol]==0){
                    vis[nrow][ncol]=true;
                    q.add(new Pair(nrow, ncol,dist+1));
                    }
                }
            }
        }
        return res;
    }
    
}
class Pair{
    int row;
    int col;
    int dist;
    Pair(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}