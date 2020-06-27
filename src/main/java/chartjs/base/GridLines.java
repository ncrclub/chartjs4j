package chartjs.base;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GridLines extends Stanza<GridLines> {

    public GridLines() {
    }

    public GridLines color(Color color) {
        return option("color", color.toString());
    }

}
