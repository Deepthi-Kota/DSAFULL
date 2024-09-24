package Sorting;

import java.util.Arrays;
/*
 * stable algorithm
 * space complexity - O(1) - constant
 * time complexity - O(N^2) - worst
 *                   O(N) - best
 * AKA - sinking algorithm
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void bubbleSort(int[] arr){
        boolean swapped;
        for(int i=0; i<arr.length; i++){
            swapped = false;
            for(int j=1; j<arr.length-i; j++){
                if(arr[j]<arr[j-1]){
                    //swap
                    int temp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
                //if for one round of i if there is no swap then the array is sorted we can return the array
            }
        }
    }
}
