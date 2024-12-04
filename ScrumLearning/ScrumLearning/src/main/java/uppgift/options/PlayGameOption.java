package uppgift.options;


import uppgift.menu.MenuOption;
import uppgift.category.CategoryCommand;
import uppgift.statistics.Player;


public class PlayGameOption implements MenuOption {
    CategoryCommand categoryCommand;
    public PlayGameOption(){
        categoryCommand = new CategoryCommand();
    }
    @Override
    public void execute(Player currentPlayer) {
        System.out.println("Starting the quiz!");
        categoryCommand.showCategoryMenu();
    }
}
