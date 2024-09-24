package String_recursion;
import java.util.*;
public class subSequence {
    public static void main(String[] args) {
        subsequence("", "abc");
        System.out.println(subse("","abc"));
        subsequenceAscii("", "abc");
    }
    static void subsequence(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subsequence(p, up.substring(1));
        subsequence(p+ch, up.substring(1));
    }

    static ArrayList<String> subse(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> a = new ArrayList<>();
            a.add(p);
            return a;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subse(p, up.substring(1));
        ArrayList<String> right = subse(p+ch, up.substring(1));
        left.addAll(right);
        return left;
    }

    static void subsequenceAscii(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subsequenceAscii(p, up.substring(1));
        subsequenceAscii(p+ch, up.substring(1));
        subsequenceAscii(p+(ch+0), up.substring(1));
    }
}
