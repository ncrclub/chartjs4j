package chartjs.base;

import java.util.Random;

public class ColorWheel {

    private final Color[] colors;
    private int idx = 0;

    public ColorWheel(ColorWheel wheel) {
        this(wheel.colors);
    }

    public ColorWheel(Color ... colors) {
        this.colors = colors;
        reset();
    }

    public Color next() {
        return colors[(idx = (idx + 1) % colors.length)];
    }

    public void reset() {
        this.idx = colors.length - 1;
    }

    public Color spin() {
        idx = new Random(System.currentTimeMillis()).nextInt() % colors.length;
        return next();
    }
}
