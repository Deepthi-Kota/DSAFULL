public class PalindromeString {
    public static void main(String[] args) {
        System.out.println(isPalindrome("liril"));
    }
    static boolean isPalindrome(String s){
        if(s.length()==1){
            return true;
        }
        int n=s.length();
        return s.charAt(0)==s.charAt(n-1) && isPalindrome(s.substring(1, n-1));
    }
}
