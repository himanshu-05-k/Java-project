import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\n Welcome to VIT Bank ");
            System.out.println("1. Create an Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Check Balance & History");
            System.out.println("6. Exit");
            System.out.print("Choose: ");
            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 1) {
                System.out.print("Account Number: ");
                String num = sc.nextLine();
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Initial Deposit: ");
                double amt = sc.nextDouble();
                bank.createAccount(num, name, amt);

            } else if (ch == 2) {
                System.out.print("Account Number: ");
                String num = sc.nextLine();
                Account a = bank.find(num);
                if (a != null) {
                    System.out.print("Amount: ");
                    a.deposit(sc.nextDouble());
                }

            } else if (ch == 3) {
                System.out.print("Account Number: ");
                String num = sc.nextLine();
                Account a = bank.find(num);
                if (a != null) {
                    System.out.print("Amount: ");
                    a.withdraw(sc.nextDouble());
                }

            } else if (ch == 4) {
                System.out.print("From Account: ");
                String from = sc.nextLine();
                System.out.print("To Account: ");
                String to = sc.nextLine();
                Account a1 = bank.find(from);
                Account a2 = bank.find(to);
                if (a1 != null && a2 != null) {
                    System.out.print("Amount: ");
                    a1.transfer(a2, sc.nextDouble());
                }

            } else if (ch == 5) {
                System.out.print("Account Number: ");
                String num = sc.nextLine();
                Account a = bank.find(num);
                if (a != null) {
                    System.out.println("Balance: Rs" + a.balance);
                    a.showHistory();
                }

            } else if (ch == 6) {
                System.out.println("Thank You!");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}
