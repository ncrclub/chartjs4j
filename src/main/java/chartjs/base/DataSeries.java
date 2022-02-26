package chartjs.base;

import java.util.List;

public class DataSeries {

    public final String label;
    public final List<ReportSeries> data;

    public DataSeries(String label, List<ReportSeries> data) {
        this.label = label;
        this.data = data;
    }
}
