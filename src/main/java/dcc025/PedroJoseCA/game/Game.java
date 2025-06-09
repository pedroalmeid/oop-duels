package dcc025.PedroJoseCA.game;

import java.util.Scanner;

import dcc025.PedroJoseCA.characters.Bowman;
import dcc025.PedroJoseCA.characters.Character;
import dcc025.PedroJoseCA.characters.Warrior;
import dcc025.PedroJoseCA.characters.Wizard;
import dcc025.PedroJoseCA.logs.Message;
import dcc025.PedroJoseCA.logs.Warning;

public class Game {
    final private Scanner KEYBOARD = new Scanner(System.in);

    private int numberOfPlayers;
    private Board board;
    private Character player1;
    private Character player2;
    private Bot bot = null;

    public Game() {
        board = new Board();
    }

    public void start() {
        Message.welcome();
        selectGameMode();
        manageCharacters();
        displayInfo();
        play();
    }

    private void selectGameMode() {
        int selectedGameMode;
        do {
            Message.gameModeSelection();
            selectedGameMode = KEYBOARD.nextInt();
            if (selectedGameMode != 1 && selectedGameMode != 2) {
                Warning.invalidGameMode();
            }
        } while (selectedGameMode != 1 && selectedGameMode != 2);

        numberOfPlayers = selectedGameMode;
    }

    private void manageCharacters() {
        if (numberOfPlayers == 2) {
            player1 = chooseCharacter(1);
            player2 = chooseCharacter(2);
        }
        else if (numberOfPlayers == 1) {
            player1 = chooseCharacter(1);
            bot = new Bot(board);
            player2 = bot.setRandomCharacter();
        }
        player1.setEnemy(player2);
        player2.setEnemy(player1);
    }

    private Character chooseCharacter(int playerNumber) {
        Message.characterSelection(playerNumber);

        int selectedCharacter = KEYBOARD.nextInt();
        while (selectedCharacter < 0 || selectedCharacter > 2) {
            Warning.invalidCharacterDigit();
            selectedCharacter = KEYBOARD.nextInt();
        }

        Message.askForCharacterName();

        String selectedCharacterName = KEYBOARD.next();
        return switch (selectedCharacter) {
            case 0 -> new Bowman(selectedCharacterName, playerNumber, board);
            case 1 -> new Warrior(selectedCharacterName, playerNumber, board);
            case 2 -> new Wizard(selectedCharacterName, playerNumber, board);
            default -> null;
        };
    }

    private void displayInfo() {
        Message.showBoard(board);
        displayPlayerInfo(player1);
        displayPlayerInfo(player2);
    }

    private void displayPlayerInfo(Character player) {
        System.out.println(player.getName() + " information (PLAYER " + player.getPlayerNumber() + ")");
        System.out.println("Class: " + player.getClassName());
        System.out.println("HP: " + player.getHp());
        System.out.println("Current attack force: " + player.getAttack());
        System.out.println("Current defense force: " + player.getCurrentDefense());
        System.out.println("Current range: " + player.getRange());
    }

    private void play() {
        if (!player1.isAlive()) {
            System.out.println(player1.getName() + " was dead");
            gameOver(player2, player1);
            return;
        }
        playerActions(player1);
        if (!player2.isAlive()) {
            System.out.println(player2.getName() + " was dead");
            gameOver(player1, player2);
            return;
        }
        if (numberOfPlayers == 2) {
            playerActions(player2);
        }
        else if (numberOfPlayers == 1) {
            bot.behave();
        }
        displayInfo();
        play();
    }

    private void playerActions(Character player) {
        System.out.println();
        System.out.println("PLAYER " + player.getPlayerNumber());
        System.out.println(player.getName() + ", please select your next action:");
        System.out.println("Digit 0 to Attack");
        System.out.println("Digit 1 to Defend");
        System.out.println("Digit 2 to Move");
        System.out.println("Digit 3 to Activate Ultimate");
        System.out.println("Digit 4 to End game");
        int selectedAction = KEYBOARD.nextInt();
        while (selectedAction < 0 || selectedAction > 4) {
            System.out.println("Invalid digit for action. Try again.");
            selectedAction = KEYBOARD.nextInt();
        }
        switch (selectedAction) {
            case 0:
                player.attack();
                break;
            case 1:
                player.defend();
                break;
            case 2:
                player.move();
                break;
            case 3:
                player.useUltimate();
                break;
            case 4:
                gameOver();
                break;
        }
    }

    private void gameOver() {
        System.out.println();
        System.out.println("Forcing end of game as requested");
        System.exit(0);
    }

    private void gameOver(Character winner, Character loser) {
        System.out.println();
        System.out.println("GAME OVER");
        System.out.println(winner.getName() + " defeated " + loser.getName());
        System.out.println("Congratulations to PLAYER " + winner.getPlayerNumber() + "!!");
        System.out.println("Do you wanna play again? Digit 1 for YES and 0 for NO");
        int selectedOption = KEYBOARD.nextInt();
        while (selectedOption < 0 || selectedOption > 1) {
            System.out.println("Invalid digit for option. Try again.");
        }
        switch (selectedOption) {
            case 0:
                System.exit(0);
                break;
            case 1:
                start();
                break;
        }
    }
}
