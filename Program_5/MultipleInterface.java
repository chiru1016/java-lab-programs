package Multiple_Interface;
import java.util.Scanner;

interface Personal {
	void displayPersonalDetails();
}

interface Official {
	void displayOfficialDetails();
}

class Employee implements Personal, Official {
	String name;
	int age;
	String designation;
	String department;

 Employee(String name, int age, String designation, String department) {
    this.name = name;
    this.age = age;
    this.designation = designation;
    this.department = department;
 }

 public void displayPersonalDetails() {
    System.out.println("\n----- Personal Details -----");
    System.out.println("Name : " + name);
    System.out.println("Age  : " + age);
 }

 public void displayOfficialDetails() {
    System.out.println("\n----- Official Details -----");
    System.out.println("Designation : " + designation);
    System.out.println("Department  : " + department);
 }
}

//Main class
public class MultipleInterface {

 public static void main(String[] args) {

     Scanner sc = new Scanner(System.in);

     System.out.print("Enter Employee Name: ");
     String name = sc.nextLine();

     System.out.print("Enter Employee Age: ");
     int age = sc.nextInt();
     sc.nextLine();

     System.out.print("Enter Designation: ");
     String designation = sc.nextLine();

     System.out.print("Enter Department: ");
     String department = sc.nextLine();

     Employee emp = new Employee(name, age, designation, department);

     boolean running = true;
     while (running) {

         System.out.println("\n========== MENU ==========");
         System.out.println("1. Display Personal Details");
         System.out.println("2. Display Official Details");
         System.out.println("3. Display Both");
         System.out.println("4. Exit");
         System.out.print("Enter your choice: ");

         int choice = sc.nextInt();
         switch (choice) {

         case 1:
         emp.displayPersonalDetails();
         break;

         case 2:
         emp.displayOfficialDetails();
         break;

         case 3:
         emp.displayPersonalDetails();
         emp.displayOfficialDetails();
         break;
         
         case 4:
         System.out.println("\nThank you!");
         running = false;
         break;

         default:
         System.out.println("\nInvalid choice! Try again.");
         }
     }
     sc.close();
 }
}
