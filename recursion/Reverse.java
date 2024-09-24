public class Reverse {
    public static void main(String[] args) {
        // reversed(1234);
        // System.out.println(sum);
        // System.out.println(reversed1(12345));
        System.out.println(palindrome(1234321));
    }

    static int sum=0;
    static void reversed(int n){
        if(n<=0){
            return;
        }
        int rem = n%10;
        sum = sum *10 +rem;
        reversed(n/10);
    }

    static int reversed1(int n){
        //sometime we would need some additional arguments in the arguments in that case use helper funcion
        int digits = (int)(Math.log10(n)) +1;
        return helper(n,digits);
    }
    private static int helper(int n, int digits){
        if(n%10 == n){
            return n;
        }
        int rem = n%10;
        return rem * (int)(Math.pow(10,digits-1)) + helper(n/10, digits-1);
    }
    static boolean palindrome(int n){
        return n==reversed1(n);
    }

}
