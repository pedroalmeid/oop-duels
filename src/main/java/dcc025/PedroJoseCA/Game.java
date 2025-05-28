package dcc025.PedroJoseCA;

import java.util.Scanner;

public class Game {
    public void start() {
        System.out.println("Welcome to Duels");
        selectGameMode();
    }

    private void selectGameMode() {
        System.out.println("Select a game mode");
        System.out.println("Digit 1 for single player");
        System.out.println("Digit 2 for multiplayer");
        Scanner keyboard = new Scanner(System.in);
        int gameMode = keyboard.nextInt();
        if (gameMode == 1) {
            playSinglePlayer();
        } else if (gameMode == 2) {
            playMultiPlayer();
        }
    }

    private void playSinglePlayer() {
        System.out.println("Playing on Single Player");
    }

    private void playMultiPlayer() {
        System.out.println("Playing on Multi Player");
    }
}
