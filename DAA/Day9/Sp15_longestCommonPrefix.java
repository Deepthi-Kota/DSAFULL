package DAA.Day9;
/*Given an array of strings strs, find the longest common prefix among all strings.

If there is no common prefix, return an empty string "".

NOTE: Solve Using Binary Search

Input Format:
-------------
Line-1: An integer n, the number of strings in the array.
Line-2: The next n lines contain n space-separated strings representing the elements of the string array strs.

Output Format:
--------------
Line-1: Print a single string, which is the longest common prefix among all the strings. If no common prefix exists, print an empty string.

Constraints:
------------
1 ≤ n ≤ 200
0 ≤ strs[i].length ≤ 200
strs[i] consists of only lowercase English letters.


Sample Input-1:
---------------
3
flower flow flight

Sample Output-1:
----------------
fl

Explanation:
The longest common prefix of the strings flower, flow, and flight is "fl".

Sample Input-2:
---------------
3
dog racecar car

Sample Output-2:
----------------
""

Explanation:
There is no common prefix among the input strings.
 */
import java.util.*;
public class Sp15_longestCommonPrefix {
    
    public class Solution{
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            String[] s = new String[n];
            for(int i=0; i<n; i++){
                s[i]=sc.next();
            }
            System.out.println(commonThroughHashMap(s));
            System.out.println(common(s));
            sc.close();
        }
        static String commonThroughHashMap(String[] s){
            String small = findSmall(s); 
            if(small == ""){
                return "";
            }
            HashMap<Character, Integer> map = new HashMap<>();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<small.length(); i++){
                char c = small.charAt(i);
                map.put(c,1);
                for(int j=0; j<s.length; j++){
                    // if(!map.containsKey(s[j].charAt(i))){
                    //     return sb.toString();
                    // }
                    map.put(s[j].charAt(i),map.getOrDefault(s[j].charAt(i),0)+1);
                }
                if(map.get(c) == s.length +1 ){
                    sb.append(c);
                }else{
                    break;
                }
            }
            return sb.toString();
        }
        
        static String findSmall(String[] s){
            int mini = Integer.MAX_VALUE;
            String small = "";
            for(int i=0; i<s.length; i++){
                if(s[i].length() < mini){
                    small = s[i];
                    mini = s[i].length();
                }
            }
            return small;
            
        }

        //through binary search
        static String common(String[] s){
                String small = findSmall(s); 
                if(small == ""){
                    return "";
                }
                int start = 0;
                int e = small.length()-1;
                while(start<=e){
                    int mid = start+(e-start)/2;
                    int c = findin(s,small,mid);
                    if(c==s.length){
                        start=mid+1;
                    } else{
                        e=mid-1;
                    }
                }
                return small.substring(0,e+1);
                
            }
            static int findin(String[] s, String small, int mid){
                int c=0;
                for(int i=0; i<s.length; i++){
                    // System.out.println(s[i].substring(0,mid+1)+" "+small.substring(0,mid+1));
                    if(s[i].substring(0,mid+1).equals(small.substring(0,mid+1))){
                        c++;
                    }
                }
                return c;
            }
            
    }
}
