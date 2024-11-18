package User;

import java.util.Scanner;

public class UserManager {
    private Scanner scanner;

    public UserManager() {
        this.scanner = new Scanner(System.in);
    }

    public void registerUser() {
        while (true) {
            System.out.print("Enter your username: ");
            String inputUsername = scanner.nextLine();

            if (User.isUsernameTaken(inputUsername)) {
                System.out.println("Username is already taken. Please try again.");
            }

            else { User newUser = new User(inputUsername);
                System.out.println("Welcome, " + newUser.getUsername() + "!");
            }
        }
    }

    public void close() {
        scanner.close();
    }
}
