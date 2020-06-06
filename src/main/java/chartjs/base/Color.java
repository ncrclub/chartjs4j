package chartjs.base;

import java.io.Serializable;

public class Color implements Serializable {

    public static final Color PURPLE = new Color(102, 51, 153, 0.85f);
    public static final Color ORANGE = new Color(255, 140, 0, 0.85f);
    public static final Color RED = new Color(255, 0, 0);
    public static final Color MAROON = new Color(145, 18, 12, 0.85f);
    public static final Color GREEN = new Color(0, 255, 0);
    public static final Color MUTED_GREEN = new Color(0, 155, 0);
    public static final Color DARK_SILVER = new Color(71, 73, 74, 0.85f);
    public static final Color BLUE = new Color(0, 0, 255);
    public static final Color SOFT_BLUE = new Color(79, 143, 247);
    public static final Color BLACK = new Color(0, 0, 0);
    public static final Color WHITE = new Color(255, 255, 255);

    public static final Color BLUE_1 = new Color(255, 140, 35, 0.70f);
    public static final Color BLUE_2 = new Color(200, 100, 25, 0.70f);
    public static final Color BLUE_3 = new Color(155, 60, 35, 0.70f);

    public static final Color ORANGE_SPECTRUM[] = new Color[]{
            new Color(255, 140, 35, 0.70f),
            new Color(200, 100, 25, 0.70f),
            new Color(155, 60, 35, 0.70f)
    };


    private int red;
    private int green;
    private int blue;
    private double opacity;

    public Color(int red, int green, int blue) {
        this(red, green, blue, 1.0f);
    }
    public Color(int red, int green, int blue, float opacity) {
        this.red = min(max(0, red), 255);
        this.green = min(max(0, green), 255);
        this.blue = min(max(0, blue), 255);
        this.opacity = opacity;
    }

    public String toString() {
        return "rgba("+ red +","+ green +","+ blue +","+ opacity +")";
    }

    private int max(int a, int b) {
        return (a > b ? a : b);
    }

    private int min(int a, int b) {
        return (a < b ? a : b);
    }

    public Color plus(Color c) {
        return new Color(red + c.red, green + c.green, blue + c.blue);
    }

    public Color minus(Color c) {
        return new Color(red - c.red, green - c.green, blue - c.blue);
    }

    public static Color next() {
        return SOFT_BLUE;
    }
}
