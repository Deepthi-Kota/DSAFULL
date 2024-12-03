package PreFs.Day25;
/* A dangerous virus, "Ebola," is spreading across several African countries. 
People are positioned in a grid of size p * q, where some positions in the grid 
are empty.

The grid is represented with three values: 0, 1, and 2, where:
    - 0 indicates an empty position,
    - 1 indicates a healthy person, and
    - 2 indicates an infected person.
    - Each minute, any healthy person who is 4-directionally adjacent (up, down, 
      left, or right) to an infected person becomes infected.

Your task is to determine the minimum amount of time, in minutes, for the virus 
to spread to all people in the grid. 
If it is impossible to infect everyone, return -1.

Input Format:
-------------
Line 1: Two integers, P and Q, representing the dimensions of the grid.
Next P lines: Each line contains Q space-separated integers, either 0, 1, or 2, 
              representing the grid.

Output Format:
--------------
An integer, the minimum amount of time in minutes


Sample Input-1:
---------------
3 3
2 1 1
1 1 0
0 1 1

Sample Output-1:
----------------
4

Explanation-1: (Refer the hint)
--------------
There is an infected person at position (0, 0).
In the first minute: people at positions (0, 1) and (1, 0) are infected.
In the second minute: people at positions (0, 2) and (1, 1) are infected.
In the third minute: the person at position (1, 2) is infected.
In the fourth minute: the person at position (2, 2) is infected.


Sample Input-2:
---------------
3 3
2 1 1
0 1 1
1 0 1

Sample Output-2:
----------------
-1

Explanation-2:
--------------
The healthy person at the bottom left corner (row 2, column 0) cannot be 
infected because infection only spreads in the four primary directions.

Sample Input-3:
---------------
1 2
0 2

Sample Output-3:
----------------
0

Explanation-3: 
-------------
Since there are no healthy people at minute 0, the answer is simply 0.
*/

import java.util.*;
public class p3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j]=sc.nextInt();
            }
        }
        int ans = bfs(arr);
        System.out.println(ans);
        sc.close();
    }
    static int bfs(int[][] arr){
        Queue<Pair> q = new LinkedList<>();
        int n = arr.length;
        int m = arr[0].length;
        boolean[][] vis = new boolean[n][m];
        int tothealthy = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=true;
                }
                else if(arr[i][j]==1){
                    tothealthy++;
                }
            }
        }
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        int tm = 0;
        int cnt = 0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;
            int t = p.time;
            tm = Math.max(t,tm);
            for(int k=0; k<4; k++){
                int nrow = r + drow[k];
                int ncol = c + dcol[k];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && !vis[nrow][ncol] && arr[nrow][ncol]==1){
                    q.add(new Pair(nrow, ncol,tm+1));
                    vis[nrow][ncol]=true;
                    cnt++;
                }
            }
        }
        if(cnt==tothealthy){
        return tm;
        }else{
            return -1;
        }
    }
}

class Pair{
    int row;
    int col;
    int time;
    Pair(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}