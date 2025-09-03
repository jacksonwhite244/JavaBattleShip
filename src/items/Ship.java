package items;

import java.util.ArrayList;

/**
 * Ship class
 * The game holds ships that can be placed anywhere on the baord
 */
public class Ship {
    ///  the length of the ship
    private int mLenth;
    /// the orientation of the ship
    private String mOrientation;
    ///  the positions of the ship
    private ArrayList<int[]> positions = new ArrayList<>();
    /// how many times the ship has been hit
    private int mHitCount;
    /// boolean if the ship has sunk yet
    private boolean mIsSunk;


    /**
     * custom constructor for a Ship
     * @param length the length of the ship
     * @param position the position of the ship [x, y] format
     * @param orientation the orientation of the ship, h or v (horizontal, vertical)
     */
    public Ship(int length, int[] position, String orientation) {
        this.mLenth = length;
        this.mOrientation = orientation;
        this.mHitCount = 0;
        this.mIsSunk = false;

        //  x and y values of our position
        int x =  position[0];
        int y = position[1];

        // horizontal
        if (orientation.equals("h")) {
            for (int i = 0; i < length; i++) {
                this.positions.add(new int[] {x, y + i});
            }
        }
        // vertical
        else if (orientation.equals("v")) {
            for (int i = 0; i < length; i++) {
                this.positions.add(new int[] {x + i, y});
            }
        }
    }

    /**
     * Get the array list of positions
     * @return a list of positions the ships are at
     */
    public ArrayList<int[]> GetPositions() {
        return this.positions;
    }

    /**
     * Get the orientation of the ship
     * @return a string depicting orientation
     */
    public String GetOrientation() {
        return this.mOrientation;
    }

    /**
     * Apply a hit to the ship
     */
    public void ApplyHit() {
        this.mHitCount++;
        if (this.mHitCount == this.mLenth) {
            this.mIsSunk = true;
        }
    }
}
