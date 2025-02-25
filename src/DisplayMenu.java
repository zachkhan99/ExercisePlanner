import java.util.Scanner;

public class DisplayMenu {
    private static Scanner scanner = new Scanner(System.in);

    public static void displayWelcomeMessage() {
        System.out.println("\nWelcome to the exercise planning program!");
    }

    public static int displayLoginOrRegisterMenu() {
        System.out.println("Please choose an option:");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.print("Enter your choice: ");

        int choice = readIntInput();
        validateLoginOrRegisterChoice(choice);

        return choice;
    }

    private static int readIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // 
        }
        return scanner.nextInt();
    }

    private static void validateLoginOrRegisterChoice(int choice) {
        while (choice < 1 || choice > 2) {
            System.out.println("Invalid choice. Please enter 1 for Login or 2 for Register.");
            System.out.print("Enter your choice: ");
            choice = readIntInput();
        }
    }
}
