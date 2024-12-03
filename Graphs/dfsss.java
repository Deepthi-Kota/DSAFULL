package Graphs;
import java.util.*;
public class dfsss {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        List<List<Integer>> adjlist = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjlist.add(new ArrayList<>());
        }
        for(int i=0; i<e; i++){
            addedge(adjlist, sc.nextInt(), sc.nextInt());
        }
        System.out.println(adjlist);
        List<Integer> dfs = new ArrayList<>();
        boolean[] vis = new boolean[n];
        dfss(adjlist, 0, dfs, vis);
        System.out.println(dfs);
        sc.close();
    }

    static void dfss(List<List<Integer>> adjList, int start, List<Integer> ans, boolean[] vis){
        ans.add(start);
        vis[start]=true;
        for(int x: adjList.get(start)){
            if(!vis[x]){
                dfss(adjList, x, ans, vis);
            }
        }
    }

    static void addedge(List<List<Integer>> adList, int i, int j){
        adList.get(i).add(j);
        if(i!=j){
            adList.get(j).add(i);
        }
    }
}