package dcc025.PedroJoseCA.characters;

import dcc025.PedroJoseCA.game.Board;
import dcc025.PedroJoseCA.logs.Message;

public class Wizard extends Character {

    public Wizard(String givenName, int playerNumber, Board board) {
        super(givenName, playerNumber, board);
        attack = 10;
        maxDefense = 7;
        currentDefense = maxDefense;
        range = 3;
        className = "Wizard";
    }

    public void useUltimate() {
        int enemyHp = enemy.getHp();
        enemy.setHp(getHp());
        setHp(enemyHp);
        Message.wizardUltimate(name, enemy.getName());
    }
}
