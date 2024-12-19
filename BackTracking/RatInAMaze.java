public class RatInAMaze {
    
}
//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        sc.nextLine();        // Consume the newline character

        while (t-- > 0) {
            String input = sc.nextLine();

            // Replace ][ with ],[
            input = input.replace("][", "],[");

            ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
            String[] rows = input.split("],\\s*\\[");

            for (String row : rows) {
                row = row.replaceAll("[\\[\\]]", ""); // Remove any surrounding brackets
                ArrayList<Integer> intRow = new ArrayList<>();
                for (String num : row.split(",")) {
                    intRow.add(Integer.parseInt(num.trim()));
                }
                mat.add(intRow);
            }

            Solution obj = new Solution();
            ArrayList<String> result = obj.findPath(mat);

            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (String res : result) {
                    System.out.print(res + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find all possible paths
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        // code here
        ArrayList<String> ans = new ArrayList<>();
        boolean[][] vis = new boolean[mat.size()][mat.get(0).size()];
        find(mat,0,0,"", ans,vis);
        return ans;
    }
    void find(ArrayList<ArrayList<Integer>> arr, int r, int c, String p, ArrayList<String> ans,boolean[][] vis){
        if(r==arr.size()-1 && c==arr.get(0).size()-1){
            ans.add(p);
            return;
        }
        if(r<0 || r>=arr.size() || c<0 || c>=arr.get(0).size() || vis[r][c] || arr.get(r).get(c)==0){
            return;
        }
        vis[r][c]=true;
        find(arr,r+1,c,p+'D',ans,vis);
        find(arr,r,c-1,p+'L',ans,vis);
        find(arr,r,c+1,p+'R',ans,vis);
        find(arr,r-1,c,p+'U',ans,vis);
        vis[r][c]=false;
        
    }
}