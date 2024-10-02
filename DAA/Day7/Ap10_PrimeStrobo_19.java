package DAA.Day7;
/*
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down). 
A strobogrammatic number must consist of only the digits 0, 1, 6, 8, and 9. 
Each of these digits either remains the same or transforms into another valid strobogrammatic digit when rotated:
	0 rotates to 0
	1 rotates to 1
	6 rotates to 9
	8 rotates to 8
	9 rotates to 6

Given an integer n, check is n is strobogrammatic number and prime strobogrammatic number.

Input Format:
-------------
Line-1: A single integer n.

Output Format:
--------------
Line-1: Space separated two boolean values, represents "is strobogrammatic number" and "is prime strobogrammatic number".

Constraints:
------------
1 ≤ n ≤ 14


Sample Input-1:
---------------
1001

Sample Output-1: 
----------------
true false


Sample Input-2:
---------------
101

Sample Output-2: 
----------------
true true

Sample Input-3:
---------------
9999

Sample Output-3: 
----------------
false false

 */
import java.util.*;
public class Ap10_PrimeStrobo_19 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(isStobo(String.valueOf(n))){
            if(isPrime(n)){
                System.out.println("true"+" "+"true");
            }
            else{
                System.out.println("true"+" "+"false");
            }
        }
        else{
        System.out.println("false"+" "+"false");}
        sc.close();
    }
    static boolean isStobo(String num){
        Map<Character,Character> strobos = new HashMap<>();
        strobos.put('0','0');
        strobos.put('1','1');
        strobos.put('6','9');
        strobos.put('9','6');
        strobos.put('8','8');
        int l = 0;
        int r = num.length()-1;

        while(l<=r){
            char lc = num.charAt(l);
            char rc = num.charAt(r);
            if(!strobos.containsKey(lc) || strobos.get(lc)!=rc){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    static boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        for(int i=2; i<n; i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

}

