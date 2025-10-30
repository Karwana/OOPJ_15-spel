package game15;

public class GameBoard {
    private Tile[][] board;
    private int rowEmpty;
    private int columnEmpty;

    public GameBoard() {
        board = new Tile[4][4];
        setupBoard();
    }
    public void setupBoard() {
        int number = 1;

        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {

                if (row == 3 && column == 3) {
                    board[row][column] = null;
                    rowEmpty = 3;
                    columnEmpty = 3;
                }
            }
        }
    }

}
