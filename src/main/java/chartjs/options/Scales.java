package chartjs.options;

import chartjs.base.Axis;
import chartjs.base.Option;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * https://www.chartjs.org/docs/latest/configuration/scales.html#configuration-options
  */
public class Scales {

    private final List<AxesConfiguration> xAxes = new ArrayList<>();
    private final List<AxesConfiguration> yAxes = new ArrayList<>();

    private final Set<Option<Object>> data= new HashSet<>();

    public Scales() {
        addXAxis();
        addYAxis();
    }

    public AxesConfiguration addXAxis() {
        AxesConfiguration axis = new AxesConfiguration(Axis.X, "x-axis-"+ xAxes.size());
        xAxes.add(axis);
        return axis;
    }

    public AxesConfiguration addYAxis() {
        AxesConfiguration axis = new AxesConfiguration(Axis.Y, "y-axis-"+ yAxes.size());
        yAxes.add(axis);
        return axis;
    }

    public Scales xAxes(int index, Consumer<AxesConfiguration> consumer) {
        consumer.accept(xAxes.get(index));
        return this;
    }

    public Scales yAxes(int index, Consumer<AxesConfiguration> consumer) {
        consumer.accept(yAxes.get(index));
        return this;
    }

    public AxesConfiguration getXAxis(int index) {
        return xAxes.get(index);
    }

    public AxesConfiguration getYAxis(int index) {
        return yAxes.get(index);
    }

    public Object pack() {
        Map<String, Object> packed = data.stream().collect(Collectors.toMap(k -> k.name, v -> v.value));
        packed.put("xAxes", xAxes.stream().map(x -> x.pack()).collect(Collectors.toList()));
        packed.put("yAxes", yAxes.stream().map(y -> y.pack()).collect(Collectors.toList()));
        return packed;
    }

}
