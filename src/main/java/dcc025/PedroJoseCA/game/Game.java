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
        int selectedGameMode = 0;
        String input;
        do {
            Message.gameModeSelection();
            input = KEYBOARD.nextLine();
            try {
                selectedGameMode = Integer.parseInt(input);
            }
            catch (NumberFormatException e) {
                Warning.invalidDigit("game mode");
                continue;
            }
            if (selectedGameMode != 1 && selectedGameMode != 2) {
                Warning.invalidDigit("game mode");
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
        int selectedCharacter = -1;
        do {
            Message.characterSelection(playerNumber);
            String input = KEYBOARD.nextLine();
            try {
                selectedCharacter = Integer.parseInt(input);
            }
            catch (NumberFormatException e) {
                Warning.invalidDigit("character");
                continue;
            }
            if (selectedCharacter < 0 || selectedCharacter > 2) {
                Warning.invalidDigit("character");
            }
        } while (selectedCharacter < 0 || selectedCharacter > 2);

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
        Message.playerInfo(player1);
        Message.playerInfo(player2);
    }

    private void play() {
        if (player1.isDead()) {
            Message.death(player1.getName());
            gameOver(player2, player1);
            return;
        }
        playerActions(player1);
        if (player2.isDead()) {
            Message.death(player2.getName());
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
        int selectedAction = -1;
        do {
            Message.askForAction(player);
            String input = KEYBOARD.nextLine();
            try {
                selectedAction = Integer.parseInt(input);
            }
            catch (NumberFormatException e) {
                Warning.invalidDigit("action");
                continue;
            }
            if (selectedAction < 0 || selectedAction > 4) {
                Warning.invalidDigit("action");
            }
        } while (selectedAction < 0 || selectedAction > 4);

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
        Warning.forcedEnd();
        System.exit(0);
    }

    private void gameOver(Character winner, Character loser) {
        Message.gameOver(winner, loser);
        Message.askForNewGame();

        int selectedOption = KEYBOARD.nextInt();
        while (selectedOption < 0 || selectedOption > 1) {
            Warning.invalidDigit("option");
            selectedOption = KEYBOARD.nextInt();
        }
        switch (selectedOption) {
            case 0:
                Warning.forcedEnd();
                System.exit(0);
                break;
            case 1:
                start();
                break;
        }
    }
}
