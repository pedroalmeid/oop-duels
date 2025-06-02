package dcc025.PedroJoseCA.game;

import dcc025.PedroJoseCA.characters.Character;

import java.util.Random;

public class Board {
    final Random RANDOM = new Random();
    final int BOARD_SIZE = 10;

    private int [][] board = new int[BOARD_SIZE][BOARD_SIZE];
    private int [][] playerPositions = new int [2][2];

    Board(Character player1, Character player2) {
        int[] firstRandomPosition = getRandomCoordinate();
        board[firstRandomPosition[0]][firstRandomPosition[1]] = 1;
        playerPositions[0] = firstRandomPosition;

        int [] secondRandomPosition = getRandomCoordinate();
        while (secondRandomPosition == firstRandomPosition) {
            secondRandomPosition = getRandomCoordinate();
        }
        board[secondRandomPosition[0]][secondRandomPosition[1]] = 2;
        playerPositions[1] = secondRandomPosition;
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
