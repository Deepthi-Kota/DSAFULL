package PreFs.Day26;
/* There are M people ordered the gold, now Mr. Manohar has to distribute the gold
to M people. Mr. Manohar, the gold merchant has N number of gold-bars, given 
as an array gold[], where gold[i] is the weight of i-th gold bar.


The process of distribution of gold is as follows:
     - He can cut the gold bar into any number of small bars, but he cannot
     join two gold bars into one.
     - He needs to distribute the gold equally among M people
     - Each person among M people has to get at most one bar.
     - Mr. Manohar can keep the gold bars that are not distributed.


Your task is to help Mr. Manohar to find the maximum weight of the gold bar 
that each person can get. If it is not possible to distribute the gold 
among M people, return 0.

NOTE: Weight of the gold bar should be at least lunit of weight (must be an integer).

Input Format:
-------------
Line-1: Two space separated integers, N and M.
Line-2: N space separated integers, weight of each gold bar.

Output Format:
--------------
Print an integer, the maximum weight of gold can be distributed.


Sample Input-1:
---------------
3 3 
5 8 6

Sample Output-l:
----------------
5


Explanation:
------------
He can cut the gold[] 45,8,6] as, gold[1] into 2 gold bars of 
weight 5 and 3, and gold[2] into 2 gold bars of weight 5 and 1. Now, there are
five gold bars of weights 5, 5, 3, 5, and 1. He can distribute 3 gold bars 
of weight 5 to 3 people.


Sample Input-2:
---------------
4 15 
2 3 4 5

Sample Output-2:
----------------
0

*/
import java.util.*;
public class p2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(search(arr,m));
        sc.close();
    }
    static int search(int[] arr, int x){
        int s = 1;
        int e = Integer.MIN_VALUE;
        int sum = 0;
        for(int n: arr){
            if(n>e){
                e=n;
            }
            sum+=n;
        }
        if(sum<x){
            return 0;
        }
        while(s<=e){
            int mid = s+(e-s)/2;
            int c =0;
            for(int i=0; i<arr.length; i++){
                c+=arr[i]/mid;
            }
            if(c>=x){
                s = mid+1;
            }else{
                e = mid-1;
            }
        }
        return e;
    }
}