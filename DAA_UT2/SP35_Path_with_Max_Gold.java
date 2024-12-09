/*The Kolar Gold Fields (KGF) is in the form of a m*n grid,
Each field, contains some amount of Gold in it.
 
You can mine the gold in the KGF in the following way.
    - You can start at any position in the grid, never visit a cell with no gold.
    - each time you visit a cell, you will grab all the gold in it.
    - You can move one step to the left, right, up or down.
    - You can't visit the same cell more than once.
    - You can stop at any cell.
    
Your task is to find the maximum amount of gold you can collect.

Input Format:
-------------
Line-1: Two integers M and N size of the KGF grid.
Next M lines: N space separated integers, gold in each row of the grid.

Output Format:
--------------
Print an integer, maximum amount of gold.


Sample Input-1:
---------------
3 3
3 6 0
5 8 7
0 9 0

Sample Output-1:
----------------
24

Explanation:
-------------
You can grab the gold in KGF grid as follows:
You can obtain like as follows: 9 -> 8 -> 7.

Sample Input-2:
---------------
5 3
1 0 7
2 0 6
3 4 5
0 3 0
9 0 20

Sample Output-2:
----------------
28

Explanation:
-------------
You can grab the gold in KGF grid as follows:
You can obtain like as follows: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
 */

import java.util.*;
public class SP35_Path_with_Max_Gold{
    static int sum = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j]=sc.nextInt();
            }
        }
        int maxi = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j]!=0){
                    boolean[][] vis = new boolean[m][n];
                    maxi = Math.max(maxi, find(i,j,arr,vis));
                }
            }
        }
        System.out.println(maxi);
        sc.close();
    }
    static int find(int i, int j, int[][] arr, boolean[][] vis){
        if(i<0 || i>=arr.length || j<0 || j>=arr[0].length || vis[i][j] || arr[i][j]==0){
            return 0;
        }
        vis[i][j]=true;
        int g = arr[i][j];
        int u=find(i-1,j,arr,vis);
        int d=find(i+1,j,arr,vis);
        int l=find(i,j-1,arr,vis);
        int r=find(i,j+1,arr,vis);
        g+=Math.max(Math.max(l,r),Math.max(u,d));
        vis[i][j]=false;
        return g;
    }
}