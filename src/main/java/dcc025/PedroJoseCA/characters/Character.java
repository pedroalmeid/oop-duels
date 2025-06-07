package dcc025.PedroJoseCA.characters;

import dcc025.PedroJoseCA.game.Board;

import java.util.Scanner;

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
    final private Scanner KEYBOARD = new Scanner(System.in);

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
        System.out.println();
        System.out.println(name + " defended. Current defense now is " + maxDefense);
        currentDefense = maxDefense;
    }

    public void attack() {
        int distance = currentBoard.getDistanceBetweenPlayers();
        if (distance > range) {
            System.out.println();
            System.out.println(name + "'s attack was unsuccessful. The character has no attack range at this distance");
        } else {
            System.out.println();
            System.out.println(name + " attacked " + enemy.getName());
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
        System.out.println();
        System.out.println(name + " lost " + lostDefense + " of defense and " + lostHp + " of hp." );
    }

    public void move() {
        System.out.println();
        System.out.println("Please select the direction of your movement");
        System.out.println("Digit 0 for UP");
        System.out.println("Digit 1 for DOWN");
        System.out.println("Digit 2 for LEFT");
        System.out.println("Digit 3 for RIGHT");
        int selectedDirection = KEYBOARD.nextInt();
        while (selectedDirection < 0 || selectedDirection > 3) {
            System.out.println("Please select a valid direction");
            selectedDirection = KEYBOARD.nextInt();
        }

        String direction = switch (selectedDirection) {
            case 0 -> "up";
            case 1 -> "down";
            case 2 -> "left";
            case 3 -> "right";
            default -> "none";
        };

        boolean validMove = currentBoard.askToMovePlayer(numberId, direction);
        if (!validMove) {
            System.out.println();
            System.out.println(name + "'s move was unsuccessful because it tried to move beyond the limits of the board or to the enemy's position");
        }
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

    public int getRange() {
        return range;
    }

    protected void setHp(int newHp) {
        hp = newHp;
    }

    public void useUltimate() {}
}
