package DAA.Day11;
/* You are given an m x n matrix of integers where:
    *Each row is sorted in non-decreasing order.
    *The first integer of each row is greater than the last integer of the previous row.

Given an integer target, your task is to determine if the target exists in the matrix. If it does, return the row and column indices where it is found. If it does not exist in the matrix, return -1.

You must implement the solution with a time complexity of O(log(m * n)) using a binary search approach.

Input Format:
-------------
Line-1: Two integers m and n, representing the number of rows and columns in the matrix.
Line-2 to m: The next m lines each contain n integers, representing the matrix elements.
Line m+1: The last line contains the integer k, the target value to search for in the matrix.

Output Format:
---------------
If the target exists, print the row and column indices of the target in the matrix.
If the target does not exist, print -1.

Constraints:
-------------
1 ≤ m, n ≤ 1000
-10^4 ≤ matrix[i][j], k ≤ 10^4

Sample Input-1:
---------------
3 4
1 3 5 7
10 11 16 20
23 30 34 60
3

Sample Output-1:
----------------
0 1

Explanation:
The target 3 is found in row 0 and column 1.


Sample Input-2:
---------------
3 4
1 3 5 7
10 11 16 20
23 30 34 60
13

Sample Output-2:
----------------
-1

Explanation:
The target 13 does not exist in the matrix, so the output is -1.

*/
import java.util.*;
public class AP17_Search_in_a_SortedMatrix {
    public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] arr = new int[m][n];
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    arr[i][j]=sc.nextInt();
                }
            }
            int t = sc.nextInt();
            int[] ans = search(arr,t);
            System.out.println(Arrays.toString(ans));
            sc.close();
        }
        static int[] search(int[][] arr, int t){
            int s = 0;
            int e = arr.length-1;
            while(s<=e){
                int mid = s+(e-s)/2;
                if(arr[mid][0] <=t && t<=arr[mid][arr[0].length-1]){
                    int col = bs(arr[mid],t);
                    if(col!=-1){
                        return new int[]{mid,col};
                    } else{
                        return new int[]{-1,-1};
                    }
                }
            if(arr[mid][0]>t){
                e=mid-1;
            } else{
                s=mid+1;
            }}
            return new int[]{-1,-1};
        }
        static int bs(int[] arr, int t){
            int s = 0;
            int e = arr.length-1;
            while(s<=e){
                int mid = s+(e-s)/2;
                if(arr[mid]==t){
                    return mid;
                } else if(arr[mid]<t){
                    s=mid+1;
                }
                else{
                    e=mid-1;
                }
            }
            return -1;
        }
}
