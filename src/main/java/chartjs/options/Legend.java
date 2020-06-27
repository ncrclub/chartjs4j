package chartjs.options;

import chartjs.base.Option;
import chartjs.base.Stanza;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://www.chartjs.org/docs/latest/configuration/legend.html#configuration-options
  */
public class Legend extends Stanza<Legend> {

    public enum Position { top, bottom, left, right }

    public Legend() {
    }

    public Legend setPosition(Position value) {
        super.set(new Option("position", value) {
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
        return option("display", value);
    }

    public Legend withFullWidth(boolean value) {
        return option("fullWidth", value);
    }

    public Legend withReverse(boolean value) {
        return option("reverse", value);
    }

}
