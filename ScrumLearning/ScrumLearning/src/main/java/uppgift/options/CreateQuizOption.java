package uppgift.options;


import uppgift.menu.MenuOption;
import uppgift.statistics.Player;

public class CreateQuizOption implements MenuOption {
PlayerQuizMaker pqm = new PlayerQuizMaker();

    @Override
    public void execute(Player currentPlayer) {
        pqm.createQuiz();
    }
}