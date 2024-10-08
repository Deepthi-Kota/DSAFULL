package DAA.Day13;
//https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/description/
/* Aruna as a type writer, typing a document in her laptop. Suddenly her system got
hacked and whatever she types as words are displaying in reverse and with simple 
braces. She types only lowercase letters.

Inorder to get the actual words, Aruna has to reverse each word starting with the
word which is in innermost most braces and remove those braces.
Help Aruna to get actual words.

Constraints:
------------
  - 0 <= word.length <= 2000
  - Word only contains lower case English characters and parentheses.
    It's guaranteed that all braces are balanced.


Input Format:
-------------
Line-1: A string, represents an encoded word.

Output Format:
--------------
Line-1: A string, return the original string.


Sample Input-1:
---------------
{pqrs}

Sample Output-1:
----------------
srqp


Sample Input-2:
---------------
{uoy{are}woh}

Sample Output-2:
----------------
howareyou

Explanation
------------
Initially "are" will be revesed as "era".
Then {uoyerawoh} will be reversed.*/
import java.util.*;
public class PP1_ReverseWord {
    public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            String s = sc.next();
            System.out.println(decode(s));
            sc.close();
        }
        static String decode(String s){
            Stack<String> st = new Stack<>();
            for(int i=0; i<s.length(); i++){
                String sb = "";
                if(s.charAt(i)=='}'){
                    while(!st.peek().equals("{")){
                        sb+=st.peek();
                        st.pop();
                    }
                    st.pop();
                    for(int j=0; j<sb.length(); j++){
                        st.push(String.valueOf(sb.charAt(j)));
                    }
                }
                else{
                    st.push(String.valueOf(s.charAt(i)));
                }
                // System.out.println(st);
            }
            String ans = "";
            while(!st.isEmpty()){
                ans=st.peek()+ans;
                st.pop();
            }
            return ans;
        }
}
