
/**
 * @author huisheng.jin
 * @date 2020/1/7.
 */
public class IntegerSchemaArg extends SchemaArg {
    public IntegerSchemaArg(String flag) {
        super(flag, "integer", 0);
    }

    @Override
    public Object convert(String value) {
        return Integer.parseInt(value);
    }
}
