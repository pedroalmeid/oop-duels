package dcc025.PedroJoseCA.characters;

import dcc025.PedroJoseCA.game.Board;
import dcc025.PedroJoseCA.logs.Message;

public class Warrior extends Character {

    public Warrior(String givenName, int playerNumber, Board board) {
        super(givenName, playerNumber, board);
        attack = 15;
        maxDefense = 10;
        currentDefense = maxDefense;
        range = 1;
        className = "Warrior";
    }

    public void useUltimate() {
        attack = 30;
        Message.warriorUltimate(name, attack);
    }
}
