package args;

import java.util.ArrayList;
import java.util.List;

public class StringParser {
    public StringParser() {
    }

    List<ParsingArg> parseArgsStr(String args) {
        String[] array = args.split(" ");
        List<ParsingArg> parsingArgs = new ArrayList<ParsingArg>();
        String flag = array[0].substring(1);
        String valueStr = array.length > 1 ? array[1] : null;
        parsingArgs.add(new ParsingArg(flag, valueStr));
        return parsingArgs;
    }
}
