package PreFs.Day22;
/* You are a warehouse manager responsible for distributing packages across different 
storage bins to minimize the maximum load in any single bin. You are given an 
integer array packages[] where the ith element represents the number of items in 
the ith package. Additionally, you are given an integer maxSplits, which defines
the maximum number of times you are allowed to split a package.

A single split operation allows you to divide a package into two smaller packages, 
each containing a positive number of items. For example, a package with 10 items 
can be split into two new packages with sizes 6 and 4, or 3 and 7.

Your objective is to minimize the "MaxLoad", defined as the maximum number of 
items in any package, after performing at most maxSplits operations.


Input Format:
-------------
Line-1: Two space separated integers, N and P
Line-2: N space separated integers, packages[].

Output Format:
--------------
Print an integer result, MaxLoad.


Sample Input-1:
---------------
1 3
15

Sample Output-1:
----------------
4

Explanation:
------------
Split the package with 15 items into packages of sizes 7 and 8. 
    [15] -> [7,8].
Split the package with 8 items into packages of sizes 4 and 4. 
    [7,8] -> [7,4,4].
Split the package with 7 items into packages of sizes 4 and 3. 
    [7,4,4] -> [4,4,4,3].
After these operations, the package with the highest load has 4 items, 
    so the MaxLoad is 4.


Sample Input-2:
---------------
3 4
6 15 24

Sample Output-2:
----------------
3

Explanation:
------------
Split the package with 24 items into packages of sizes 8 and 16. 
    [6,15,24] -> [6,15,8,16].
Split the package with 16 items into packages of sizes 8 and 8. 
    [6,15,8,16] -> [6,15,8,8,8]
Split one of the packages with 15 items into packages of sizes 7 and 8. 
    [6,15,8,8,8] -> [6,7,8,8,8,8]
Split the remaining package with 8 items into packages of sizes 4 and 4. 
    [6,7,8,8,8,8] -> [6,7,4,4,8,8,8]
After these operations, the package with the highest load has 8 items, 
    So the MaxLoad is 8.

*/

import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int split = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            arr.add(sc.nextInt());
        }
        System.out.println(find(arr,split));
        sc.close();
    }
    static int find(ArrayList<Integer> arr, int cut){
        while(cut>0){
            int ind = great(arr);
            int greater = arr.get(ind);
            //int greater = Collections.max(arr);
            arr.remove(ind);
            if(greater%2!=0){
                arr.add((int)greater/2+1);
                arr.add((int)greater/2);
            }else{
                arr.add((int)Math.ceil(greater/2));
                arr.add((int)Math.floor(greater/2));
            }
            System.out.println(arr);
            cut--;
        }
        return arr.get(great(arr));
    }
    static int great(ArrayList<Integer> arr){
        int maxi = Integer.MIN_VALUE;
        int index = -1;
        for(int i=0; i<arr.size(); i++){
            if(arr.get(i)>maxi){
                maxi=arr.get(i);
                index = i; 
            }
        }
        // System.out.println(index);
        return index;
    }
}