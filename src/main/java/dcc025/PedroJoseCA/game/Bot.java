package dcc025.PedroJoseCA.game;

import dcc025.PedroJoseCA.characters.Character;
import dcc025.PedroJoseCA.characters.Bowman;
import dcc025.PedroJoseCA.characters.Warrior;
import dcc025.PedroJoseCA.characters.Wizard;

import java.util.Random;

public class Bot {
    final Random RANDOM = new Random();
    private Board currentBoard;
    private Character character;

    public Bot(Board board) {
        currentBoard = board;
    }

    public Character setRandomCharacter() {
        int randomNumber = RANDOM.nextInt(3);
        String botName = "BOT " + randomNumber;
        character = switch (randomNumber) {
            case 0 -> new Bowman(botName, 2, currentBoard);
            case 1 -> new Warrior(botName, 2, currentBoard);
            case 2 -> new Wizard(botName, 2, currentBoard);
            default -> null;
        };
        return character;
    }

}
