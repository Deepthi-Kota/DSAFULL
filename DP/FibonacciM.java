package DP;
import java.util.*;
public class FibonacciM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibo(n));
        System.out.println(fibo2(n));
        System.out.println(fibo3(n));
        sc.close();
    }
    //memorizarion tc=O(n) sc=O(n)+O(n) i.e stack space and array space
    static int fibo(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        if(n<=1){
            return n;
        }
        if(dp[n]!=-1){
            return dp[n];
        }else{
            return fibo(n-1)+fibo(n-2);
        }
    }
    //tabulation tc= O(n) && sc = O(n);
    static int fibo2(int n){
        int[] dp=new int[n+1];
        dp[0]=0; dp[1]=1;
        for(int i=2; i<=n; i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];

    }
    //optimizing space tc=O(n) && sc = O(1)
    static int fibo3(int n){
        int prev2 = 0;
        int prev = 1;
        int curr = 0;
        for(int i=2; i<=n; i++){
            curr = prev2 +prev;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
