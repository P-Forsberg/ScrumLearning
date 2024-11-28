package uppgift.saveandload;

import java.io.IOException;

public interface SaveAndLoad {
    void saveQuiz() throws IOException;
    void loadQuiz() throws IOException;
}
