class BankAccount {
    protected String depositorName;
    protected String accountNumber;
    protected double balance;

    // Default constructor initializes account number to zero
    public BankAccount() {
        this.accountNumber = "0";
    }

    // Constructor to initialize all parameters
    public BankAccount(String depositorName, String accountNumber, double balance) {
        this.depositorName = depositorName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Display account information
    public void displayAccountInfo() {
        System.out.println("Depositor's Name: " + depositorName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }

    // Deposit money into the account
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount);
    }

    // Withdraw money from the account
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn $" + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String depositorName, String accountNumber, double balance, double interestRate) {
        super(depositorName, accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void computeAndDepositInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Interest of $" + interest + " deposited.");
    }
}

class CurrentAccount extends BankAccount {
    private double minimumBalance;
    private double serviceCharge;

    public CurrentAccount(String depositorName, String accountNumber, double balance, double minimumBalance, double serviceCharge) {
        super(depositorName, accountNumber, balance);
        this.minimumBalance = minimumBalance;
        this.serviceCharge = serviceCharge;
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= minimumBalance) {
            balance -= amount;
            System.out.println("Withdrawn $" + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void checkMinimumBalance() {
        if (balance < minimumBalance) {
            balance -= serviceCharge;
            System.out.println("Penalty charged: $" + serviceCharge);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount("John Doe", "12345", 1000, 5);
        savingsAccount.displayAccountInfo();
        savingsAccount.deposit(500);
        savingsAccount.computeAndDepositInterest();
        savingsAccount.displayAccountInfo();

        System.out.println();

        CurrentAccount currentAccount = new CurrentAccount("Jane Smith", "67890", 2000, 1000, 50);
        currentAccount.displayAccountInfo();
        currentAccount.withdraw(1500);
        currentAccount.checkMinimumBalance();
        currentAccount.displayAccountInfo();
    }
}
