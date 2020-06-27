package chartjs.options;

import chartjs.base.Option;
import chartjs.base.Stanza;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://www.chartjs.org/docs/latest/configuration/title.html#title-configuration
  */
public class Title extends Stanza<Title> {

    public enum Position { top, bottom, left, right }

    public Title withText(String title) {
        return option("text", title);
    }

    public Title withText(String ... title) {
        return option("text", title);
    }

    public Title withPosition(Position value) {
        set(new Option("position", value) {
            @Override
            public Object pack() {
                return this.value.toString();
            }
        });
        return this;
    }

    public Title withPadding(int value) {
        set(new Option("padding", value));
        return this;
    }

    public Title withFontSize(int value) {
        set(new Option("fontSize", value));
        return this;
    }

    public Title withFontFamily(String value) {
        set(new Option("fontSize", value));
        return this;
    }

    public Title withFontColor(String value) {
        set(new Option("fontColor", value));
        return this;
    }

    public Title withLineHieght(String value) {
        set(new Option("lineHeight", value));
        return this;
    }

    public Title withLineHieght(float value) {
        set(new Option("lineHeight", value));
        return this;
    }

    public Title withBoldFont() {
        set(new Option("fontStyle", "bold"));
        return this;
    }

    public Title withDisplay(boolean value) {
        return option("display", value);
    }

    public Title withFullWidth(boolean value) {
        return option("fullWidth", value);
    }

    public Title withReverse(boolean value) {
        return option("reverse", value);
    }

}
