package PreFs.Day34;
/* Given an 2D character array, Letters[][], of size r*c.
You have to construct the word W, using the given array.

Rules to construct the word are as follows:
    - All the letters of the word W, should be adjacent to each other 
    in the array Letters(either horizontal or vertical).
    - You can use each charcater in Letters[][] only once.

If you are able to construct the word W, return 'true'
Otherwise 'false'.

Input Format:
-------------
Line-1 -> two integers R and C, array size.
R lines -> C space separated characters.
Last line -> a string, word W

Output Format:
--------------
print the boolean result.


Sample Input-1:
---------------
3 3
a b c
d e f
g h i
bad

Sample Output-1:
----------------
true


Sample Input-2:
---------------
3 3
a b c
d e f
g h i
ace

Sample Output-2:
----------------
false


Sample Input-3:
---------------
3 3
a b c
d e f
g h i
add

Sample Output-3:
----------------
false
*/
import java.util.*;
public class p1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        sc.nextLine();
        String[][] arr = new String[r][c];
        for(int i=0; i<r; i++){
            String[] s = sc.nextLine().split(" ");
            for(int j=0; j<c; j++){
                arr[i][j]=s[j];
            }
        }
        String word = sc.nextLine();
        boolean[][] vis = new boolean[r][c];
        boolean found = false;
        for(int i= 0; i < r; i++){
            for(int j= 0; j < c; j++){
                if(find(i, j, word, arr, vis)){
                    found = true;
                    break;
                }
            }
            if(found)
                break;
        }

        System.out.println(found);
        sc.close();
    }
    static boolean find(int r, int c, String word, String[][] arr, boolean[][] vis){
        if(word.isEmpty()){
            return true;
        }
        if(r<0 ||c<0 || r>=arr.length || c>=arr[0].length || vis[r][c]){
            return false;
        }
        String ch = arr[r][c];
        if(!ch.equals(String.valueOf(word.charAt(0)))){
            return false;
        }
        vis[r][c]=true;
            
        boolean found = find(r-1,c,word.substring(1),arr,vis) || find(r+1,c,word.substring(1),arr,vis) ||find(r,c-1,word.substring(1),arr,vis)|| find(r,c+1,word.substring(1),arr,vis);
        vis[r][c]=false;
        return found;
    }
}