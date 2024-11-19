package main.java.uppgift;

import Participant.ParticipantGame;

public class Application {
    public static void main(String[] args) {
        ParticipantGame participantGame = new ParticipantGame();

        participantGame.displayWelcomeMessage();

        participantGame.handleMenuSelection();

        System.out.println("Starting the game with " + participantGame.getNumberOfParticipants() + " participant(s)!");
    }
}
