package DAA.Day11;
/* You are given an integer array nums and an integer k. 
Your task is to split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

A subarray is a contiguous part of the array. You need to return the minimized largest sum of the split.

Input Format:
--------------
Line-1: Integers representing the elements of the array nums, separated by commas.
Line-2: An integer k, representing the number of subarrays to split nums into.

Output Format:
---------------
Line-1: Print a single integer representing the minimized largest sum after splitting the array into k subarrays.

Constraints:
-------------
1 ≤ nums.length ≤ 1000
0 ≤ nums[i] ≤ 10^6
1 ≤ k ≤ min(50, nums.length)

Sample Input-1:
---------------
7,2,5,10,8
2

Sample Output-1:
----------------
18

Explanation:
There are four ways to split nums into two subarrays. The best way is to split it into [7, 2, 5] and [10, 8], where the largest sum among the two subarrays is only 18.


Sample Input-2:
---------------
1,2,3,4,5
2

Sample Output-2:
----------------
9

Explanation:
The best way to split nums into two subarrays is [1, 2, 3] and [4, 5], where the largest sum is 9.*/
import java.util.*;
public class AP19_Split_Array_with_Minimized_LargestSum {
    public static int bs(int arr[],int low,int high,int b)
        {
            int res=-1;
            while(low<=high)
            {
                int mid=(low+high)/2;
                int c=0;
                int days=0;
                for(int i=0;i<arr.length;i++)
                {
                    c+=arr[i];
                    if(c>mid)
                    {
                        days++;
                        c=arr[i];
                    }
                }
                days++;
                if(days<=b)
                {
                    res=mid;
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
            return res;
        }
        
        public static int call(int[] arr,int a,int b)
        {
            int low=0;
            for(int i=0;i<arr.length;i++)
            {
                low=Math.max(arr[i],low);
            }
            int high=0;
            for(int i=0;i<a;i++)
            {
                high+=arr[i];
            }
            int from=bs(arr,low,high,b);
            return from;
        }
        
        public static void main(String args[])
        {
            Scanner sc= new Scanner(System.in);
            String[] a=sc.next().split(",");
            int[] arr = new int[a.length];
            for(int i=0; i<a.length; i++){
                arr[i]=Integer.parseInt(a[i]);
            }
            int b=sc.nextInt();
            int ans=call(arr,a.length,b);
            System.out.println(ans);
            sc.close();
        }
}
