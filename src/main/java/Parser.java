import java.util.ArrayList;
import java.util.List;

/**
 * @author huisheng.jin
 * @date 2020/1/7.
 */
public class Parser {

    private List<ParsedArg> parsedArgList;
    private Schema schema;

    public Parser(Schema schema) {

        this.schema = schema;
    }

    public void parse(String[] args) {
        List<ParsingArg> paringArgList = parseArgs(args);
        parsedArgList = schema.convert(paringArgList);
    }

    public List<ParsingArg> parseArgs(String[] args) {
        List<ParsingArg> parsingArgList = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            parseArg(args, parsingArgList, i);
        }
        return parsingArgList;
    }

    private void parseArg(String[] args, List<ParsingArg> parsingArgList, int i) {
        if (args[i].startsWith("-")) {
            if (hasNoValue(args, i)) {
                parsingArgList.add(new ParsingArg(args[i].substring(1), ""));
            } else {
                parsingArgList.add(new ParsingArg(args[i].substring(1), args[i + 1]));
            }
        }
    }

    private boolean hasNoValue(String[] args, int i) {
        return i + 1 >= args.length || args[i + 1].startsWith("-");
    }

    public ParsedArg getArg(String flag) {
        return parsedArgList.stream().filter(arg -> arg.getFlag().equals(flag)).findFirst().get();
    }
}
