package dcc025.PedroJoseCA.game;

import java.util.Random;

public class Board<P1, P2> {
    final Random RANDOM = new Random();
    final int BOARD_SIZE = 10;

    private int [][] board = new int[BOARD_SIZE][BOARD_SIZE];

    Board(P1 player1, P2 player2) {
        int[] firstRandomPosition = getRandomCoordinate();
        board[firstRandomPosition[0]][firstRandomPosition[1]] = 1;

        int [] secondRandomPosition = getRandomCoordinate();
        while (secondRandomPosition == firstRandomPosition) {
            secondRandomPosition = getRandomCoordinate();
        }
        board[secondRandomPosition[0]][secondRandomPosition[1]] = 2;
    }

    private int[] getRandomCoordinate() {
        int randomX = RANDOM.nextInt(BOARD_SIZE);
        int randomY = RANDOM.nextInt(BOARD_SIZE);
        return new int[]{randomX, randomY};
    }

    public void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
