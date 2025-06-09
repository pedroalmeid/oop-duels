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
        String botName = "BOT";
        character = switch (randomNumber) {
            case 0 -> new Bowman(botName, 2, currentBoard);
            case 1 -> new Warrior(botName, 2, currentBoard);
            case 2 -> new Wizard(botName, 2, currentBoard);
            default -> null;
        };
        return character;
    }

    public void behave() {
        if (character.getEnemy().getHp() <= character.getAttack() && currentBoard.getDistanceBetweenPlayers() <= character.getRange()) {
            character.attack(); // Kill enemy if it's possible
        }
        else if (character.getHp() <= 18) {
            character.useUltimate(); // Use ultimate at low hp (good for Wizard)
        }
        else if (currentBoard.getDistanceBetweenPlayers() <= character.getRange()) {
            character.attack(); // Attack enemy if it's possible because of positions
        }
        else if (character.getHp() <= 40 && character.getCurrentDefense() < character.getMaxDefense()) {
            character.defend(); // Defend to avoid death
        }
        else if (character.getHp() == 100 && character.getEnemy().getHp() == 100) {
            character.useUltimate(); // Activate ultimate at start to improve attack force or range (good for Bowman and Warrior)
        }
        else {
            character.randomMove(); // Move randomly to try to approximate or run from the enemy (randomness factor)
        }
    }
}