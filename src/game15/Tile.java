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
    // Getters
    public int getNumber() {
        return number;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    // Setters
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
    // Kolla om detta är tomma platsen
    public boolean isEmpty() {
        return number == 0;
    }
    // Kolla om en annan bricka ligger bredvid denna
    public boolean isAdjacentTo(Tile other) {
        if (other == null) return false;

        // Samma rad, en kolumn bort
        boolean sameRow = (this.row == other.row) &&
                (Math.abs(this.col - other.col) == 1);

        // Samma kolumn, en rad bort
        boolean sameCol = (this.col == other.col) &&
                (Math.abs(this.row - other.row) == 1);

        return sameRow || sameCol;
    }
    // Räkna distansen till en annan bricka
    public int distanceTo(Tile other) {
        return Math.abs(this.row - other.row) +
                Math.abs(this.col - other.col);
    }
    // Är brickan på rätt plats (för att kolla vinst)
    public boolean isInCorrectPosition() {
        if (isEmpty()) {
            // Tom plats ska vara nere till höger (3,3)
            return row == 3 && col == 3;
        }
        // Räkna ut vart brickan ska vara
        int correctRow = (number - 1) / 4;
        int correctCol = (number - 1) % 4;

        return row == correctRow || col == correctCol;
    }
    // Vart borde brickan ligga (returna ett array, [rad,col])
    public int[] getCorrectPosition() {
        if (isEmpty()) {
            return new int []{3, 3};
        }
        int correctRow = (number - 1) / 4;
        int correctCol = (number - 1) % 4;

        return new int []{correctRow, correctCol};
    }
    // Override metoder
    @Override
    public String toString(){
        if (isEmpty()){
            return "[ ]";
        }
        return "[" + (number < 10 ? " " : "") + number + "]";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Tile tile = (Tile) obj;
        return number == tile.number &&
                row == tile.row &&
                col == tile.col;
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + row;
        result = 31 * result + col;
        return result;
    }
    // Kopiera en bricka (metod)
    public Tile copy() {
        return new Tile(this.number, this.row, this.col);
    }
    // Debug Metod
    public String getDetailedInfo() {
        return String.format("Tile %d at position (%d,%d)%s%s",
                number,
                row,
                col,
                isEmpty() ? "[EMPTY]" : "",
                isInCorrectPosition() ? "[CORRECT POSITION]" : "");
    }






}
