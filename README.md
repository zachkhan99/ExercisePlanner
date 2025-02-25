# Exercise Planner

## Project Overview
The **Exercise Planner** is a Java-based program designed to help users search for exercises, create personalized workout plans, and manage their fitness routines. The program features a **command-line interface (CLI)** that allows users to interact with the system efficiently. It includes user authentication, exercise searching, and customizable exercise plans, making it a valuable tool for fitness enthusiasts.

## Features
- **User Authentication**: Secure login system to maintain personalized exercise plans.
- **Exercise Search**: Allows users to find exercises based on muscle group, equipment, difficulty level, or type.
- **Personalized Workout Plans**: Users can create and modify exercise plans tailored to their fitness goals.
- **Intuitive Command-Line Interface**: Simplified navigation and interaction for ease of use.
- **Data Persistence**: Exercise plans and user credentials are stored in text files for persistence between sessions.

## Technologies Used
- **Java**: Core programming language.
- **Object-Oriented Programming (OOP)**: Applied principles like encapsulation, inheritance, and polymorphism.
- **File Handling**: Data storage for user exercise plans.
- **API Integration**: Handled via `HttpClientManager` for potential external exercise databases.
- **Makefile**: Automates compilation, JAR creation, and execution.

## Files in This Repository
- `Makefile` – Automates compilation and execution.
- `exercise_plan.txt` – Stores user-created workout plans.
- `user_credentials.txt` – Stores user login information.
- **Source Files (`src/`)**:
  - `Main.java` – Entry point of the program.
  - `DisplayMenu.java` – Handles menu display and navigation.
  - `ExercisePlannerApp.java` – Core application logic.
  - `ExercisePlanSaver.java` – Saves exercise plans to a file.
  - `ExercisePlanLoader.java` – Loads exercise plans from a file.
  - `ExerciseFormatter.java` – Formats exercises for display.
  - `HttpClientManager.java` – Handles API requests (if applicable).
  - `RegisterUser.java` – Manages user registration.
  - `UserLogin.java` – Handles user authentication.
  - `SearchExercise.java` and Variants – Implements search by name, muscle, difficulty, and type.
  - `ViewExercisePlan.java` – Displays user workout plans.

## How to Run the Program
1. **Ensure Java is Installed**: The program requires Java 8 or later.
2. **Compile and Build JAR**:
   ```bash
   make
   ```
3. **Run the Program**:
   ```bash
   make run
   ```
4. **Clean Build Files** (Optional):
   ```bash
   make clean
   ```

## Future Improvements
- Implement a **GUI-based interface** for a more interactive user experience.
- Enhance **data persistence** using databases instead of file handling.
- Expand exercise database with **more detailed filtering options**.
- Integrate an **external API** to fetch real-time exercise information.

## Author
**Zach Khan**
