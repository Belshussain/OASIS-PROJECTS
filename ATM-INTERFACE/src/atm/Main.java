package atm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        ATM atm = new ATM(bank, scanner);

        System.out.println("Welcome to the ATM! Please use these default user details to test the ATM functionality: ");
        System.out.println("User ID : user00");
        System.out.println("User PIN : 1111");
        System.out.println(" Use this RecipietID (Already exists on system) : user02");
        while (true) {
            System.out.print("Enter User ID: ");
            String userId = scanner.nextLine();
            System.out.print("Enter PIN: ");
            String userPin = scanner.nextLine();

            if (atm.authenticate(userId, userPin)) {
                System.out.println("Login successful");
                atm.showMenu();
            } else {
                System.out.println("Invalid User ID or PIN. Try again.");
            }
        }
    }
}
