package DAA.Day29;
/* A group of houses is arranged in a street, and each house has a certain amount of money stashed inside. 
A robber wants to steal the maximum amount of money possible. 
However, there is a catch: 
"the robber cannot rob two adjacent houses as it will alert the police."

You are tasked to calculate the maximum amount of money the robber can steal without alerting the police.

Input Format:
-------------
Line-1: An integer n, representing the number of houses in the street.
Line-2: n space-separated integers, representing the money stashed in each house.
  
Output Format:
--------------
Line-1: An integer, Print the maximum amount of money the robber can steal without alerting the police.


Sample Input-1:
---------------
5
100 50 400 200 100
  
Sample Output-1:
----------------
600

Explanation:
------------
The robber will steal 100, 400 and 100 from the houses.
Refer Hint for more.
   
Sample Input-2:
---------------
5
5 3 4 11 2 
  
Sample Output-2:
----------------
16

Explanation:
------------
Thief will steal 5 and 11 from the houses.*/

import java.util.*;
public class Day29_AP38_House_Robber{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        // System.out.println(find(arr,n-1));
        // System.out.println(findmem(arr,n-1,dp));
        System.out.println(tabu(arr,n));
        sc.close();
    }
    static int find(int[] arr, int n){
        if(n<0){
            return 0;
        }
        return Math.max(arr[n]+find(arr,n-2),find(arr,n-1));
    }
    static int findmem(int[] arr, int n, int[] dp){
        if(n<0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n] = Math.max(arr[n]+find(arr,n-2),find(arr,n-1));
        return dp[n];
    }
    static int tabu(int[] arr, int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return arr[0];
        }
        if(n==2){
            return Math.max(arr[0],arr[1]);
        }
        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]);
        for(int i=2; i<n; i++){
            dp[i] = Math.max(dp[i-2]+arr[i] , dp[i-1]);
        }
        return dp[n-1];
    }
    
}