package PreFs.Day26;
/* Mahalakshmi is participating in a treasure hunt that includes N boxes, each 
numbered sequentially from 0 to N-1. Initially, all the boxes are locked with 
unique passcodes, except for Box-0, which is unlocked.

Each box in the treasure hunt contains a list of envelopes, with each envelope 
holding the passcode to unlock a different box. The envelope is labeled with 
the box number it can unlock.

Mahalakshmi can open the boxes in any order, but she must start with Box-0.

The goal of the treasure hunt is to unlock all the boxes. Your task is to 
determine if Mahalakshmi can open every box and win the game.

If she can unlock all the boxes, print "Win". Otherwise, print "Lost".

Input Format:
-------------
Line-1: An integer, number of boxes.
Next N lines: space separated integers, box numbers.

Output Format:
--------------
Print a string value, Win or Lost


Sample Input-1:
---------------
5
1
2
3
4
3

Sample Output-1:
----------------
Win

Sample Input-2:
---------------
4
1 3
3 0 1
2
0

Sample Output-2:
----------------
Lost
*/
import java.util.*;
public class p1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<List<String>> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            String[] s = sc.nextLine().split(" ");
            arr.add(Arrays.asList(s));
        }
        Queue<String> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        q.add("0");
        vis[0]=true;
        while(!q.isEmpty()){
            String k = q.poll();
            int x = Integer.parseInt(k);
            for(String s: arr.get(x)){
                int y = Integer.parseInt(s);    
                if(!vis[y]){
                    q.add(s);
                    vis[y]=true;
                    // System.out.println(s);
                }
            }
        }
        boolean b = true;
        for(int i=0; i<n; i++){
            // System.out.println(vis[i]);
            b = b& vis[i];
        }
        if(b){
            System.out.println("Win");
        }else{
            System.out.println("Lost");
        }
        sc.close();
    }
}