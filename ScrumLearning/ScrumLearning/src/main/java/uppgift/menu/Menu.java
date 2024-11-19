package uppgift.menu;

import uppgift.category.CategoryCommand;
import uppgift.category.Sport;

import java.util.Scanner;

public class Menu{
    private IMenuOptions direction;
    private final IMenuOptions[] options;

   public Menu() {
        options = new IMenuOptions[] {
                new PlayGameOption(),
                new CreateQuizOption(),
                new ViewStatisticsOption()
        };
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to the quiz!");
            System.out.println("Chose an option below: ");
            System.out.println("1. Play the quiz");
            System.out.println("2. Make your own quiz");
            System.out.println("3. View your game stats");
            System.out.println("4. End the quiz");

            int choice = scanner.nextInt();

            if (choice > 0 && choice <= options.length) {
                options[choice - 1].execute();
            } else if (choice == 4) {
                System.out.println("Ending the quiz, see you next time!");
                running = false;
            } else {
                System.out.println("Invalid choice, try again.");
            }
        }

    }
    public class PlayGameOption implements IMenuOptions {

        @Override
        public void execute() {
            System.out.println("getting quiz..");
            Sport.TriviaAPI();

        }
    }
    public class CreateQuizOption implements IMenuOptions {

        @Override
        public void execute() {
            System.out.println("Getting create quiz...");
        }
    }
    public class ViewStatisticsOption implements IMenuOptions {

        @Override
        public void execute() {
            System.out.println("Getting Statistics...");
        }
    }

}
