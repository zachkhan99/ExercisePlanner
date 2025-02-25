import java.util.Scanner;

public class SearchByType {
    private static final String API_URL = "https://exercises-by-api-ninjas.p.rapidapi.com/v1/exercises";

    public static void search() {
        Scanner scanner = ExercisePlannerApp.getScanner();
        try {
            System.out.println("Search by exercise type. Possible values are:");
            System.out.println("1. Cardio");
            System.out.println("2. Olympic Weightlifting");
            System.out.println("3. Plyometrics");
            System.out.println("4. Powerlifting");
            System.out.println("5. Strength");
            System.out.println("6. Stretching");
            System.out.println("7. Strongman");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();

            String type;
            switch (choice) {
                case 1:
                    type = "cardio";
                    break;
                case 2:
                    type = "olympic_weightlifting";
                    break;
                case 3:
                    type = "plyometrics";
                    break;
                case 4:
                    type = "powerlifting";
                    break;
                case 5:
                    type = "strength";
                    break;
                case 6:
                    type = "stretching";
                    break;
                case 7:
                    type = "strongman";
                    break;
                default:
                    System.out.println("Invalid choice. Exiting search.");
                    return;
            }

            String response = HttpClientManager.sendGetRequest(API_URL, "?type=" + type);
            System.out.println("\nResults:");
            
            // Split on the complete exercise objects instead
            String[] exercises = response.split("\\},\\s*\\{");
            
            if (exercises.length == 0) {
                System.out.println("\nNo exercises found for this type.");
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
