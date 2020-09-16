import java.util.ArrayList;
import java.util.List;

/**
 * @author huisheng.jin
 * @date 2020/9/13.
 */
public class Parser {
    private Schema schema;
    private ArgsSeparator argsSeparator;
    private List<ParsedArg> parsedArgList = new ArrayList<>();

    public Parser(Schema schema) {
        this.schema = schema;
        this.argsSeparator = new ArgsSeparator();
    }

    public void parse(String args) {
        List<Arg> argList = argsSeparator.separate(args);
        argList.forEach(this::parseArg);
    }

    private void parseArg(Arg arg) {
        ParsedArg parsedArg = schema.parse(arg);
        parsedArgList.add(parsedArg);
    }

    public ParsedArg getArg(String flag) {
        return parsedArgList.stream()
                .filter(item -> item.getFlag().equals(flag))
                .findFirst()
                .get();
    }
}
