package PreFs.Day8;
//https://leetcode.com/problems/score-after-flipping-matrix/submissions/1416098895/
/* To maximize energy efficiency and lighting optimization, you are allowed to perform 
an operation multiple times:
    You can choose any row or column of the grid and toggle all the bulbs in 
    that row or column. Toggling means:
        - Bulbs that are ON (1) will turn OFF (0).
        - Bulbs that are OFF (0) will turn ON (1).

Each row in the grid can be interpreted as a binary number, where the leftmost bulb 
is the most significant bit and the rightmost bulb is the least significant bit. 
The goal is to maximize the sum of these binary numbers for all rows in the grid, 
after performing any number of toggles on the grid.

Your task is to find the highest possible score, which is the maximum sum of all 
the binary numbers that can be obtained after optimizing the grid through these 
toggling operations.

Input Format:
-------------
Line-1: Two space separated integers, M and N
Next M lines: N space separated integers, grid[][]

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
3 5
0 1 1 1 1 
1 0 1 1 1 
0 0 0 0 1 

Sample Output-1:
----------------
78

Explanation:
------------
Given grid is 
0 1 1 1 1
1 0 1 1 1
0 0 0 0 1

Perform operation on row-0 and row-2
1 0 0 0 0
1 0 1 1 1
1 1 1 1 0

Perform operation on col-1 and col-4
1 1 0 0 1 = 25
1 1 1 1 0 = 30
1 0 1 1 1 = 23
So, now the total value of Binary Equivalent is 78


Sample Input-2:
---------------
2 3
0 1 0
0 0 1

Sample Output-2:
----------------
11
*/
import java.util.*;
 
public class p3 {
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
        System.out.println(find(arr));
        sc.close();
    }
    static int find(int[][] arr){
        //swapping rows
        for(int i=0; i<arr.length; i++){
            if(arr[i][0]!=1){
                swap(arr[i]);
            }
        }
        //swapping cols
        for(int i=0; i<arr[0].length; i++){
            int ones = count(arr,i);
            // System.out.println(ones+" "+arr.length/2);
            if(ones<=arr.length/2){
                swapcol(arr, i);
            }
        }
        // for(int i=0; i<arr.length; i++){
        //     for(int j=0; j<arr[0].length; j++){
        //         System.out.print(arr[i][j]+" ");
        //     }
        //     System.out.println("");
        // }
        return cal(arr);
    }
    static void swap(int[] arr){
        for(int i=0; i<arr.length; i++){
            arr[i]=1-arr[i];
        }
    }
    static int count(int[][] arr, int col){
        int c=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i][col]==1){
                c++;
            }
        }
        return c;
    }
    static void swapcol(int[][] arr, int col){
        for(int i=0; i<arr.length; i++){
            arr[i][col]=1-arr[i][col];
        }
    }
    static int cal(int[][] arr){
        int c=0;
        for(int[] a:arr){
            int bin = 0;
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<a.length; i++){
                sb.append(String.valueOf(a[i]));
            }
            for(int i=sb.length()-1; i>=0; i--){
                if(sb.charAt(i)=='1'){
                    bin+=Math.pow(2,(sb.length()-1-i));
                }
            }
            c+=bin;
        }
        return c;
    } 
}
