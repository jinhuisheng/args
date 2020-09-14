/**
 * @author huisheng.jin
 * @date 2020/9/14.
 */
public class BooleanSchemaArg extends SchemaArg {
    public BooleanSchemaArg(String flag, Object value) {
        super(flag, "boolean", value);
    }

    @Override
    protected Object convertValue(String value) {
        return Boolean.parseBoolean(value);
    }

}
