package main.java.uppgift;

import menu.Menu;
import options.PlayerQuizMaker;
import java.io.IOException;


public class Application {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.displayMenu();

        PlayerQuizMaker quizMaker = new PlayerQuizMaker();

        try {
            quizMaker.loadQuiz();
        } catch (IOException e) {
            System.out.println("No previous quiz found, starting fresh.");
        }

        quizMaker.createQuiz();
    }
}