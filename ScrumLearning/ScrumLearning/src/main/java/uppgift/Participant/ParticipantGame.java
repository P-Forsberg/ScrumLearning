package uppgift.Participant;

import java.util.Scanner;

public class ParticipantGame {
    private final ParticipantManager participantManager;

    public ParticipantGame() {
        this.participantManager = new ParticipantManager();
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
                    case 0:
                        System.out.println("Thank you for playing. Goodbye!");
                        System.exit(0);
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        participantManager.setNumberOfParticipants(choice);
                        System.out.println("\nYou chose " + choice + " participant(s).");
                        return;
                    case 7:
                        System.out.println("\nRestarting the participant selection...\n");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
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
