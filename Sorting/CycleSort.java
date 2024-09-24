package Sorting;
import java.util.*;
public class CycleSort {
    /*
     * n elements
     * space complexity - O(1)
     * Time complexity - O(n)
     */
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        cycle1(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void cycle(int[] arr){
        int i=0;
        while(i<arr.length){
            if(arr[i]-1!=i){
                swap(arr,i,arr[i]-1);
            } else{
                i++;
            }
        }
    }

    static void cycle1(int[] arr){
        int i=0;
        while(i<arr.length){
            int correct = arr[i]-1;
            if(arr[i] != arr[correct]){
                swap(arr, i, correct);
            } else {
                i++;
            }
        }
    }
    static void swap(int[] arr, int f, int s){
        int temp = arr[f];
        arr[f]=arr[s];
        arr[s]=temp;
    }
}
