/* 
Sharath is playing a game where he has to cross N levels to win. 

The rules of the game allow Sharath to take one of the following steps:
    -Jump 1 level in one step.
    -Jump 2 levels in one step.
    
Your task is to determine the number of distinct ways Sharath can reach the Nth level.

Constraints:

    1 <= N <= 45

Input Format:
-------------
Line-1: An Integer N represents number of levels.
  
Output Format:
--------------
Print an integer.


Sample Input-1:
---------------
2
  
Sample Output-1:
----------------
2

Explanation:
------------
1. 1-level+ 1-level =2
2. 2 levels in one step.
   
Sample Input-2:
---------------
4
  
Sample Output-2:
----------------
5

Explanation:
------------
1. 1-level + 1-level + 1-level + 1-level = 4
2. 1-level + 1-level + 2-levels = 4
3. 1-level + 2-levels + 1-level = 4
4. 2-levels + 1-level + 1-level = 4
5. 2-levels + 2-levels  = 4
*/
import java.util.*;
class SP28_ClimbingStairs{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        if(n==0){
            System.out.println(0);
            sc.close();
            return;
        }
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        // System.out.println(find(n,dp));
        // System.out.println(space(n));
        System.out.println(tabu(n,dp));
        sc.close();
    }
    static int find(int n, int[] dp){
        if(n==1 || n==2){
            return dp[n];
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n]=find(n-1,dp)+find(n-2,dp);
        return dp[n];
    }
    static int space(int n){
        int a = 1;
        int b = 1;
        int c;
        while(n-1>0){
            c=a+b;
            a=b;
            b=c;
            n--;
        }
        return b;
    }
    static int tabu(int n,int[] dp){
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    
}