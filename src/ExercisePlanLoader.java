import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExercisePlanLoader {
    public static List<String> loadExercisePlan(String fileName) {
        List<String> exercisePlan = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                exercisePlan.add(line);
            }
        } catch (IOException e) {
            System.out.println("No existing exercise plan found.");
        }
        return exercisePlan;
    }
} 