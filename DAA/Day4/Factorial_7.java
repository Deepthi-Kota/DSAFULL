package DAA.Day4;
/*
 * Day4_Program1
Given a non-negative integer n, compute the factorial of n. 
The factorial of a non-negative integer n is the product of all positive integers less than or equal to n. 
The factorial of 0 is defined as 1.

The formula for the factorial of n is:
n! = n × (n-1) × (n-2) × ... × 1

Constraints:
-------------
0 ≤ n ≤ 10⁵ (Handle large inputs efficiently).
Ensure that your solution can handle large values of n without exceeding time limits or running into integer overflow.

Input Format:
-------------
Line-1: A single integer n, representing the number whose factorial needs to be computed.

Output Format:
--------------
Line-1: A single integer, representing the factorial of n.


Sample Input-1: 
----------------
5

Sample Output-1: 
-----------------
120

Sample Input-2: 
---------------
0

Sample Output-2: 
----------------
1

 */
import java.util.*;
import java.math.*;
public class Factorial_7 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BigInteger n = sc.nextBigInteger();
        System.out.println(fact(n));
        sc.close();
    }
    static BigInteger fact(BigInteger n){
        if(n.equals(BigInteger.ONE) || n.equals(BigInteger.ZERO)){
            return BigInteger.ONE;
        }
        return n.multiply(fact(n.subtract(BigInteger.ONE)));
    }
}
