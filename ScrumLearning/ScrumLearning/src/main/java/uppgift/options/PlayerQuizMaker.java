package uppgift.options;

import uppgift.saveandload.SaveAndLoad;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerQuizMaker implements SaveAndLoad {
    private List<String> questions;
    private List<String> correctAnswers;
    private static final String FILE_NAME ="selfmade_quizzes.txt";

    public PlayerQuizMaker() {
        questions = new ArrayList<>();
        correctAnswers = new ArrayList<>();
    }

    public void createQuiz() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many questions do you want to add to your quiz: ");
        int numberOfQuestions = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= numberOfQuestions; i++) {
            System.out.println("PLease write your question" + i + ":");
            String question = scanner.nextLine();
            questions.add(question);

            System.out.println("Enter the correct answer for question " + i + ": ");
            String correctAnswer = scanner.nextLine();
            correctAnswers.add(correctAnswer);
        }

        try {
            saveQuiz();
        } catch (IOException e) {
            System.out.println("Failed to save quiz: " + e.getMessage());
        }

        System.out.println("Your quiz is now done, this is your questions: ");
        for (int i = 0; i < questions.size(); i++) {
            System.out.println((i + 1) + ". " + questions.get(i));
            System.out.println("   Correct answer: " + correctAnswers.get(i));
        }
    }

    @Override
    public void saveQuiz() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (int i =0; i < questions.size(); i++) {
                writer.write(questions.get(i) + "|" + correctAnswers.get(i));
                writer.newLine();
            }
            System.out.println("Quiz saved successfully!");
        }
    }
    @Override
    public void loadQuiz() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    questions.add(parts[0]);
                    correctAnswers.add(parts[1]);
                }
            }
            System.out.println("Quiz loaded successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("No previous quiz data found, starting fresh.");
        }
    }
}
