package uppgift.user;

import uppgift.statistics.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    private Player currp;
    private List<Player> regPlayers;
    private Scanner scanner;

    private static final String FILE_PATH = "users.txt";

    public UserManager() {
        this.scanner = new Scanner(System.in);
        currp = null;
        this.regPlayers = new ArrayList<>();
        loadUsers();
    }

    public Player start() {
        while (true) {
            displayMenu();
            String choice = scanner.nextLine();
            System.out.println();
            switch (choice) {
                case "1":
                    if (loginUser()) {
                        return currp;
                    } else {
                        System.out.println("Username not found. Please register first.");
                    }
                    break;
                case "2":
                    registerNewUser();
                    break;
                case "0":
                    System.out.println("Exiting the system. Goodbye!");
                    return null;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nWelcome to Quiz");
        System.out.println("1. Login");
        System.out.println("2. Register new username");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    private void registerNewUser() {
        System.out.print("Enter a new username: ");
        String username = scanner.nextLine();
        for (Player p : regPlayers) {
            if (p.getUsername().equals(username)) {
                System.out.println("Username already taken. Please choose another one.");
                return;
            }
        }
        Player newPlayer = new Player(username);
        regPlayers.add(newPlayer);
        System.out.println("User registered successfully!");
        System.out.println("You can now log in with your username.");
        saveUsers();
    }

    private boolean loginUser() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        for (Player p : regPlayers) {
            if (username.equals(p.getUsername())) {
                currp = p;
                return true;
            }
        }
        return false;
    }

    private void loadUsers() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                Player player = new Player(line.trim());
                regPlayers.add(player);
            }
        } catch (IOException e) {
            System.out.println("No previous user data found, starting fresh.");
        }
    }

    private void saveUsers() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Player p : regPlayers) {
                bw.write(p.getUsername());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving user data.");
        }
    }
}
