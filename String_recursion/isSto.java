package String_recursion;
import java.util.*;
class Solution
{
    public static boolean check_prime(int n)
    {
        if(n<=1)
        {
            return false;
        }
        if(n==2)
        {
            return true;
        }
        if(n%2==0)
        {
            return false;
        }
        for(int i=2;i<n;i++)
        {
            if(n%i==0)
            {
                return false;
            }
        }
        return true;
    }
    public static boolean check_strobo(int n)
    {
        String a= String.valueOf(n);
        int s=0;
        int e=a.length()-1;
         Map <String,String> map = new HashMap<>();
        map.put("1","1");
        map.put("6","9");
        map.put("9","6");
        map.put("0","0");
        map.put("8","8");
        
            while (s <= e) {
            String start = String.valueOf(a.charAt(s));
            String end = String.valueOf(a.charAt(e));
            if (!map.containsKey(start) || !map.get(start).equals(end)) {
                return false;
            }
            s++;
            e--;
            }
        return true;

         
    }
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        boolean [] b= new boolean[2];
        boolean x=check_strobo(n);
        b[0]=x;
        boolean y=check_strobo(n) && check_prime(n);
        b[1]=y;
        for(boolean g:b)
        {
            System.out.print(g+" ");
        }
        sc.close();
    }
}