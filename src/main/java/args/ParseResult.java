package args;

import java.util.ArrayList;
import java.util.List;

public class ParseResult {

    private final List<ParsedArg> parsedArgs;

    public ParseResult(List<ParsedArg> parsedArgs) {
        this.parsedArgs = parsedArgs;
    }

    public Object valueOf(String flag) {
        return parsedArgs.stream().filter(parsedArg -> parsedArg.getFlag().equals(flag))
                .map(ParsedArg::getValue).findFirst().get();
    }
}
