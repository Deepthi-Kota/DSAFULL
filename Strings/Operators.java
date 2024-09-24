import java.util.*;
public class Operators {
    public static void main(String[] args) {
        System.out.println('a'+'b'); //195
        System.out.println("a"+"b"); //ab
        System.out.println('a'+3); //100
        System.out.println((char)('a'+3)); //d
        System.out.println("a"+1); // integer will be converted into Integer and that calls toString(), this after few steps "a"+"1"
        System.out.println("deepthi"+new ArrayList<>()); //calls toString (in println everything calls toString())
        System.out.println("deepthi" + new Integer(56));
        //if we hava a object like arr, it calls obj.toString which give hashcode or something
        System.out.println(new int[]{1,2,3});
        //so we can call Arrays.toString like overriding 
        System.out.println(Arrays.toString(new int[]{1,2,3}));
        //if strings it will print string else it will convert into strings

        //operator + is defined only for primitives or if atleast one of the operands is string Integer + ArrayList gives error
        // System.out.println(new Integer(56)+new ArrayList<>());
        System.out.println(new Integer(56)+" "+new ArrayList<>()); //this works since we added string
        //above one is like
        String ans = new Integer(56)+" "+new ArrayList<>();
        System.out.println(ans);
        //operator - cannot be applied to string
        //on string objects + operator is being oveloaded, it give more functionality, java supports operator overloading only on strings... unlike python and cpp

    }
}
