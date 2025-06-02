package dcc025.PedroJoseCA.characters;

public class Character {
    protected int[] position = new int [2];
    protected String name;
    protected int hp = 100;
    protected int attack;
    protected int maxDefense;
    protected int currentDefense;
    protected int range;
    protected int numberId;

    public Character(String givenName, int playerNumber) {
        name = givenName;
        numberId = playerNumber;
    }
}
