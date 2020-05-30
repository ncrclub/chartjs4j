package chartjs.options;

import chartjs.base.Option;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://www.chartjs.org/docs/latest/configuration/legend.html#configuration-options
  */
public class Legend {

    public enum Position { top, bottom, left, right }

    private final Set<Option<Object>> data= new HashSet<>();

    public Legend() {
    }

    public Legend setPosition(Position value) {
        set(new Option("position", value) {
            @Override
            public Object pack() {
                return this.value.toString();
            }
        });
        return this;
    }

    public Legend hidden() {
        return setDisplay(false);
    }

    public Legend setDisplay(boolean value) {
        set(new Option("display", value));
        return this;
    }

    public Legend withFullWidth(boolean value) {
        set(new Option("fullWidth", value));
        return this;
    }

    public Legend withReverse(boolean value) {
        set(new Option("reverse", value));
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
