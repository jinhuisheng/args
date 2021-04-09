package args;


public class Definition {
    private final String flag;
    private final String type;
    private final Object defaultValue;

    public Definition(String flag, String type, Object defaultValue) {
        this.flag = flag;
        this.type = type;
        this.defaultValue = defaultValue;
    }

    public String getFlag() {
        return this.flag;
    }

    public Object getValue(String valueStr) {
        if (valueStr == null) {
            return this.defaultValue;
        }
        if (type.equals("int")) {
            return Integer.parseInt(valueStr);
        } else {
            return valueStr;
        }
    }

    public boolean isBoolean() {
        return type.equals("boolean");
    }
}
