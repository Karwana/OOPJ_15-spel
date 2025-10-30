package game15;

public class GameBoard {
    private Tile[][] board;
    private int rowEmpty;
    private int columnEmpty;

    public GameBoard() {
        board = new Tile[4][4]; // // Skapa 4x4 rutnät
        setupBoard();   // // Fyll det med brickor
    }

    // Sätter ut alla brickor 0-14 och en tom ruta
    public void setupBoard() {
        int number = 1;

        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {

                // Sista rutan (3,3) ska vara tom
                if (row == 3 && column == 3) {
                    board[row][column] = null;
                    rowEmpty = 3;
                    columnEmpty = 3;
                }
                // Alla andra får en bricka
                else {
                    board[row][column] = new Tile(number);
                    number = number + 1;
                }
            }
        }
    }
    public Tile getTile(int row, int column) {
        return board[row][column];
    }
}
