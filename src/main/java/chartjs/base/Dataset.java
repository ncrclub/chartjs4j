package chartjs.base;

import java.util.*;
import java.util.stream.Collectors;

public class Dataset<T> {


    private final Map<String, Object> data = new HashMap<>();

    public Dataset(String label, Color background, Color border, List<T> data) {
        this(label, new Color[]{background}, new Color[]{border}, data);
    }
    public Dataset(String label, Color[] background, Color border, List<T> data) {
        this(label, background, new Color[]{border}, data);
    }

    public Dataset(String label, Color[] background, Color[] border, List<T> data) {
        this.data.put("label", label);
        if (background.length == 1) {
            this.data.put("backgroundColor", background[0].toString());
        } else {
            this.data.put("backgroundColor", Arrays.stream(background).map(c -> c.toString()).collect(Collectors.toList()));
        }
        if (border.length == 1) {
            this.data.put("borderColor", border[0].toString());
        } else {
            this.data.put("borderColor", Arrays.stream(border).map(c -> c.toString()).collect(Collectors.toList()));
        }

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

    public Dataset<T> fill(boolean value) { return set("fill", value); }

    /* bars */
    public Dataset<T> setMaxBarThickness(int value) { return set("maxBarThickness", value); }
    public Dataset<T> setBarThickness(int value) { return set("barThickness", value); }
    public Dataset<T> setMinBarLength(int value) { return set("MinBarLength", value); }

    /* lines */
    public Dataset<T> setBorderLineThickness(int value) { return set("borderWidth", value); }

    /* points */
    public Dataset<T> setPointRadius(int value) { return set("pointRadius", value); }
    public Dataset<T> setPointHitRadius(int value) { return set("pointHitRadius", value); }
    public Dataset<T> setPointBorderWidth(int value) { return set("pointBorderWidth", value); }
    public Dataset<T> setPointHoverRadius(int value) { return set("pointHoverRadius", value); }
    public Dataset<T> setPointHoverBackgroundColor(Color value) { return set("pointHoverBackgroundColor", value.toString()); }
    public Dataset<T> setPointHoverBorderColor(Color value) { return set("pointHoverBorderColor", value.toString()); }

    public String name() {
        return (String) data.get("label");
    }

    /*
    pointBorderWidth: 0,
    pointHoverRadius: 0,
    pointHoverBackgroundColor: "rgba(75,192,192,1)",
    pointHoverBorderColor: "rgba(220,220,220,1)",
    pointHoverBorderWidth: 0,
    pointRadius: 0,
    pointHitRadius: 0
     */

}
