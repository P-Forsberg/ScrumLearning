package uppgift.user;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectReader;
import uppgift.statistics.FileService;
import uppgift.statistics.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.fasterxml.jackson.databind.ObjectMapper;


public class UserManager implements FileService {
    private Player currp;
    private List<Player> regPlayers;
    private Scanner scanner;

    private static final String FILE_PATH = "players.json";

    public UserManager() {
        this.scanner = new Scanner(System.in);
        currp = null;
        this.regPlayers = new ArrayList<>();
        load();
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
        save();
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

    @Override
    public void save() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(FILE_PATH), regPlayers);
        } catch (IOException e) {
            System.out.println("Error saving user data.");
        }
    }

    @Override
    public void load() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                regPlayers = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Player.class));
            }
        } catch (IOException e) {
            System.out.println("No previous user data found, starting fresh.");
        }
    }
}

