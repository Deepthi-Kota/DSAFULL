package PreFs.Day46;
/*Mr. Parandamayya is working with Strings.
He is given a String S. He has to find the palindromes in S, 
A palindrome can be a substring of S (Strictly substrings only, not subsequences).

Your task is to find the count the number of palindromes can be formed from S.

NOTE: Count each occurence of palindromes if duplicate substrings found.

Input Format:
-------------
A string S

Output Format:
--------------
Print an integer, number of palindromes.


Sample Input-1:
---------------
divider

Sample Output-1:
----------------
9

Explanation:
-------------
Palindromes are d, i, v, i, d, e, r, ivi, divid


Sample Input-2:
---------------
abcdef

Sample Output-2:
----------------
6

Explanation:
-------------
Palindromes are a, b, c, d, e, f.
 */

import java.util.*;
public class p1{
    static int c = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        find(s,0,s.length());
        System.out.println(c);
        sc.close();
    }
    static void find(String s,int st,int e){
        if (st>=e){
            return;
        }
        for(int i=st+1;i<=e;i++){
            String sub=s.substring(st,i);
            if (isPal(sub)){
                c++; 
            }
        }
        find(s,st+1,e);
    }
    static boolean isPal(String s){
        int l=0;
        int r=s.length()-1;
        while (l< r){
            if (s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
