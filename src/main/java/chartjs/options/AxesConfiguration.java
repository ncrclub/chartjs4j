package chartjs.options;

import chartjs.base.Axis;
import chartjs.base.GridLines;
import chartjs.base.Option;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * https://www.chartjs.org/docs/latest/configuration/legend.html#configuration-options
 */
public class AxesConfiguration {

    public final String key;
    public final String id;
    private final Set<Option<Object>> data= new HashSet<>();

    private final TickConfiguration ticks = new TickConfiguration();
    private final Axis axis;
    private final GridLines gridLines = new GridLines();

    public AxesConfiguration(Axis axis, String id) {
        this.axis = axis;
        this.key = axis.name().toLowerCase() +"AxisID";
        this.id = id;
    }

    public AxesConfiguration hidden() {
        return setDisplay(false);
    }

    public AxesConfiguration setDisplay(boolean value) {
        set(new Option("display", value));
        return this;
    }

    public AxesConfiguration setPosition(String value) {
        set(new Option("position", value));
        return this;
    }

    public AxesConfiguration stacked(boolean value) {
        set(new Option("stacked", value));
        return this;
    }
    public AxesConfiguration stacked() {
        return stacked(true);
    }
    public AxesConfiguration linear() {
        set(new Option("type", "linear"));
        return this;
    }
    public AxesConfiguration logarithmic() {
        set(new Option("type", "logarithmic"));
        return this;
    }

    public AxesConfiguration withTicks(Consumer<TickConfiguration> consumer) {
        consumer.accept(ticks);
        return this;
    }

    public AxesConfiguration withGridLines(Consumer<GridLines> consumer) {
        consumer.accept(gridLines);
        return this;
    }

    private void set(Option option) {
        if (this.data.contains(option)) {
            this.data.remove(option);
        }
        this.data.add(option);
    }


    public Object pack() {
        Map<String, Object> packed = data.stream().collect(Collectors.toMap(k -> k.name, v -> v.pack()));
        packed.put("id", id);
        packed.put("ticks", ticks.pack());
        packed.put("gridLines", gridLines.pack());
        return packed;
    }

}
