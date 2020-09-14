/**
 * @author huisheng.jin
 * @date 2020/9/14.
 */
public class IntegerSchemaArg extends SchemaArg {
    public IntegerSchemaArg(String flag, Object value) {
        super(flag, "integer", value);
    }

    @Override
    protected Object convertValue(String value) {
        return Integer.parseInt(value);
    }
}
