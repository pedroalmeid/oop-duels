package dcc025.PedroJoseCA.characters;

public class Warrior extends Character {

    public Warrior(String givenName, int playerNumber) {
        super(givenName, playerNumber);
        attack = 15;
        maxDefense = 10;
        currentDefense = maxDefense;
        range = 1;
    }

    public void useUltimate() {
        attack = 30;
    }
}
