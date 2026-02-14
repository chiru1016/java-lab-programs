package cal;
import java.util.Scanner;

class BankAccount {
    String name;
    String accountType;
    double balance;

    static int totalAccounts = 0;

    // Constructor 1: Only name
    BankAccount(String name) {
        this.name = name;
        this.accountType = "Savings";
        this.balance = 0.0;
        totalAccounts++;
    }

    // Constructor 2: Name and initial deposit
    BankAccount(String name, double initialDeposit) {
        this.name = name;
        this.accountType = "Savings";
        this.balance = initialDeposit;
        totalAccounts++;
    }

    // Constructor 3: Name, initial deposit and account type
    BankAccount(String name, double initialDeposit, String accountType) {
        this.name = name;
        this.accountType = accountType;
        this.balance = initialDeposit;
        totalAccounts++;
    }

    // Method Overloading - Deposit (amount only)
    void deposit(double amount) {
        balance += amount;
        System.out.println("₹" + amount + " deposited through Cash.");
    }

    // Method Overloading - Deposit (amount + transaction type)
    void deposit(double amount, String transactionType) {
        balance += amount;
        System.out.println("₹" + amount + " deposited through " + transactionType + ".");
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient Balance!");
        } else {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        }
    }

    void display() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Name         : " + name);
        System.out.println("Account Type : " + accountType);
        System.out.println("Balance      : ₹" + balance);
    }

    static void showTotalAccounts() {
        System.out.println("Total Accounts Created: " + totalAccounts);
    }
}

public class Bank {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Deposit: ");
        double deposit = sc.nextDouble();

        BankAccount acc = new BankAccount(name, deposit);

        int choice;

        // do-while loop with switch-case
        do {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Deposit (Cash)");
            System.out.println("2. Deposit (Cheque)");
            System.out.println("3. Withdraw");
            System.out.println("4. Display Account Details");
            System.out.println("5. Show Total Accounts");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    double amt1 = sc.nextDouble();
                    acc.deposit(amt1);
                    break;

                case 2:
                    System.out.print("Enter amount: ");
                    double amt2 = sc.nextDouble();
                    acc.deposit(amt2, "Cheque");
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double wd = sc.nextDouble();
                    acc.withdraw(wd);
                    break;

                case 4:
                    acc.display();
                    break;

                case 5:
                    BankAccount.showTotalAccounts();
                    break;

                case 6:
                    System.out.println("Thank you for using the Banking Application.");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}
