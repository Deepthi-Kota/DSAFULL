package BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};
        System.out.println(search(20, arr));

    }
    static int search(int target,int[] arr){
        int s = 0;
        int e = arr.length-1;
        if(s>e){
            return -1;
        }
        while(s<=e){
            int m = s + (e-s)/2;
            if(target<arr[m]){
                e = m-1;
            }
            else if(target> arr[m]){
                s=m+1;
            }
            else{
                return m;
            }
        }
        return -1;

    }
}
