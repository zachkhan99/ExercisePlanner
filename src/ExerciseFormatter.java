public class ExerciseFormatter {
    public static String formatExercise(String jsonExercise) {
        if (jsonExercise == null || jsonExercise.trim().isEmpty()) {
            return "";
        }

        // Skip if no name field is found
        if (!jsonExercise.contains("\"name\":")) {
            return "";
        }

        StringBuilder formatted = new StringBuilder();
        formatted.append("\n======================\n");
        
        // Extract name first (it's the most important field)
        String namePattern = "\"name\"\\s*:\\s*\"([^\"]+)\"";
        java.util.regex.Pattern nameRegex = java.util.regex.Pattern.compile(namePattern);
        java.util.regex.Matcher nameMatcher = nameRegex.matcher(jsonExercise);
        
        if (!nameMatcher.find()) {
            return ""; // Skip if no name found
        }
        
        formatted.append("Name: ").append(nameMatcher.group(1)).append("\n");
        
        // Handle the remaining fields in order
        String[] fields = {"type", "muscle", "equipment", "difficulty", "instructions"};
        
        for (String field : fields) {
            String pattern = "\"" + field + "\"\\s*:\\s*\"([^\"]+)\"";
            java.util.regex.Pattern r = java.util.regex.Pattern.compile(pattern);
            java.util.regex.Matcher m = r.matcher(jsonExercise);
            
            if (m.find()) {
                // Capitalize first letter of field name
                String label = field.substring(0, 1).toUpperCase() + field.substring(1);
                formatted.append(label).append(": ").append(m.group(1)).append("\n");
            }
        }
        
        formatted.append("======================");
        return formatted.toString();
    }
} 