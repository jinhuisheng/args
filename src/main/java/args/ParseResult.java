package args;

import java.util.List;
import java.util.stream.Collectors;

public class ParseResult {

    private final List<ParsedArg> parsedArgs;

    public ParseResult(List<ParsedArg> parsedArgs) {
        this.parsedArgs = parsedArgs;
    }

    public Object valueOf(String flag) {
        return parsedArgs.stream().filter(parsedArg -> parsedArg.getFlag().equals(flag))
                .map(ParsedArg::getValue).findFirst().get();
    }

    void addBooleanDefaultParsedArgs(List<ParsedArg> booleanParsedArgs) {
        if (booleanParsedArgs.isEmpty()) {
            return;
        }
        List<ParsedArg> booleanDefaultParsedArg = filter(booleanParsedArgs);
        parsedArgs.addAll(booleanDefaultParsedArg);
    }

    private List<ParsedArg> filter(List<ParsedArg> defaultParsedArgs) {
        return defaultParsedArgs.stream()
                .filter(parsedArg -> !isInParsedArgs(parsedArg.getFlag()))
                .collect(Collectors.toList());
    }

    boolean isInParsedArgs(String flag) {
        return parsedArgs.stream().anyMatch(parsedArg -> parsedArg.getFlag().equals(flag));
    }

}
