import java.util.Scanner;

class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful.");
            System.out.println("Amount deposited: ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful.");
            System.out.println("Amount withdrawn: ₹" + amount);
        }
    }

    public void transfer(BankAccount receiver, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid transfer amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            receiver.balance += amount;

            System.out.println("Transfer successful.");
            System.out.println("Amount transferred: ₹" + amount);
        }
    }

    public void displayDetails() {
        System.out.println("\n----- Account Details -----");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Balance        : ₹" + balance);
    }
}

public class BankingSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BankAccount account1 =
                new BankAccount(1001, "John", 5000);

        BankAccount account2 =
                new BankAccount(1002, "Alice", 3000);

        BankAccount currentAccount = account1;

        int choice;

        do {
            System.out.println("\n========== BANKING SYSTEM ==========");
            System.out.println("Current Account: "
                    + currentAccount.getAccountNumber());

            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Account Details");
            System.out.println("5. Transfer Money");
            System.out.println("6. Switch Account");
            System.out.println("7. Exit");

            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    currentAccount.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    currentAccount.withdraw(withdrawAmount);
                    break;

                case 3:
                    System.out.println(
                            "Current Balance: ₹"
                                    + currentAccount.getBalance());
                    break;

                case 4:
                    currentAccount.displayDetails();
                    break;

                case 5:
                    BankAccount receiver;

                    if (currentAccount == account1) {
                        receiver = account2;
                    } else {
                        receiver = account1;
                    }

                    System.out.print("Enter amount to transfer: ₹");
                    double transferAmount = scanner.nextDouble();

                    currentAccount.transfer(receiver, transferAmount);
                    break;

                case 6:
                    if (currentAccount == account1) {
                        currentAccount = account2;
                    } else {
                        currentAccount = account1;
                    }

                    System.out.println(
                            "Switched to account "
                                    + currentAccount.getAccountNumber());
                    break;

                case 7:
                    System.out.println(
                            "Thank you for using the Banking System!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 7);

        scanner.close();
    }
}
