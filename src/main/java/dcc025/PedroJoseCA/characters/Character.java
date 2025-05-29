package dcc025.PedroJoseCA.characters;

public class Character {
    private int[] position = new int [2];
    private String name;
    private int hp = 100;
    private int attack;
    private int defense;
    private int range;

    public Character(String givenName) {
        name = givenName;
    }
}
