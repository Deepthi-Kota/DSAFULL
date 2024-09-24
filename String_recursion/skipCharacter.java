package String_recursion;

public class skipCharacter {
    public static void main(String[] args) {
        String s = "abbabbaba";
        skip("",s);
        System.out.println(skip1(s));
        System.out.println(skipApple("hgjappleaon"));
        System.out.println(skipAppNotApple("adongoappoavoappleapppp"));
    }
    static void skip(String p, String up){
        if(up.length()==0){
            System.out.println(p);
            return;
        }
        char ch= up.charAt(0);
        if(ch=='a'){
            skip(p, up.substring(1));
        } else{
            skip(p+ch, up.substring(1));
        }

    }

    static String skip1(String up){
        if(up.isEmpty()){
            return "";
        }
        char ch= up.charAt(0);
        if(ch=='a'){
            return skip1(up.substring(1));
        } else{
            return ch+skip1(up.substring(1));
        }

    }

    static String skipApple(String up){
        if(up.isEmpty()){
            return "";
        }
        char ch= up.charAt(0);
        if(up.startsWith("apple")){
            return skipApple(up.substring(5));
        } else{
            return ch+skipApple(up.substring(1));
        }

    }

    static String skipAppNotApple(String up){
        if(up.isEmpty()){
            return "";
        }
        char ch= up.charAt(0);
        if(up.startsWith("app") && !up.startsWith("apple")){
            return skipAppNotApple(up.substring(3));
        } else{
            return ch+skipAppNotApple(up.substring(1));
        }

    }
}
