package charts;

import chartjs.base.Option;
import chartjs.base.Options;
import chartjs.options.Title;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ChartOptionsTests {


    @Test
    public void testOption() {
        Option<String> option = new Option<>("name", "value");
        Assert.assertEquals("option.name == 'name'", "name", option.name);
        Assert.assertEquals("option.name == 'value'", "value", option.value);
    }

    @Test
    public void testScalesOptions() {
        Options options = new Options();
        options.withXAxis(0, x -> x.withTicks(t -> t.setMin(0).setBeginAtZero(true)));
        Option<String> option = new Option<>("name", "value");
        Assert.assertEquals("option.name == 'name'", "name", option.name);
        Assert.assertEquals("option.name == 'value'", "value", option.value);
    }

    @Test
    public void testPackOption() {
        Option<String> option = new Option<>("name", "value");
        String value = (String)option.pack();
        Assert.assertEquals("option.pack() == 'value'", "value", value);
    }

    @Test
    public void testPackOptions() {
        Options options = new Options();
        Map<String, Object> map = options.pack();
        // Assert.assertEquals(new HashMap<String, Object>(), ((Map<String, Object>)map.get("legend")));
        Assert.assertEquals(new HashMap<String, Object>(), ((Map<String, Object>)map.get("title")));

    }

    @Test
    public void testPackedLegendDisplay() {
        Options options = new Options();
        options.ledgend.setDisplay(true);
        Map<String, Object> map = options.pack();
        Assert.assertEquals(true, ((Map<String, Object>)map.get("legend")).get("display"));
    }

    @Test
    public void testPackedTitlePosition() {
        Options options = new Options();
        options.title.withDisplay(true);
        options.title.withPosition(Title.Position.left);
        Map<String, Object> map = options.pack();
        Assert.assertEquals(true, ((Map<String, Object>)map.get("title")).get("display"));
        Assert.assertEquals(Title.Position.left, ((Map<String, Object>)map.get("title")).get("position"));
    }


}
