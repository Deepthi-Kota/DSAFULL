package PreFs.Day45;
/* In a prestigious Collaborative Innovation Summit, there are two key sessions: 
Artificial Intelligence (AI) and Sustainability (SUS). Teams for these sessions 
must adhere to strict size requirements:
    - Session AI: Each team participating in this session must have exactly 
      'TA' members.
    - Session SUS: Each team participating in this session must have exactly 
      'TS' members.

The total number of participants attending the summit is TP.

Your task is to determine the minimum number of teams needed to accommodate all 
participants such that:
    - Each participant is assigned to exactly one team.
    - Each team confirms to the size requirements of either the AI or the SUS 
      session.
If it is not possible to assign all participants into teams while meeting these 
criteria, return -1.

Input Format:
-------------
Three space sepaarted integers, TP, TA, TS

Output Format:
--------------
A single integer representing the minimum number of teams required to allocate 
all participants


Sample Input-1:
---------------
50 5 8

Sample Output-1:
----------------
7

Explanation:
------------
5 teams of size 8 → 5×8=40 participants.
2 teams of size 5 → 2×5=10 participants.
The total is: 40+10=50 (Total:50 participants,all accounted for).


Sample Input-2:
---------------
23 5 6

Sample Output-2:
----------------
4

Explanation:
------------
3 teams of size 6 → 3×6=18 participants.
1 teams of size 5 → 1×5=5 participants.
The total is: 18+5=23 (Total:23 participants,all accounted for).
*/

import java.util.*;
public class p2{
    static int mini = Integer.MAX_VALUE;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int t = Integer.parseInt(s[0]);
        int a = Integer.parseInt(s[1]);
        int b = Integer.parseInt(s[2]);
        find(t,a,b);
        System.out.println(mini);
    }
    static void find(int t, int a, int b){
        for(int i=0; i<=t/a; i++){
            int rem = t - a*i;
            if(rem%b==0){
                int j = rem/b;
                if(rem-b*j==0){
                    mini = Math.min(i+j,mini);
                }
            }
        }
    }
}