package Model;

import java.util.Arrays;

public enum Direction {
    NORTH(0),
    EAST(1),
    SOUTH(2),
    WEST(3);

    public final int index;

    Direction(int groupIndex) {
        this.index = groupIndex % 4;
    }

    int getIndex() {
        return index;
    }

    public Direction valueOfIndex(int i) {
        return Arrays.stream(values())
                .filter(d -> d.index == Math.floorMod(i, 4))
                .findFirst()
                .get();
    }

    public Direction turn(DirectionChange change) {
        return valueOfIndex(this.index + change.indexChange);
    }


}