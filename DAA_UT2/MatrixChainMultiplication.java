/*You are playing a game. There are N boxes placed in a row (0-indexed), 
every box has some points. 

You need to play the game with the following rules:
    - Initially your score is  '0' points.
    - Suppose the box has P points in it.
      if p>0 you will gain P points, if p<0 you will loose P points.
    - You are allowed to choose any number of consecutive boxes, atleast 1 box.
    
You are given the points in the N boxes as points[]. 
Your target is to maximize your score, and return the highest score possible. 
 
Input Format:
-------------
Line-1: An integer N.
Line-2: N space separated integers, points[].
  
Output Format:
--------------
An integer, print the highest score.
    
Sample Input-1:
---------------
9
-3 1 -2 4 -2 2 3 -5 4
 
Sample Output-1:
----------------
7
   
Explanation:
------------
By selecting consecutive boxes are [4,-2,2,3] has the highest score is 7
   
 
Sample Input-2:
---------------
2
1 -2
  
Sample Output-2:
----------------
1

Explanation:
------------
By picking the box is [1] has the highest score is 1. */

import java.util.*;
public class MatrixChainMultiplication {
    public static int matrixChainMultiplication(int[] arr, int i, int j, int[][] dp){
        if(i==j){
            return 0;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        dp[i][j] = Integer.MAX_VALUE;
        for(int k = i;k<j;k++){
            dp[i][j] = Math.min(dp[i][j],matrixChainMultiplication(arr, i, k, dp)+matrixChainMultiplication(arr, k+1, j, dp) + arr[i-1]*arr[k]*arr[j]);
        }
        return dp[i][j];
    }
    public static int matrixChainOrder(int[] arr, int i, int n){
        int[][] dp = new int[n][n];
        return matrixChainMultiplication(arr,i,n-1,dp);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(matrixChainOrder(arr,1,n));
        sc.close();

    }
}
