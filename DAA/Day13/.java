package DAA.Day13;

import java.util.*;
class Solution
{
    
    public static void call(List<Integer>temp,List<Integer>ans)
    {
        Stack <Integer> st= new Stack<>();
        for(int i=0;i<temp.size();i++)
        {
            if(st.isEmpty())
            {
                st.push(temp.get(i));
            }
            else
            {
                int c=0;
                while(!st.isEmpty() && temp.get(i)<st.peek())
                {
                    if(Math.abs(temp.get(i))==Math.abs(st.peek()))
                    {
                        st.pop();
                        c=1;
                        break;
                    }
                    else if(Math.abs(temp.get(i))<Math.abs(st.peek()))
                    {
                        c=1;
                        break;
                    }
                    else
                    {
                        st.pop();
                    }
                }
                if(c==0)
                {
                    st.push(temp.get(i));
                }
            }
    }
       while(!st.isEmpty())
            {
                ans.add(0,st.pop());
            }
    }
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        String s=sc.nextLine();
        String[]sx=s.split("\\s+");
        List<Integer> temp= new ArrayList<>();
        for(int i=0;i<sx.length;i++)
        {
            temp.add(Integer.parseInt(sx[i]));
        }
        List<Integer> ans = new ArrayList<>();
        call(temp,ans);
        System.out.println(ans);
    }
}
