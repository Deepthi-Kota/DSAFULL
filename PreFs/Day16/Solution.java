package PreFs.Day16;
/* You have a list of employee objects representing the company's staff, 
where each employee object contains the following attributes:
    - name (String)
    - age (int)
    - department (String)
    - salary (double)

Write a Java program that reads the number of employees and their details 
from user input, where each employee’s data is entered on a single line 
in the format: name age department salary.

Your task is to perform the following operations concurrently using multithreading:
    - Filter the list to include only employees with a salary greater than 50,000.
    - Map the remaining employees to a new list of their names only.
    - Reduce the salaries of the filtered employees to compute the total salary 
      expenditure.
    - Partition the list of employees into two groups:
        - One with employees above 30 years of age.
        - Another with employees 30 years or younger.

Requirements:
-------------
    - Use the Streams API and parallel streams to process the list in parallel.
    - Use ExecutorService to manage concurrent tasks for filtering, mapping, 
      reducing, and partitioning.
    - Implement each step using separate threads, ensuring parallel execution 
      of the tasks.

Expected Outcome:
----------------
    - A filtered list of employee names with salaries greater than 50,000.
    - The total salary expenditure for employees earning above 50,000.
    -Two partitioned groups of employees: 
        - one with age > 30 and the other with age <= 30.

Sample Input:
-------------
6
Alice 25 IT 60000
Bob 35 Finance 45000
Charlie 28 IT 52000
David 40 HR 70000
Eve 30 Finance 49000
Frank 32 IT 80000

Sample Output:
--------------
Names of Employees with Salary > 50,000:
[Alice, Charlie, David, Frank]
Total Salary Expenditure for Employees with Salary > 50,000:
262000.0
Employees above 30 years of age:
[Employee{name='Bob', age=35, department='Finance', salary=45000.0}, Employee{name='David', age=40, department='HR', salary=70000.0}, Employee{name='Frank', age=32, department='IT', salary=80000.0}]
Employees 30 years or younger:
[Employee{name='Alice', age=25, department='IT', salary=60000.0}, Employee{name='Charlie', age=28, department='IT', salary=52000.0}, Employee{name='Eve', age=30, department='Finance', salary=49000.0}]
*/

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
// Employee class.
class Employee {
    String name;
    int age;
    String department;
    double salary;

    public Employee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", department='" + department + "', salary=" + salary + "}";
    }
}


public class Solution{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<Employee> emp = new ArrayList<>();
        for(int i=0; i<n; i++){
            String[] s = sc.nextLine().split(" ");
            String name = s[0].trim();
            int age = Integer.parseInt(s[1].trim());
            String dep = s[2].trim();
            double sal = Double.parseDouble(s[3].trim());
            emp.add(new Employee(name,age,dep,sal));
        }
        
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Callable<List<Employee>> filterTask = () -> emp.parallelStream()
            .filter(e->e.getSalary()>50000.0)
            .collect(Collectors.toList());
            
        Callable<List<String>> mapTask = () ->{
            List<Employee> filteredEmp = filterTask.call();
            return filteredEmp.stream().map(Employee::getName).collect(Collectors.toList());
        };
        Callable<Double> reduceTask =()->{
            List<Employee> filteredEmp = filterTask.call();
            return filteredEmp.stream().mapToDouble(Employee::getSalary).reduce(0.0,Double::sum);
        } ;
        
        Callable<Map<Boolean, List<Employee>>> partitionTask1 = () -> emp.parallelStream()
            .collect(Collectors.partitioningBy(e -> e.getAge() > 30));
            
        Future<List<String>> empnameFuture = executor.submit(mapTask);
        Future<Double> totalExp = executor.submit(reduceTask);
        Future<Map<Boolean, List<Employee>>> partitionfuture1 = executor.submit(partitionTask1);

        List<String> empname = empnameFuture.get();
        Double texp = totalExp.get();
        Map<Boolean,List<Employee>> partition30 = partitionfuture1.get();
        
        System.out.println("Names of Employees with Salary > 50,000:");
        System.out.println(empname);
        System.out.println("Total Salary Expenditure for Employees with Salary > 50,000:");
        System.out.println(texp);
        System.out.println("Employees above 30 years of age:");
        System.out.println(partition30.get(true));
        System.out.println("Employees 30 years or younger:");
        System.out.println(partition30.get(false));
        executor.shutdown();
        sc.close();
    }
}
