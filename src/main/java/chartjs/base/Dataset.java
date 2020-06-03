package chartjs.base;

import java.util.*;
import java.util.stream.Collectors;

public class Dataset<T> {


    private final Map<String, Object> data = new HashMap<>();

    public Dataset(String label, Color[] background, Color border, List<T> data) {
        this.data.put("label", label);
        if (background.length == 1) {
            this.data.put("backgroundColor", background[0].toString());
        } else {
            this.data.put("backgroundColor", Arrays.stream(background).map(c -> c.toString()).collect(Collectors.toList()));
        }
        this.data.put("borderColor", border.toString());
        this.data.put("data", data);
    }

    public Map<String, Object> pack() {
        return Collections.unmodifiableMap(data);
    }

    protected Dataset set(String key, Object value) {
        if (value != null) {
            data.put(key, value);
        } else {
            data.remove(key);
        }
        return this;
    }

    public Dataset setMaxBarThickness(int value) {
        this.data.put("maxBarThickness", value);
        return this;
    }
    public Dataset setBarThickness(int value) {
        this.data.put("barThickness", value);
        return this;
    }
    public Dataset setMinBarLength(int value) {
        this.data.put("MinBarLength", value);
        return this;
    }

}
