/**
 * @author huisheng.jin
 * @date 2020/9/13.
 */
public class Arg {
    private String flag;
    private String value;

    public Arg(String flag, String value) {
        this.flag = flag;
        this.value = value;
    }

    public String getFlag() {
        return flag;
    }

    public String getValue() {
        return value;
    }
}
