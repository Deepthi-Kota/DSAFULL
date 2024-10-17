package DAA.Day14;
/* You are given an integer num. Your task is to maximize its value by swapping at most two digits once. 
Write a program to return the maximum possible value after performing the swap.

If no swap can increase the value, return the original number.

Input Format:
--------------
Line-1: An integer num, where 0 <= num <= 10^8.

Output Format:
--------------
Line-1: Return an integer representing the maximum value obtained after swapping two digits at most once.

Sample Input-1:
---------------
2736

Sample Output-1:
----------------
7236

Explanation:
------------
Swap the digit 2 with 7, resulting in the number 7236, which is the maximum possible value.

Sample Input-2:
---------------
9973

Sample Output-2:
----------------
9973

Explanation:
------------
No swap can make the number larger, so return the original number.*/
import java.util.*;
public class AP21_Single_Digit_Swap {
    public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            System.out.println(find(n));
            sc.close();
        }
        static int find(int num){
            int[] arr = new int[10];
            Arrays.fill(arr,-1);
            String[] n = String.valueOf(num).split("");
            for(int i=0; i<n.length; i++){
                arr[Integer.parseInt(n[i])]=i;
            }
            for(int i=0; i<n.length; i++){
                int c = Integer.parseInt(n[i]);
               for(int j=9; j>c; j--)
                if(arr[j] > i){
                    String temp = n[i];
                    n[i]=n[arr[j]];
                    n[arr[j]]=temp; 
                    return Integer.parseInt(String.join("",n));
                }
            }
            return num;
        }
}
