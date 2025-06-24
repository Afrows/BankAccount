import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    static bank bank = new bank();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello, please enter your name");
        String name = scanner.nextLine();
        bank.setCustomerName(name);

        do {
            System.out.println("Would you like to withdraw or deposit");
            String choice = scanner.nextLine();
            double currentBalance = 10.0;
            String number = " ";

            try {
                if (choice.equalsIgnoreCase("Withdraw")) {
                    withdraw(number, currentBalance);
                    break;
                } else if (choice.equalsIgnoreCase("Deposit")) {
                    deposit(number, currentBalance);
                    break;
                } else
                    continue;
            } catch (NullPointerException e) {
                System.out.println("Please type that again");
                continue;
            }
        } while (true);

    }

    public static void deposit(String number, double currentBalance) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, " + bank.getCustomerName() + ", your current balance is £" + currentBalance + ". How much would you like to deposit?");
        number = scanner.nextLine();

        try {
            double deposit = Double.parseDouble(number);
            if (deposit < 0.0) {
                System.out.println("Invalid Number");
                return;
            }
            currentBalance = deposit + currentBalance;
            System.out.println("Thank you, your new current balance is: £" + currentBalance);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Number");
        }
    }
    public static void withdraw(String number, double currentBalance) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, " + bank.getCustomerName() + ", your current balance is £" + currentBalance + ". How much would you like to withdraw");
        number = scanner.nextLine();

        try {
            double withdraw = Double.parseDouble(number);
            if (withdraw < 0.0 || currentBalance - withdraw < 0) {
                System.out.println("Insufficient Funds, Try Again");
                return;
            }
            currentBalance = currentBalance - withdraw;
            System.out.println("Thank you, your new current balance is: £" + currentBalance);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Number");
        }
    }
}
