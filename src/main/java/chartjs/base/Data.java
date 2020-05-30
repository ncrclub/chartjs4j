package chartjs.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Data {
    public final List<Object> labels;
    public final List<Dataset> datasets;

    public Data(List<Object> labels, List<Dataset> datasets) {
        this.labels = labels;
        this.datasets = datasets;
    }

    public Map<String, Object> pack() {
        Map<String, Object> map = new HashMap<>();
        map.put("labels", labels);
        map.put("datasets", datasets.stream().map(d -> d.pack()).collect(Collectors.toList()));
        return map;
    }
}
