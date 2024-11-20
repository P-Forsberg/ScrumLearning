package Options;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerQuizMaker {
    private List<String> questions;
    private List<String> correctAnswers;

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

        System.out.println("Your quiz is now done, this is your questions: ");

        for (int i = 0; i < questions.size(); i++) {
            System.out.println((i + 1) + ". " + questions.get(i));
            System.out.println("   Correct answer: " + correctAnswers.get(i));
        }
    }
}
