package PreFs.Day2;

import java.util.*;
class Solution
{
    public static boolean call(String a,String b,int n)
    {
        int i=0;
        int j=0;
        Map <Character,Character> map = new HashMap <>();
        while(i<n && j<n)
        {
            if(!map.containsKey(a.charAt(i)) && map.containsKey(b.charAt(j)))
            {
                j++;
            } else if(map.containsKey(a.charAt(i)) && map.containsKey(b.charAt(j))){
                i++;
                j++;
            }
            else if(!map.containsKey(a.charAt(i)) && ! (map.containsKey(b.charAt(j))))
            {
                map.put(a.charAt(i),b.charAt(j));
                map.put(b.charAt(j),a.charAt(i));
                i++;
                j++;
            }
        }
        return i==n;
    }
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        String s=sc.nextLine();
        String[] sx=s.split(" ");
        int n=sx[0].length();
        System.out.println(call(sx[0],sx[1],n));
        sc.close();
    }
}
