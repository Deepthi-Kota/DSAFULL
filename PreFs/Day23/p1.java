package PreFs.Day23;
/* Brahmi and his gang have been chased by a group of police officers and are now 
trapped in a building with M×N rooms, arranged in a grid format. Each room is 
connected to its adjacent rooms both horizontally and vertically, forming a 
complex layout. Fortunately, some rooms in the building are designated as 
"safe zones," providing a possible escape for Brahmi and his gang.

The building's rooms are marked with the following values:
    -1 : Danger Zone - an area that Brahmi and his gang cannot enter.
    0 : Safe Zone - an area that provides a possible escape.
    -2 : Occupied by a gang member.
    
Your task is to help Brahmi and his gang reach the nearest safe zones by 
calculating the minimum distance from each gang member's room to a safe zone, 
avoiding danger zones. If a gang member is unable to reach any safe zone, 
mark their room with -2.

Input Format:
-------------
Line-1 -> two integers M and N, size of the grid of rooms.
Next M Lines -> N space separated integers, from this set [-2,-1,0] only.

Output Format:
--------------
Print an integer as result.


Sample Input-1:
---------------
4 4
-2 -1 0 -2
-2 -2 -2 -1
-2 -1 -2 -1
0 -1 -2 -2

Sample Output-1:
----------------
3 -1 0 1
2 2 1 -1
1 -1 2 -1
0 -1 3 4

NOTE: Please refer the hint.
*/

import java.util.*;
public class p1{
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
        bfs(arr);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        sc.close();
    }
    static void bfs(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]==0){
                    q.add(new Pair(i,j,0));
                }
            }
        }
        
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        while(!q.isEmpty()){
            Pair p =q.poll();
            int r = p.row;
            int c = p.col;
            int s = p.step;
            for(int k=0; k<4; k++){
                int nrow = r+drow[k];
                int ncol = c+dcol[k];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && arr[nrow][ncol]==-2){
                    arr[nrow][ncol]=s+1;
                    q.add(new Pair(nrow,ncol,s+1));
                }
            }
        }
    }
}

class Pair{
    int row;
    int col;
    int step;
    Pair(int row, int col, int step){
        this.row=row;
        this.col = col;
        this.step = step;
    }
}