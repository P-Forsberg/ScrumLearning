package uppgift.statistics;

import uppgift.menu.MenuOption;

import java.util.Scanner;

public class LeaderboardMenu implements MenuOption {
    private LeaderboardManager leaderboardManager;

    public LeaderboardMenu() {
        this.leaderboardManager = new LeaderboardManager();
    }

    @Override
    public void execute() {
        displayMenu();
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Leaderboard Menu ===");
            System.out.println("1. View total leaderboard");
            System.out.println("2. View leaderboard for a specific category");
            System.out.println("3. Reset leaderboard statistics");
            System.out.println("4. Back to main menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> displayTotalLeaderboard();
                case 2 -> displayCategoryLeaderboard(scanner);
                case 3 -> resetLeaderboard();
                case 4 -> {
                    System.out.println("Returning to main menu.");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayTotalLeaderboard() {
        System.out.println("\n=== Total Leaderboard ===");
        leaderboardManager.displayTotalStats();
        System.out.println();
    }

    private void displayCategoryLeaderboard(Scanner scanner) {
        System.out.println("\nEnter the category name: ");
        String category = scanner.nextLine();
        System.out.println("\n=== " + category + " Leaderboard ===");
        leaderboardManager.displayCategoryStats(category);
        System.out.println();
    }
    private void resetLeaderboard() {
        System.out.print("Are you sure you want to reset all statistics? (yes/no): ");
        String confirmation = new Scanner(System.in).nextLine();

        if (confirmation.equalsIgnoreCase("yes")) {
            leaderboardManager = new LeaderboardManager();
            System.out.println("All statistics have been reset.");
        } else {
            System.out.println("Reset cancelled.");
        }
        System.out.println();
    }
}
