package game15;

public class Tile {


    private int number;            // Brickans nummer (1-15)
    private int currentRow;        // Nuvarande rad (0-3)
    private int currentColumn;     // Nuvarande kolumn (0-3)

    public Tile(int number, int row, int column) {
        this.number = number;
        this.currentRow = row;
        this.currentColumn = column;
    }

    public int getNumber() {
        return number;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public int getCurrentColumn() {
        return currentColumn;
    }
    // Uppdatera brickans position när den flyttas
    public void setPosition(int row, int column) {
        this.currentRow = row;
        this.currentColumn = column;
    }
    // Kolla om brickan är på rätt plats
    // Bricka 1 ska vara på (0,0) , bricka 2 på (0,1) , bricka 5 på (1,0)
    public boolean isInCorrectPosition() {
        int correctRow = (number - 1) / 4;
        int correctColumn = (number - 1) % 4;

        // Kolla om nuvarande position matchar rätt position
        if (currentRow == correctRow && currentColumn == correctColumn) {
            return true; // Brickan är på rätt plats
        } else {
            return false; // Brickan är på fel plats
        }


    }

}
