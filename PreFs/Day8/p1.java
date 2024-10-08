package PreFs.Day8;
//https://leetcode.com/problems/relative-ranks/description/
//https://leetcode.com/problems/rank-transform-of-an-array/description/
/* You are given an array of integers called 'score,' containing 'n' elements, 
where 'score[i]' represents the performance score of the ith participant in a 
competitive event. The scores are guaranteed to be unique.

The participants' final rankings are based on their performance scores, with 
the top performer (the one with the highest score) securing the 1st place, 
the second-highest scorer obtaining the 2nd place, and so on. Each participant's 
rank is directly associated with their position:
 - The participant in the 1st place is awarded the rank "Champion".
 - The participant in the 2nd place is awarded the rank "RunnerUp-1".
 - The participant in the 3rd place is awarded the rank "RunnerUp-2".
 - For participants in the 4th place to the nth place, their rank corresponds to 
   their position (i.e., the participant in the x-th position is assigned the rank 'x').

Your task is to generate an array called 'answer' of size 'n'. Each element 
'answer[i]' in this array should represent the rank achieved by the i-th 
participant based on their performance score.

Input Format:
-------------
Line-1: An integer N, number of participants.
Line-2: N space seprated integers, scores[].

Output Format:
--------------
Print the list of ranks of the participants.


Sample Input-1:
---------------
5
10 3 9 8 4

Sample Output-1:
----------------
[Champion, 5, RunnerUp-1, RunnerUp-2, 4]


Sample Input-2:
---------------
8
10 3 9 4 2 7 6 1

Sample Output-2:
----------------
[Champion, 6, RunnerUp-1, 5, 7, RunnerUp-2, 4, 8]
*/
import java.util.*;
public class p1 {
public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        int[] newArr = Arrays.copyOf(arr,arr.length);
        Arrays.sort(newArr);
        System.out.println(Arrays.toString(find(arr,newArr)));
        sc.close();
    }
    static String[] find(int[] arr, int[] newArr){
        String[] ans = new String[arr.length];
        for(int i=0; i<arr.length; i++){
            if(arr[i]==newArr[arr.length-1]){
                ans[i]="Champion";
            } else if(arr[i] == newArr[arr.length-2]){
                ans[i]="RunnerUp-1";
            } else if(arr[i]==newArr[arr.length-3]){
                ans[i]="RunnerUp-2";
            }else{
                int k = findElem(newArr,arr[i]);
                ans[i]= String.valueOf(arr.length-k);
            }
            
        }
        return ans;
    }
    static int findElem(int[] arr, int t){
        for(int i=0; i<arr.length; i++){
            if(arr[i]==t){
                return i;
            }
        }
        return -1;
    }
}

