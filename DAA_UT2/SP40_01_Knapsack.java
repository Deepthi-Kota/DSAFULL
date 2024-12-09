/* Mr. Dharma is shopping at D-Mart with a basket that has a capacity C. 
He has a wishlist of N products, where each product has a cost and a quantity. 

His goal is to purchase products in such a way that:
    -The total quantity of the selected products does not exceed the basket capacity C.
    -The total cost of the selected products is maximized among all possible combinations.

Your task is to help Mr. Dharma determine the maximum cost he can achieve under the given constraints.

Input Format:
--------------
Line-1: Two space-separated integers N and C, representing the number of products and the basket capacity, respectively.
Next N lines: Two space-separated integers Ci and Qi, representing the cost and quantity of the ith product.

Output Format:
--------------
Line-1: Print an integer, the maximum cost Mr. Dharma can achieve.

Constraints:
------------
*1≤N≤100 (Number of products)
*1≤C≤1000 (Basket capacity)
*1≤Ci,Qi≤100 (Cost and quantity of each product)

Sample Input-1:
---------------
4 15
10 2
10 4
12 6
18 9

Sample Output-1:
----------------
38

Explanation:
------------
The selected products are:
    Product 1 (Cost = 10, Quantity = 2)
    Product 2 (Cost = 10, Quantity = 4)
    Product 4 (Cost = 18, Quantity = 9)

Total cost = 10 + 10 + 18 = 38
Total quantity = 2 + 4 + 9 = 15

Sample Input-2:
---------------
4 21
18 6
20 3
14 5
18 9

Sample Output-2:
----------------
56

Explanation:
------------
The selected products are:
    Product 1 (Cost = 18, Quantity = 6)
    Product 2 (Cost = 20, Quantity = 3)
    Product 4 (Cost = 18, Quantity = 9)

Total cost = 18 + 20 + 18 = 56
Total quantity = 6 + 3 + 9 = 18*/

import java.util.*;
class SP40_01_Knapsack{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cap = sc.nextInt();
        int[] wt = new int[n];
        int[] val = new int[n];
        for(int i=0; i<n; i++){
            val[i] = sc.nextInt();
            wt[i] = sc.nextInt();
        }
        int[][] dp = new int[n+1][cap+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=cap; j++){
                dp[i][j]=-1;
            }
        }
        // System.out.println(find(wt,val,n,cap));
        // System.out.println(findmemo(wt,val,n,cap,dp));
        System.out.println(tabu(wt,val,n,cap));
        sc.close();
    }
    static int find(int[] wt, int[] val, int n, int cap){
        if(n==0 || cap==0){
            return 0;
        }
        if(wt[n-1] > cap){
            return find(wt,val,n-1,cap);
        }
        else{
            return Math.max(val[n-1] + find(wt,val,n-1,cap-wt[n-1]), find(wt,val,n-1,cap));
        }
    }
    
    static int findmemo(int[] wt, int[] val, int n, int cap, int[][] dp){
        if(n==0 || cap == 0){
            return 0;
        }
        if(dp[n][cap]!=-1){
            return dp[n][cap];
        }
        if(wt[n-1]>cap){
            return find(wt,val,n-1,cap);
        }else{
            dp[n][cap] = Math.max(val[n-1]+find(wt,val,n-1,cap-wt[n-1]),find(wt,val,n-1,cap));
        }
        return dp[n][cap];
    }
    
    static int tabu(int[] wt, int[] val, int n, int cap){
        int[][] dp = new int[n+1][cap+1];
        if(n==0 || cap==0){
            return 0;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=cap; j++){
                if(wt[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]],dp[i-1][j]);
                }
            }
        }
        return dp[n][cap];
    }
    
}