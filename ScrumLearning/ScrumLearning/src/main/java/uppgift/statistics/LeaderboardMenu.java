package uppgift.statistics;

import uppgift.menu.MenuOption;
import java.util.Scanner;

public class LeaderboardMenu implements MenuOption {
    private LeaderboardManager leaderboardManager;

    public LeaderboardMenu(LeaderboardManager leaderboardManager) {
        this.leaderboardManager = leaderboardManager;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("=== Leaderboard Menu ===");
            System.out.println("1. Visa hela leaderboarden");
            System.out.println("2. Filtrera leaderboard per kategori");
            System.out.println("3. Tillbaka till huvudmenyn");
            System.out.print("Välj ett alternativ: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Rensa raden

            switch (choice) {
                case 1:
                    // Visa hela leaderboarden
                    leaderboardManager.displayLeaderboard();
                    break;
                case 2:
                    // Filtrera per kategori
                    System.out.print("Ange kategori: ");
                    String category = scanner.nextLine();
                    leaderboardManager.displayCategoryLeaderboard(category);
                    break;
                case 3:
                    // Tillbaka till huvudmenyn
                    running = false;
                    break;
                default:
                    System.out.println("Ogiltigt val, försök igen.");
            }
            System.out.println();
        }
    }

    @Override
    public void execute() {
    }
}
