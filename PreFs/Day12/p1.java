package PreFs.Day12;
/*
You are given a list of Product objects with fields name, category, and price. 
Write a Given a list of Product objects with the following fields:
    - name (String)
    - category (String)
    - price (double)
    - quantityInStock (int)
    
Write a program to filter products where the stock is more than 5 units.
Then group the products by their category, then find the total value of stock 
(price × quantity) for each category and finally find the category with the 
highest total stock value.

Input Format:
-------------
Line-1: AN integer N, number of products.
Next N lines: 3 space separated strings, first is name, 
              second is category and thrid is price and
              last one is quantity.

Output Format:
--------------
A string, name of the category with highest stock value.


Sample Input:
-------------
5
Laptop Electronics 1000.0 10
Phone Electronics 500.0 5
Shoes Clothing 50.0 20
Jacket Clothing 100.0 10
Blender Home_Appliances 150.0 3

Sample Output:
--------------
Electronics
    
*/

import java.util.*;
import java.util.stream.Collectors;
class Product{
    String name;
    String category;
    double price;
    int quantity;
    public Product(String name, String category, double price, int quantity) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }
    
    public double stock(){
        return price*quantity;
    }
}
public class p1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<Product> products = new ArrayList<>();
        for(int i=0; i<n; i++){
            String[] s = sc.nextLine().split(" ");
            String name = s[0].trim();
            String cat = s[1].trim();
            double pri = Double.parseDouble(s[2].trim());
            int qua = Integer.parseInt(s[3].trim());
            products.add(new Product(name,cat,pri,qua));
        }
        Map<String, Double> filtered = products.stream()
            .filter(p->p.quantity>5)
            .collect(Collectors.groupingBy(p->p.category, Collectors.summingDouble(Product::stock)));
    String high = filtered.entrySet().stream()
        .max(Map.Entry.comparingByValue())
        .map(Map.Entry::getKey)
        .orElse("no Category");
    System.out.println(high); 
    sc.close();   
    }
}










