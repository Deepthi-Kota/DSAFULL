package DAA.Day14;
/* You are given n items, each with a specific weight and value. 
You are also given a knapsack that can hold a maximum weight W. 
The goal is to maximize the total value in the knapsack by selecting items to add.

NOTE: You can take fractions of items instead of having to take the whole item. 
You need to calculate the maximum possible value that can be achieved.

Input Format:
-------------
Line-1: Two integers n and W representing the number of items and the maximum weight capacity of the knapsack, respectively.
Line-2 to n: Each line contains two integers value and weight for each item.

Output Format:
--------------
Line-1: Printing the maximum total value that can be obtained in the knapsack, rounded to two decimal places.

Constraints:
-------------
1 <= n <= 10^5
0 <= W <= 10^9
1 <= value, weight <= 10^9

Sample Input-1:
---------------
3 50
60 10
100 20
120 30

Sample Output-1:
----------------
240.00

Explanation:
------------
The first item can be added in full (value = 60, weight = 10).
The second item can be added in full (value = 100, weight = 20).
The third item can be added partially, using only 20 out of 30 weight capacity, which gives a value of (120/30) * 20 = 80.
Thus, the total value is 60 + 100 + 80 = 240.

Sample Input-2:
---------------
2 50
60 20
100 50

Sample Output-2:
----------------
120.00

Explanation:
------------
The first item can be added in full (value = 60, weight = 20).
From the second item, only 30 weight units can be used, so the value will be (100/50) * 30 = 60.
Thus, the total value is 60 + 60 = 120.

Sample Input-3:
---------------
1 10
500 30

Sample Output-3:
----------------
166.67

Explanation:
------------
The item has a value of 500 and a weight of 30. Since the knapsack can only hold 10 units of weight, we take a fraction of the item.
The value of 10 units from the first item is (500/30) * 10 = 166.67.
Thus, the total value is 166.67*/
import java.util.*;
public class SP18_Knapsack {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int w = sc.nextInt();
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++){
            arr[i][0]=sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        Arrays.sort(arr,(a,b)-> Double.compare(b[0]/b[1],a[0]/a[1]));
        System.out.format("%.2f",max(arr,w));
        sc.close();
    }
    static double max(int[][] arr, int w){
        double total = 0;
        for(int i=0; i<arr.length; i++){
            int curwt = (int)arr[i][1];
            int curval = (int)arr[i][0];
            if(w - curwt >=0){
                total+=curval;
                w-= curwt;
            } else{
                double frac = ((double)w/(double)curwt);
                total+=(curval*frac);
                w=0;
                break;
            }
        }
        return total;
    }
}