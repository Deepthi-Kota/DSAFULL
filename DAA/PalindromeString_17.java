package DAA;
/*
 * In your English exam, there is a question that asks you to check whether a given string is a palindrome. Using your programming skills, you need to write a program that prints True if the string is the same when reversed, and False otherwise.

A palindrome is a word, phrase, or sequence that reads the same backward as forward.

Input Format:
--------------
Line-1: A single string str, which may contain lowercase letters.

Output Format:
---------------
Line-1: Print True if the string is a palindrome, otherwise print False.

Constraints:
------------
The string can contain up to 1000 characters.


Sample Input-1: 
---------------
liril

Sample Output-1: 
----------------
True

Sample Input-2: 
---------------
genesis

Sample Output-2: 
----------------
False
 */
import java.util.*;
public class PalindromeString_17 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        if(isPalindrome(s,0,s.length()-1)){
            System.out.println("True");
        } else{
            System.out.println("False");
        }
        sc.close();
    }
    static boolean isPalindrome(String st, int s, int e){
        if(e<s){
            return true;
        }
        System.out.println(s+" "+e+" "+ st.charAt(s)+" "+st.charAt(e));
        return st.charAt(s)==st.charAt(e) && isPalindrome(st,s+1,e-1);
    }
}

