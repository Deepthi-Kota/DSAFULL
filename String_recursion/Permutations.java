package String_recursion;
import java.util.*;
public class Permutations {
    public static void main(String[] args) {
        permu("", "abc");
        System.out.println(permut("", "abc"));
        System.out.println(permuCount("", "abc"));
    }
    static void permu(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for(int i=0; i<=p.length(); i++){
            String f = p.substring(0, i);
            String s = p.substring(i,p.length());
            permu(f+ch+s, up.substring(1));
        }

    }
    static ArrayList<String> permut(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        char ch = up.charAt(0);
        //local call
        ArrayList<String> ans = new ArrayList<>();
        for(int i=0; i<=p.length(); i++){
            String f = p.substring(0, i);
            String s = p.substring(i,p.length());
            ans.addAll(permut(f+ch+s, up.substring(1)));
        }
        return ans;
    }

    static int permuCount(String p, String up){
        if(up.isEmpty()){
            return 1;
        }
        int count = 0;
        char ch = up.charAt(0);
        for(int i=0; i<=p.length(); i++){
            String f = p.substring(0, i);
            String s = p.substring(i,p.length());
            count += permuCount(f+ch+s, up.substring(1));
        }
        return count;
    }
}