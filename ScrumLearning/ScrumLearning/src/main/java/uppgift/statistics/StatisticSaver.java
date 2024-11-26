package uppgift.statistics;

import java.io.FileWriter;
import java.io.IOException;

public interface StatisticSaver {
    void saveStatistics(String playerName, int score, int questionsAttempted, int correctAnswers, double accuracy);

     class FileStatisticSaver implements StatisticSaver {
        private String filePath;

        public FileStatisticSaver(String filePath) {
            this.filePath = filePath;
        }

        @Override
        public void saveStatistics(String playerName, int score, int questionsAttempted, int correctAnswers, double accuracy) {
            try (FileWriter writer = new FileWriter(filePath, true)) {
                writer.write("Statistics for " + playerName + ":\n");
                writer.write("Score: " + score + "\n");
                writer.write("Questions Attempted: " + questionsAttempted + "\n");
                writer.write("Correct Answers: " + correctAnswers + "\n");
                writer.write(String.format("Accuracy: %.2f%%\n", accuracy));
                writer.write("-----------------------\n");
            } catch (IOException e) {
                System.out.println("Error saving statistics: " + e.getMessage());
            }
        }
    }
}
