package String_recursion;

import java.util.*;
class StroboGrammaticNumber
{
    static String [][] digitPair={{"1","1"},{"8","8"},{"6","9"},{"9","6"}};
    public static List <String> helper(int n,int m)
    {
        if(n==0)
        {
            return Arrays.asList("");
        }
        if(n==1)
        {
            return Arrays.asList("0","1","8");
        }
        List <String> sub =helper(n-2,m);
        List <String> result = new ArrayList <>();
        for(String s:sub)
        {
            if(n!=m)
            {
                result.add("0"+s+"0");
            }
            for(String[] pair :digitPair)
            {
                result.add(pair[0]+s+pair[1]);
            }
        }
        return result;
    }
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        
        List<String> result = helper(n,n);
        Collections.sort(result);
        System.out.println(result);
        sc.close();
}
}
