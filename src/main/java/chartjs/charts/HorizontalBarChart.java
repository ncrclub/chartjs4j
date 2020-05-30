package chartjs.charts;

import chartjs.Chart;
import chartjs.base.Type;

public class HorizontalBarChart extends Chart {

    public HorizontalBarChart(String title) {
        super(Type.horizontalBar, title);
        this.withXAxes(0, axes -> axes.withTicks(ticks -> ticks.setMin(0)));
    }

}

