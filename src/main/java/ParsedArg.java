/**
 * @author huisheng.jin
 * @date 2020/9/13.
 */
public class ParsedArg {
    private final String flag;
    private final Object value;
    private final String type;

    public ParsedArg(String flag, Object value, String type) {

        this.flag = flag;
        this.value = value;
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public String getFlag() {
        return flag;
    }

}
