package uppgift.statistics;

import java.util.HashMap;
import java.util.Map;

public class LeaderboardManager {
    private Map<String, StatisticManager> playerStats;

    public LeaderboardManager() {
        this.playerStats = new HashMap<>();
    }

    public void addPlayer(String playerName) {
        playerStats.putIfAbsent(playerName, new StatisticManager());
    }

    public void updatePlayerStats(String playerName, boolean isCorrect, String category) {
        if (!playerStats.containsKey(playerName)) {
            addPlayer(playerName);
        }
        playerStats.get(playerName).updateStats(isCorrect, category);
    }

    public void displayLeaderboard() {
        System.out.println("=== Total Leaderboard ===");
        playerStats.forEach((player, stats) -> {
            System.out.printf("%s: %d points\n", player, stats.getScore());
        });
    }

    public void displayCategoryLeaderboard(String category) {
        System.out.printf("=== Leaderboard for %s ===\n", category);
        playerStats.forEach((player, stats) -> {
            Map<String, int[]> categoryStats = stats.getCategoryStats();
            if (categoryStats.containsKey(category)) {
                int[] catStats = categoryStats.get(category);
                double accuracy = catStats[1] > 0 ? (catStats[0] / (double) catStats[1]) * 100 : 0.0;
                System.out.printf("%s: %d/%d (%.2f%%)\n", player, catStats[0], catStats[1], accuracy);
            }
        });
    }
}