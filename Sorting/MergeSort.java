package Sorting;
import java.util.*;
public class MergeSort {
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1,6,7,8};
        mergerSortInPlace(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(mergesort(arr)));
    }
    static int[] mergesort(int[] arr){
        //through recursion, a new array is returned
        if(arr.length==1){
            return arr;
        }
        int mid = arr.length/2;
        int[] first = mergesort(Arrays.copyOfRange(arr,0,mid));
        int[] second = mergesort(Arrays.copyOfRange(arr,mid,arr.length));

        return merge(first,second);
    }

    static void mergerSortInPlace(int[] arr, int s, int e){
        if(e-s==1){
            return;
        }
        int mid = s+(e-s)/2;
        mergerSortInPlace(arr, s, mid);
        mergerSortInPlace(arr, mid, e);
        mergeInPlace(arr,s,mid,e);
    }
    
    private static void mergeInPlace(int[] arr, int s, int mid, int e) {
       int[] mix = new int[e-s];
       int i=s; int j=mid; int k=0;
       while(i<mid && j<e){
            if(arr[i]<arr[j]){
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
        arr[s+l]=mix[l];
       }
    }
    private static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length+second.length];
        int i=0; int j=0; int k=0;
        while(i<first.length && j<second.length){
            if(first[i]<second[j]){
                mix[k]=first[i];
                i++;
            } else{
                mix[k]=second[j];
                j++;
            }
            k++;
        }
        while(i<first.length){
            mix[k]=first[i];
            i++;
            k++;
        }
        while(j<second.length){
            mix[k]=second[j];
            j++;
            k++;
        }
        return mix;
    }
}
