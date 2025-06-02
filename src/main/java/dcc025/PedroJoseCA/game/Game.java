package dcc025.PedroJoseCA.game;

import java.util.Scanner;

public class Game {
    final private Scanner KEYBOARD = new Scanner(System.in);
    private int numberOfPlayers;

    public void start() {
        System.out.println("Welcome to Duels");
        selectGameMode();
        manageCharacters();
    }

    private void selectGameMode() {
        int selectedGameMode;
        do {
            System.out.println("Select a game mode");
            System.out.println("Digit 1 for single player");
            System.out.println("Digit 2 for multiplayer");
            selectedGameMode = KEYBOARD.nextInt();
            if (selectedGameMode != 1 && selectedGameMode != 2) {
                System.out.println("Invalid game mode. Try again.");
            }
        } while (selectedGameMode != 1 && selectedGameMode != 2);

        numberOfPlayers = selectedGameMode;
    }

    private void chooseCharacter(int playerNumber) {
        System.out.println("PLAYER " + playerNumber);
        System.out.println("Please select your character");
        System.out.println("Digit 0 for Archer");
        System.out.println("Digit 1 for Warrior");
        System.out.println("Digit 2 for Wizard");
        int selectedCharacter = KEYBOARD.nextInt();
        while (selectedCharacter < 0 || selectedCharacter > 2) {
            System.out.println("Invalid digit for character. Try again.");
            selectedCharacter = KEYBOARD.nextInt();
        }
        System.out.println("Please enter your character name");
        String selectedCharacterName = KEYBOARD.next();

    }

    private void manageCharacters() {

    }
}
