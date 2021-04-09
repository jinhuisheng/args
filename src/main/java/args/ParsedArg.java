package args;

public class ParsedArg {

    private final String flag;
    private final Object value;

    public ParsedArg(String flag, Object value) {
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
