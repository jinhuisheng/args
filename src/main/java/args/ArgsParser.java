package args;

import java.util.List;

public class ArgsParser {

    private final Schema schema;

    public ArgsParser(Schema schema) {
        this.schema = schema;
    }

    public ParseResult parse(String args) {
        List<ParsingArg> parsingArgs = new StringParser().parseArgsStr(args);
        return schema.parseResult(parsingArgs);
    }

}
