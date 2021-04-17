package args;

import java.util.List;

public class ArgsParser {

    private final Schema schema;
    private final ArgsSeparator argsSeparator;

    public ArgsParser(Schema schema) {
        this.schema = schema;
        this.argsSeparator = new ArgsSeparator();
    }

    public ParseResult parse(String argsString) {
        List<Arg> args = argsSeparator.of(argsString);
        return schema.parse(args);
    }

}
