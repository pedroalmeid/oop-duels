package dcc025.PedroJoseCA.characters;

import dcc025.PedroJoseCA.game.Board;
import dcc025.PedroJoseCA.logs.Message;
import dcc025.PedroJoseCA.logs.Warning;

import static dcc025.PedroJoseCA.game.Game.KEYBOARD;
import static dcc025.PedroJoseCA.game.Game.RANDOM;

public class Character {
    protected String name;
    protected String className;
    private int hp = 100;
    protected int attack;
    protected int maxDefense;
    protected int currentDefense;
    protected int range;
    protected int numberId;
    private Board currentBoard;
    protected Character enemy;

    protected Character(String givenName, int playerNumber, Board board) {
        name = givenName;
        numberId = playerNumber;
        currentBoard = board;
    }

    public void setEnemy(Character givenEnemy) {
        enemy = givenEnemy;
    }

    protected void setHp(int newHp) {
        hp = newHp;
    }

    public void defend() {
        Message.defense(name, maxDefense);
        currentDefense = maxDefense;
    }

    public void attack() {
        int distance = currentBoard.getDistanceBetweenPlayers();
        if (distance > range) {
            Warning.missedAttack(name);
        } else {
            Message.attack(name, enemy.getName());
            enemy.sufferDamage(attack);
        }
    }

    protected void sufferDamage(int attackDamage) {
        int lostDefense = 0;
        int lostHp = 0;
        if (currentDefense - attackDamage >= 0) {
            currentDefense -= attackDamage;
            lostDefense = attackDamage;
        } else {
            hp -= attackDamage - currentDefense;
            if (hp < 0) {
                hp = 0;
            }
            lostDefense = currentDefense;
            lostHp = attackDamage - currentDefense;
            currentDefense = 0;
        }
        Message.damage(name, lostDefense, lostHp);
    }

    public void move() {
        String direction = selectDirection();
        boolean validMove = currentBoard.askToMovePlayer(numberId, direction);

        while (!validMove) {
            Warning.invalidMove(name);
            direction = selectDirection();
            validMove = currentBoard.askToMovePlayer(numberId, direction);
        }

        Message.movement(name, direction);
    }

    public void randomMove() {
        String direction = randomSelectDirection();
        boolean validMove = currentBoard.askToMovePlayer(numberId, direction);
        while (!validMove) {
            direction = randomSelectDirection();
            validMove = currentBoard.askToMovePlayer(numberId, direction);
        }
        Message.movement(name, direction);
    }

    private String selectDirection() {
        int selectedDirection = -1;
        do {
            Message.askForDirection();
            String input = KEYBOARD.nextLine();
            try {
                selectedDirection = Integer.parseInt(input);
            }
            catch (NumberFormatException e) {
                Warning.invalidDigit("direction");
                continue;
            }
            if (selectedDirection < 0 || selectedDirection > 3) {
                Warning.invalidDigit("direction");
            }
        } while (selectedDirection < 0 || selectedDirection > 3);

        return switch (selectedDirection) {
            case 0 -> "up";
            case 1 -> "down";
            case 2 -> "left";
            case 3 -> "right";
            default -> "none";
        };
    }

    private String randomSelectDirection() {
        int randomNumber = RANDOM.nextInt(4);
        return switch (randomNumber) {
            case 0 -> "up";
            case 1 -> "down";
            case 2 -> "left";
            case 3 -> "right";
            default -> "none";
        };
    }

    public void useUltimate() {}

    public boolean isDead() {
        return hp == 0;
    }

    public int getPlayerNumber() {
        return numberId;
    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }

    public String getClassName() { return className; }

    public int getAttack() {
        return attack;
    }

    public int getCurrentDefense() {
        return currentDefense;
    }

    public int getMaxDefense() {
        return maxDefense;
    }

    public int getRange() {
        return range;
    }

    public Character getEnemy() {
        return enemy;
    }
}
