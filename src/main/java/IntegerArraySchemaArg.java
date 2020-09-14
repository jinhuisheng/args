import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author huisheng.jin
 * @date 2020/9/14.
 */
public class IntegerArraySchemaArg extends SchemaArg {
    public IntegerArraySchemaArg(String flag, ArrayList<Integer> value) {
        super(flag, "integerArray", value);
    }

    @Override
    protected Object convertValue(String value) {
        return Arrays.stream(value.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
