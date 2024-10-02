package PreFs.Day5;
/*A warehouse stores boxes of different weights that need to be transported to 
different distribution centers across multiple cities. The boxes are stored in 
the order in which they were manufactured, and they must be transported in 
this specific order. Each day, a truck is sent to pick up a load of boxes from 
the warehouse. However, the truck has a limited carrying capacity based on its 
maximum weight limit.

You are tasked with determining the minimum weight capacity of the truck that 
will allow all the boxes to be shipped in the given number of days without 
violating the order in which the boxes are loaded. Each day, the truck can load
as many boxes as possible without exceeding its weight capacity.

Input Format:
-------------
line-1: two space separated integers, N boxes, and number of days.
line-2: N space separated integers, weights of boxes.

Sample Input-1: 
---------------
5 2
7 2 5 10 8

Sample Output-1:
----------------
18

Explanation:
-------------
A truck capacity of 18 is the minimum to transport all the boxes 
in 2 days as follows:

1st day: 7, 2, 5 (total weight: 14)
2nd day: 10, 8 (total weight: 18)
With a capacity less than 18, it is impossible to ship all the boxes in 
the given number of days without exceeding the truck's weight capacity.


Sample Input-2: 
---------------
8 4
1 5 6 7 3 2 9 4

Sample Output-2:
----------------
12

Explanation:
------------
A truck capacity of 12 is the minimum to transport all the boxes in 4 days as follows:

1st day: 1, 5, 6 (total weight: 12)
2nd day: 7, 3, 2 (total weight: 12)
3rd day: 9 (total weight: 9)
4th day: 4 (total weight: 4)
 */
import java.util.*;
public class p2_ {
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
        int a=sc.nextInt();
        int b=sc.nextInt();
        int[] arr= new int[a];
        for(int i=0;i<a;i++)
        {
            arr[i]=sc.nextInt();
        }
        int ans=call(arr,a,b);
        System.out.println(ans);
    }
}
