package uppgift;

import uppgift.category.Category;
import uppgift.category.CategoryCommand;
import uppgift.menu.Menu;
import uppgift.menu.MenuOption;
import uppgift.question.Question;
import uppgift.statistics.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Game {
    Menu menu;
    //private Player currentPlayer;
    //private List<player> players;
    private CategoryCommand categoryCommand;

    public Game() {
        //this.player = currentPlayer;
        //this.players = new ArrayList<>();
        this.categoryCommand = new CategoryCommand();
        this.menu = new Menu();
    }

    public void game(){

       int choice = menu.displayMenu();
       MenuOption[] optionList = menu.getOptions();

      boolean running = true;
      while(running){
         if (choice == -1 ) System.out.println("enter a valid option");
         if (choice > -1 && choice <= optionList.length) {
             optionList[choice -1].execute();
             running = false;
         }
      }
        Category category = categoryCommand.showCategoryMenu();
        category.executeCategory();
        List<Question> questions = category.getQuestions();
        System.out.println(questions);

        handleQuiz(questions);
    }

    private void handleQuiz(List<Question> questions) {
        Scanner scanner = new Scanner(System.in);
        for (Question question : questions) {
            System.out.println("Question: " + question.getQuestion());
            for (int i = 0; i < question.getAllAnswers().size(); i++){
                System.out.println((i + 1) + ". " + question.getAllAnswers().get(i));
            }
            int answer = scanner.nextInt() -1;
            System.out.println(question.getAllAnswers().get(answer));
            System.out.println("--------------------------");
            if(question.getAllAnswers().get(answer).equals(question.getCorrectAnswer())){
                System.out.println("Correct");
            } else{
                System.out.println("Wrong");
            }
        }
    }
}
