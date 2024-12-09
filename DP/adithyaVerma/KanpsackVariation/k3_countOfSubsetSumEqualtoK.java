package DP.adithyaVerma.KanpsackVariation;
import java.util.*;
public class k3_countOfSubsetSumEqualtoK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        } 

        System.out.println(find(arr,n-1, sum));
        // System.out.println(findmem(arr, n, sum, dp));
        System.out.println(tabu(arr, n, sum/2));
        sc.close();
    }
    static int find(int[] arr, int n, int sum){
        if(sum==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(arr[n]>sum){
            return find(arr,n-1,sum);
        }
        else{
            return find(arr,n-1,sum-arr[n]) + find(arr,n-1,sum);
        }
    }

    static int tabu(int[] arr,int n, int sum){
        int[][] dp = new int[n+1][sum+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;  // If sum is 0, we can always have an empty subset
        }
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = 0; // If no elements and non-zero sum, cannot form the sum
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if(arr[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] =  dp[i-1][j] + dp[i-1][j-arr[i-1]];
                }
            }
        }
        return dp[n][sum];
    }
}

