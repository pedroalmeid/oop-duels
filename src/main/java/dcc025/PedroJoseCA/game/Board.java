package dcc025.PedroJoseCA.game;

import java.util.Random;

public class Board {
    Random random = new Random();
    final int BOARD_SIZE = 10;

    private final int [][] board = new int[BOARD_SIZE][BOARD_SIZE];

    Board() {
        int[] firstRandomPosition = getRandomCoordinate();
        board[firstRandomPosition[0]][firstRandomPosition[1]] = 1;

        int [] secondRandomPosition = getRandomCoordinate();
        while (secondRandomPosition == firstRandomPosition) {
            secondRandomPosition = getRandomCoordinate();
        }
        board[secondRandomPosition[0]][secondRandomPosition[1]] = 2;
    }


    private int[] getRandomCoordinate() {
        int randomI = random.nextInt(BOARD_SIZE);
        int randomJ = random.nextInt(BOARD_SIZE);
        return new int[]{randomI, randomJ};
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
