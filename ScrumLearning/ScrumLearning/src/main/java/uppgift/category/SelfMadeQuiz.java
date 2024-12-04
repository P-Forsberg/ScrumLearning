package uppgift.category;


import uppgift.options.PlayerQuizMaker;

public class SelfMadeQuiz extends Category {
    private PlayerQuizMaker pqm;
    public SelfMadeQuiz() {
        super("Selfmade Quiz");
        this.pqm = new PlayerQuizMaker();
        pqm.load();
    }

    @Override
    public void executeCategory() {
        if (pqm.getQuizzes().isEmpty()) {
            System.out.println("No selfmade quizzes available. Please create on first.");
            return;
        }
        questions = pqm.getQuizzes();
    }
}
