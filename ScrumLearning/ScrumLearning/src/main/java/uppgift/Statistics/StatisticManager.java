package uppgift.Statistics;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StatisticManager {
    private int score;
    private int questionsAttempted;
    private int correctAnswers;

    public StatisticManager() {
        this.score = 0;
        this.questionsAttempted = 0;
        this.correctAnswers = 0;
    }

    public void updateStats(boolean isCorrect) {
        questionsAttempted++;
        if (isCorrect) {
            correctAnswers++;
            score += 10;
        }
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

    public void loadStatistics(String playerName){
        File file = new File("statistics.txt");

        if(!file.exists()){
            System.out.println("Stats not found.");
            return;
        }
        try (Scanner scanner = new Scanner(file)){
            boolean playerFound = false; 
            String score = "";
            String questionsAttempted = "";
            String correctAnswers = ""; 
            String calculateAccuracy = "";
            
            while(scanner.hasNextLine()){
                String line = scanner.nextLine().trim();
                
                if(line.contains(playerName)){
                    playerFound = true;
                    System.out.println("Loading stats for " + playerName);
                    continue;
                }
                
                if (playerFound){
                    if (line.startsWith("Score:")){
                        score = line.split(":")[1].trim();
                    } else if (line.startsWith("Questions Attempted:")){
                        questionsAttempted = line.split(":")[1].trim();
                    } else if (line.startsWith("Correct Answers:")){
                        correctAnswers = line.split(":")[1].trim();
                    } else if (line.startsWith("Accuracy:")) {
                        calculateAccuracy = line.split(":")[1].trim();
                    } else if (line.startsWith("-----------------------")) {
                        break;
                    }
                }
            }

            if(playerFound){
                System.out.println("Score: " + score);
                System.out.println("Questions Attempted: " + questionsAttempted);
                System.out.println("Correct Answers: " + correctAnswers);
                System.out.println("Accuracy: " + calculateAccuracy);
                System.out.println("-----------------------");
            } else {
                System.out.println("No stats found2 " + playerName);
            }
        } catch (IOException e){
            System.out.println("error reading file: " + e.getMessage());
        }
    }

    public void displayStatistics(String playerName) {
            loadStatistics(playerName);

            System.out.println("\nStatistics for " + playerName + ":");
            System.out.println("Score: " + score);
            System.out.println("Questions Attempted: " + questionsAttempted);
            System.out.println("Correct Answers: " + correctAnswers);
            System.out.printf("Accuracy: %.2f%%\n", calculateAccuracy());
            System.out.println("-----------------------");
        }
    }

