import org.apache.commons.lang3.StringUtils;

/**
 * @author huisheng.jin
 * @date 2020/9/13.
 */
public abstract class SchemaArg {
    private final String flag;
    private final String type;
    private final Object value;

    SchemaArg(String flag, String type, Object value) {
        this.flag = flag;
        this.type = type;
        this.value = value;
    }

    public String getFlag() {
        return flag;
    }

    ParsedArg getParsedArg(String value) {
        return new ParsedArg(this.flag, convert(value), this.type);
    }

    protected Object convert(String value) {
        if (StringUtils.isNotBlank(value)) {
            return convertValue(value);
        } else {
            return this.value;
        }
    }

    protected abstract Object convertValue(String value);

}
