package uppgift.statistics;

import java.io.FileWriter;
import java.io.IOException;

public interface StatisticSaver {
    void saveStatistics(String playerName, int score, int questionsAttempted, int correctAnswers, double accuracy);
}
