import org.apache.commons.lang3.StringUtils;

/**
 * @author huisheng.jin
 * @date 2020/1/7.
 */
public abstract class SchemaArg {
    private final String flag;
    private final String type;
    final Object defaultValue;

    SchemaArg(String flag, String type, Object defaultValue) {
        this.flag = flag;
        this.type = type;
        this.defaultValue = defaultValue;
    }

    String getFlag() {
        return flag;
    }

    String getType() {
        return type;
    }

    Object convertValue(String value) {
        if (StringUtils.isBlank(value)) {
            return defaultValue;
        }
        return convert(value);
//        switch (type) {
//            case "boolean":
//                return Boolean.parseBoolean(value);
//            case "string":
//                return value;
//            case "integer":
//                return Integer.parseInt(value);
//            default:
//                return "";
//        }
    }

    public abstract Object convert(String value);
}
