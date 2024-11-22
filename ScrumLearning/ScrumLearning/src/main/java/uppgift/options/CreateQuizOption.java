package uppgift.options;


import uppgift.menu.MenuOption;

public class CreateQuizOption implements MenuOption {
    private PlayerQuizMaker quizMaker;

    public CreateQuizOption() {
        quizMaker = new PlayerQuizMaker();
    }

    @Override
    public void execute() {
        quizMaker.createQuiz();
    }
}