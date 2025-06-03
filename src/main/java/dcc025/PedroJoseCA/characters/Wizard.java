package dcc025.PedroJoseCA.characters;

public class Wizard extends Character {

    public Wizard(String givenName, int playerNumber) {
        super(givenName, playerNumber);
        attack = 10;
        maxDefense = 7;
        currentDefense = maxDefense;
        range = 3;
    }

    public void useUltimate(Character enemy) {
        int enemyHp = enemy.getHp();
        enemy.setHp(this.getHp());
        this.setHp(enemyHp);
    }
}
