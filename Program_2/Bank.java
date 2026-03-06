package Program_02;

import java.util.Scanner; 
public class P02 { 
 
    private String name,accountType; 
    private double balance; 
     
    private static int totalAccounts = 0; 

    public P02(String name) { 
        this.name = name; 
        this.accountType = "Savings"; 
        this.balance = 0; 
        totalAccounts++; 
    } 
 
    // Constructor 2: Name + Deposit 
    public P02(String name, double initialDeposit) { 
        this.name = name; 
        this.balance = initialDeposit; 
        this.accountType = "Savings"; 
        totalAccounts++; 
    } 
 
    // Constructor 3: Name + Deposit + Account Type 
    public P02(String name, double initialDeposit, String accountType) { 
        this.name = name; 
        this.balance = initialDeposit; 
        this.accountType = accountType; 
        totalAccounts++; 
    } 
 
    // Deposit overloading 
    public void deposit(double amount) { 
        balance += amount; 
        System.out.println("Deposited " + amount + " New Balance = " + balance); 
    } 
 
    public void deposit(double amount, String type) { 
        balance += amount; 
        System.out.println("Deposited " + amount + " via " + type + " New Balance = " + 
balance); 
    } 
 
    // Withdraw method 
    public void withdraw(double amount) { 
        if (amount > balance) { 
            System.out.println("Insufficient balance!"); 
        } else { 
            balance -= amount; 
            System.out.println("Withdrawn " + amount + ". Remaining Balance = " + balance); 
        } 
    } 
 
    public static void displayTotalAccounts() { 
        System.out.println("Total Accounts Created = " + totalAccounts); 
    } 
 
    public void displayInfo() { 
        System.out.println("Account Holder : " + name); 
        System.out.println("Account Type   : " + accountType); 
        System.out.println("Balance        : " + balance); 
    } 
 
    // MAIN METHOD WITH USER INPUT 
    public static void main(String[] args) { 
 
        Scanner sc = new Scanner(System.in); 
        int count = 0; 
 
        do { 
 
            System.out.println("Enter name:"); 
            String name = sc.nextLine(); 
 
            System.out.println("Enter 1 for default account "); 
            System.out.println("Enter 2 for account with initial deposit"); 
            System.out.println("Enter 3 for account with deposit + type"); 
            System.out.println("Enter 4 to skip"); 
            int ch = sc.nextInt(); 
            sc.nextLine(); 
 
            // Skip logic 
            if (ch == 4) { 
                System.out.println("Skipping\n"); 
            } 
 
            P02 acc; 
 
            if (ch == 1) { 
                acc = new P02(name); 
 
            } else if (ch == 2) { 
 
                System.out.println("Enter initial deposit:"); 
                double dep = sc.nextDouble(); 
                sc.nextLine(); 
                acc = new P02(name, dep); 
 
            } else if (ch == 3) { 
 
                System.out.println("Enter initial deposit:"); 
                double dep = sc.nextDouble(); 
                sc.nextLine(); 
                System.out.println("Enter account type (Savings/Current):"); 
                String type = sc.nextLine(); 
                acc = new P02(name, dep, type); 
 
            } else { 
                System.out.println("Invalid option! Skipping..."); 
                count++; 
                continue; 
            } 
 
            // Display account details 
            System.out.println("\n--- Account Created ---"); 
            acc.displayInfo(); 
 
            // Deposit 
            System.out.println("\nEnter amount to deposit:"); 
            double amt = sc.nextDouble(); 
            sc.nextLine(); 
 
            System.out.println("Enter deposit type (Cash/Cheque):"); 
            String dtype = sc.nextLine(); 
            acc.deposit(amt, dtype); 
 
            // Withdraw 
            System.out.println("\nEnter amount to withdraw:"); 
            double wamt = sc.nextDouble(); 
            sc.nextLine(); 
            acc.withdraw(wamt); 
 
            // Show total accounts created 
            System.out.println("\n--- Total Accounts ---"); 
            P02.displayTotalAccounts(); 
            count++; 
        	} while (count < 10); 
sc.close(); 
} 
}
