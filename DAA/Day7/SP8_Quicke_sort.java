package DAA.Day7;
/*You are given an unsorted array of integers. 
Your task is to implement the QuickSort algorithm to sort the array in ascending order.

QuickSort is a divide-and-conquer algorithm that:
    -Picks an element as a pivot and partitions the given array around the pivot.
    -Recursively applies the same process to the subarrays on the left and right of the pivot.
    -You need to implement QuickSort using the Lomuto partition scheme (where the pivot is chosen as the last element of the array).

Input Format:
-------------
Line-1: An integer n (the size of the array).
Line-2: n space-separated integers representing the elements of the array.

Output Format:
---------------
Line-1: Output the sorted array in a single line, with each element separated by a space.

Constraints:
------------
1 ≤ n ≤ 10^5
-10^9 ≤ arr[i] ≤ 10^9


Sample Input-1:
---------------
6
10 7 8 9 1 5

Sample Output-1:
----------------
1 5 7 8 9 10


Sample Input-2:
---------------
5
3 2 1 5 4

Sample Output-2:
----------------
1 2 3 4 5 */
import java.util.*;
public class SP8_Quicke_sort {
    public static void swap(int a[],int i,int j)
      {
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
      }
      public static int part(int a[],int low,int high)
      {
        int pivot=a[high];
        int k=low;
        for(int i=low;i<high;i++)
        {
          if(a[i]<pivot)
          {
            swap(a,i,k);
            k++;
          }
        }
        swap(a,high,k);
        return k;
      }
      public static void quick(int a[],int low,int high)
      {
        if(low<high)
        {
          int j=part(a,low,high);
          quick(a, low, j-1);
          quick(a, j+1, high);
        }
      }
        public static void main(String[] args) {
          Scanner sc =new Scanner(System.in);
          int n=sc.nextInt();
          int[] a= new int[n];
          for(int i=0;i<n;i++)
          {
            a[i]=sc.nextInt();
          }
          quick(a, 0, n-1);
          for(int i=0;i<n;i++)
          {
            System.out.println(a[i]);
          }
          sc.close();
        }
}
