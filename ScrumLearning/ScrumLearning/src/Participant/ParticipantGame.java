package Participant;

import java.util.Scanner;

public class ParticipantGame {
    private final Participant.ParticipantManager participantManager;

    public ParticipantGame() {
        this.participantManager = new Participant.ParticipantManager();
    }

    public void displayWelcomeMessage() {
        System.out.println("Welcome to the Participant Selection!");
    }

    private void displayMenu() {
        System.out.println("\nChoose an option:");
        System.out.println("1. One participant");
        System.out.println("2. Two participants");
        System.out.println("3. Three participants");
        System.out.println("4. Four participants");
        System.out.println("5. Five participants");
        System.out.println("6. Six participants");
        System.out.println("7. Restart");
        System.out.println("0. Exit");
    }

    public void handleMenuSelection() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();

            try {
                int choice = Integer.parseInt(input);

                switch (choice) {
                    case 1:
                        System.out.println("One participant selected. Preparing the game for a solo experience.");
                        participantManager.setNumberOfParticipants(choice);
                        break;
                    case 2:
                        System.out.println("Two participants selected. Setting up a competitive match!");
                        participantManager.setNumberOfParticipants(choice);
                        break;
                    case 3:
                        System.out.println("Three participants selected. Let the trio battle begin!");
                        participantManager.setNumberOfParticipants(choice);
                        break;
                    case 4:
                        System.out.println("Four participants selected. A fun group activity awaits!");
                        participantManager.setNumberOfParticipants(choice);
                        break;
                    case 5:
                        System.out.println("Five participants selected. The more, the merrier!");
                        participantManager.setNumberOfParticipants(choice);
                        break;
                    case 6:
                        System.out.println("Six participants selected. Maximum fun is guaranteed!");
                        participantManager.setNumberOfParticipants(choice);
                        break;
                    case 7:
                        System.out.println("\nRestarting the participant selection...\n");
                        break;
                    case 0:
                        System.out.println("Thank you for playing. Goodbye!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }

                if (choice >= 1 && choice <= 6) {
                    System.out.println("\nParticipants set to: " + participantManager.getNumberOfParticipants());
                    return;
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public int getNumberOfParticipants() {
        return participantManager.getNumberOfParticipants();
    }
}