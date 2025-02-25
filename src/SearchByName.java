import java.util.Scanner;

public class SearchByName {
    private static final String API_URL = "https://exercises-by-api-ninjas.p.rapidapi.com/v1/exercises";

    public static void search() {
        Scanner scanner = ExercisePlannerApp.getScanner();
        System.out.print("Search by name of exercise (partial matches allowed): ");
        String query = scanner.next();

        try {
            String response = HttpClientManager.sendGetRequest(API_URL, "?name=" + query);
            System.out.println("\nResults:");
            
            // Split on the complete exercise objects instead
            String[] exercises = response.split("\\},\\s*\\{");
            
            if (exercises.length == 0) {
                System.out.println("\nNo exercises found matching your search.");
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
