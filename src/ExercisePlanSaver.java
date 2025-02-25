import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExercisePlanSaver {
    public static void saveExercisePlan(List<String> exercisePlan, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String exercise : exercisePlan) {
                writer.write(exercise);
                writer.newLine();
            }
            System.out.println("Exercise plan saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error occurred while saving the exercise plan.");
        }
    }
}
