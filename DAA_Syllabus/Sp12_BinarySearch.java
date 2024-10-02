package DAA_Syllabus;
//https://leetcode.com/problems/binary-search/description/
/*You are given a sorted array of integers and a target integer. 
Your task is to write a program that uses binary search to find the index of the target integer in the array. 
If the target is found, return its index. If the target is not found, return -1.

Your solution must have a time complexity of O(log n), where n is the number of elements in the array.

Input Format:
--------------
Line-1: An integer n (the number of elements in the array).
Line-2: n space-separated integers, representing the sorted array.
Line-3: An integer target, the value you need to search for in the array.

Output Format:
---------------
Line-1: Print a single integer, which is the index of the target element in the array. If the target is not found, print -1.

Constraints:
-------------
1 ≤ n ≤ 10^6 (size of the array)
-10^9 ≤ arr[i], target ≤ 10^9 (array elements and target value)
The array is sorted in non-decreasing order.


Sample Input-1:
---------------
6
1 3 5 7 9 11
5

Sample Output-1:
----------------
2

Explanation:
The target 5 is found at index 2.


Sample Input-2:
---------------
5
2 4 6 8 10
7

Sample Output-2:
----------------
-1

Explanation:
The target 7 is not found in the array, so the output is -1. 
*/
import java.util.*;
public class Sp12_BinarySearch {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        int t = sc.nextInt();
        System.out.println(Bs(arr,t,0,arr.length-1));
        sc.close();
    }
    static int Bs(int[] arr, int t, int s, int e){
        if(s>e){
            return -1;
        }
        int mid = s+(e-s)/2;
        if(t==arr[mid]){
            return mid;
        }
        if(t<arr[mid]){
            return Bs(arr,t,s,mid-1);
        }
        return Bs(arr,t,mid+1,e);
    }
}

