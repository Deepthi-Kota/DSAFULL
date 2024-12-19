//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.increasingNumbers(n);

            IntArray.print(res);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends





class Solution {
    public static ArrayList<Integer> increasingNumbers(int n) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        find(n,ans);
        return ans;
    }
    static void find(int n, ArrayList<Integer> ans){
        if(n==1){
            for(int i=0; i<=9; i++){
                ans.add(i);
            }
            return;
        }
        find(n-1,ans);
        ArrayList<Integer> temp = new ArrayList<>();
        for(int num: ans){
            if(num==0){
                continue;
            }
            int lastdig = num%10;
            for(int i=lastdig+1; i<=9; i++){
             temp.add(num*10+i);   
            }
        }
        ans.addAll(temp);
    }
    
}
