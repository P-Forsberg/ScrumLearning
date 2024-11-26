package uppgift.user;

import uppgift.menu.Menu;
import java.util.Scanner;

public class UserManager {
    private Scanner scanner;
    private Menu menu;

    public UserManager() {
        this.scanner = new Scanner(System.in);
        this.menu = new Menu();
    }

    public void start() {
        while (true) {
            displayMenu();
            String choice = scanner.nextLine();
            System.out.println();
            switch (choice) {
                case "1":
                    loginUser();
                    break ;
                case "2":
                    registerNewUser();
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
            System.out.println("Welcome, " + newUser.getUsername() + "!" + "\n");
            menu.displayMenu();
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
    public void close() {
        scanner.close();
    }
}
