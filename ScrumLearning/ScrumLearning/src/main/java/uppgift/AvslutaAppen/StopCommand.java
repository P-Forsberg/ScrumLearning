package uppgift.avslutaappen;

import uppgift.statistics.Player;
import uppgift.options.ViewStatisticsOption;
import java.util.Scanner;

public class StopCommand {
    private Player currentPlayer;

    public StopCommand(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vill du spara dina resultat innan du avslutar? (j/n)");
        String input = scanner.nextLine().trim().toLowerCase();

        if (input.equals("j")) {
            SparaTillFil sparaTillFil = new SparaTillFil(currentPlayer);
            sparaTillFil.saveResults();
        } else {
            System.out.println("Dina resultat har inte sparats.");
        }
        System.out.println("Tack för att du spelade! Hejdå!");
    }
}
