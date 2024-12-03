package PreFs.Day33;
/* Ganesh is working on numbers, He is given a list of integers 1,2,3,...,N 
and the list is indexed from 1 to N.

Now he can shuffle the list in whatever way he want. Shuffled list is said 
to be valid, if one of the following is true for i-th position in the list.
    - The integer at the i-th position is divisible by i.
    - 'i' is divisible by the integer at the i-th position.

Your task is to find out, How many valid shuffles can Ganesh do?

Input Format:
-------------
An integer N, where N<=20.

Output Format:
--------------
Print an integer, number of ways ganesh can shuffle.


Sample Input-1:
---------------
1

Sample Output-1:
----------------
1

Explanation:
------------
The only shuffled list is [1]


Sample Input-2:
---------------
2

Sample Output-2:
----------------
2

Explanation:
------------
The first shuffled list is [1, 2]:
Integer at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
Integer at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).

The second shuffled list is [2, 1]:
Integer at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
Integer at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.


Sample Input-3:
---------------
3

Sample Output-3:
----------------
3

Explanation:
------------
The first shuffled list is [1, 2, 3]:
Integer at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
Integer at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
Integer at the 3rd position (i=3) is 3, and 3 is divisible by i (i=3).

The second shuffled list is [3, 2, 1]:
Integer at the 1st position (i=1) is 3, and 3 is divisible by i (i=1).
Integer at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
Integer at the 3rd position (i=3) is 1, and i is divisible by 1 (i=3).

The third shuffled list is [2, 1, 3]:
Integer at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
Integer at the 2nd position (i=2) is 1, and i is divisible by 1 (i=2).
Integer at the 3rd position (i=3) is 3, and 3 is divisible by i (i=3).
*/

import java.util.*;
public class p2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = "";
        for(int i=0; i<n; i++){
            s+=i+1;
        }
        System.out.println(find("", s));
    }
    
    static int find(String p, String up){
        if(up.isEmpty()){
            if(valid(p)){
                return 1;
            }
            return 0;
        }
        int count = 0;
        char ch = up.charAt(0);
        for(int i=0; i<=p.length(); i++){
            String f = p.substring(0, i);
            String s = p.substring(i,p.length());
            count += find(f+ch+s, up.substring(1));
        }
        return count;
    }
    
    static boolean valid(String p){
        for(int i=0; i<p.length(); i++){
            int a = i+1;
            int b = p.charAt(i)-'0';
            if(!(a%b==0 || b%a==0)){
                return false;
            }
        }
        return true;
    }
}