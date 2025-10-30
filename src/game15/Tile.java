package game15;

public class Tile {

    // Representerar en bricka (nummer, position)
    // Hämta färg från inställningar

    // Steg 1: Vad brickan ska komma ihåg?
    private int number;
    private int row;
    private int col;

    // Steg 2: Hur skapar vi en bricka?
    public Tile(int number, int row, int col) {
        this.number = number;
        this.row = row;
        this.col = col;
    }
    // Getters och Setters
    public int getNumber() {
        return number;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean isEmpty() {
        return number == 0;
    }

}
