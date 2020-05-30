package chartjs.options;

import chartjs.base.Option;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://www.chartjs.org/docs/latest/configuration/title.html#title-configuration
  */
public class Title {

    public enum Position { top, bottom, left, right }

    private final Set<Option<Object>> data= new HashSet<>();

    public Title withText(String title) {
        return set(new Option("text", title));
    }

    public Title withText(String ... title) {
        return set(new Option("text", title));
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

    public Title withNormalFont() {
        this.data.removeIf(o -> o.name.equals("fontStyle"));
        return this;
    }

    public Title withDisplay(boolean value) {
        return set(new Option("display", value));
    }

    public Title withFullWidth(boolean value) {
        return set(new Option("fullWidth", value));
    }

    public Title withReverse(boolean value) {
        return set(new Option("reverse", value));
    }

    private Title set(Option option) {
        if (this.data.contains(option)) {
            this.data.remove(option);
        }
        this.data.add(option);
        return this;
    }


    public Object pack() {
        return data.stream().collect(Collectors.toMap(k -> k.name, v -> v.pack()));
    }
}
