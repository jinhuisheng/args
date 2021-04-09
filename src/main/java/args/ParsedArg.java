package args;

public class ParsedArg {

    private final String flag;
    private final boolean value;

    public ParsedArg(String flag, boolean value) {
        this.flag = flag;
        this.value = value;
    }

    public Object getFlag() {
        return this.flag;
    }

    public Object getValue() {
        return this.value;
    }

}
