package uppgift.menu;


import uppgift.options.CreateQuizOption;
import uppgift.options.PlayGameOption;
import uppgift.options.ViewStatisticsOption;
import uppgift.statistics.LeaderboardMenu;

import java.util.Scanner;


public class Menu {
    private MenuOption[] options;

    public Menu() {
        options = new MenuOption[] {
                  new PlayGameOption(),
                  new CreateQuizOption(),
                  new ViewStatisticsOption(),
                  new LeaderboardMenu()
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
            System.out.println("4. View leaderboard");
            System.out.println("5. End the quiz");

            int choice = scanner.nextInt();

            if (choice > 0 && choice <= options.length) {
                options[choice - 1].execute();
            } else if (choice == 5) {
                System.out.println("Ending the quiz, see you next time!");
                running = false;
            } else {
                System.out.println("Invalid choice, try again.");
            }
        }

    }
}
