/**
 * @author huisheng.jin
 * @date 2020/1/7.
 */
public class ParsingArg {
    private String flag;
    private String value;

    ParsingArg(String flag, String value) {

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
