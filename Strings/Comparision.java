public class Comparision {
    public static void main(String[] args){
        String a="hello";
        String b="hello"; //points to same object in string pool
        System.out.println(a==b); //true, because they both point to same object , == operator checks if two references points to single object 
        String c = a;
        System.out.println(c==a); //true, points to same object
        a = "hi"; //object is not modified instead new object is created in pool, and a is referenced to the object

        //if we dont want to create an object in string pool, or if we want a new object to be created we can you use new keyword
        String name = new String("Deepthi");
        String first = new String("Deepthi"); //2 objects created on heap

        System.out.println(name==first); //false, because both references points to different object

        //if we want to compare the values of the objects
        System.out.println(name.equals(first));
    }
}
