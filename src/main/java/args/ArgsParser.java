package args;

import java.util.ArrayList;

public class ArgsParser {

    private final Schema schema;

    public ArgsParser(Schema schema) {
        this.schema = schema;
    }

    public ParseResult parse(String args) {
        ArrayList<ParsedArg> parsedArgs = new ArrayList<>();
        String flag = args.substring(1);
        boolean value = getValue(flag);
        parsedArgs.add(new ParsedArg(flag, value));
//        -flag value -flag value
        return new ParseResult(parsedArgs);
    }

    private boolean getValue(String flag) {
        return schema.getValue(flag);
    }
}
