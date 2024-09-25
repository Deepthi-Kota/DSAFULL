package PreFs.Day2;
/*
You are developing an inventory management system for a retail company. 
The company wants to introduce a new feature where it can predict when 
the inventory for a product might need restocking. The inventory levels 
for various products are recorded daily, and the company wants to monitor 
the next higher stock level for each product to anticipate demand.

Given an array stock_levels where each element represents the daily inventory 
level of a particular product over a certain period, write a function to find 
the "next higher stock level" for every day. The "next higher stock level" for
a given day is defined as the first higher stock level recorded in 
the subsequent days. If no higher stock level is found in the following days, 
return -1.

Sample Input:
---------
Line-1: An integer N, Number of days.
Line-2: N space seprated integers,  

Sample Output:
--------------
An integer array acoording to problem.


Sample Input-1:
---------------
3
10 15 10

Sample Output-1: 
---------------
[15, -1, -1]

Explanation-1:
--------------
- For day 1 (stock level = 10), the next higher stock level is 15.
- For day 2 (stock level = 15), there is no higher stock level in the subsequent days.
- For day 3 (stock level = 10), there is no higher stock level in the subsequent days.


Sample Input-2:
---------------
6
20 25 30 15 20 35

Sample Output-2: 
---------------
[25, 30, 35, 20, 35, -1]

Explanation-2:
--------------
- For day 1 (stock level = 20), the next higher stock level is 25.
- For day 2 (stock level = 25), the next higher stock level is 30.
- For day 3 (stock level = 30), the next higher stock level is 35.
- For day 4 (stock level = 15), the next higher stock level is 20.
- For day 5 (stock level = 20), the next higher stock level is 35.
- For day 6 (stock level = 35), there is no higher stock level in 
  the subsequent days.
*/
import java.util.*;
public class p2_nextGreater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(Arrays.toString(findMixes(arr)));
        sc.close();
    }
    static int[] findMixes(int[] arr){
        int[] a = new int[arr.length];
        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[j]>arr[i]){
                    a[i]=arr[j];
                    break;
                }
            }
            if(a[i]==0){
                a[i]=-1;
            }
        }
        a[a.length-1] = -1;
        return a;
    }
}
