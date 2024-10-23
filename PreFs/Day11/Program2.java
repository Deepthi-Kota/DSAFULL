/*
You are required to build an Employee Management System that processes a list 
of Employee objects to group them by their department and calculate the average 
salary for each department. Each Employee object has the following attributes:
    - Name: (String) The name of the employee
    - Department: (String) The department in which the employee works
    - Salary: (double) The salary of the employee
    
Your task is to group employees by their department and find the average salary 
for each department using Java Streams.

Sample Input:
-------------
4                   //no of employees
Alice,IT,60000      //name, department,salary
Bob,HR,50000
Charlie,IT,70000
David,HR,55000

Sample Output:
-------------
HR : 52500.00
IT : 65000.00

*/
import java.util.*;
import java.util.stream.Collectors;

class Employee{
    String name;
    String dep;
    double sal;
    
    Employee(String name, String dep, double sal){
        this.name = name;
        this.dep = dep;
        this.sal = sal;
    }
    
}
public class Program2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<Employee> emp = new ArrayList<>();
        for(int i=0; i<n; i++){
            String[] s = sc.nextLine().split(",");
            String name = s[0].trim();
            String dep = s[1].trim();
            double sal = Double.parseDouble(s[2].trim());
            emp.add(new Employee(name,dep,sal));
        }
        Map<String,Double> avg = emp.stream()
            .collect(Collectors.groupingBy(e->e.dep, Collectors.averagingDouble(e->e.sal)));
        
        avg.forEach((dep,avgsal)->{
            System.out.println(dep+" : "+String.format("%.2f",avgsal));
        });    
        sc.close();
    }
}