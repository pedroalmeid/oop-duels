package dcc025.PedroJoseCA.game;

import dcc025.PedroJoseCA.logs.Message;

import java.util.Random;

public class Board {
    final Random RANDOM = new Random();
    final String COLOR_GREEN = "\u001B[32m";
    final String COLOR_PURPLE = "\u001B[35m";
    final String COLOR_RESET = "\u001B[0m";
    final int BOARD_SIZE = 10;

    private int [][] board = new int[BOARD_SIZE][BOARD_SIZE];
    private int [][] playerPositions = new int [2][2];

    Board() {
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
        int randomI = RANDOM.nextInt(BOARD_SIZE);
        int randomJ = RANDOM.nextInt(BOARD_SIZE);
        return new int[]{randomI, randomJ};
    }

    public void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == 1) {
                    System.out.print(Message.COLOR_CYAN + board[i][j] + Message.COLOR_RESET + " ");
                }
                else if (board[i][j] == 2) {
                    System.out.print(Message.COLOR_PURPLE + board[i][j] + Message.COLOR_RESET + " ");
                }
                else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public int[] getPlayerPosition(int playerNumber) {
        return playerPositions[playerNumber - 1];
    }

    public int getDistanceBetweenPlayers() {
        // Using Chebyshev distance
        return Math.max(
                Math.abs(playerPositions[0][0] - playerPositions[1][0]),
                Math.abs(playerPositions[0][1] - playerPositions[1][1])
        );
    }

    public boolean askToMovePlayer(int playerNumber, String direction) {
        int[] playerPosition = getPlayerPosition(playerNumber);
        int enemyNumber = (playerNumber == 1) ? 2 : 1;
        int[] enemyPosition = getPlayerPosition(enemyNumber);

        int height = playerPosition[0];
        int width = playerPosition[1];
        int enemyHeight = enemyPosition[0];
        int enemyWidth = enemyPosition[1];

        switch (direction) {
            case "up":
                if (height - 1 >= 0 && (height - 1 != enemyHeight || width != enemyWidth)) {
                    board[height][width] = 0;
                    playerPositions[playerNumber - 1][0]--;
                    board[height-1][width] = playerNumber;
                    return true;
                }
                break;
            case "down":
                if (height + 1 < BOARD_SIZE && (height + 1 != enemyHeight || width != enemyWidth)) {
                    board[height][width] = 0;
                    playerPositions[playerNumber - 1][0]++;
                    board[height+1][width] = playerNumber;
                    return true;
                }
                break;
            case "left":
                if (width - 1 >= 0 && (height != enemyHeight || width - 1 != enemyWidth)) {
                    board[height][width] = 0;
                    playerPositions[playerNumber - 1][1]--;
                    board[height][width-1] = playerNumber;
                    return true;
                }
                break;
            case "right":
                if (width + 1 < BOARD_SIZE && (height != enemyHeight || width + 1 != enemyWidth)) {
                    board[height][width] = 0;
                    playerPositions[playerNumber - 1][1]++;
                    board[height][width+1] = playerNumber;
                    return true;
                }
                break;
        }
        return false;
    }
}
