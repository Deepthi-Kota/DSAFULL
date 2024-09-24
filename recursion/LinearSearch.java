import java.util.*;
public class LinearSearch {
    public static void main(String[] args) {
        int[] arr ={2,6,6,4,5,61};
        System.out.println(search1(arr, 0,61));
        System.out.println(search2(arr, arr.length-1,61));
        searchAll(arr, 0, 6);
        System.out.println(list);
        System.out.println(searchAll1(arr, 0, 6, null));

        System.err.println(searchAll2(arr, 0, 6));
    }

    static boolean search(int[] arr, int index, int target){
        if(index==arr.length){
            return false;
        }
        return arr[index]==target || search(arr, index+1, target);
    }
    static int search1(int[] arr, int index, int target){
        if(index==arr.length){
            return -1;
        }
        if(arr[index]==target){
            return index;
        }
        else{
            return  search1(arr, index+1, target);
        }
    }
    static int search2(int[] arr, int index, int target){
        if(index==-1){
            return -1;
        }
        if(arr[index]==target){
            return index;
        }
        else{
            return  search2(arr, index-1, target);
        }
    }

    static List<Integer> list= new ArrayList<>(); 
    static void searchAll(int[] arr, int index, int target){
        if(index==arr.length){
            return;
        }
        if(arr[index]==target){
            list.add(index);
        }
        searchAll(arr, index+1, target);
    }

    static ArrayList<Integer> searchAll1(int[] arr, int index, int target, ArrayList<Integer> list){
        if(index==arr.length){
            return list;
        }
        if(arr[index]==target){
            list.add(index);
        }
        return searchAll1(arr, index+1, target, list);
    }

    // VVVVI 
    static ArrayList<Integer> searchAll2(int[] arr, int index, int target){
        ArrayList<Integer> list = new ArrayList<>();
        if(index==arr.length){
            return list;
        }
        //contain answer for that function call only
        if(arr[index]==target){
            list.add(index);
        }
        ArrayList<Integer> ansFromBelowCalls = searchAll2(arr, index+1, target);
        list.addAll(ansFromBelowCalls);

        return list;
        
    }
}
