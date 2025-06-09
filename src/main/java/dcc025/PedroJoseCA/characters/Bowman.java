package dcc025.PedroJoseCA.characters;

import dcc025.PedroJoseCA.game.Board;
import dcc025.PedroJoseCA.logs.Message;

public class Bowman extends Character {

    public Bowman(String givenName, int playerNumber, Board board) {
        super(givenName, playerNumber, board);
        attack = 8;
        maxDefense = 5;
        currentDefense = maxDefense;
        range = 5;
        className = "Bowman";
    }

    public void useUltimate() {
        range++;
        Message.bowmanUltimate(name, range);
    }
}
