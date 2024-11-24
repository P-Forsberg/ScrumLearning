package user;

import saveandload.SaveAndLoad;

import java.io.*;
import java.util.Scanner;

public class UserManager implements SaveAndLoad {
    private Scanner scanner;

    public UserManager() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            displayMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    loginUser();
                    break;
                case "2":
                    registerNewUser();
                    break;
                case "3":
                    try {
                        saveQuiz();
                    } catch (IOException e) {
                        System.out.println("Failed to save data: " + e.getMessage());
                    }
                    break;
                case "4":
                    try {
                        loadQuiz();
                    } catch (IOException e) {
                        System.out.println("Failed to load data: " + e.getMessage());
                    }
                    break;
                case "0":
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nWelcome to Quiz");
        System.out.println("1. Username");
        System.out.println("2. Register new username");
        System.out.println("3. Save user data");
        System.out.println("4. Load user data");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    private void registerNewUser() {
        System.out.print("Enter a new username: ");
        String username = scanner.nextLine();

        if (Users.isUsernameTaken(username)) {
            System.out.println("Username is already taken. Please try again.");
        } else {
            Users newUser = new Users(username);
            System.out.println("Welcome, " + newUser.getUsername() + "!");
        }
    }

    private void loginUser() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        if (Users.usernameExists(username)) {
            System.out.println("Welcome back, " + username + "!");
        } else {
            System.out.println("Username not found. Please register as a new user.");
        }
    }

    @Override
    public void saveQuiz() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt"))) {
            for (String username : Users.getRegisteredUsernames()) {
                writer.write(username);
                writer.newLine();
            }
            System.out.println("User data saved successfully.");
        }
    }

    @Override
    public void loadQuiz() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                new Users(line);
            }
            System.out.println("User data loaded successfully.");
        }
    }

    public void close() {
        scanner.close();
    }
}