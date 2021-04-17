package args;

public class IntegerDefinition extends Definition {
    public IntegerDefinition(String flag, Object defaultValue) {
        super(flag, defaultValue);
    }

    @Override
    public Object convert(String valueStr) {
        if (valueStr == null) {
            return this.defaultValue;
        }
        return Integer.parseInt(valueStr);
    }
}
