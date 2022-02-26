package chartjs.base;

public enum Type {
    line("line")
    , bar("bar")
    , horizontalBar("horizontalBar")
    , radar("radar")
    , doughnut("doughnut")
    , pie("pie")
    , polarArea("polarArea")
    , bubble("bubble")
    , scatter("scatter")
    ;

    private final String type;

    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return type;
    }
}
