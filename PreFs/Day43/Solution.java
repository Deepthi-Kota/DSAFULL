package PreFs.Day43;
/*A family is about to break their piggy bank to use the money for different 
purposes. The piggy bank is represented as an array (`arr[]`) consisting of 
`M` coins. The family needs to split the coins in the piggy bank into smaller 
stacks (sub-arrays) such that the **sum of the differences between the maximum 
value and the minimum value of the coins in all the stacks (sub-arrays) is 
maximum. 

Constraints:
- Each value in the array can only be used once, i.e., it can belong to only 
  one sub-array.
- You are not allowed to change the order of the elements in the array.

Input Format:
-------------
5
8 9 7 1 2

Output Format:
-------------
7

Sample Input-1:
---------------
5
8 9 7 1 2

Sample Output-1:
----------------
8

Explanation:
------------
Sub-array [8]: Difference = 0 (a single element has no difference).
Sub-array [9, 7, 1]: Difference = 9 - 1 = 8
Sub-array [2]: Difference = 0 (a single element has no difference).


Sample Input-2:
---------------
5
8 1 7 9 2

Sample Output-2:
----------------
14

     */import java.util.*;
     public class Solution{
         public static void main(String[] args){
             Scanner sc = new Scanner(System.in);
             int n= sc.nextInt();
             int[] arr = new int[n];
             for (int i= 0; i< n; i++) {
                 arr[i] = sc.nextInt();
             }
             System.out.println(find(arr,0,n-1));
         }
         static int find(int[] arr, int i, int j){
             if(i==j){
                 return 0; 
             }
             int res = maxmin(arr,i,j);
             for(int k=i; k<j; k++){
                 res= Math.max(res,find(arr,i,k)+find(arr,k+1,j));
             }
             return res;
         }
         static int maxmin(int[] arr, int i, int j){
             int mini = Integer.MAX_VALUE;
             int maxi = Integer.MIN_VALUE;
             for(int k= i; k<= j; k++){
                 mini = Math.min(arr[k],mini);
                 maxi = Math.max(arr[k],maxi);
             }
             return maxi-mini;
         }
     }