package PreFs.Day32;
//1079
/* There are some cubes, and each cube has an alphabet (from A to Z) 
printed on it. You can construct different, non-empty words using these 
cubes and each of the word length should be 0 < length <= number of cubes.

You are given a string of alphabets S, 
Your task is to findout number of possible non-empty distinct words

Input Format:
-------------
A string S, consist of A-Z letters only.

Output Format:
--------------
Print an integer, number of possible non-empty distinct words.


Sample Input-1:
---------------
EGG

Sample Output-1:
----------------
8

Explanation:
--------------
The possible distinct words are "E", "G", "EG", "GG", "GE", "EGG", "GEG", "GGE".


Sample Input-2:
---------------
MADAM

Sample Output-2:
----------------
89
*/

import java.util.*;
public class p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine(); 
        List<String> combi = new ArrayList<>();
        Combis(s,"",combi);
        int c= 0;
        Set<String> u = new HashSet<>(); 
        for(String a : combi){
            c+= permuCount("",a,u);
        }
        System.out.println(c); 
        sc.close();
    }
    static void Combis(String p, String res, List<String> combi){
        if(!res.isEmpty()){
            combi.add(res);
        }
        for(int i=0; i<p.length(); i++){
            Combis(p.substring(i+1), res + p.charAt(i),combi);
        }
    }
    static int permuCount(String p, String up, Set<String> u){ 
        if(up.isEmpty()){
            if(u.add(p)){ 
                return 1;
            }
            return 0;
        }
        int count= 0;
        char ch = up.charAt(0);
        for(int i = 0; i<=p.length(); i++){
            String f = p.substring(0, i);
            String s = p.substring(i);
            count+= permuCount(f+ch+s,up.substring(1), u);
        }
        return count;
    }
}
