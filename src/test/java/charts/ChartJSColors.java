package charts;

import chartjs.base.Color;
import org.junit.Assert;
import org.junit.Test;

public class ChartJSColors {

    @Test
    public void testMax() {
        Color c = new Color(300, 50, 50);
        Assert.assertEquals("rgba(255,50,50,1.0)", c.toString());
    }

    @Test
    public void testMin() {
        Color c = new Color(-20, 100, 100);
        Assert.assertEquals("rgba(0,100,100,1.0)", c.toString());
    }

}
