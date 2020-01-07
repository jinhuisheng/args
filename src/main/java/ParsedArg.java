/**
 * @author huisheng.jin
 * @date 2020/1/7.
 */
public class ParsedArg {
    private String flag;
    private Object value;
    private String type;

    ParsedArg(String flag, String type, Object value) {

        this.flag = flag;
        this.type = type;
        this.value = value;
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
