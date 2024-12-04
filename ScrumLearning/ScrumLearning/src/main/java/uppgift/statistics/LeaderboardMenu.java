package uppgift.statistics;

import uppgift.PrintUtil;
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
            System.out.println(PrintUtil.BLUE + "=== Leaderboard Menu ===");
            System.out.println("1. Show total leaderboard");
            System.out.println("2. Filter leaderboard by category");
            System.out.println("3. Back to main menu");
            System.out.print("Choose an option: " + PrintUtil.RESET);
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    leaderboardManager.displayLeaderboard();
                    break;
                case 2:
                    System.out.print("Category: ");
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("invalid input, try again.");
            }
            System.out.println();
        }
    }

    @Override
    public void execute(Player currentPlayer) {
    }
}
