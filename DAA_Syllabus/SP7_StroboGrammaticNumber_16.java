package DAA_Syllabus;
/*
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down). 
A strobogrammatic number must consist of only the digits 0, 1, 6, 8, and 9. 
Each of these digits either remains the same or transforms into another valid strobogrammatic digit when rotated:
	0 rotates to 0
	1 rotates to 1
	6 rotates to 9
	8 rotates to 8
	9 rotates to 6

Given an integer n, return all strobogrammatic numbers that are of length n.

Input Format:
-------------
Line-1: A single integer n, representing the length of the strobogrammatic numbers to generate.

Output Format:
--------------
line-1: Return a list of all strobogrammatic numbers of length n. The list can be in any order.

Constraints:
------------
1 ≤ n ≤ 14


Sample Input-1:
---------------
2

Sample Output-1: 
----------------
[11, 69, 88, 96]

Explanation:
-------------
All valid strobogrammatic numbers of length 2 are:
11: Rotates to 11
69: Rotates to 96
88: Rotates to 88
96: Rotates to 69

Sample Input-2:
---------------
1

Sample Output-2: 
----------------
[0, 1, 8]

Explanation:
------------
The strobogrammatic numbers of length 1 are:
0: Rotates to 0
1: Rotates to 1
8: Rotates to 8

NOTE: Print the results in sorted order to pass the testcases
 */
import java.util.*;
public class SP7_StroboGrammaticNumber_16 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        List<String> ans = helper(n,n);
        Collections.sort(ans);
        System.out.println(ans);
        sc.close();
    }
    static String[][] digitPair={{"1","1"},{"8","8"},{"6","9"},{"9","6"}};
    static List<String> helper(int n, int m){
        if(n==0){
            return Arrays.asList("");
        }
        if(n==1){
            return Arrays.asList("0","1","8");
        }
        List<String> sub = helper(n-2,m);
        List<String> res = new ArrayList<>();
        for(String s: sub){
            if(n!=m){
                res.add("0"+s+"0");
            }
            for(String[] pair: digitPair){
                res.add(pair[0]+s+pair[1]);
            }
        }
        return res;
    }
}
