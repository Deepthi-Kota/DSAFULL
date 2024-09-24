public class SumofDigits {
    public static void main(String[] args) {
        System.out.println(sum(145));
        System.out.println(prod(123));
    }
    static int sum(int n){
        if(n<=0){
            return 0;
        }
        return n%10 + sum(n/10);
    }
    static int prod(int n){
        if(n%10==n){
            return n;
        }
        return n%10 * prod(n/10);
    }
}
