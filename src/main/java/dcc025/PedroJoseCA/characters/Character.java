package dcc025.PedroJoseCA.characters;

import dcc025.PedroJoseCA.game.Board;
import dcc025.PedroJoseCA.logs.Message;
import dcc025.PedroJoseCA.logs.Warning;

import java.util.Random;
import java.util.Scanner;

public class Character {
    final private Scanner KEYBOARD = new Scanner(System.in);
    final Random RANDOM = new Random();

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

    public int getPlayerNumber() {
        return numberId;
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
        boolean validMove = currentBoard.askToMovePlayer(numberId, selectDirection());

        while (!validMove) {
            Warning.invalidMove(name);
            validMove = currentBoard.askToMovePlayer(numberId, selectDirection());
        }
    }

    public void randomMove() {
        boolean validMove = currentBoard.askToMovePlayer(numberId, randomSelectDirection());
        while (!validMove) {
            validMove = currentBoard.askToMovePlayer(numberId, randomSelectDirection());
        }
    }

    private String selectDirection() {
        Message.askForDirection();

        int selectedDirection = KEYBOARD.nextInt();

        while (selectedDirection < 0 || selectedDirection > 3) {
            Warning.invalidDigit("direction");
            selectedDirection = KEYBOARD.nextInt();
        }

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

    public int getHp() {
        return hp;
    }

    public boolean isAlive() {
        return hp > 0;
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

    protected void setHp(int newHp) {
        hp = newHp;
    }

    public Character getEnemy() {
        return enemy;
    }

    public void useUltimate() {}
}
