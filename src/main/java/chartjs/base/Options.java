package chartjs.base;

import chartjs.options.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Options {

    private Map<String, Option> options= new HashMap<>();
    public final Legend ledgend= new Legend();
    public final Title title= new Title();
    private final Scales scales= new Scales();
    private final Tooltips tooltips= new Tooltips();

    public Options add(Option option) {
        this.options.put(option.name, option);
        return this;
    }

    public Map<String, Object> pack() {
        Map<String, Object> data = new HashMap<>();
        this.options.values().forEach(o -> data.put(o.name, o.pack()));
        data.put("legend", ledgend.pack());
        data.put("title", title.pack());
        data.put("scales", scales.pack());
        data.put("tooltips", tooltips.pack());
        return data;
    }

    public AxesConfiguration addXAxis() {
        return scales.addXAxis();
    }

    public AxesConfiguration addYAxis() {
        return scales.addYAxis();
    }

    public AxesConfiguration xAxis(int index) {
        return scales.getXAxis(index);
    }

    public AxesConfiguration yAxis(int index) {
        return scales.getYAxis(index);
    }

    public Options withXAxis(int index, Consumer<AxesConfiguration> consumer) {
        scales.xAxes(index, consumer);
        return this;
    }

    public Options withYAxis(int index, Consumer<AxesConfiguration> consumer) {
        scales.yAxes(index, consumer);
        return this;
    }

    public Options withTooltips(Consumer<Tooltips> consumer) {
        consumer.accept(tooltips);
        return this;
    }



}
