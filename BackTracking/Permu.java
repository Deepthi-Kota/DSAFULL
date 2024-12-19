import java.util.*;
public class Permu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        HashSet<List<Integer>> hs = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> ans1 = new ArrayList<>();
        List<List<Integer>> ans2 = new ArrayList<>();
        boolean[] vis = new boolean[n];
        //for non duplicate
        permu(arr,new ArrayList<>(), ans,vis);
        //for duplicates
        permuWDup(arr, new ArrayList<>(), ans1, vis,hs);
        permuWDup2(arr, new ArrayList<>(), ans2, vis);
        System.out.println(ans);
        System.out.println(ans1);
        System.out.println(ans2);
        sc.close();
    }
    static void permu(int[] arr, List<Integer> list, List<List<Integer>>ans, boolean[] vis){
        if(list.size()==arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0; i<arr.length; i++){
            if(!vis[i]){
                vis[i]=true;
                list.add(arr[i]);
                permu(arr, list, ans, vis);
                list.remove(list.size()-1);
                vis[i]=false;
            }
        }
    }
    static void permuWDup(int[] arr, List<Integer> list, List<List<Integer>>ans, boolean[] vis, HashSet<List<Integer>> hs){
        if(list.size()==arr.length){
            if(!hs.contains(list)){
                hs.add(list);
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        for(int i=0; i<arr.length; i++){
            if(!vis[i]){
                vis[i]=true;
                list.add(arr[i]);
                permuWDup(arr, list, ans, vis, hs);
                list.remove(list.size()-1);
                vis[i]=false;
            }
        }
    }
    static void permuWDup2(int[] arr, List<Integer> list, List<List<Integer>>ans, boolean[] vis){
        if(list.size()==arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0; i<arr.length; i++){
            if(i>0 && arr[i]==arr[i-1] && !vis[i-1]){
                continue;
            }
            if(!vis[i]){
                vis[i]=true;
                list.add(arr[i]);
                permuWDup2(arr, list, ans, vis);
                list.remove(list.size()-1);
                vis[i]=false;
            }
        }
    }
}
