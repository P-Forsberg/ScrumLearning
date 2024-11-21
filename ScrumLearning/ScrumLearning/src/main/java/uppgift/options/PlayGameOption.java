package uppgift.options;

import uppgift.menu.MenuOption;
import uppgift.category.CategoryCommand;

import java.util.Locale;

public class PlayGameOption implements MenuOption {
    @Override
    public void execute() {
        System.out.println("Starting the quiz!");
        CategoryCommand.showCategoryMenu();
    }

}
