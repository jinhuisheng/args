package args;

public class Definition {
    private final String flag;
    private final String type;
    private final boolean defaultValue;

    public Definition(String flag, String type, boolean defaultValue) {
        this.flag = flag;
        this.type = type;
        this.defaultValue = defaultValue;
    }

    public String  getFlag() {
        return this.flag;
    }

    public boolean getValue() {
        return this.defaultValue;
    }
}
