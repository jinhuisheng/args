package args;

public class BooleanDefinition extends Definition {
    public BooleanDefinition(String flag, Object defaultValue) {
        super(flag, defaultValue);
    }

    @Override
    public Object convert(String valueStr) {
        return defaultValue;

    }

    @Override
    public boolean isBoolean() {
        return true;
    }
}
