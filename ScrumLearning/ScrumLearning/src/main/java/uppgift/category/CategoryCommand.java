package uppgift.category;

import java.util.Scanner;

public abstract class CategoryCommand implements ICategoryCommand {
    private String name;

    public CategoryCommand(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public abstract void executeCategory();

    public static void showCategoryMenu() {
        ICategoryCommand[] categories = {
                new Sport(),
                new Music(),
                new Animals(),
                new History(),
                new Geography(),
                new SelfmadeQuiz(),
                // Lägg till fler kategorier här
        };

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select a category:");
        for (int i = 0; i < categories.length; i++) {
            System.out.println((i + 1) + ". " + ((CategoryCommand) categories[i]).getName());
        }

        int choice = scanner.nextInt();

        if (choice > 0 && choice <= categories.length) {
            categories[choice - 1].executeCategory();
        } else {
            System.out.println("Invalid choice, returning to menu.");
        }
    }

} 
