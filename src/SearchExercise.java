import java.util.Scanner;

public class SearchExercise {
    

    public static void searchMenu() {
        Scanner scanner = ExercisePlannerApp.getScanner();
        int choice;
        do {
            System.out.println("\nSearch by:");
            System.out.println("1. Name");
            System.out.println("2. Type");
            System.out.println("3. Muscle");
            System.out.println("4. Difficulty");
            System.out.println("5. Exit Search");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    SearchByName.search();
                    break;
                case 2:
                    SearchByType.search();
                    break;
                case 3:
                    SearchByMuscle.search();
                    break;
                case 4:
                    SearchByDifficulty.search();
                    break;
                case 5:
                    System.out.println("Exiting search.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1-5.");
            }
        } while (choice != 5);
    }
}
