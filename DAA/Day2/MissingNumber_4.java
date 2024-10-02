package DAA.Day2;
/*
 * Given an array arr containing n distinct numbers taken from the range 1 to n+1
Your task is to find the missing number.
The array contains exactly n numbers from the range 1 to n+1, with one number m
Input Format:
-------------
Line-1: An integer n, represents size of array
Line-2 to n: An integer array of length n, where the elements are distinct and
Output Format:
--------------
Line-1: An integer, the missing number.
Constraints:
------------
The solution must run in O(n) time.
The solution must use O(1) extra space.
The missing number will always be within the range [1, n+1].
Sample Input-1:
---------------
7
8 1 4 3 5 7 6
Sample Output-1:
----------------
2
Sample Input-2:
---------------
4
2 3 4 5
Sample Output-2:
----------------
1
1

 */ 
import java.util.*;
public class MissingNumber_4 {
   
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    int sum=0;
    for(int i=0; i<n; i++){
    arr[i] = sc.nextInt();
    sum+=arr[i];
    }
    int total = ((n+1)*(n+2))/2;
    System.out.println(total-sum);
    sc.close();

    }
}

