package DAA.Day9;
/*You are given an array of distinct integers sorted in increasing order. 
A fixed point in an array is an index i such that arr[i] == i.

Return the smallest index that satisfies arr[i] == i. 
If there is no such index, return -1.

Input Format:
-------------
Line-1: An integer n, the number of elements in the array.
Line-2: n space-separated integers, representing the elements of the array.

Output Format:
--------------
Line-1: Return a single integer, which is the smallest index i such that arr[i] == i. If no such index exists, return -1.

Constraints:
-------------
1 ≤ n ≤ 10^4
-10^4 ≤ arr[i] ≤ 10^4
The array arr is sorted in strictly increasing order (i.e., no duplicates).


Sample Input-1:
----------------
5
-10 -5 0 3 7

Sample Output-1:
-----------------
3

Explanation: For the array arr = [-10, -5, 0, 3, 7], the index 3 satisfies arr[3] == 3.


Sample Input-2:
---------------
4
0 2 5 8

Sample Output-2:
----------------
0

Explanation: For the array arr = [0, 2, 5, 8], the index 0 satisfies arr[0] == 0.


Sample Input-3:
----------------
6
-10 -5 1 3 6 7

Sample Output-3:
-----------------
-1

Explanation: No index i satisfies arr[i] == i.
 */
import java.util.*;
public class Sp13_FixedPoint {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(fixed(arr, 0, arr.length-1));
        sc.close();
    }
    static int fixed(int[] arr, int s, int e){
        
        if(s>e){
            return -1;
        }
        int mid = s+(e-s)/2;
        if(s==e && s==arr[mid]){
            return arr[mid];
        }
        if(arr[mid]==mid){
            return fixed(arr,s,mid);
        } else if(arr[mid]>mid){
            return fixed(arr,s,mid-1);
        }
        return fixed(arr,mid+1,e);
    }
}

