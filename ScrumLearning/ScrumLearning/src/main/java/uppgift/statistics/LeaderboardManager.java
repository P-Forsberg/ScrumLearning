package uppgift.statistics;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class LeaderboardManager {
    private static final String FILE_NAME = "leaderboard_stats.txt";
    private Map<String, int[]> stats;

    public LeaderboardManager() {
        stats = new HashMap<>();
        loadStats();
    }

    public void addResult(String category, int score, int totalQuestions) {
        stats.putIfAbsent(category, new int[]{0, 0});
        int[] currentStats = stats.get(category);
        currentStats[0] += score;
        currentStats[1] += totalQuestions;
        stats.put(category, currentStats);

        saveStats();
    }

    public void displayTotalStats() {
        System.out.println("=== Total Leaderboard ===");
        stats.forEach((category, result) -> {
            System.out.printf("%s: %d/%d (%.2f%%)\n", category, result[0], result[1], calculatePercentage(result));
        });
    }

    public void displayCategoryStats(String category) {
        if (stats.containsKey(category)) {
            int[] result = stats.get(category);
            System.out.printf("=== %s Leaderboard ===\n", category);
            System.out.printf("%d/%d (%.2f%%)\n", result[0], result[1], calculatePercentage(result));
        } else {
            System.out.println("No statistics available for the selected category.");
        }
    }

    private double calculatePercentage(int[] result) {
        return result [1] > 0 ? (result[0] / (double) result[1]) * 100 : 0;
    }

    private void saveStats() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Map.Entry<String, int[]> entry : stats.entrySet()) {
                writer.write(entry.getKey() + ";" + entry.getValue()[0] + ";" + entry.getValue()[1]);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Failed to save leaderboard stats: " + e.getMessage());
        }
    }

    private void loadStats() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String category = parts[0];
                int score = Integer.parseInt(parts[1]);
                int totalQuestions = Integer.parseInt(parts[2]);
                stats.put(category, new int[]{score, totalQuestions});
            }
        } catch (FileNotFoundException e) {
            System.out.println("No leaderboard file found, starting fresh.");
        } catch (IOException e) {
            System.out.println("Filed to load leaderboard stats: " + e.getMessage());
        }
    }
}
