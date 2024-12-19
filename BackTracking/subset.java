import java.util.*;
public class subset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> ans2 = new ArrayList<>();
        subsets(0,arr,new ArrayList<>(), ans);
        Arrays.sort(arr);
        subsetWdups(0,arr,new ArrayList<>(),ans2);
        System.out.println(ans);
        System.out.println(ans2);
        sc.close();

    }
    static void subsets(int h, int[] arr, List<Integer> list, List<List<Integer>> ans){
        ans.add(new ArrayList<>(list));
        for(int i=h; i<arr.length; i++){
            list.add(arr[i]);
            subsets(i+1, arr, list, ans);
            list.remove(list.size()-1);
        }
    }
    static void subsetWdups(int h, int[] arr, List<Integer> list, List<List<Integer>> ans){
        ans.add(new ArrayList<>(list));
        for(int i=h; i<arr.length; i++){
            if(i>h && arr[i]==arr[i-1]){
                continue;
            }
            list.add(arr[i]);
            subsets(i+1, arr, list, ans);
            list.remove(list.size()-1);
        }
    }


}
