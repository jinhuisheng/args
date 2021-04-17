package args;


public abstract class Definition {
    private final String flag;
    protected final Object defaultValue;

    protected Definition(String flag, Object defaultValue) {
        this.flag = flag;
        this.defaultValue = defaultValue;
    }

    public String getFlag() {
        return this.flag;
    }

    public abstract Object convert(String valueStr);

    public boolean isBoolean() {
        return false;
    }
}
