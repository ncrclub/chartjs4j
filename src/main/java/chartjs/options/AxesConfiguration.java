package chartjs.options;

import chartjs.base.Axis;
import chartjs.base.GridLines;
import chartjs.base.Option;
import chartjs.base.Stanza;
import chartjs.options.axes.TickConfiguration;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * https://www.chartjs.org/docs/latest/configuration/legend.html#configuration-options
 */
public class AxesConfiguration extends Stanza<AxesConfiguration> {

    public final String key;
    public final String id;

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
        return option("display", value);
    }

    public AxesConfiguration setPosition(String value) {
        return option("position", value);
    }

    public AxesConfiguration stacked(boolean value) {
        return option("stacked", value);
    }
    public AxesConfiguration stacked() {
        return stacked(true);
    }
    public AxesConfiguration linear() {
        return option("type", "linear");
    }
    public AxesConfiguration logarithmic() {
        return option("type", "logarithmic");
    }

    public AxesConfiguration withTicks(Consumer<TickConfiguration> consumer) {
        consumer.accept(ticks);
        return this;
    }

    public AxesConfiguration tickFontColor(String htmlColor) {
        ticks.withFontColor(htmlColor);
        return this;
    }

    public AxesConfiguration withGridLines(Consumer<GridLines> consumer) {
        consumer.accept(gridLines);
        return this;
    }




    public Object pack() {
        Map<String, Object> packed = (Map<String, Object>) super.pack();
        packed.put("id", id);
        packed.put("ticks", ticks.pack());
        packed.put("gridLines", gridLines.pack());
        return packed;
    }

}
