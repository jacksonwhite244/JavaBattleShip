package items;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Board class
 * Holds ships and can be different sizes
 */
public class Board {
    ///  the size of the board
    private int size;
    ///  the board is a list of lists of chars
    private ArrayList<char[]> mBoard;
    ///  list of ships on the board
    private ArrayList<Ship> mShips;

    /**
     * custom constructor
     * @param size the size of the board
     */
    public Board(int size) {
        this.size = size;
        this.mBoard = new ArrayList<>();
        this.mShips = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            char[] inside = new char[size];
            Arrays.fill(inside, ' ');
            this.mBoard.add(inside);
        }
    }

    /**
     * Place a given ship onto the board
     * Mark all spots of the ship as S on the board
     * @param ship the ship object we are adding to the game
     */
    public void PlaceShip(Ship ship) {
        if (!this.mShips.contains(ship)) {
            this.mShips.add(ship);
        }

        ArrayList<int[]> coordinates = ship.GetPositions();
        for (int[] coordinate : coordinates) {
            int row = coordinate[0];
            int col = coordinate[1];

            char[] selectedRow = mBoard.get(row);
            selectedRow[col] = 'S';
        }
    }

    /**
     * Check if a guess has hit the ship
     * @param guess coordinates of the guess [x, y]
     */
    public void ApplyGuess(int[] guess) {
        int row = guess[0];
        int col = guess[1];

        if (this.mBoard.get(row)[col] == 'S') {
            for (Ship ship : this.mShips) {
                for (int[] coordinate : ship.GetPositions()) {
                    if (coordinate[0] == row && coordinate[1] == col) {
                        ship.ApplyHit();
                        break;
                    }
                }
            }
            mBoard.get(row)[col] = 'H';
            System.out.println("Hit!");
        }
        else {
            mBoard.get(row)[col] = 'M';
            System.out.println("Miss!");
        }
    }



}
