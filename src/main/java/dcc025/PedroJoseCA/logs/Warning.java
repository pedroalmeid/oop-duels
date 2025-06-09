package dcc025.PedroJoseCA.logs;

import static dcc025.PedroJoseCA.logs.Message.br;

public class Warning {
    public static void invalidGameMode() {
        System.out.println("Invalid game mode. Try again.");
    }

    public static void invalidDigit(String context) {
        System.out.println("Invalid digit for " + context + ". Try again.");
    }

    public static void forcedEnd() {
        br();
        System.out.println("Forcing end of game as requested");
    }

    public static void missedAttack(String name) {
        br();
        System.out.println(name + "'s attack was unsuccessful. The character has no attack range at this distance");
    }

    public static void invalidMove(String name) {
        br();
        System.out.println(name + "'s move was unsuccessful because it tried to move beyond the limits of the board or to the enemy's position");
        System.out.println("Please, try it again!");
    }
}
