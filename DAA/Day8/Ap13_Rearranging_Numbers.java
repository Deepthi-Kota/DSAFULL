package DAA.Day8;
/* You are given an array of integers containing both positive and negative values. 
Your task is to rearrange the array such that all negative integers appear before the positive integers while preserving the relative order of the numbers. 
The order of positive and negative integers in the array should remain unchanged, but negatives must come before positives.

Input Format:
--------------
Line-1: An integer n, the number of integers in the array.
Line-2: n integers, which are a mix of positive and negative numbers.

Output Format:
---------------
Line-1: Print the rearranged list of integers where all negative numbers come before the positive numbers while preserving the relative order.

Constraints:
------------
* 1 ≤ n ≤ 10^5 (The size of the array can be up to 100,000 integers).
* The array contains both positive and negative integers. Zero is considered as a positive number.

Sample Input-1:
---------------
8
9 -3 5 -2 -8 -6 1 3

Sample Output-1:
[-3, -2, -8, -6, 9, 5, 1, 3]


Sample Input-2:
---------------
8
5 -4 3 -4 2 1 -5 -6

Sample Output-2:
-----------------
[-4, -4, -5, -6, 5, 3, 2, 1]*/
import java.util.*;
public class Ap13_Rearranging_Numbers {
    public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i]=sc.nextInt();
            }
            mergeSort(arr,0,arr.length-1);
            System.out.println(Arrays.toString(arr));
            
        }
        static void mergeSort(int[] arr, int s, int e){
            if(s>=e){
                return;
            }
            int mid = s+(e-s)/2;
            mergeSort(arr, s, mid);
            mergeSort(arr, mid+1, e);
            merge(arr,s,mid,e);
        }
        
        private static void merge(int[] arr, int s, int mid, int e) {
           int[] mix = new int[e-s+1];
           int i=s; int j=mid+1; int k=0;
           while(i<=mid && j<=e){
                if(arr[i]>=0 && arr[j]<0){
                    mix[k]=arr[j];
                    j++;
                } else if(arr[i]<0 && arr[j]>0){
                    mix[k]=arr[i];
                    i++;
                } else {
                    mix[k]=arr[i];
                    i++;
                }
                k++;
           }
           while(i<=mid){
                mix[k]=arr[i];
                    i++;
                    k++;
           }
           while(j<=e){
                mix[k]=arr[j];
                j++;
                k++;
           }
    
           for(int l=0; l<mix.length; l++){
            arr[s+l]=mix[l];
           }
        }    
}
