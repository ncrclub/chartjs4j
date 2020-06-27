package chartjs.options.axes;

import chartjs.base.Stanza;

/**
 * https://www.chartjs.org/docs/latest/configuration/legend.html#configuration-options
  */
public class TickConfiguration extends Stanza<TickConfiguration> {

    public TickConfiguration() {
    }

    public TickConfiguration hidden() {
        return setDisplay(false);
    }
    public TickConfiguration mirror() {
        return setMirror(true);
    }
    public TickConfiguration setMirror(boolean value) {
        return option("mirror", value);
    }

    public TickConfiguration setDisplay(boolean value) {
        return option("display", value);
    }

    public TickConfiguration setMin(int value) {
        return option("suggestedMin", value);
    }
    public TickConfiguration setMax(int value) {
        return option("max", value);
    }

    public TickConfiguration setBeginAtZero(boolean value) {
        return option("beginAtZero", value);
    }


}
