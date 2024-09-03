/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentmanagementtask;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Main class 
public class StudentManagementTask {
    public static void main (String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("STUDENT MANAGEMENT APPLICATION");
            System.out.println("****************************************************************");
            System.out.println("Enter 1 to launch the menu or enter any other key to exit");

            String choice = scanner.nextLine();
            if (!choice.equals("1")) 
            System.out.println("select task:");
            System.out.println("(1) Capture a new student.");
            System.out.println("(2) Search for a student.");
            System.out.println("(3) Print student report.");
            System.out.println("(4) Exit Application.");

            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    System.out.println("CAPTURE A NEW STUDENT");
                    System.out.println("*********************");
                    System.out.print("Enter the student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter the student name: ");
                    String name = scanner.nextLine();
                    int age = 0;
                    while (true) {
                       
                            System.out.print("Enter student age: ");
                            age = Integer.parseInt(scanner.nextLine());
                            if (age >= 16) break;
                            else System.out.println("Invalid. Student must be 16 or older.");
                        
                    }
                    System.out.print("Enter student email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter student course: ");
                    String course = scanner.nextLine();
                    Student student = new Student(id, name, age, email, course);
                    manager.saveStudent(student);
                    break;
                case 2:
                    System.out.print("Enter ID number to find student: ");
                    String searchId = scanner.nextLine();
                    Student foundStudent = manager.searchStudent(searchId);
                    if (foundStudent != null) {
                        System.out.println(foundStudent);
                    }
                    break;    
                case 3:
                    manager.studentReport();
                    break;
                case 4:
                    manager.exitStudentApplication();
                    break;
                default:
                    System.out.println("Invalid. Try again.");
            }
        }
    }
}

// Class representing a student with attributes and methods
class Student {
    private final String id;
    private final String name;
    private final int age;
    private final String email;
    private final String course;

    // student details
    public Student(String id, String name, int age, String email, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    // Getters for student attributes
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getEmail() {
        return email;
    }
    public String getCourse() {
        return course;
    }

    //display details
    public String toString() {
        return "STUDENT ID: " + id + " " + "STUDENT NAME: " + name + " " + "STUDENT AGE: " + age + " " + "STUDENT EMAIL: " + email + " " +  "STUDENT COURSE: " + course;
    }
}
// Class to manage student operations like saving, searching, deleting, and reporting
class StudentManager {
    private final List<Student> students = new ArrayList<>();

    // Method to save student details
    public void saveStudent(Student student) {
        students.add(student);
        System.out.println("Student details successfully saved.");
    }
    // search for a student by ID
    public Student searchStudent(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    // print a report of all students
    public void studentReport() {
        int count = 1;
        for (Student student : students) {
            System.out.println("STUDENT " + count);
            System.out.println(student);
            count++;
        }
    }
    //exit application
    public void exitStudentApplication() {
        System.out.println("Exiting application");
        System.exit(0);
    }
}