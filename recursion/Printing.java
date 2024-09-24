public class Printing{
    public static void main(String[] args) {
        // incprint(1);
        // decprint(1);
        // bothprint(1);
        print(1);
    }
    static void incprint(int n){
        if(n==5){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        incprint(n+1);
    }
    static void decprint(int n){
        if(n==5){
            System.out.println(n);
            return;
        }
        decprint(n+1);        
        System.out.println(n);

    }
    static void bothprint(int n){
        if(n==5){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        decprint(n+1);        
        System.out.println(n);

    }
    static void print(int n){
        if(n==5){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        // incprint(n++); //doesnt work causes stack overflow, cuz it the number is not changed // is still working???
        print(++n);
    }
}