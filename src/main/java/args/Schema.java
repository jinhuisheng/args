package args;

import java.util.List;
import java.util.stream.Collectors;

public class Schema {

    private final List<Definition> definitions;

    public Schema(List<Definition> definitions) {
        this.definitions = definitions;
    }

    public Object getValue(Arg arg) {
        Definition definition = getDefinition(arg.getFlag());
        return definition.convert(arg.getValueStr());
    }

    private Definition getDefinition(String flag) {
        return definitions.stream()
                .filter(definition -> definition.getFlag().equals(flag))
                .findFirst().get();
    }

    List<ParsedArg> parseArgs(List<Arg> args) {
        return args.stream().map(this::parseArg).collect(Collectors.toList());
    }

    private ParsedArg parseArg(Arg arg) {
        Object value = getValue(arg);
        return new ParsedArg(arg.getFlag(), value);
    }

    private List<ParsedArg> getBooleanDefaultParsedArgs() {
        return definitions.stream().filter(Definition::isBoolean)
                .map(definition -> new ParsedArg(definition.getFlag(), false))
                .collect(Collectors.toList());
    }

    ParseResult parse(List<Arg> args) {
        List<ParsedArg> parsedArgs = parseArgs(args);
        ParseResult parseResult = new ParseResult(parsedArgs);
        parseResult.addBooleanDefaultParsedArgs(getBooleanDefaultParsedArgs());
        return parseResult;
    }

}
