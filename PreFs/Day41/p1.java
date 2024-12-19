package PreFs.Day41;
//299
/*
Ramesh and Suresh are playing a game.
Initially, Ramesh has a secret number, and Suresh has to guess that number.
Ramesh now checks, How many digits of the guess number match 
the secret number exactly, if both the digit and position are matched, 
indicate them as Apples. If the digit is matched and position is different, 
indicate them as Bananas.

Ramesh will give a hint to Suresh as follows:
e.g., secret number= 1231, and guess number = 4213
Only digit=2 is matching, so apple is 1, banana is 2
Ramesh tell the answer as 1A2B

You are given secrect number and guess number as strings,
Your task to help Ramesh, to find and return the HINT.

NOTE: The length of the both secrect and guess number is same, 
        contains only digits.

Input Format:
-------------
Two strings, secret and guess

Output Format:
--------------
Print the string, the HINT.


Sample Input-1:
---------------
1807 7810

Sample Output-1:
----------------
1A3B

Explanation: 
------------
1 Apple and 3 Banana. Apple is 8, Banana are 0, 1 and 7.


Sample Input-2:
---------------
1123 0111

Sample Output-2:
----------------
1A1B

Explanation: 
------------
The 1st 1 in Suresh guess is an Apple, the 2nd or 3rd 1 is B.

*/

import java.util.*;
public class p1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        String num = s[0];
        String guess = s[1];
        int apple = 0;
        int banana = 0;
        boolean[] vis = new boolean[num.length()];
        for(int i=0; i<num.length(); i++){
            if(num.charAt(i)== guess.charAt(i)){
                // System.out.println(i+" "+"apple");
                apple++;
                vis[i] = true;
            }
            
            // System.out.println(Arrays.toString(vis));
            // System.out.println("in loop");
        }
        for (int i = 0; i < guess.length(); i++) {
            if (num.charAt(i) == guess.charAt(i)) continue;

            for (int j = 0; j < num.length(); j++) {
                if (!vis[j] && num.charAt(j) == guess.charAt(i)) {
                    banana++;
                    vis[j] = true; 
                    break; 
                }
            }
        }

        String ans = apple + "A" + banana + "B";
        System.out.println(ans);
        sc.close();
    }
}