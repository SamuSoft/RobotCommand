package Model;

import java.util.Arrays;
import java.util.List;

public enum DirectionChange {
    LEFT(-1),
    RIGHT(1);

    public final int indexChange;

    DirectionChange(int i) {
        indexChange = i;
    }

    public static List<String> getAsListOfStrings() {
        return Arrays.stream(values()).map(DirectionChange::toString).toList();
    }
}
