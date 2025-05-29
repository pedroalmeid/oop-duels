package dcc025.PedroJoseCA.game;

import java.util.Scanner;

public class Game {
    private int numberOfPlayers;

    public void start() {
        System.out.println("Welcome to Duels");
        numberOfPlayers = selectGameMode();
        switch (numberOfPlayers) {
            case 1:
                playSinglePlayer();
                break;
            case 2:
                playMultiPlayer();
                break;
        }
    }

    private int selectGameMode() {
        int selectedGameMode;
        do {
            System.out.println("Select a game mode");
            System.out.println("Digit 1 for single player");
            System.out.println("Digit 2 for multiplayer");
            Scanner keyboard = new Scanner(System.in);
            selectedGameMode = keyboard.nextInt();
            if (selectedGameMode != 1 && selectedGameMode != 2) {
                System.out.println("Invalid game mode. Try again.");
            }
        } while (selectedGameMode != 1 && selectedGameMode != 2);

        return selectedGameMode;
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
