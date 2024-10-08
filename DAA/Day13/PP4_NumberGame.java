package DAA.Day13;
//https://leetcode.com/problems/maximum-69-number/
/* Pranav is playing with numbers 2 and 5 only.
He is given an integer N consist of 2 and 5 only.
Pranav is trying to find the maximum number by 
altering atmost one digit in the given N  

Help pranav to find the maximum number.

Input Format:
-------------
An integer N, consist of 2 and 5

Output Format:
--------------
Print the maximum number.


Sample Input-1:
---------------
5225

Sample Output-1:
----------------
5525

Explanation:
---------------
alter the 1st digit-> 2225
alter the 2nd digit-> 5525.
alter the 3rd digit-> 5255.
alter the 4th digit->5222.
So, The maximum number is 5525.

Sample Input-2:
---------------
52525

Sample Output-2:
----------------
55525

Sample Input-3:
---------------
2555

Sample Output-3:
----------------
5555
*/
import java.util.*;
public class PP4_NumberGame {
    public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            System.out.println(find(n));
            sc.close();
        }
        static int find(int n){
            int x = (int)(Math.log10(n));
            while(x>=0){
                // int y = (int)Math.pow(10,x);
                // int z = (int)(n/y);
                if((int)(n/(int)(Math.pow(10,x)))%10==2){
                    n+=(int)(Math.pow(10,x)*3);
                    return n;
                }
                x--;
            }
            return n;
        }
}
