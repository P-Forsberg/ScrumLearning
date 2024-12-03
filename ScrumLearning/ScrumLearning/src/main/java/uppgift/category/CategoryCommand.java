package uppgift.category;

import uppgift.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public  class CategoryCommand  {

    public Category showCategoryMenu() {
        List<Category> categories;
        categories = new ArrayList<>(Arrays.asList(
                new Sport(),
                new Music(),
                new Animals(),
                new History(),
                new Geography(),
                new SelfMadeQuiz()
        ));
        // Lägg till fler kategorier här

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select a category:");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println(PrintUtil.YELLOW + (i + 1) + ". " + categories.get(i).getName());
        }

        int choice = scanner.nextInt();

        if (choice > 0 && choice <= categories.size()) {
            return categories.get(choice -1);
        } else {
            System.out.println("Invalid choice, returning to menu.");
        }
        return null;
    }
}
