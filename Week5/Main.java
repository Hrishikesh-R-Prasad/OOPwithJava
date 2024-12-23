import java.util.Scanner;

class Account {
    private String customerName;
    private String accountNumber;
    private String accountType;
    private double balance;


    public Account(String customerName, String accountNumber, String accountType) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = 0.0;
    }


    public String getCustomerName() {
        return customerName;
    }


    public String getAccountNumber() {
        return accountNumber;
    }
    public String getAccountType() {
        return accountType;
    }


    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }


    public void displayBalance() {
        System.out.println("Balance: $" + balance);
    }


    public void updateBalance(double amount) {
        balance = amount;
    }
}


class SavAcct extends Account {
    private double interestRate;


    public SavAcct(String customerName, String accountNumber, double interestRate) {
        super(customerName, accountNumber, "Savings");
        this.interestRate = interestRate;
    }


    public void computeInterest(int years) {
        double balance = getBalance();
        double interest = balance * Math.pow((1 + interestRate / 100), years) - balance;
        deposit(interest); 
        System.out.println("Interest of $" + interest + " added to your account.");
    }

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

class CurAcct extends Account {
    private double minBalance;
    private double penalty;


    public CurAcct(String customerName, String accountNumber, double minBalance, double penalty) {
        super(customerName, accountNumber, "Current");
        this.minBalance = minBalance;
        this.penalty = penalty;
    }

 
    public void withdraw(double amount) {
        double balance = getBalance();
        if (amount > 0 && amount <= balance) {
            updateBalance(balance - amount);
            System.out.println("Withdrawn: $" + amount);


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


        System.out.print("Enter customer name for Savings Account: ");
        String savName = scanner.nextLine();
        System.out.print("Enter account number for Savings Account: ");
        String savAccNum = scanner.nextLine();
        SavAcct savAccount = new SavAcct(savName, savAccNum, 4.0); 

        savAccount.deposit(1000); 
        savAccount.computeInterest(2);
        savAccount.displayBalance();
        savAccount.withdraw(500); 
        savAccount.displayBalance();

        System.out.println("\n--------------------\n");


        System.out.print("Enter customer name for Current Account: ");
        String curName = scanner.nextLine();
        System.out.print("Enter account number for Current Account: ");
        String curAccNum = scanner.nextLine();
        CurAcct curAccount = new CurAcct(curName, curAccNum, 500, 50); 
        curAccount.deposit(1500); 
        curAccount.displayBalance();
        curAccount.withdraw(1200); 
        curAccount.displayBalance();
        curAccount.withdraw(500);
        curAccount.displayBalance();

        scanner.close();
    }
}
