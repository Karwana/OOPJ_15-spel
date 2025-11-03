package game15;

public class Tile {

    // Representerar en bricka (nummer, position)
    // Hämta färg från inställningar

    // Steg 1: Vad brickan ska komma ihåg?
    private int number;
    private int currentRow;
    private int currentColumn;

    // Steg 2: Hur skapar vi en bricka?
    public Tile(int number, int currentRow, int col) {
        this.number = number;
        this.currentRow = currentRow;
        this.currentColumn = col;
    }
    // Getters
    public int getNumber() {
        return number;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public int getCol() {
        return currentColumn;
    }

    public void setPosition(int row, int col) {
        this.currentRow = row;
        this.currentColumn = col;
    }
    // Kolla om brickan är på rätt plats
    // Bricka 1 ska vara på (0,0) , bricka 2 på (0,1) , bricka 5 på (1,0)
    public boolean isInCorrectPosition() {
        int correctRow = (number - 1) / 4;
        int correctCol = (number - 1) % 4;

        // Kolla om nuvarande position matchar rätt position
        if (currentRow == correctRow && currentColumn == correctCol) {
            return true;
        } else {
            return false;
        }


    }

}
