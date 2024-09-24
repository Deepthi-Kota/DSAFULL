public class IsArraySorted {
    public static void main(String[] args){
        int[] arr ={2,6,4,5,6};
        System.out.println(isSorted(arr, 0));

    }
    static boolean isSorted(int[] arr, int n){
        if(n==arr.length-1){
            return true;
        } 
        return arr[n]<arr[n+1] && isSorted(arr, n+1);
    }
}
