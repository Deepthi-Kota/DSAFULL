package DP.adithyaVerma.KanpsackVariation;
//check if subset can form the sum or not
import java.util.*;
public class k1_subsetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        } 
        System.out.println(find(arr,n-1, sum));
        // boolean[] dp = new boolean[n+1];
        // System.out.println(findmem(arr, n, sum, dp));
        System.out.println(tabu(arr, n, sum));
        sc.close();
    }
    static boolean find(int[] arr, int n, int sum){
        if(n==0 && sum==0){
            return true;
        }
        if(n==0){
            return false;
        }
        if(sum==0){
            return true;
        }
        if(arr[n]>sum){
            return find(arr,n-1,sum);
        }else{
            return find(arr,n-1,sum-arr[n]) || find(arr,n-1,sum);
        }
    }
    // static boolean findmem(int[] arr, int n, int sum, boolean[] dp){
    //     if(n==0 && sum==0){
    //         return true;
    //     }
    //     if(n==0){
    //         return false;
    //     }
    //     if(sum==0){
    //         return true;
    //     }
    //     if(dp[n]!=false){
    //         return dp[n];
    //     }
    //     if(arr[n-1]>sum){
    //         return findmemo(arr, n-1, sum,dp);
    //     }
    // }
    static boolean tabu(int[]arr, int n, int sum){
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
