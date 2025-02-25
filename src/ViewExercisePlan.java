import java.util.List;
import java.util.Scanner;

public class ViewExercisePlan {
    private static final Scanner scanner = new Scanner(System.in);

    public static void displayExercisePlan(List<String> exercisePlan) {
        if (exercisePlan.isEmpty()) {
            System.out.println("\nYour exercise plan is empty.");
        } else {
            System.out.println("\nYour Exercise Plan (" + exercisePlan.size() + " exercises):");
            for (int i = 0; i < exercisePlan.size(); i++) {
                String exercise = exercisePlan.get(i);
                System.out.println("\nExercise #" + (i + 1));
                System.out.println("======================");
                System.out.println(exercise);
                System.out.println("======================");
            }
        }
    }


    public static void addExerciseToPlan(List<String> exercisePlan) {
        System.out.print("Enter the name of the exercise to add: ");
        String exerciseName = scanner.nextLine();
        exercisePlan.add(exerciseName);
        System.out.println(exerciseName + " has been added to your exercise plan.");
    }

    public static void removeExerciseFromPlan(List<String> exercisePlan) {
        displayExercisePlan(exercisePlan);
        if (!exercisePlan.isEmpty()) {
            System.out.print("Enter the number of the exercise to remove: ");
            int exerciseNumber = scanner.nextInt();
            if (exerciseNumber >= 1 && exerciseNumber <= exercisePlan.size()) {
                String removedExercise = exercisePlan.remove(exerciseNumber - 1);
                System.out.println(removedExercise + " has been removed from your exercise plan.");
            } else {
                System.out.println("Invalid exercise number. Please enter a valid number.");
            }
        } else {
            System.out.println("Your exercise plan is already empty.");
        }
    }
}
