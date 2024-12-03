package DAA.Day27;
/* With the growing trend of shorthand writing, 
people often replace parts of a word with their lengths to create short-forms. 
A valid short-form can be created by replacing non-overlapping and non-adjacent substrings with their respective lengths.

You are given a word as input. 
Your task is to generate all possible short-forms of the given word and return them in lexicographical order.

Input Format:
--------------
Line-1: A single string W representing the word.

Output Format:
---------------
A list of strings representing all possible short-forms of the word W in lexicographical order.

Constraints:
-------------
1 ≤ len(W) ≤ 10
The word W consists of lowercase English letters only.

Sample Input-1:
---------------
kmit

Sample Output-1:
----------------
[1m1t, 1m2, 1mi1, 1mit, 2i1, 2it, 3t, 4, k1i1, k1it, k2t, k3, km1t, km2, kmi1, kmit]


Sample Input-2:
---------------
cse

Sample Output-2:
----------------
[1s1, 1se, 2e, 3, c1e, c2, cs1, cse]*/
public class SP37_Generalized_Abbreviation {
    
}
import java.util.*;
public class GenerateAbbreviations{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String sb = "";
        for(int i=0; i<s.length(); i++){
            sb+="0";
        }
        List<String> ans = new ArrayList<>();
        call("",sb,s,ans);
        Collections.sort(ans);
        System.out.println(ans);
    }
    static void call(String p, String up, String s, List<String> ans){
        if(up.isEmpty()){
            int c=0;
            StringBuilder res = new StringBuilder();
            for(int i=0; i<s.length(); i++){
                if(p.charAt(i)=='1'){
                    c++;
                }else{
                    if(c>0){
                        res.append(c);
                        c=0;
                    }
                    res.append(s.charAt(i));
                }
            }
                if(c>0){
                    res.append(c);
                }
            ans.add(res.toString());
            return;
        }
        int ch = up.charAt(0)-'0';
        call(p+ch, up.substring(1),s,ans);
        call(p+(1-ch), up.substring(1),s,ans);
    }
}