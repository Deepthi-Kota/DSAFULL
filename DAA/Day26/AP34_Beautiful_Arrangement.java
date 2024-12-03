package DAA.Day26;
/*Ganesh is working on numbers,
He is given a list of integers 1,2,3,...,N, the list is indexed from 1 to N.

Now he can shuffle the list in whatever way he want.
Shuffled list is said to be valid, if one of the following is true for i-th position in the list.
    - The integer at the i-th position is divisible by i.
    - 'i' is divisible by the integer at the i-th position.

Now your task is to find out, How many valid shuffles can Ganesh do?

Input Format:
-------------
Line-1: An integer N, where N<=20.

Output Format:
--------------
Line-1: Print an integer, number of ways ganesh can shuffle.


Sample Input:
---------------
2

Sample Output:
----------------
2

Explanation:
------------
The first shuffled list is [1, 2]:
Integer at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
Integer at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).

The second shuffled list is [2, 1]:
Integer at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
Integer at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1. */
public class AP34_Beautiful_Arrangement {
    
}
import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=i+1;
        }
        boolean[] vis = new boolean[n];
        System.out.println(permu(new ArrayList<>(),arr,vis));
    }
    static int permu(List<Integer> ans, int[] arr, boolean[] vis){
        if(ans.size()==arr.length){
            return 1;
        }   
        int c = 0;
        for(int i=0; i<arr.length; i++){
            int index = ans.size()+1;
            if(!vis[i] && (index%arr[i]==0 || arr[i]%index==0)){
                vis[i]=true;
                ans.add(arr[i]);
                c+=permu(ans,arr,vis);
                ans.remove(ans.size()-1);
                vis[i]=false;
            }
        }
        return c;
    }
}