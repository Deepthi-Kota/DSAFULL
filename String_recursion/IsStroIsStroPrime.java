package String_recursion;
import java.util.*;
public class IsStroIsStroPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(isStobo(String.valueOf(n))){
            if(isPrime(n)){
                System.out.println("True"+" "+"True");
            }
            else{
                System.out.println("True"+" "+"False");
            }
        }
        else{
        System.out.println("False"+" "+"False");}
        sc.close();
    }
    static boolean isStobo(String num){
        Map<Character,Character> strobos = new HashMap<>();
        strobos.put('0','0');
        strobos.put('1','1');
        strobos.put('6','9');
        strobos.put('9','6');
        strobos.put('8','8');
        int l = 0;
        int r = num.length()-1;

        while(l<=r){
            char lc = num.charAt(l);
            char rc = num.charAt(r);
            if(!strobos.containsKey(lc) || strobos.get(lc)!=rc){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    static boolean isPrime(int n){
        for(int i=2; i<n; i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

}
