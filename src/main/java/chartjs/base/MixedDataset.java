package chartjs.base;

import chartjs.options.AxesConfiguration;

import java.util.List;

public class MixedDataset<Object> extends Dataset {

    public MixedDataset(AxesConfiguration axis, Type type, String label, Color[] background, Color[] border, List<Object> data) {
        super(label, background, border, data);
        setType(type).setAxis(axis);
    }

    public MixedDataset setType(Type value) {
        if (value != null) {
            set("type", value);
        }
        return this;
    }


    public MixedDataset setAxis(AxesConfiguration axis) {
        if (axis != null) {
            super.set(axis.key, axis.id);
        }
        return this;
    }

}
