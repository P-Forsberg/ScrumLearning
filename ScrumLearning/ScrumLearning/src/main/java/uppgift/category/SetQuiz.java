package uppgift.category;

import java.util.Scanner;

public class SetQuiz {

    public String selectCategory(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select difficulty");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");

        int choice = scanner.nextInt();
        switch(choice){
            case 1:
                return "geography";
            case 2:
                return "animals";
            case 3:
                return "history";
            case 4:
                return "music";
            case 5:
                return "sport";
            default:
                System.out.println("Invalid choice, defaulting to 'History");
                return "history";

    }
    }

    public String selectDifficulty(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select difficulty");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");

        int choice = scanner.nextInt();
        switch(choice){
            case 1:
                return "easy";
            case 2:
                return "medium";
            case 3:
                return "hard";
            default:
                System.out.println("Invalid choice, defaulting to 'easy'");
                return "easy";
        }

    }
}
