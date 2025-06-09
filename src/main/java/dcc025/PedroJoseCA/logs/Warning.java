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
}
