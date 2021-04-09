package args;

public class ParsingArg {
    private final String flag;
    private final String valueStr;

    public ParsingArg(String flag, String valueStr) {

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
