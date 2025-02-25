# Define the source directory
SRC_DIR = src
BIN_DIR = bin

# Define Java source files and class files
SOURCES = $(SRC_DIR)/Main.java $(SRC_DIR)/DisplayMenu.java $(SRC_DIR)/ExercisePlannerApp.java $(SRC_DIR)/ExercisePlanSaver.java $(SRC_DIR)/HttpClientManager.java $(SRC_DIR)/RegisterUser.java $(SRC_DIR)/SearchByDifficulty.java $(SRC_DIR)/SearchByMuscle.java $(SRC_DIR)/SearchByName.java $(SRC_DIR)/SearchByType.java $(SRC_DIR)/SearchExercise.java $(SRC_DIR)/User.java $(SRC_DIR)/UserLogin.java $(SRC_DIR)/ViewExercisePlan.java $(SRC_DIR)/ExercisePlanLoader.java $(SRC_DIR)/ExerciseFormatter.java

# Define the name of the JAR file
JAR_FILE = Plan.jar
MANIFEST_FILE = manifest.txt

# Default target: compile the project and create the JAR file
all: $(JAR_FILE)

# Compile all Java files
compile:
	mkdir -p $(BIN_DIR)
	javac -d $(BIN_DIR) $(SOURCES)

# Target to create the JAR file
$(JAR_FILE): compile
	echo "Main-Class: Main" > $(MANIFEST_FILE)
	jar cfm $(JAR_FILE) $(MANIFEST_FILE) -C $(BIN_DIR) .

# Run the JAR file
run: $(JAR_FILE)
	java -jar $(JAR_FILE)

# Clean up
clean:
	rm -rf $(BIN_DIR)
	rm -f $(JAR_FILE) $(MANIFEST_FILE)

# Target to generate an empty exercise plan file
exercise_plan:
	echo "" > exercise_plan.txt

# Target to generate the user credentials file
user_credentials:
	echo "zach:zach" > user_credentials.txt
