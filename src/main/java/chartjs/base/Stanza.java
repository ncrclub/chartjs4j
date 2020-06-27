package chartjs.base;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Stanza<T> {

    private final Set<Option<Object>> data= new HashSet<>();

    private T instance;

    public Stanza() {
        this.instance = (T)this;
    }



    public T option(String key, Object value) {
        set(new Option(key, value));
        return instance;
    }

    protected void set(Option option) {
        if (this.data.contains(option)) {
            this.data.remove(option);
        }
        this.data.add(option);
    }

    public Object pack() {
        return data.stream().collect(Collectors.toMap(k -> k.name, v -> v.value));
    }
}
