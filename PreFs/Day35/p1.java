package PreFs.Day35;
//254
/* Ms Manasa is working on numbers; she is fascinated by number factors.
She is given a number N, she wants to find out all possible ways of 
obtaining N as multiple of its factors.
For example given N =12
can be written as multiple of 2,3 and 4.
and the ways to obtains 12 from ots factors are: 2*2*3, 2*6, 3*4

Your task is to help Ms Manasa to find the all possible ways of obtaining N 
from its factors and return all the possible ways as shown in the samples.

Input Format:
-------------
An integer N, value of N.

Output Format:
--------------
Print the list of possiblilties.


Sample Input-1:
---------------
12

Sample Output-1:
----------------
[[2, 2, 3], [2, 6], [3, 4]]


Sample Input-2:
---------------
16

Sample Output-2:
----------------
[[2, 2, 2, 2], [2, 2, 4], [2, 8], [4, 4]]


Sample Input-3:
---------------
32

Sample Output-3:
----------------
[[2, 2, 2, 2, 2], [2, 2, 2, 4], [2, 2, 8], [2, 4, 4], [2, 16], [4, 8]]
*/

import java.util.*;
public class p1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> ans = new ArrayList<>();
        call(2,n,new ArrayList<>(),ans);
        ans.remove(ans.size()-1);
        System.out.println(ans);
        sc.close();
    }
    static void call(int s, int n, List<Integer> list, List<List<Integer>> ans){
        if(n==1){
            if(!list.isEmpty()){
               ans.add(new ArrayList<>(list));
            }
            return;
        }
        for(int i=s; i<=n; i++){
            if(n%i==0){
                list.add(i);
                call(i, n/i, list,ans);
                list.remove(list.size()-1);
            }
        }
    }
}