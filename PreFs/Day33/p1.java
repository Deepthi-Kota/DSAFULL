package PreFs.Day33;
//17
/* Given a classic mobile phone, and the key pad of the phone looks like below.
    1		2		3
           abc	   def
         
    4		5		6
    ghi    jkl     mno
  
    7		8		9
    pqrs    tuv     wxyz
    
    *		0		#


You are given a string S contains digits between [2-9] only, 
For example: S = "2", then the possible words are "a", "b", "c".

Now your task is to find all possible words that the string S could represent.
and print them in a lexicographical order. 

Input Format:
-------------
A string S, consist of digits [2-9]

Output Format:
--------------
Print the list of words in lexicographical order.


Sample Input-1:
---------------
2

Sample Output-1:
----------------
[a, b, c]


Sample Input-2:
---------------
24

Sample Output-2:
----------------
[ag, ah, ai, bg, bh, bi, cg, ch, ci]
*/

import java.util.*;
class p1 {
    public static void main(String[] args){ 
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        HashMap<Character,String> m = new HashMap<>();
        m.put('2',"abc");
        m.put('3',"def");
        m.put('4',"ghi");
        m.put('5',"jkl");
        m.put('6',"mno");
        m.put('7',"pqrs");
        m.put('8',"tuv");
        m.put('9',"wxyz");
        System.out.println(combi("",s,m));
        sc.close();
    }

    static List<String> combi(String p, String up, HashMap<Character,String> m){
        if(up.isEmpty()){
            List<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        char ch = up.charAt(0);
        String s = m.get(ch);
        List<String> ans = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            ans.addAll(combi(p+s.charAt(i), up.substring(1),m));
        }
        return ans;
    }
}