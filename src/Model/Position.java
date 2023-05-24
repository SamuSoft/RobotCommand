package Model;

public record Position(int x, int y) {
    /** Calculate what a change in a direction would yield for position
     * @param direction The direction the position is changing towards
     * @param change    The step-size at which the position is changing
     * @return the new position resulting in the change
     */
    public Position changeFromDirection(Direction direction, int change) {
        return switch (direction) {
            case NORTH -> new Position(this.x, y+change);
            case SOUTH -> new Position(this.x, y-change);
            case WEST -> new Position(this.x-change, y);
            case EAST -> new Position(this.x+change, y);
        };
    }
}
