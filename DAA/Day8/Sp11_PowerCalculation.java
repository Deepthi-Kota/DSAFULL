package DAA.Day8;
/*A school kid named John Doe, wants to find the value of N^P
Pth power of a number N.

You will be given two integers N and P.
Your task is to help John Doe to find the value of N^P.

NOTE:
---------
Value of N and P can be both positive and negative

Input Format:
-------------
Line-1: Two integers N and P, where N is the number and P is the power

Output Format:
--------------
Line-1: Print a float number, N power P


Sample Input-1:
---------------
3 2

Sample Output-1:
----------------
9.000000


Sample Input-2:
---------------
2 -3

Sample Output-2:
----------------
0.125000 */
import java.util.*;
public class Sp11_PowerCalculation {
    public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            float x = sc.nextFloat();
            int y = sc.nextInt();
            System.out.println(pow(x,y));
            sc.close();
        }
        static float pow(float x, int y){
            float res;
            float temp;
            if(y==0){
                return 1;
            }
            temp = pow(x,y/2);
            if(y%2==0){
                res = temp*temp;
            }
            else{
                if(y>0){
                    res = x*temp*temp;
                } else{
                    res = (temp*temp)/x;
                }
            }
            return res;
        }
}
