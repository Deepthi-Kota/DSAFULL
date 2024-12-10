/* Naresh is working on expression of words.
If you give him an expression like, [p,q,r]s[t,u],
Naresh will form the words like as follows : [pst, psu, qst,qsu, rst, rsu]
Another example, [a,b]c[d,e] will be converted as: [acd, ace, bcd, bce].

Naresh will be given an expression as a string EXP, like the above format.
He needs to return all words that can be formed in like mentioned above, 
Can you help Naresh to convert iven expression into a list of words, in lexicographical order.

NOTE: 
Expression consist of lowercase alphabets, comma, and square brackets only.

Input Format:
-------------
Line-1: A string EXP, expression.

Output Format:
--------------
Line-1: Print list of words, formed from the expression.

Sample Input-1:
---------------
[b]c[e,g]k

Sample Output-1:
----------------
[bcek, bcgk]


Sample Input-2:
---------------
[a,b][c,d]

Sample Output-2:
----------------
[ac, ad, bc, bd]


Sample Input-3:
---------------
[xyz]a[b,c]

Sample Output-3:x   
----------------
[xyzab, xyzac]*/

import java.util.*;
class BraceExpression{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<String[]> parts = new ArrayList<>();
        createparts(parts,s);
        List<String> ans = new ArrayList<>();
        backtrack(0,parts,ans, new StringBuilder());
        Collections.sort(ans);
        System.out.println(ans.toString());
    }
    public static void createparts(List<String[]> parts, String s){
        while(!s.equals("")){
            if(s.charAt(0)=='['){
                int end = s.indexOf(']');
                parts.add(s.substring(1,end).split(","));
                s = s.substring(end+1);
            }else{
                int end = s.indexOf('[');
                if(end!=-1){
                    parts.add(new String[]{s.substring(0,end)});
                    s = s.substring(end);
                }else{
                    parts.add(new String[]{s});
                    break;
                }
            }
        }
    }
    public static void backtrack(int id, List<String[]>parts, List<String> ans , StringBuilder curr){
        if(id==parts.size()){
            ans.add(curr.toString());
            return;
        }
        for(String str: parts.get(id)){
            curr.append(str);
            backtrack(id+1,parts,ans,curr);
            curr.delete(curr.length()-str.length(),curr.length());
        }
    }
}