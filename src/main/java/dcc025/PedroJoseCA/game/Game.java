package dcc025.PedroJoseCA.game;

import java.util.Scanner;

import dcc025.PedroJoseCA.characters.Bowman;
import dcc025.PedroJoseCA.characters.Character;
import dcc025.PedroJoseCA.characters.Warrior;
import dcc025.PedroJoseCA.characters.Wizard;

public class Game {
    final private Scanner KEYBOARD = new Scanner(System.in);

    private int numberOfPlayers;
    private Board board;
    private Character player1;
    private Character player2;

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

    private Character chooseCharacter(int playerNumber) {
        System.out.println("PLAYER " + playerNumber);
        System.out.println("Please select your character");
        System.out.println("Digit 0 for Bowman");
        System.out.println("Digit 1 for Warrior");
        System.out.println("Digit 2 for Wizard");
        int selectedCharacter = KEYBOARD.nextInt();
        while (selectedCharacter < 0 || selectedCharacter > 2) {
            System.out.println("Invalid digit for character. Try again.");
            selectedCharacter = KEYBOARD.nextInt();
        }
        System.out.println("Please enter your character name");
        String selectedCharacterName = KEYBOARD.next();
        return switch (selectedCharacter) {
            case 0 -> new Bowman(selectedCharacterName, playerNumber);
            case 1 -> new Warrior(selectedCharacterName, playerNumber);
            case 2 -> new Wizard(selectedCharacterName, playerNumber);
            default -> null;
        };
    }

    private void manageCharacters() {
        if (numberOfPlayers == 2) {
            player1 = chooseCharacter(1);
            player2 = chooseCharacter(2);
        }
    }
}
