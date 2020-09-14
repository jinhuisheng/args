import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author huisheng.jin
 * @date 2020/9/14.
 */
public class StringArraySchemaArg extends SchemaArg {
    public StringArraySchemaArg(String flag, ArrayList<String> value) {
        super(flag, "stringArray", value);
    }

    @Override
    protected Object convertValue(String value) {
        return Arrays.asList(value.split(","));
    }
}
