import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserLogin {
    private static final String USER_CREDENTIALS_FILE = "user_credentials.txt";
    private static final Map<String, String> userCredentials = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    static {
        loadUserCredentialsFromFile();
    }

    public static User login() {
        System.out.println("Enter your login credentials:");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        // Verify the credentials
        if (userCredentials.containsKey(username)) {
            System.out.print("Password: ");
            String password = scanner.nextLine();

            if (password.equals(userCredentials.get(username))) {
                System.out.println("\nLogin successful!");
                return new User(username, password);
            } else {
                System.out.println("Invalid password. Login failed.");
            }
        } else {
            System.out.println("User not found. Login failed.");
        }

        // Return null if login fails
        return null;
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
}
