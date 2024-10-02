package DAA_Syllabus;
//https://leetcode.com/problems/majority-element/description/
/*Given an array nums of size n, return the majority element. 
The majority element is the element that appears more than ⌊n / 2⌋ times.

You may assume that the majority element always exists in the array.

Input Format:
--------------
Line-1: An integer n (the size of the array).
Line-2: n space-separated integers representing the elements of the array.

Output Format:
--------------
Line-1: Output a single integer, the majority element.

Constraints:
-------------
1 ≤ n ≤ 5 * 10^4
-10^9 ≤ nums[i] ≤ 10^9


Sample Input-1:
---------------
3
3 2 3

Sample Output-1:
----------------
3

Explanation:
The number 3 appears more than n/2 times, so it is the majority element.

Sample Input-2:
---------------
7
2 2 1 1 1 2 2

Sample Output-2:
----------------
2

Explanation:
The number 2 appears 4 times, which is more than n/2 = 3.5, so it is the majority element.
 */
import java.util.*;
public class Sp10_MajorityElement {
    public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int [] arr = new int[n];
            for(int i=0;i<n; i++){
                arr[i]= sc.nextInt();
            }
            System.out.println(mergeSort(arr,0,arr.length-1));
            sc.close();
        }
        static int mergeSort(int[] arr, int s, int e){
            if(s==e){
                return arr[s];
            }
            int mid = s+(e-s)/2;
            int left = mergeSort(arr,s,mid);
            int right = mergeSort(arr,mid+1,e);
            if(left == right){
                return left;
            }
            else{
                int lc = CountInArr(arr,left,s,e);
                int rc = CountInArr(arr,right,s,e);
                return lc>rc?left:right;
            }
        }
        static int CountInArr(int[] arr, int target, int s, int e){
            int c=0;
            for(int i=s; i<=e; i++){
                if(arr[i]==target){
                    c++;
                }
            }
            return c;
        }
}
