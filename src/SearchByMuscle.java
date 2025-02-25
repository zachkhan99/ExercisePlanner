import java.util.Scanner;

public class SearchByMuscle {
    private static final String API_URL = "https://exercises-by-api-ninjas.p.rapidapi.com/v1/exercises";

    public static void search() {
        Scanner scanner = ExercisePlannerApp.getScanner();
        try {
            System.out.println("Search by muscle group targeted by the exercise. Possible values are:");
            System.out.println("1. Abdominals");
            System.out.println("2. Abductors");
            System.out.println("3. Adductors");
            System.out.println("4. Biceps");
            System.out.println("5. Calves");
            System.out.println("6. Chest");
            System.out.println("7. Forearms");
            System.out.println("8. Glutes");
            System.out.println("9. Hamstrings");
            System.out.println("10. Lats");
            System.out.println("11. Lower Back");
            System.out.println("12. Middle Back");
            System.out.println("13. Neck");
            System.out.println("14. Quadriceps");
            System.out.println("15. Traps");
            System.out.println("16. Triceps");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();

            String muscle;
            switch (choice) {
                case 1:
                    muscle = "abdominals";
                    break;
                case 2:
                    muscle = "abductors";
                    break;
                case 3:
                    muscle = "adductors";
                    break;
                case 4:
                    muscle = "biceps";
                    break;
                case 5:
                    muscle = "calves";
                    break;
                case 6:
                    muscle = "chest";
                    break;
                case 7:
                    muscle = "forearms";
                    break;
                case 8:
                    muscle = "glutes";
                    break;
                case 9:
                    muscle = "hamstrings";
                    break;
                case 10:
                    muscle = "lats";
                    break;
                case 11:
                    muscle = "lower_back";
                    break;
                case 12:
                    muscle = "middle_back";
                    break;
                case 13:
                    muscle = "neck";
                    break;
                case 14:
                    muscle = "quadriceps";
                    break;
                case 15:
                    muscle = "traps";
                    break;
                case 16:
                    muscle = "triceps";
                    break;
                default:
                    System.out.println("Invalid choice. Exiting search.");
                    return;
            }

            String response = HttpClientManager.sendGetRequest(API_URL, "?muscle=" + muscle);
            System.out.println("\nResults:");
            
            String[] exercises = response.split("\\},\\s*\\{");
            
            if (exercises.length == 0) {
                System.out.println("\nNo exercises found for this muscle group.");
            } else {
                exercises[0] = exercises[0].replaceFirst("^\\[\\{", "");
                int lastIndex = exercises.length - 1;
                exercises[lastIndex] = exercises[lastIndex].replaceFirst("\\}\\]$", "");
                
                System.out.println("\nFound " + exercises.length + " exercises:");
                for (String exercise : exercises) {
                    String fullExercise = "{" + exercise + "}";
                    System.out.print(ExerciseFormatter.formatExercise(fullExercise));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
