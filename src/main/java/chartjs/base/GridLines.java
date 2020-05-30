package chartjs.base;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GridLines {

    private final Set<Option<Object>> data= new HashSet<>();

    public GridLines() {
    }

    private void set(Option option) {
        if (this.data.contains(option)) {
            this.data.remove(option);
        }
        this.data.add(option);
    }

    public GridLines color(Color color) {
        set(new Option("color", color.toString()));
        return this;
    }

    public Object pack() {
        return data.stream().collect(Collectors.toMap(k -> k.name, v -> v.value));
    }
}
