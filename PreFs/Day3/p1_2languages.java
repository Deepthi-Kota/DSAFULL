package PreFs.Day3;
/*In a futuristic virtual reality (VR) game world, players are provided with custom VR keypads that are similar to modern American keyboards but have some restrictions. The keypad is divided into three distinct zones, and each zone contains specific letters that the player can use for a task.
    - Zone 1: Letters on the top row: "qwertyuiop"
    - Zone 2: Letters on the middle row: "asdfghjkl"
    - Zone 3: Letters on the bottom row: "zxcvbnm"

Players are given a set of secret codes (words), and they must type these codes using only letters from one zone at a time. If a word uses letters from more than one zone, it will be considered invalid and cannot be typed.

Your task is to help the players by filtering out the valid secret codes (words) that can be typed using letters from only one zone.

Given a list of secret codes (words), return the codes that can be typed using letters from only one zone of the VR keypad.

Constraints:
------------
1 ≤ secretCodes.length ≤ 20
1 ≤ secretCodes[i].length ≤ 100
secretCodes[i] consists of English letters (both lowercase and uppercase).

Input Format:
-------------
Space separated words, secretCodes[]

Output Format:
--------------
A list of codes that can be typed using letters from only one zone.


Sample Input-1:
---------------
Galaxy Mars Venus Sky

Sample Output-1:
----------------
["Mars", "Sky"]

Explanation:
------------
"Mars" can be typed using only Zone 2.
"Sky" can be typed using only Zone 3.
"Galaxy" and "Venus" use letters from multiple zones and are thus invalid.


Sample Input-2:
---------------
keyboard monkey

Sample Output-2:
----------------
[]

Explanation:
------------
None of the words can be typed using letters from only one zone.


Sample Input-3:
---------------
qw er ty

Sample Output-3:
----------------
["qw", "er", "ty"]

Explanation:
------------
All the codes can be typed using only letters from Zone 1.
 */
import java.util.*;
public class p1_2languages {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String [] s = sc.nextLine().split(" ");
        System.out.println(valid(s));
        sc.close();
    }
    static ArrayList<String> valid(String[] sin){
        String s1 = "qwertyuiop";
        String s2 = "asdfghjkl";
        String s3 = "zxcvbnm";
        ArrayList<String> ans = new ArrayList<>();
        for(String s: sin){
            if(onlyin(s.toLowerCase(),s1,s2,s3)){
                ans.add(s);
            }
            System.out.println(ans);
        }
        return ans;
    }
    static boolean onlyin(String s, String s1, String s2, String s3){
        boolean b1 = false;
        boolean b2 =false;
        boolean b3 = false;
        for(char c: s.toCharArray()){
                if(s1.contains(String.valueOf(c))){
                    b1=true;
                    System.out.println(b1);
                }
                if(s2.contains(String.valueOf(c))){
                    b2=true;
                    System.out.println(b2);
                }
                if(s3.contains(String.valueOf(c))){
                    b3 = true;
                    System.out.println(b3);
                }
                if((b1&&b2)||(b2&&b3)||(b1&&b3)){
                    System.out.println("returning");
                    return false;
                }
        }
        return true;
    }
}
