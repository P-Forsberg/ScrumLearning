package uppgift.menu;


import uppgift.options.CreateQuizOption;
import uppgift.options.LeaderBoardOption;
import uppgift.options.PlayGameOption;
import uppgift.options.ViewStatisticsOption;
import uppgift.statistics.LeaderboardManager;
import uppgift.statistics.LeaderboardMenu;

import java.util.Scanner;


public class Menu {
    private MenuOption[] options;

    public Menu() {
        options = new MenuOption[] {
                new PlayGameOption(),
                new CreateQuizOption(),
                new LeaderBoardOption(),
                new ViewStatisticsOption(),
        };
    }

    public int mainMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the quiz!");
        System.out.println("Chose an option below: ");
        System.out.println("1. Play the quiz");
        System.out.println("2. Make your own quiz");
        System.out.println("3. View Leaderboard");
        System.out.println("5. End the quiz");
        return scanner.nextInt();
    }

    public MenuOption[] getOptions () {
        return options;
    }
}