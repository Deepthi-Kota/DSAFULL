package DAA.Day27;
/* You are entering into a maze N*N grid consist of(0's and 1's)
Initially you will start from (0,0) position in the maze, 
Your target is to reach the end position (N-1, N-1).

Among the four directions available(top, down, left, right),
you can move in two directions only, right and down.

In the maze, '0' indicates dead end and '1' indicates open way. 
You can travel through only open way.
For Example:-
Given Maze of size N=4 , starting position is (0, 0),
1 0 0 0
1 1 0 1
0 1 0 0
1 1 1 1

You can reach the (3, 3) position in the following way.
1 0 0 0
1 1 0 0
0 1 0 0
0 1 1 1

Return true, if you can reach the end position(N-1, N-1).
otherwise return false.

Input Format:
-------------
Line-1 -> An integer N, size of square board.
Next N lines -> N space separated integers 

Output Format:
--------------
Print a boolean value.

Sample Input-1:
---------------
4
1 0 0 0
1 1 0 1
0 1 0 0
1 1 1 1

Sample Output-1:
----------------
true


Sample Input-2:
---------------
4
1 1 0 0
1 0 0 1
0 1 1 0
1 0 0 1

Sample Output-2:
----------------
false*/
public class AP37_Maze {
    
}
import java.util.*;
public class Maze{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j]=sc.nextInt();
            }
        }
        if(arr[0][0]==0)
        {
            System.out.println(false);
            return;
        }
        boolean[][] vis = new boolean[n][n];
        System.out.println(find(arr,0,0,vis));
    }
    static boolean find(int[][] arr, int r, int c, boolean[][] vis){
        if(r==arr.length-1 && c==arr.length-1){
            return true;
        }
        if(r<0 || c<0 || r>=arr.length || c>= arr.length || vis[r][c] || arr[r][c]==0){
            return false;
        }
        vis[r][c]=true;
        boolean found = find(arr,r+1,c,vis) || find(arr,r,c+1,vis);
        vis[r][c] = false;
        return found;
    }
}
    