package BinarySearch;
import java.util.*;
public class RowAndCol {
    public static void main(String[] args) {
        int[][] arr = {{10,20,30},{15,25,36},{17,28,39}};
        System.out.println(Arrays.toString(search(arr, 36)));
    }
    static int[] search(int[][] arr, int target){
        int r=0;
        int c=arr.length-1;
        while(r<arr.length && c>=0){
            if(arr[r][c]==target){
                return new int[]{r,c};
            }
            if(arr[r][c]<target){
                r++;
            }
            else{
                c--;
            }
        }
        return new int[]{-1,-1};
    }
}
