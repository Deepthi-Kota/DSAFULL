package PreFs.Day34;
/* Mr Parandhamayya working with words.
He is given a word W, you need to divide the word into N non-empty parts, 
such that all the newly formed words should be distinct, and 
if you append all those words should form original word W.

Your task is to help Mr Parandhamayya to divide the word into N parts,
such that, the value of N should be maximized, and print N.

Input Format:
-------------
Line-1: A string W, a word.

Output Format:
--------------
Print an integer result, the value of N.


Sample Input-1:
---------------
banana

Sample Output-1:
----------------
4

Explanation: 
------------
One way to divide the word is "b","a","n","ana".
If you divide it like "b","a","n","an","a".The word "a" will be repeated.
So it is not allowed to divide like the second way.


Sample Input-2:
---------------
mississippi

Sample Output-2:
----------------
7

Explanation: 
------------
One of the way to divide the word is "m","i","s","si","ssi","p","pi".

NOTE: Subsequences are not allowed.
*/
import java.util.*;
class p2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        HashSet<String> set = new HashSet<>();
        System.out.println(subs("",s,set));
        sc.close();
    }
    static int subs(String p, String s, HashSet<String>set){
        if(s.isEmpty()){
            return set.size();
        }
       p+=s.charAt(0);
       int maxi = 0;
       if(!set.contains(p)){
        set.add(p);
        maxi = Math.max(maxi,subs("",s.substring(1),set));
        set.remove(p);
       }
       maxi = Math.max(maxi,subs(p,s.substring(1),set));
       return maxi;
    }
}