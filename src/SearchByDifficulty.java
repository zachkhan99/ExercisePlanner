import java.util.Scanner;

public class SearchByDifficulty {
    private static final String API_URL = "https://exercises-by-api-ninjas.p.rapidapi.com/v1/exercises";

    public static void search() {
        Scanner scanner = ExercisePlannerApp.getScanner();

        System.out.println("Search by difficulty level of the exercise. Possible values are:");
        System.out.println("1. Beginner");
        System.out.println("2. Intermediate");
        System.out.println("3. Expert");
        System.out.println("Enter your choice: ");

        int choice = scanner.nextInt();

        String difficulty;
        switch (choice) {
            case 1:
                difficulty = "beginner";
                break;
            case 2:
                difficulty = "intermediate";
                break;
            case 3:
                difficulty = "expert";
                break;
            default:
                System.out.println("Invalid choice. Exiting search.");
                return;
        }

        try {
            String response = HttpClientManager.sendGetRequest(API_URL, "?difficulty=" + difficulty);
            System.out.println("\nResults:");
            
            // Split on the complete exercise objects instead
            String[] exercises = response.split("\\},\\s*\\{");
            
            if (exercises.length == 0) {
                System.out.println("\nNo exercises found for this difficulty level.");
            } else {
                // Clean up the first and last elements
                exercises[0] = exercises[0].replaceFirst("^\\[\\{", "");
                int lastIndex = exercises.length - 1;
                exercises[lastIndex] = exercises[lastIndex].replaceFirst("\\}\\]$", "");
                
                System.out.println("\nFound " + exercises.length + " exercises:");
                for (String exercise : exercises) {
                    // Restore the JSON object syntax for each exercise
                    String fullExercise = "{" + exercise + "}";
                    System.out.print(ExerciseFormatter.formatExercise(fullExercise));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
