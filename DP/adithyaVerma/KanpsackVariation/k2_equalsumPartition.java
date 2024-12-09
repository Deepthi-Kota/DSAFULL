package DP.adithyaVerma.KanpsackVariation;

import java.util.Scanner;

public class k2_equalsumPartition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        } 
        int sum = 0;
        for(int i: arr){
            sum+=i;
        }
        System.out.println(sum);
        if(sum%2!=0){
            System.out.println(false);
            sc.close();
            return;
        }
        System.out.println(find(arr,n-1, sum/2));
        // boolean[] dp = new boolean[n+1];
        // System.out.println(findmem(arr, n, sum, dp));
        // System.out.println(tabu(arr, n, sum/2));
        sc.close();
    }
    static boolean find(int[] arr, int n, int sum){
        if(sum==0){
            return true;
        }
        if(n==0){
            return false;
        }
        if(arr[n]>sum){
            return find(arr,n-1,sum);
        }
        else{
            return find(arr,n-1,sum-arr[n]) || find(arr,n-1,sum);
        }
    }

    static boolean tabu(int[] arr,int n, int sum){
        boolean[][] dp = new boolean[n+1][sum+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;  // If sum is 0, we can always have an empty subset
        }
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = false; // If no elements and non-zero sum, cannot form the sum
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if(arr[i-1]>sum){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] =  dp[i-1][j]|| dp[i-1][j-arr[i-1]];
                }
            }
        }
        return dp[n][sum];
    }
}
