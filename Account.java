import java.util.ArrayList;
import java.util.List;

public class Account {
    String number, name;
    double balance;
    List<String> transactions;

    public Account(String number, String name, double initial) {
        this.number = number;
        this.name = name;
        this.balance = initial;
        this.transactions = new ArrayList<>();
        addTransaction("Initial Deposit", initial);
    }

    void deposit(double amount) {
        balance += amount;
        addTransaction("Deposit", amount);
        System.out.println("Deposited: Rs" + amount);
    }

    boolean withdraw(double amount) {
        if (balance - amount >= 500) {
            balance -= amount;
            addTransaction("Withdraw", amount);
            System.out.println("Withdrawn: Rs" + amount);
            return true;
        } else {
            System.out.println("Insufficient balance!");
            return false;
        }
    }

    void transfer(Account to, double amount) {
        if (this.withdraw(amount)) {
            to.deposit(amount);
            System.out.println("Transferred Rs" + amount + " to " + to.number);
        }
    }

    void addTransaction(String type, double amount) {
        transactions.add(type + ": Rs" + amount + " | Balance: Rs" + balance);
    }

    void showHistory() {
        System.out.println("\n Account Transaction History " + number);
        for (String t : transactions) {
            System.out.println(t);
        }
        System.out.println("Current Balance: Rs" + balance + "\n");
    }
}
