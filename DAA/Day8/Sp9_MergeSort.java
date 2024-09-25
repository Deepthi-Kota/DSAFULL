package DAA.Day8;
/* 
You are given an unsorted array of integers. 
Your task is to implement the MergeSort algorithm to sort the array in ascending order.

MergeSort is a divide-and-conquer algorithm that:
    -Divides the array into two halves.
    -Recursively sorts the two halves.
    -Merges the two sorted halves to produce the final sorted array.
    -Your task is to write a function that sorts the given array using MergeSort.

Input Format:
--------------
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
12 11 13 5 6 7

Sample Output-1:
----------------
5 6 7 11 12 13


Sample Input-2:
---------------
5
10 1 2 8 5

Sample Output-2:
----------------
1 2 5 8 10
*/
import java.util.*;
public class Sp9_MergeSort {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        mergeSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
        sc.close();
    }
    static void mergeSort(int[] arr, int s, int e){
        if(e-s==1){
            return;
        }
        int mid = s+(e-s)/2;
        mergeSort(arr,s,mid);
        mergeSort(arr,mid,e);
        merge(arr,s,mid,e);
    }
    static void merge(int[] arr, int s, int mid, int e){
        int[] mix = new int[e-s];
        int i=s; int j=mid; int k=0;
        while(i<mid && j<e){
            if(arr[i] < arr[j]){
                mix[k]=arr[i];
                i++;
            } else{
                mix[k]=arr[j];
                j++;
            }
            k++;
        }
        while(i<mid){
            mix[k]=arr[i];
            i++;
            k++;
        }
        while(j<e){
            mix[k]=arr[j];
            j++;
            k++;
        }
        for(int l=0; l<mix.length; l++){
            arr[l+s]=mix[l];
        }
        
    }
}

