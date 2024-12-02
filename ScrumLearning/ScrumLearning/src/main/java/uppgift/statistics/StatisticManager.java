package uppgift.statistics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StatisticManager implements StatisticSaver {
    private int score;
    private int questionsAttempted;
    private int correctAnswers;
    private Map<String, int[]> categoryStats;

    public StatisticManager() {
        this.score = 0;
        this.questionsAttempted = 0;
        this.correctAnswers = 0;
        this.categoryStats = new HashMap<>();
    }

    public void updateStats(boolean isCorrect, String category) {
        questionsAttempted++;
        if (isCorrect) {
            correctAnswers++;
            score += 10;
        }

        categoryStats.putIfAbsent(category, new int[2]);
        int[] stats = categoryStats.get(category);
        stats[1]++;
        if (isCorrect) {
            stats[0]++;
        }
        categoryStats.put(category, stats);
    }

    public int getScore() {
        return score;
    }

    public int getQuestionsAttempted() {
        return questionsAttempted;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public double calculateAccuracy() {
        if (questionsAttempted == 0) {
            return 0.0;
        }
        return ((double) correctAnswers / questionsAttempted) * 100;
    }

    public void displayStatistics(String playerName) {
        System.out.println("Statistics for " + playerName + ":");
        System.out.println("Score: " + score);
        System.out.println("Questions Attempted: " + questionsAttempted);
        System.out.println("Correct Answers: " + correctAnswers);
        System.out.printf("Accuracy: %.2f%%\n", calculateAccuracy());
        System.out.println("-----------------------");
    }

    public void displayCategoryStatistics(String playerName) {
        System.out.println("Category Statistics for " + playerName + ":");
        for (Map.Entry<String, int[]> entry : categoryStats.entrySet()) {
            String category = entry.getKey();
            int[] stats = entry.getValue();
            double accuracy = stats[1] > 0 ? ((double) stats[0] / stats[1]) * 100 : 0.0;
            System.out.printf("Category: %s - Correct Answers: %d/%d (%.2f%%)\n", category, stats[0], stats[1], accuracy);
        }
        System.out.println("-----------------------");
    }

    @Override
    public void saveStatistics(String playerName, int score, int questionsAttempted, int correctAnswers, double accuracy) {
        String filename = playerName + "stats.txt";
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write("Statistics for " + playerName + ":\n");
            writer.write("Score: " + score + "\n");
            writer.write("Questions Attempted: " + questionsAttempted + "\n");
            writer.write("Correct Answers: " + correctAnswers + "\n");
            writer.write(String.format("Accuracy: %.2f%%\n", accuracy));
        } catch (IOException e) {
            System.out.println("Error saving statistics: " + e.getMessage());
        }
    }
}
