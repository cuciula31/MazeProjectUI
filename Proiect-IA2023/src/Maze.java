import java.util.Random;

public class Maze {
    private Chamber[][] chambers;
    private int numRows;
    private int numCols;
    private int numExits;
    private Man man;

    public Maze(Chamber[][] chambers) {
        this.chambers = chambers;
        this.numRows = chambers.length;
        this.numCols = chambers[0].length;
        this.man = findMan();
    }
    public Maze(int numRows, int numCols, int numExits, int manX, int manY) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.numExits = numExits;

        chambers = new Chamber[numRows][numCols];
        Random random = new Random();

        // Create chambers and randomly assign exits
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                boolean hasExit = random.nextInt(numExits) == 0;
                chambers[i][j] = new Chamber(hasExit, false);
            }
        }

        // Assign man's starting position
        man = new Man(manX, manY);
        chambers[manX][manY].setPerson(true);
    }

    public Man findMan() {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                Chamber chamber = chambers[i][j];
                if (chamber.hasPerson()) {
                    return new Man(i, j);
                }
            }
        }
        return null;
    }

    public Chamber getChamber(int row, int col) {
        return chambers[row][col];
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public Man getMan() {
        return man;
    }

    public void moveMan(int dx, int dy) {
        Chamber currentChamber = chambers[man.getX()][man.getY()];
        currentChamber.setPerson(false);
        man.move(dx, dy);
        chambers[man.getX()][man.getY()].setPerson(true);
    }
}
