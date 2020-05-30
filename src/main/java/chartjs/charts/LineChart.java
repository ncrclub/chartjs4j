package chartjs.charts;

import chartjs.Chart;
import chartjs.base.Type;

public class LineChart extends Chart {

    public LineChart(String title) {
        super(Type.line, title);
        this.withYAxes(0, axes -> axes.withTicks(ticks -> ticks.setMin(0)));
    }




}

