package args;

public class Arg {
    private final String flag;
    private final String valueStr;

    public Arg(String flag, String valueStr) {

        this.flag = flag;
        this.valueStr = valueStr;
    }

    public String getFlag() {
        return flag;
    }

    public String getValueStr() {
        return valueStr;
    }
}
