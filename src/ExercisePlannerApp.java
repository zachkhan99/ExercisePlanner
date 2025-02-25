import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExercisePlannerApp {
    private static final Scanner scanner = new Scanner(System.in);

    private static User currentUser;
    private static List<String> userExercisePlan = new ArrayList<>();

    public void start() {
        try {
            do {
                if (currentUser != null) {
                    displayUserMenu();
                    int userChoice = scanner.nextInt();

                    switch (userChoice) {
                        case 1:
                            SearchExercise.searchMenu();
                            break;
                        case 2:
                            ViewExercisePlan.displayExercisePlan(userExercisePlan);
                            handleExercisePlanOptions(userExercisePlan);
                            break;
                        case 3:
                            saveAndExit(userExercisePlan);
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                    }
                } else {
                    handleAuthentication();
                }
            } while (true);
        } finally {
            scanner.close(); // Only close scanner when program exits
        }
    }

    private static void displayUserMenu() {
        System.out.println("\nUser Menu:");
        System.out.println("1. Search Exercises");
        System.out.println("2. View Exercise Plan");
        System.out.println("3. Save and Exit");
        System.out.print("Enter your choice: ");
    }

    private static void handleExercisePlanOptions(List<String> userExercisePlan) {
        System.out.println("\nExercise Plan Options:");
        System.out.println("1. Add Exercise to Plan");
        System.out.println("2. Remove Exercise from Plan");
        System.out.println("3. Back to Main Menu");
        System.out.print("Enter your choice: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                ViewExercisePlan.addExerciseToPlan(userExercisePlan);
                break;
            case 2:
                ViewExercisePlan.removeExerciseFromPlan(userExercisePlan);
                break;
            case 3:
                System.out.println("\nReturning to the main menu.");
                break;
            default:
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
        }
    }

    private static void handleAuthentication() {
        DisplayMenu.displayWelcomeMessage();

        int authenticationChoice = DisplayMenu.displayLoginOrRegisterMenu();
        if (authenticationChoice == 1) {
            currentUser = UserLogin.login();
            if (currentUser != null) {
                userExercisePlan = ExercisePlanLoader.loadExercisePlan("exercise_plan.txt");
            }
        } else if (authenticationChoice == 2) {
            RegisterUser.register();
        } else {
            System.out.println("Invalid choice. Please enter 1 or 2.");
        }
    }

    private static void saveAndExit(List<String> userExercisePlan) {
        ExercisePlanSaver.saveExercisePlan(userExercisePlan, "exercise_plan.txt");
        System.out.println("Exercise plan saved. Exiting the program.");
        scanner.close();
        System.exit(0);
    }

    public static Scanner getScanner() {
        return scanner;
    }
}
