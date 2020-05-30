package chartjs;

import chartjs.base.Color;
import chartjs.base.MixedDataset;
import chartjs.base.ReportSeries;
import chartjs.base.Type;

import java.util.List;
import java.util.stream.Collectors;

public class MixedChart extends Chart {

    public MixedChart(Type type, String title) {
        super(type, title);
    }

    public Chart addSeries(Type type, String label, List<ReportSeries> data, Color[] background, Color border) {
        setLabels(d -> d.getLabel(), data);
        List<Double> values = data.stream().map(d -> d.getValue()).collect(Collectors.toList());
        addDataset(new MixedDataset(xAxis(0), type, label, background, border, values));
        return this;
    }
}
