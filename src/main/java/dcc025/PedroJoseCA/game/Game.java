package dcc025.PedroJoseCA.game;

import java.util.Scanner;

public class Game {
    private int numberOfPlayers;

    public void start() {
        System.out.println("Welcome to Duels");
        selectGameMode();
    }

    private void selectGameMode() {
        System.out.println("Select a game mode");
        System.out.println("Digit 1 for single player");
        System.out.println("Digit 2 for multiplayer");
        Scanner keyboard = new Scanner(System.in);
        int selectedGameMode = keyboard.nextInt();
        if (selectedGameMode == 1) {
            numberOfPlayers = selectedGameMode;
            playSinglePlayer();
        } else if (selectedGameMode == 2) {
            numberOfPlayers = selectedGameMode;
            playMultiPlayer();
        } else {
            System.out.println("Invalid game mode. Try again.");
            selectGameMode();
        }
    }

    private void playSinglePlayer() {
        System.out.println("Playing on Single Player");
    }

    private void playMultiPlayer() {
        System.out.println("Playing on Multi Player");
    }

    private void chooseCharacters() {

    }
}
