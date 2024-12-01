package uppgift.avslutaappen;

import uppgift.statistics.Player;
import java.io.FileWriter;
import java.io.IOException;

public class SparaTillFil {
    private Player player;

    public SparaTillFil(Player player) {
        this.player = player;
    }

    public void saveResults() {
        String filename = player.getUsername() + "_results.txt";
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write("Resultat för " + player.getUsername() + ":\n");
            writer.write("Poäng: " + player.getStatisticManager().getScore() + "\n");
            writer.write("Frågor Besvarade: " + player.getStatisticManager().getQuestionsAttempted() + "\n");
            writer.write("Korrekt Svar: " + player.getStatisticManager().getCorrectAnswers() + "\n");
            writer.write(String.format("Precision: %.2f%%\n", player.getStatisticManager().calculateAccuracy()));
            writer.write("------------------------------\n");
        } catch (IOException e) {
            System.out.println("Fel vid sparande av resultat: " + e.getMessage());
        }
        System.out.println("Dina resultat har sparats till " + filename);
    }
}
