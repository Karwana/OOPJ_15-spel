package game15;

import java.util.Random;

public class GameBoard {
    private Tile[][] board;
    private int emptyRow;
    private int emptyColumn;

    public GameBoard() {
        board = new Tile[4][4]; // // Skapa 4x4 rutnät
        setupBoard();   // // Fyll det med brickor
    }

    // Sätter ut alla brickor 0-14 och en tom ruta
    public void setupBoard() {
        int number = 1; // 1-15

        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {

                // Sista rutan (3,3) ska vara tom
                if (row == 3 && column == 3) {
                    board[row][column] = null;
                    emptyRow = 3;
                    emptyColumn = 3;
                }
                // Alla andra får en bricka
                else {
                    board[row][column] = new Tile(number, row, column);
                    number = number + 1;
                }
            }
        }
    }

    public Tile getTile(int row, int column) {
        return board[row][column];
    }

    // Bricka bredvid tom ruta = giltigt
    public boolean isValidMove(int row, int column) {

        // ovanför
        if (row == emptyRow - 1 && column == emptyColumn)
            return true;

        // under
        else if (row == emptyRow + 1 && column == emptyColumn)
            return true;

        // vänster
        else if (row == emptyRow && column == emptyColumn - 1)
            return true;

        // höger
        else if (row == emptyRow && column == emptyColumn + 1)
            return true;

        else return false;
    }

    // Flytta brickan till tom ruta om giltigt
    public void moveTile(int row, int column) {
        if (isValidMove(row, column)) {

            // Byt plats på brickan och tom ruta
            board[emptyRow][emptyColumn] = board[row][column];
            board[emptyRow][emptyColumn].setPosition(emptyRow, emptyColumn);
            board[row][column] = null;

            // Uppdatera var tom ruta är
            emptyRow = row;
            emptyColumn = column;
        }
    }

    // Blandar brickorna
    public void shuffle() {
        Random random = new Random();
        // Gör 500 slumpmässiga förflyttningar
        for (int i = 0; i < 500; i++) {
            int direction = random.nextInt(4); // 0=upp, 1=ner, 2=vänster, 3=höger

            if (direction == 0 && emptyRow > 0) {
                moveTile(emptyRow - 1, emptyColumn);
            }
            else if (direction == 1 && emptyRow < 3) {
                moveTile(emptyRow + 1, emptyColumn);
            }
            else if (direction == 2 && emptyColumn > 0) {
                moveTile(emptyRow, emptyColumn - 1);
            }
            else if (direction == 3 && emptyColumn < 3) {
                moveTile(emptyRow, emptyColumn + 1);
            }
        }
    }

    public boolean isGameWon() {
        // Tomma rutan MÅSTE vara på (3,3) för vinst
        if (board[3][3] != null) {
            return false;
        }

        // Kolla alla andra brickor
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                if (board[row][column] != null) {
                    if (!board[row][column].isInCorrectPosition()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

