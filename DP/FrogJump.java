package DP;

import java.util.*;
public class FrogJump {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(find(arr, arr.length-1));
        System.out.println(find1(arr, arr.length-1));
        System.out.println(find2(arr, arr.length-1));
        System.out.println(find3(arr, arr.length-1));
        sc.close();
    }
    //recursion
    static int find(int arr[], int n){
        if(n==0){
            return 0;
        }
        int left = find(arr,n-1) + Math.abs(arr[n]-arr[n-1]);
        int right = Integer.MAX_VALUE;
        if(n>1){
            right  = find(arr,n-2) +Math.abs(arr[n]-arr[n-2]);
        }
        return Math.min(left,right);
    }
    //memorization tc = O(n) sc = O(n)+O(n) topdown
    static int find1(int arr[], int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }else{
            int left = find(arr,n-1)+Math.abs(arr[n]-arr[n-1]);
            int right = Integer.MAX_VALUE;
            if(n>1){
                right = find(arr,n-2) +Math.abs(arr[n]-arr[n-2]);
            }
            dp[n] = Math.min(left,right);
            return dp[n];
        }
    }
    //tabulation bottom up
    static int find2(int arr[], int n){
        int[] dp =new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int i=1; i<arr.length; i++){
            int fs = dp[i-1] +Math.abs(arr[i]- arr[i-1]);
            int ss = Integer.MAX_VALUE;
            if(i>1){
                ss = dp[i-2] + Math.abs(arr[i]-arr[i-2]);
            }
            dp[i]=Math.min(fs,ss);
        }
        return dp[n];
    }
    //optimizing space
    static int find3(int arr[], int n){
        int prev2 = 0;
        int prev = 0;
        for(int i=1; i<arr.length; i++){
            int fs =prev + Math.abs(arr[i]-arr[i-1]);
            int ss = Integer.MAX_VALUE;
            if(i>1){
                ss = prev2 + Math.abs(arr[i]-arr[i-2]);
            }
            int curr = Math.min(fs,ss);
            prev2=prev;
            prev = curr;
        }
        return prev;
    }
}
