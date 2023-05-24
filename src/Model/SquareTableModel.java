package Model;

public record SquareTableModel(int x, int y) implements TableModel {

    @Override
    public boolean isOutOfBounds(int x, int y) {
        if (x < 0 || x > this.x)
            return true;
        return y < 0 || y > this.x;
    }

    @Override
    public boolean isOutOfBounds(Position position) {
        if (position.x() < 0 || position.x() > this.x)
            return true;
        return position.y() < 0 || position.y() > this.y;
    }
}
