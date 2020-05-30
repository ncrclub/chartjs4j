package chartjs.base;

public class Option<T> {

    public final String name;
    public final T value;

    public Option(String name, T value) {
        this.name = name;
        this.value = value;
    }

    public Object pack() {
        return value;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (! (obj instanceof Option)) { return false; }
        return name.equals(((Option)obj).name);
    }
}

