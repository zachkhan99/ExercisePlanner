import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RegisterUser {
    private static final String USER_CREDENTIALS_FILE = "user_credentials.txt";
    private static final Map<String, String> userCredentials = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    static {
        loadUserCredentialsFromFile();
    }

    public static void register() {
        System.out.println("Enter your registration details:");

        System.out.print("Choose a username: ");
        String username = scanner.nextLine();

        // Check if the username is available
        if (!userCredentials.containsKey(username)) {
            System.out.print("Choose a password: ");
            String password = scanner.nextLine();

            // Add the new user to the in-memory Map and save to the file
            userCredentials.put(username, password);
            saveUserCredentialsToFile();

            System.out.println("\nRegistration successful! Welcome, " + username + "!");
        } else {
            System.out.println("Username is already taken. Registration failed.");
        }
    }

    private static void loadUserCredentialsFromFile() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(USER_CREDENTIALS_FILE));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                userCredentials.put(parts[0], parts[1]);
            }
        } catch (IOException e) {
            // Handle file reading exception
            e.printStackTrace();
        } finally {
            // Close the BufferedReader in a finally block to avoid resource leaks
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void saveUserCredentialsToFile() {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(USER_CREDENTIALS_FILE, true));
            for (Map.Entry<String, String> entry : userCredentials.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the BufferedWriter in a finally block to avoid resource leaks
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
