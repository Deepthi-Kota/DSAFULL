package DAA.Day27;
/* You are given a string of uppercase English letters representing letter tiles. Each letter tile can be used once per combination. 
Your task is to determine the total number of possible sequences that can be formed using these letter tiles.

Rules:
    -The order of letters in a sequence matters.
    -A sequence can consist of any number of tiles (from 1 to the total number of tiles).
    -Duplicate tiles may lead to duplicate sequences, so consider each sequence as unique.

Input Format:
-------------
Line-1: A string tiles, where 1 ≤ tiles.length ≤ 7 and each character is an uppercase English letter.

Output Format:
--------------
Line-1: An integer representing the total number of unique sequences that can be formed.

Sample Input-1:
---------------
AAB

Sample Output-1:
----------------
8

Explanation:
The sequences are: A, B, AA, AB, BA, AAB, ABA, BAA.

Sample Input-2:
---------------
AAABBC

Sample Output-2:
----------------
188
*/

import java.util.*;
public class AP36_Tile_Possibility{
    static int c = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        boolean[] vis = new boolean[s.length()];
        HashSet<String> hs = new HashSet<>();
        count("",s,vis,hs);
        System.out.println(c);
        sc.close();
    }
    static void count(String p, String s, boolean[] vis, HashSet<String> hs){
        if(!p.isEmpty()){
            if(!hs.contains(p)){
                // System.out.println(p);
                hs.add(p);
                c++;
            }
        }
        for(int i=0; i<s.length(); i++){
            if(!vis[i]){
                vis[i]=true;
                count(p+s.charAt(i),s, vis,hs);
                vis[i]=false;
            }
        }
    }
}