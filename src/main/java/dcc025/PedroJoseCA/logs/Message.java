package dcc025.PedroJoseCA.logs;

import dcc025.PedroJoseCA.game.Board;
import dcc025.PedroJoseCA.characters.Character;

public class Message {
    public static final String COLOR_GREEN = "\u001B[32m";
    public static final String COLOR_RED = "\u001b[31m";
    public static final String COLOR_PURPLE = "\u001B[35m";
    public static final String COLOR_CYAN = "\u001b[36m";
    public static final String COLOR_RESET = "\u001B[0m";


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
        System.out.print(playerNumber == 1 ? COLOR_CYAN : COLOR_PURPLE);
        System.out.println("PLAYER " + playerNumber + COLOR_RESET);
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
    }

    public static void playerInfo(Character player) {
        br();
        System.out.print(player.getPlayerNumber() == 1 ? COLOR_CYAN : COLOR_PURPLE);
        System.out.println(player.getName() + " information (PLAYER " + player.getPlayerNumber() + ")");
        System.out.println("Class: " + player.getClassName());
        System.out.println("HP: " + player.getHp());
        System.out.println("Current attack force: " + player.getAttack());
        System.out.println("Current defense force: " + player.getCurrentDefense());
        System.out.println("Current range: " + player.getRange());
        System.out.print(COLOR_RESET);
    }

    public static void death(String playerName) {
        br();
        System.out.println(COLOR_RED + playerName + " was dead!" + COLOR_RESET);
    }

    public static void askForAction(Character player) {
        br();
        System.out.print(player.getPlayerNumber() == 1 ?  COLOR_CYAN : COLOR_PURPLE);
        System.out.println("PLAYER " + player.getPlayerNumber());
        System.out.println(player.getName() + ", please select your next action:");
        System.out.print(COLOR_RESET);
        System.out.println("Digit 0 to Attack");
        System.out.println("Digit 1 to Defend");
        System.out.println("Digit 2 to Move");
        System.out.println("Digit 3 to Activate Ultimate");
        System.out.println("Digit 4 to End game");
    }

    public static void gameOver(Character winner, Character loser) {
        br();
        System.out.print(COLOR_GREEN);
        System.out.println("================");
        System.out.println("GAMER OVER");
        System.out.println("===============");
        System.out.println(winner.getName() + " defeated " + loser.getName());
        System.out.println("Congratulations to PLAYER " + winner.getPlayerNumber() + "!!");
        System.out.print(COLOR_RESET);
    }

    public static void askForNewGame() {
        br();
        System.out.println("Do you wanna play again? Digit 1 for YES and 0 for NO");
    }

    public static void defense(String name, int maxDefense) {
        br();
        System.out.print(COLOR_GREEN);
        System.out.println(name + " defended. Current defense now is " + maxDefense);
        System.out.print(COLOR_RESET);
    }

    public static void attack(String name, String enemyName) {
        br();
        System.out.print(COLOR_GREEN);
        System.out.println(name + " attacked " + enemyName);
        System.out.print(COLOR_RESET);
    }

    public static void damage(String name, int defense, int hp) {
        br();
        System.out.print(COLOR_GREEN);
        System.out.println(name + " lost " + defense + " of defense and " + hp + " of hp." );
        System.out.print(COLOR_RESET);
    }

    public static void askForDirection() {
        br();
        System.out.println("Please select the direction of your movement");
        System.out.println("Digit 0 for UP");
        System.out.println("Digit 1 for DOWN");
        System.out.println("Digit 2 for LEFT");
        System.out.println("Digit 3 for RIGHT");
    }

    public static void movement(String name, String direction) {
        br();
        System.out.print(COLOR_GREEN);
        System.out.println(name + " moved on " + direction + " direction.");
        System.out.print(COLOR_RESET);
    }

    public static void bowmanUltimate(String name, int range) {
        br();
        System.out.print(COLOR_GREEN);
        System.out.println(name + " has activated his ultimate.");
        System.out.println("Range updated to " + range);
        System.out.print(COLOR_RESET);
    }

    public static void warriorUltimate(String name, int attackForce) {
        br();
        System.out.print(COLOR_GREEN);
        System.out.println(name + " has activated his ultimate");
        System.out.println("Attack force updated to " + attackForce);
        System.out.print(COLOR_RESET);
    }

    public static void wizardUltimate(String name, String enemyName) {
        br();
        System.out.print(COLOR_GREEN);
        System.out.println(name + " has activated his ultimate");
        System.out.println(name + " exchanged his hp with " + enemyName);
        System.out.print(COLOR_RESET);
    }

}


