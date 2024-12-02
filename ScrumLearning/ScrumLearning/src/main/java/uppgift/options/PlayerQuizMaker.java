package uppgift.options;

import uppgift.statistics.FileService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerQuizMaker implements FileService {
    private static final String FILE_NAME = "selfmade_quizzes.txt";

    private List<List<String>> quizzes;
    private List<List<String>> answers;

    public PlayerQuizMaker() {
        quizzes = new ArrayList<>();
        answers = new ArrayList<>();
    }

    public List<List<String>> getQuizzes() {
        return quizzes;
    }

    public List<List<String>> getAnswers() {
        return answers;
    }

    public void createQuiz() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Creating a new quiz.");
        List<String> questions = new ArrayList<>();
        List<String> correctAnswers = new ArrayList<>();

        System.out.println("How many questions do you want to add to your quiz: ");
        int numberOfQuestions = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= numberOfQuestions; i++) {
            System.out.println("PLease write your question" + i + ":");
            questions.add(scanner.nextLine());

            System.out.println("Enter the correct answer for question " + i + ": ");
            correctAnswers.add(scanner.nextLine());
        }

        quizzes.add(questions);
        answers.add(correctAnswers);

        save();

        System.out.println("Your quiz is now done, this is your questions: ");
        for (int i = 0; i < questions.size(); i++) {
            System.out.println((i + 1) + ". " + questions.get(i));
            System.out.println("   Correct answer: " + correctAnswers.get(i));
        }
    }

    @Override
    public void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (int i = 0; i < quizzes.size(); i++) {
                writer.write(String.join(",", quizzes.get(i)));
                writer.newLine();
                writer.write(String.join(",", answers.get(i)));
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void load() {
        quizzes.clear();
        answers.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] questions = line.split(",");
                line = reader.readLine();
                if (line != null) {
                    String[] correctAnswers = line.split(",");
                    quizzes.add(List.of(questions));
                    answers.add(List.of(correctAnswers));

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No previous quiz data found, starting fresh.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
