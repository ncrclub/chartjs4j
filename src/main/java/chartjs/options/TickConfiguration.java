package chartjs.options;

import chartjs.base.Option;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://www.chartjs.org/docs/latest/configuration/legend.html#configuration-options
  */
public class TickConfiguration {


    private final Set<Option<Object>> data= new HashSet<>();

    public TickConfiguration() {
    }

    public TickConfiguration hidden() {
        return setDisplay(false);
    }
    public TickConfiguration mirror() {
        return setMirror(true);
    }
    public TickConfiguration setMirror(boolean value) {
        set(new Option("mirror", value));
        return this;
    }

    public TickConfiguration setDisplay(boolean value) {
        set(new Option("display", value));
        return this;
    }

    public TickConfiguration setMin(int value) {
        set(new Option("suggestedMin", value));
        return this;
    }
    public TickConfiguration setMax(int value) {
        set(new Option("max", value));
        return this;
    }

    public TickConfiguration setBeginAtZero(boolean value) {
        set(new Option("beginAtZero", value));
        return this;
    }

    private void set(Option option) {
        if (this.data.contains(option)) {
            this.data.remove(option);
        }
        this.data.add(option);
    }


    public Object pack() {
        return data.stream().collect(Collectors.toMap(k -> k.name, v -> v.value));
    }
}
