package dcc025.PedroJoseCA.characters;

import dcc025.PedroJoseCA.game.Board;

public class Character {
    protected String name;
    private int hp = 100;
    protected int attack;
    protected int maxDefense;
    protected int currentDefense;
    protected int range;
    protected int numberId;

    protected Character(String givenName, int playerNumber) {
        name = givenName;
        numberId = playerNumber;
    }

    public int getPlayerNumber() {
        return numberId;
    }

    public void defend() {
        System.out.println();
        System.out.println("You defended yourself. Current defense now is " + maxDefense);
        currentDefense = maxDefense;
    }

    public void attack(Board currentBoard, Character enemy) {
        int distance = currentBoard.getDistanceBetweenPlayers();
        if (distance > range) {
            System.out.println();
            System.out.println("Your attack was unsuccessful. Your character has no attack range at this distance");
        } else {
            System.out.println();
            System.out.println("You attacked " + enemy.getName());
            enemy.sufferDamage(attack);
        }
    }

    protected void sufferDamage(int attackDamage) {
        if (currentDefense - attackDamage >= 0) {
            currentDefense -= attackDamage;
        } else {
            currentDefense = 0;
            hp -= attackDamage - currentDefense;
        }
    }

    public void move(Board currentBoard) {
        boolean validMove = currentBoard.askToMovePlayer(numberId, "down");
        if (!validMove) {
            System.out.println();
            System.out.println("Your move was unsuccessful because you tried to move beyond the limits of the board or to the enemy's position");
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

    public void useUltimate(Character enemy) {}
}
