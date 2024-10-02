package DAA.Day10;
/*In a school, the 5th standard class is divided into two sections, Rose and Lotus. 
The teacher has recorded the scores of students from both sections in their Mathematics exam. 
The marks for both sections are provided in ascending order. 
The task is to compute the median of the combined marks of both sections.

You are given the number of students in each section and their respective marks. Your task is to find the median of the combined sorted marks from both sections.

The overall run-time complexity of your solution should be O(log(min(m + n))).

Input Format:
-------------
Line-1: An integer m, representing the number of students in section Rose.
Line-2: An integer n, representing the number of students in section Lotus.
Line-3: m space-separated integers, representing the scores of students in section Rose, sorted in ascending order.
Line-4: n space-separated integers, representing the scores of students in section Lotus, sorted in ascending order.

Output Format:
--------------
Line-1: Print a single float representing the median of the combined sorted marks from both sections.

Constraints:
------------
0 ≤ m, n ≤ 1000
The marks of students are in the range 0 ≤ marks ≤ 100.
Time complexity: O(log(min(m + n)))
Space complexity: O(1)

Sample Input-1:
---------------
4
6
32 45 70 95
40 50 59 67 73 84

Sample Output-1:
----------------
63.0

Explanation: The combined sorted marks are: [32, 40, 45, 50, 59, 67, 70, 73, 84, 95].
The median is 63.0.


Sample Input-2:
---------------
5
6
10 20 30 40 50
35 44 60 70 80 90

Sample Output-2:
----------------
44.0

Explanation: The combined sorted marks are: [10, 20, 30, 35, 40, 44, 50, 60, 70, 80, 90].
The median is 44.0.

Sample Input-3:
---------------
4
6
3 6 8 10
14 17 20 33 44 55

Sample Output-3:
-----------------
15.5

Explanation: The combined sorted marks are: [3, 6, 8, 10, 14, 17, 20, 33, 44, 55].
The median is (10 + 14) / 2 = 15.5.


Sample Input-4:
----------------
3
5
50 60 80
7 10 20 30 40

Sample Output-4:
----------------
35.0

Explanation: The combined sorted marks are: [7, 10, 20, 30, 40, 50, 60, 80].
The median is 35.0. */
import java.util.*;
public class Sp16_Median_of_2SortedArrays {
    public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr1[] = new int[n];
            int arr2[] = new int[m];
            for(int i=0; i<n; i++){
                arr1[i]=sc.nextInt();
            }
            for(int i=0; i<m; i++){
                arr2[i]=sc.nextInt();
            }
            System.out.println(findMedianSortedArrays(arr1,arr2));
            sc.close();
        }
        static double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if(nums1.length<=nums2.length){
                return find(nums1,nums2);
            }
            return find(nums2,nums1);
        }
        static double find(int[] arr1, int[] arr2){
            int l=0;
            int h = arr1.length;
            while(l<=h){
                int mid1 = l+(h-l)/2;
                int mid2 = (arr1.length+arr2.length+1)/2-mid1;
                int l1 = (mid1==0) ? Integer.MIN_VALUE:arr1[mid1-1];
                int r1 = (mid1==arr1.length)? Integer.MAX_VALUE :arr1[mid1];
                int l2 = (mid2==0) ? Integer.MIN_VALUE : arr2[mid2-1];
                int r2 = (mid2==arr2.length) ? Integer.MAX_VALUE:arr2[mid2] ;
                if(l1>r2){
                    h=mid1-1;
                } else if(l2>r1){
                    l=mid1+1;
                } else {
                    if((arr1.length + arr2.length)%2==0){
                        return (Math.max(l1,l2)+Math.min(r1,r2)) /2.0;
                    }
                    else{
                        return Math.max(l1,l2);
                    }
                }
            }
            return -1;
        }
}
