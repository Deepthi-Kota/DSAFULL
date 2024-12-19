package PreFs.Day46;
/* You are tasked with calculating the minimum cost to travel between a series of 
buildings arranged in a straight line. There are n buildings, numbered from 1 
to n, and each building has an associated cost. 

The cost represents the expense incurred when you stop at a particular building.

You are allowed to jump between buildings, but the maximum jump length is limited
to k buildings. Whenever you stop at a building, the cost of that building is 
added to your total cost. The objective is to determine the minimum total cost 
required to travel all the buildings from the first building to the n-th 
(destination) building. Initially you are at 0th position, and the first building
starts at 1st position.

Input Format:
-------------
Two space separated integers, N and K.
N space separated integers, costs[], to reach buildings.

Output Format:
--------------
An integer result, minimum total cost.


Sample Input-1:
---------------
5 2
4 3 9 3 1

Sample Output-1:
----------------
7


Sample Input-2:
---------------
6 3
10 30 40 50 20 10

Sample Output-2:
----------------
60
*/

import java.util.*;
public class p2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        System.out.println(find(arr,n-1,k,dp));
        sc.close();
    }
    static int find(int[] arr, int n, int k, int[] dp){
        if(n==0){
            return arr[0];
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int mini = Integer.MAX_VALUE;
        for(int i=1; i<=k; i++){
            if(n-i>=0){
            mini=Math.min(arr[n]+find(arr,n-i,k,dp),mini);
            }
        }
        dp[n]=mini;
        return mini;
    }
    
}