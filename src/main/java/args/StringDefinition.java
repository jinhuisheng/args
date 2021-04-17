package args;

public class StringDefinition extends Definition {
    public StringDefinition(String flag, Object defaultValue) {
        super(flag, defaultValue);
    }

    @Override
    public Object convert(String valueStr) {
        if (valueStr == null) {
            return this.defaultValue;
        }
        return valueStr;
    }
}
