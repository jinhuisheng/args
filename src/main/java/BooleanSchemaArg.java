/**
 * @author huisheng.jin
 * @date 2020/1/7.
 */
public class BooleanSchemaArg extends SchemaArg {
    public BooleanSchemaArg(String flag) {
        super(flag, "boolean", false);
    }

    @Override
    public Object convert(String value) {
        return Boolean.parseBoolean(value);
    }
}
