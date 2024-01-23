import java.util.Scanner;

class BankAccount 
{
    private double balance;

    public BankAccount(double initialBalance) 
    {
        this.balance = initialBalance;
    }

    public double getBalance() 
    {
        return balance;
    }

    public void deposit(double amount) 
    {
        if (amount > 0) 
        {

            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } 
        else 
        {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) 
    {
        if (amount > 0 && amount <= balance) 
        {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } 
        else 
        {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }
}

class ATM 
{
    private BankAccount userAccount;

    public ATM(BankAccount userAccount) 
    {
        this.userAccount = userAccount;
    }

    public void displayMenu() 
    {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void performTransaction(int option, Scanner scanner) 
    {
        switch (option) 
        {
            case 1:
                // Check Balance
                System.out.println("Current Balance: $" + userAccount.getBalance());
                break;

            case 2:
                // Deposit
                System.out.print("Enter deposit amount: $");
                double depositAmount = scanner.nextDouble();
                userAccount.deposit(depositAmount);
                break;

            case 3:
                // Withdraw
                System.out.print("Enter withdrawal amount: $");
                double withdrawalAmount = scanner.nextDouble();
                userAccount.withdraw(withdrawalAmount);
                break;

            case 4:
                // Exit
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid option. Please choose a valid option.");
                break;
        }
    }
}

public class Main 
{

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        // Create a BankAccount with an initial balance of $1000
        BankAccount userAccount = new BankAccount(1000);

        // Create an ATM linked to the user's bank account
        ATM atm = new ATM(userAccount);

        while (true) 
        {
            atm.displayMenu();
            System.out.print("Enter your choice (1-4): ");
            int userChoice = scanner.nextInt();

            // Perform the selected transaction
            atm.performTransaction(userChoice, scanner);
        }
    }
}
