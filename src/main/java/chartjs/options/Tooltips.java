package chartjs.options;

import chartjs.base.Option;
import chartjs.base.Axis;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://www.chartjs.org/docs/latest/configuration/scales.html#configuration-options
  */
public class Tooltips {

    private final Set<Option<Object>> data= new HashSet<>();

    public enum Mode {
        dataset,
        index,
        x,
        y;
    };

    public Tooltips() {
    }

    public Tooltips set(Option option) {
        if (data.contains(option)) {
            data.remove(option);
        }
        data.add(option);
        return this;
    }

    public Tooltips setAxis(Axis axis) {
        return set(new Option("axis", axis.name().toLowerCase()));
    }

    public Tooltips setMode(Mode mode) {
        return set(new Option("mode", mode.name()));
    }

    public Object pack() {
        Map<String, Object> packed = data.stream().collect(Collectors.toMap(k -> k.name, v -> v.value));
        return packed;
    }

}
