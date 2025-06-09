package dcc025.PedroJoseCA.logs;

import dcc025.PedroJoseCA.game.Board;

public class Message {
    static void br() {
        System.out.println();
    }

    public static void welcome() {
        System.out.println("================");
        System.out.println("Welcome to DUELS");
        System.out.println("===============");
    }

    public static void gameModeSelection() {
        br();
        System.out.println("Select a game mode");
        System.out.println("Digit 1 for single player");
        System.out.println("Digit 2 for multiplayer");
    }

    public static void characterSelection(int playerNumber) {
        br();
        System.out.println("PLAYER " + playerNumber);
        System.out.println("Please select your character");
        System.out.println("Digit 0 for Bowman");
        System.out.println("Digit 1 for Warrior");
        System.out.println("Digit 2 for Wizard");
    }

    public static void askForCharacterName() {
        br();
        System.out.println("Please enter your character name");
    }

    public static void showBoard(Board board) {
        br();
        System.out.println("CURRENT BOARD");
        board.printBoard();
        br();
    }

}


