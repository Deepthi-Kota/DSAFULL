package PreFs.Day8;
/* You are tasked with building a communication system where text messages are encoded using 
these symbol sequences. You are developing an encoding system that converts words into a 
secret code using a specific set of predefined symbols. Each letter of the English alphabet 
is mapped to a unique sequence of symbols, where - and / are used to represent different 
elements. The entire alphabet has been mapped to these unique sequences.

Here is the mapping for each letter:
['/-', '/---', '/-/-', '/--', '-', '--/', '//-', '----', '--', '-///', '/-/', '-/-/', '//', 
'/-', '---', '/--/', '//-/', '/-/', '---', '/', '--/', '---/', '/--', '/--/', '/-//', '//--']

Given an array words, messages[], each word can be encoded by converting each letter into its
corresponding symbol sequence and concatenating them together.

For example, the word "data" might transform into a code like /---/--/ where each letter is 
replaced by its corresponding symbol sequence. Your goal is to determine how many distinct 
encoded messages are generated from a list of words.

Input Format:
-------------
space separated strings, messages[].

Output Format:
--------------
An integer, number of distinct encoded messages.


Sample Input-1:
---------------
gin zen gig msg

Sample Output-1:
----------------
2


Sample Input-2:
---------------
abc def ghi

Sample Output-2:
----------------
3
*/
import java.util.*;
public class p2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().trim().split("\\s+");
        System.out.println(find(s));
        sc.close();
    }
    static int find(String[] s){
        String[] sym = {"/-", "/---", "/-/-", "/--", "-", "--/", "//-", "----", "--", "-///", "/-/", "-/-/", "//", "/-", "---", "/--/", "//-/", "/-/", "---", "/", "--/", "---/", "/--", "/--/", "/-//", "//--"};
        HashSet<String> set= new HashSet<>();
        for(String b: s){
            StringBuilder sb = new StringBuilder();
            for(char c: b.toLowerCase().toCharArray()){
                sb.append(sym[c-'a']);
            }
            // System.out.println(sb.toString());
            set.add(sb.toString());
        }
        return set.size();
    }    
}
