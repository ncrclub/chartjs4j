package chartjs.charts;

import chartjs.Chart;
import chartjs.base.Type;

public class BarChart extends Chart {

    public BarChart(String title) {
        super(Type.bar, title);
        this.withYAxes(0, axes -> axes.withTicks(ticks -> ticks.setMin(0)));
    }

    @Override
    public Type type() {
        return Type.bar;
    }

}

