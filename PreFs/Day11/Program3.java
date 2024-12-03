package PreFs.Day11;
/*
You are tasked with building a Student Score Management System that sorts 
students based on their scores. Each student has multiple test scores: 
a coding test score, MCQ test score, and a total score.

The students should be sorted according to the following rules:
    - Primary Sorting: By total score in descending order.
    - Secondary Sorting: If two students have the same total score, 
      sort them by coding test score in descending order.
    - Tertiary Sorting: If the coding test scores are also the same, 
      sort them by MCQ test score in descending order.
    
You must use Java Streams to perform the sorting operation.

Sample Input:
-------------
3               //no of students
Alice,80,70     // name, codingScore, mcqScore
Bob,85,60
Charlie,90,60

Sample Output:
--------------
Charlie: 90, 60, 150
Alice: 80, 70, 150
Bob: 85, 60, 145

*/
import java.util.*;
import java.util.stream.Collectors;

class Student{
  String name;
  int coding;
  int mcq;
  
  public Student(String name, int coding, int mcq) {
    this.name = name;
    this.coding = coding;
    this.mcq = mcq;
  }
  
  public int getCom(){
      return coding+mcq;
  }
  public int getco(){
      return coding;
  }
  public int getmc(){
      return mcq;
  }
  
  public String toString(){
      return name+": "+coding+", "+mcq+", "+getCom();
  }
}
public class Program3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<Student> stu = new ArrayList<>();
        for(int i=0; i<n; i++){
            String[] s = sc.nextLine().split(",");
            String name = s[0].trim();
            int co = Integer.parseInt(s[1].trim());
            int mc = Integer.parseInt(s[2].trim());
            stu.add(new Student(name,co,mc));
        }
        List<Student> sorteds = stu.stream()
            .sorted(Comparator.comparingInt(Student::getCom).reversed()
                .thenComparing(Comparator.comparingInt(Student::getco).reversed())
                .thenComparing(Comparator.comparingInt(Student::getmc).reversed()))
            .collect(Collectors.toList());
        sorteds.forEach(System.out::println);
        sc.close();
    }
}