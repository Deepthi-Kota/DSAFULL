package BinarySearch;

public class CeilAndFloor {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};
        System.out.println("ceil: "+ ceil(arr, 100, 0, 4));
        System.out.println("floor: "+floor(arr, 2, 0, 4));
    }


    static int ceil(int arr[], int target, int s, int e){
        if(s>e){
            return arr[s];
        }
        //what if target is greater than the greatest element in the array
        if(target>arr[arr.length-1]){
            return -1;
        }
        int m = s + (e-s)/2;
        if(arr[m]==target){
            return arr[m];
        }
        if(target<arr[m]){
            return ceil(arr, target, s, m-1);
        }
        return ceil(arr, target, m+1, e);
    }

    static int ceil1(int target,int[] arr){
        if(target>arr.length-1){
            return -1;
        }
        int s = 0;
        int e = arr.length-1;
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
        return s;

    }


    static int floor(int arr[], int target, int s, int e){
        if(s>e){
            return arr[e];
        }
        //what if target is smaller than the smallest element in the array
        if(target<arr[0]){
            return -1;
        }
        int m = s + (e-s)/2;
        if(arr[m]==target){
            return arr[m];
        }
        if(target<arr[m]){
            return floor(arr, target, s, m-1);
        }
        return floor(arr, target, m+1, e);
    }
}
