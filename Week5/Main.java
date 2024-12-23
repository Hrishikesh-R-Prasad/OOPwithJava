import java.util.Scanner;

// Base class Account
class Account {
    private String customerName;
    private String accountNumber;
    private String accountType;
    private double balance;

    // Constructor to initialize account details
    public Account(String customerName, String accountNumber, String accountType) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = 0.0;
    }

    // Getter for customerName
    public String getCustomerName() {
        return customerName;
    }

    // Getter for accountNumber
    public String getAccountNumber() {
        return accountNumber;
    }

    // Getter for accountType
    public String getAccountType() {
        return accountType;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Method to accept deposit and update the balance
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to display the balance
    public void displayBalance() {
        System.out.println("Balance: $" + balance);
    }

    // Method to update balance (used by subclasses)
    public void updateBalance(double amount) {
        balance = amount;
    }
}

// Derived class for Savings Account
class SavAcct extends Account {
    private double interestRate;

    // Constructor for Savings Account
    public SavAcct(String customerName, String accountNumber, double interestRate) {
        super(customerName, accountNumber, "Savings");
        this.interestRate = interestRate;
    }

    // Method to compute and deposit interest
    public void computeInterest(int years) {
        double balance = getBalance();
        double interest = balance * Math.pow((1 + interestRate / 100), years) - balance;
        deposit(interest); // Using deposit method to add interest to the balance
        System.out.println("Interest of $" + interest + " added to your account.");
    }

    // Method to permit withdrawal and update the balance
    public void withdraw(double amount) {
        double balance = getBalance();
        if (amount > 0 && amount <= balance) {
            updateBalance(balance - amount);
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}

// Derived class for Current Account
class CurAcct extends Account {
    private double minBalance;
    private double penalty;

    // Constructor for Current Account
    public CurAcct(String customerName, String accountNumber, double minBalance, double penalty) {
        super(customerName, accountNumber, "Current");
        this.minBalance = minBalance;
        this.penalty = penalty;
    }

    // Method to permit withdrawal and update the balance with penalty check
    public void withdraw(double amount) {
        double balance = getBalance();
        if (amount > 0 && amount <= balance) {
            updateBalance(balance - amount);
            System.out.println("Withdrawn: $" + amount);

            // Check for minimum balance requirement
            if (getBalance() < minBalance) {
                updateBalance(getBalance() - penalty);
                System.out.println("Balance below minimum. Penalty of $" + penalty + " imposed.");
            }
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating a Savings Account
        System.out.print("Enter customer name for Savings Account: ");
        String savName = scanner.nextLine();
        System.out.print("Enter account number for Savings Account: ");
        String savAccNum = scanner.nextLine();
        SavAcct savAccount = new SavAcct(savName, savAccNum, 4.0); // 4% interest rate

        // Deposit and compute interest for Savings Account
        savAccount.deposit(1000); // Depositing $1000
        savAccount.computeInterest(2); // Compound interest for 2 years
        savAccount.displayBalance();
        savAccount.withdraw(500); // Withdraw $500
        savAccount.displayBalance();

        System.out.println("\n--------------------\n");

        // Creating a Current Account
        System.out.print("Enter customer name for Current Account: ");
        String curName = scanner.nextLine();
        System.out.print("Enter account number for Current Account: ");
        String curAccNum = scanner.nextLine();
        CurAcct curAccount = new CurAcct(curName, curAccNum, 500, 50); // $500 min balance, $50 penalty

        // Deposit and check withdrawal for Current Account
        curAccount.deposit(1500); // Depositing $1500
        curAccount.displayBalance();
        curAccount.withdraw(1200); // Withdraw $1200
        curAccount.displayBalance();
        curAccount.withdraw(500); // Withdraw $500 (should trigger penalty)
        curAccount.displayBalance();

        scanner.close();
    }
}
