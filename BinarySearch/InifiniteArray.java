package BinarySearch;

public class InifiniteArray {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9,10};
        System.out.println(search(arr, 10));
    }
    static int search(int arr[],int target){
        int s = 0;
        int e = 1;
        while(target>e){
            s = e+1;
            e = e+(e-s+1)*2;
        }
        return BinarySearch(target, arr, s, e);

    }
    static int BinarySearch(int target,int[] arr, int s, int e){
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
