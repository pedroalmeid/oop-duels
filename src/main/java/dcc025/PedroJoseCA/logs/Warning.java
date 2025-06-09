package dcc025.PedroJoseCA.logs;

import static dcc025.PedroJoseCA.logs.Message.*;

public class Warning {
    public static void invalidGameMode() {
        System.out.print(COLOR_RED);
        System.out.println("Invalid game mode. Try again.");
        System.out.print(COLOR_RESET);
    }

    public static void invalidDigit(String context) {
        System.out.print(COLOR_RED);
        System.out.println("Invalid digit for " + context + ". Try again.");
        System.out.print(COLOR_RESET);
    }

    public static void invalidMove(String name) {
        br();
        System.out.print(COLOR_RED);
        System.out.println(name + "'s move was unsuccessful because it tried to move beyond the limits of the board or to the enemy's position");
        System.out.println("Please, try it again!");
        System.out.print(COLOR_RESET);
    }

    public static void forcedEnd() {
        br();
        System.out.print(COLOR_RED);
        System.out.println("Forcing end of game as requested");
        System.out.print(COLOR_RESET);
    }

    public static void missedAttack(String name) {
        br();
        System.out.print(COLOR_RED);
        System.out.println(name + "'s attack was unsuccessful. The character has no attack range at this distance");
        System.out.print(COLOR_RESET);
    }
}
