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
    private Menu menu;
    private Player currentPlayer;
    private List<Player> players;
    private CategoryCommand categoryCommand;

    public Game(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
        this.players = new ArrayList<>();
        this.categoryCommand = new CategoryCommand();
        this.menu = new Menu();
    }

    public void game() {
        System.out.println(currentPlayer.getUsername());
        MenuOption[] options = menu.getOptions();
        while(true){
            int choice = menu.mainMenu();
            switch (choice) {
                case 1:
                    Category category = categoryCommand.showCategoryMenu();
                    category.executeCategory();
                    List<Question> questions = category.getQuestions();
                    handleQuiz(currentPlayer, questions, category);
                    break;
                case 2:
                case 3:
                case 4:
                    System.out.println("exec ::: " + options[choice -1]);
                    options[choice -1].execute();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
                    break;
            }
        }
    }


    private void handleQuiz(Player currentPlayer, List<Question> questions, Category currc) {
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
                System.out.println(PrintUtil.GREEN + "Correct" + PrintUtil.RESET);
                currentPlayer.updateStatistics(true, currc.getName());
            } else{
                System.out.println(PrintUtil.RED + "Wrong" + PrintUtil.RESET);
                currentPlayer.updateStatistics(false, currc.getName());
            }
        }
        currentPlayer.displayStatistics();
        currentPlayer.saveStatistics();
    }
}