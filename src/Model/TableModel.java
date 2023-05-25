package Model;

public interface TableModel {
    /**
     * Checks to see if a certain coordinate is out of bounds on a table. The top left corner is the 0,0 coordinate.
     *
     * @param x the X coordinate on a linear grid
     * @param y the Y coordinate on a linear grid
     * @return If the coordinate in question is on top of the table
     */
    public boolean isOutOfBounds(int x, int y);

    /**
     * Checks to see if a certain coordinate is out of bounds on a table. The top left corner is the 0,0 coordinate.
     *
     * @param position the X and Y coordinates on a linear grid
     * @return If the coordinate in question is on top of the table
     */
    public boolean isOutOfBounds(Position position);
}
