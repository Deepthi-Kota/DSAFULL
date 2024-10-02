package DAA_Syllabus;
/* You are given an m x n matrix mat where each row is sorted in non-decreasing order.

Your task is to find the smallest common element in all rows. If there is no common element, return -1.

Input Format:
--------------
Line-1: Two integers m and n, representing the number of rows and columns, respectively.
Line-2: The next m lines contain n space-separated integers each, representing the elements of the matrix. Each row of the matrix is sorted in non-decreasing order.

Output Format:
---------------
Line-1: Print a single integer, the smallest common element in all rows. If no common element exists, print -1.

Constraints:
-------------
1 ≤ m, n ≤ 500
1 ≤ mat[i][j] ≤ 10^4
Each row is sorted in non-decreasing order.

Sample Input-1:
----------------
3 4
1 2 3 4
2 3 5 7
3 5 6 7

Sample Output-1:
-----------------
3

Explanation: The number 3 is the smallest common element in all rows.


Sample Input-2:
---------------
2 3
1 2 3
4 5 6

Sample Output-2:
----------------
-1

Explanation: There is no common element in all rows, so the output is -1.*/
import java.util.*;
public class Sp14_Smallest_common_Element_in_All_Rows {
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
            System.out.println(helper(arr));
            sc.close();
        }
        static int helper(int[][] arr){
            for(int num: arr[0]){
                int c=0;
                for(int i=1; i<arr.length; i++){
                    if(bs(arr[i],num)){
                        c++;
                    }
                }
                if(c==arr.length-1){
                    return num;
                }
            }
            return -1;
        }
        static boolean bs(int[] arr,int t){
            int s=0;int e= arr.length-1;
            while(s<=e){
                int mid = s+(e-s)/2;
                if(t==arr[mid]){
                    return true;
                } else if(t<arr[mid]){
                    e=mid-1;
                }else{
                    s=mid+1;
                }
            }
            return false;
        }
}
