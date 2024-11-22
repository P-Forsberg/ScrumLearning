package main.java.uppgift.options;


import main.java.uppgift.category.CategoryCommand;
import main.java.uppgift.menu.MenuOption;

import java.util.Locale;

public class PlayGameOption implements MenuOption {
    @Override
    public void execute() {
        System.out.println("Starting the quiz!");
        CategoryCommand.showCategoryMenu();
    }

}
