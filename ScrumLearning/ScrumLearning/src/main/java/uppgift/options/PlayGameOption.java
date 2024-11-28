package uppgift.options;


import uppgift.category.Category;
import uppgift.menu.MenuOption;
import uppgift.category.CategoryCommand;


public class PlayGameOption implements MenuOption {
    CategoryCommand categoryCommand;
    public PlayGameOption(){
        categoryCommand = new CategoryCommand();
    }
    @Override
    public void execute() {
        System.out.println("Starting the quiz!");
        categoryCommand.showCategoryMenu();
    }
}
