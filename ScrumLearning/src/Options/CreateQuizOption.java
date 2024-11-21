package Options;

import menu.MenuOption;

public class CreateQuizOption implements MenuOption {
    @Override
    public void execute() {
        System.out.println("Create your own quiz!");
        PlayerQuizMaker quizMaker = new PlayerQuizMaker();
        quizMaker.createQuiz();
    }
}
