package dcc025.PedroJoseCA.characters;

public class Bowman extends Character {

    public Bowman(String givenName, int playerNumber) {
        super(givenName, playerNumber);
        attack = 8;
        maxDefense = 5;
        currentDefense = maxDefense;
        range = 5;
    }
}
