/**
 * @author huisheng.jin
 * @date 2020/9/14.
 */
public class StringSchemaArg extends SchemaArg {
    public StringSchemaArg(String flag, Object value) {
        super(flag, "string", value);
    }

    @Override
    protected Object convertValue(String value) {
        return value;
    }
}
