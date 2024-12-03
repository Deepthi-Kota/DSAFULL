package Graphs;
import java.util.*;
public class bfs{

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
        List<Integer> bfs = bfss(adjlist, 0);
        System.out.println(bfs);
        sc.close();
    }

    static List<Integer> bfss(List<List<Integer>> adjList, int start){
        boolean[] vis = new boolean[adjList.size()];
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        q.offer(start);
        vis[start]=true;
        while(!q.isEmpty()){
            int n = q.poll();
            ans.add(n);
            for(int i: adjList.get(n)){
                if(!vis[i]){
                    q.offer(i);
                    vis[i]=true;
                }
            }
        }
        return ans;
    }

    static void addedge(List<List<Integer>> adList, int i, int j){
        adList.get(i).add(j);
        if(i!=j){
            adList.get(j).add(i);
        }
    }
}