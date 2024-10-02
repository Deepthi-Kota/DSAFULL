package DAA.Day5;
/*
 * Given a string s, write a recursive function to reverse the string. 
You are not allowed to use any built-in string manipulation functions. 

Constraints:
------------
The input string s consists of printable ASCII characters (including spaces, punctuation, etc.).
The length of the string s is between 1 and 1000.
You must reverse the string recursively.

Input Format:
--------------
Line-1: A single string s, containing characters that need to be reversed.

Output Format:
--------------
Line-1: A single string, representing the reversed input string.


Sample Input-1: 
---------------
hello

Sample Output-1:
-----------------
olleh

Sample Input-2:
----------------
12345

Sample Output-2: 
----------------
54321

 */
import java.util.*;
public class ReverseString_10 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] c = reverse(s.toCharArray(),0,s.length()-1);
        String sb = new String(c);
        System.out.println(sb);
        sc.close();
        
    }
    static char[] reverse(char[] c, int s, int e){
        if(s>=e){
            return c;
        }
        char temp = c[s];
        c[s++] = c[e];
        c[e--] = temp;
        return reverse(c,s,e);
    }
}

