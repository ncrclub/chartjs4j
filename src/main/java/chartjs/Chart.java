package chartjs;


import chartjs.base.*;
import chartjs.options.AxesConfiguration;
import chartjs.options.Legend;
import chartjs.options.Title;
import chartjs.options.Tooltips;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Chart {

    private List<Object> labels;
    private List<Dataset> datasets = new ArrayList<>();
    private Options options = new Options();
    private Type type;

    protected Chart(Type type) {
        this.type = type;
        withLedgend(l -> l.setPosition(Legend.Position.bottom));
    }

    public Chart(Type type, String title) {
        this(type);
        withTitle(t -> t.withText(title)
                .withDisplay(true)
                .withFontSize(18)
                .withFontColor("#000000")
        );
        withLedgend(l -> l.labels().option("fontColor","#000000"));
        withLedgend(l -> l.labels().option("color","#000000"));
        withXAxes(0, axes -> axes.withTicks(ticks -> ticks.setMin(0)).tickFontColor("#000000"));
        withYAxes(0, axes -> axes.withTicks(ticks -> ticks.setMin(0)).tickFontColor("#000000"));
    }


    public Chart addSeries(String label, List<? extends ReportSeries> data, Color background, Color border) {
        return addSeries(type, label, data, new Color[] { background }, new Color[] {border});
    }

    public Chart addSeries(String label, List<? extends ReportSeries> data, Color[] background, Color[] border) {
        return addSeries(type, label, data, background, border);
    }

    public Chart addSeries(String label, List<? extends ReportSeries> data, Color[] background, Color border) {
        return addSeries(type, label, data, background, border);
    }

    public Chart addSeries(Type type, String label, List<? extends ReportSeries> data, Color background, Color border) {
        return addSeries(xAxis(0), type, label, data, new Color[] { background }, new Color[] { border });
    }

    public Chart addSeries(Type type, String label, List<? extends ReportSeries> data, Color[] background, Color[] border) {
        return addSeries(xAxis(0), type, label, data, background, border);
    }

    public Chart addSeries(Type type, String label, List<? extends ReportSeries> data, Color[] background, Color border) {
        return addSeries(xAxis(0), type, label, data, background, new Color[] { border });
    }

    public Chart addSeries(AxesConfiguration axis, Type type, String label, List<? extends ReportSeries> data, Color background, Color border) {
        return addSeries(axis, type, label, data, new Color[] { background }, new Color[] { border });
    }
    public Chart addSeries(AxesConfiguration axis, Type type, String label, List<? extends ReportSeries> data, Color[] background, Color[] border) {
        setLabels(element -> element.getLabel(), data);
        List<Double> values = data.stream().map(d -> d.getValue()).collect(Collectors.toList());
        Dataset dataset = new MixedDataset(axis, type, label, background, border, values);
        addDataset(dataset);
        return this;
    }

    public Chart withSeries(String name, Consumer<Dataset> consumer) {
        Optional<Dataset> found = datasets.stream().filter(d -> name.equals(d.name())).findFirst();
        if (!found.isPresent()) {
            throw new RuntimeException("Series name '"+ name +"' not defined.");
        }
        consumer.accept(found.get());
        return this;
    }
    public Chart withSeries(int index, Consumer<Dataset> consumer) {
        consumer.accept(datasets.get(index));
        return this;
    }

    public AxesConfiguration xAxis(int index) {
        return this.options.xAxis(index);
    }

    public AxesConfiguration yAxis(int index) {
        return this.options.yAxis(index);
    }


    protected void setLabels(Function<ReportSeries, Object> getLabel, List<? extends ReportSeries> data) {
        labels = data.stream().map(getLabel).collect(Collectors.toList());
    }

    protected void addDataset(Dataset data) {
        this.datasets.add(data);
    }

    public Map<String, Object> pack() {
        Map<String, Object> map = new HashMap<>();
        map.put("type", type().getName());
        map.put("data", data().pack());
        map.put("options", options().pack());
        return map;
    }

    public Chart setOption(Option option) {
        this.options.add(option);
        return this;
    }

    public Chart responsive(Boolean value) {
        return setOption(new Option("responsive", value));
    }

    public AxesConfiguration addXAxis() {
        return this.options.addXAxis();
    }
    public AxesConfiguration addYAxis() {
        return this.options.addYAxis();
    }


    public Chart withXAxes(int index, Consumer<AxesConfiguration> consumer) {
        this.options.withXAxis(index, consumer);
        return this;
    }

    public Chart withYAxes(int index, Consumer<AxesConfiguration> consumer) {
        this.options.withYAxis(index, consumer);
        return this;
    }

    public Chart withTooltips(Consumer<Tooltips> consumer) {
        this.options.withTooltips(consumer);
        return this;
    }

    public Chart withLedgend(Consumer<Legend> consumer) {
        consumer.accept(this.options.ledgend);
        return this;
    }

    public Chart withTitle(Consumer<Title> consumer) {
        consumer.accept(this.options.title);
        return this;
    }

    public Data data() {
        return new Data(labels, datasets);
    }
    public Options options() { return options; }

    public Type type() { return this.type; }
}
