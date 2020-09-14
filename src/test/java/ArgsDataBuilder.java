import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author huisheng.jin
 * @date 2020/9/14.
 */
public class ArgsDataBuilder {

    public static Schema givenSchema() {
        return new Schema(Arrays.asList(
                new BooleanSchemaArg("l", true),
                new IntegerSchemaArg("p", 0),
                new StringSchemaArg("d", ""),
                new StringArraySchemaArg("g", new ArrayList<String>()),
                new IntegerArraySchemaArg("h", new ArrayList<Integer>())
        ));
    }

}
