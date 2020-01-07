
/**
 * @author huisheng.jin
 * @date 2020/1/7.
 */
public class StringSchemaArg extends SchemaArg {
    public StringSchemaArg(String flag) {
        super(flag, "string", "");
    }

    @Override
    public Object convert(String value) {
        return value;
    }
}
