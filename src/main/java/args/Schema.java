package args;

import java.util.List;
import java.util.stream.Collectors;

public class Schema {

    private final List<Definition> definitions;

    public Schema(List<Definition> definitions) {
        this.definitions = definitions;
    }

    public Object getValue(ParsingArg parsingArg) {
        Definition definition = getDefinition(parsingArg);
        return definition.getValue(parsingArg.getValueStr());
    }

    private Definition getDefinition(ParsingArg parsingArg) {
        return definitions.stream()
                .filter(definition -> definition.getFlag().equals(parsingArg.getFlag()))
                .findFirst().get();
    }

    private ParsedArg parseArg(ParsingArg parsingArg) {
        Object value = getValue(parsingArg);
        return new ParsedArg(parsingArg.getFlag(), value);
    }

    List<ParsedArg> parseArgs(List<ParsingArg> parsingArgs) {
        return parsingArgs.stream().map(this::parseArg).collect(Collectors.toList());
    }

    ParseResult parseResult(List<ParsingArg> parsingArgs) {
        List<ParsedArg> parsedArgs = parseArgs(parsingArgs);
        addBooleanFlags(parsedArgs);
        return new ParseResult(parsedArgs);
    }

    private void addBooleanFlags(List<ParsedArg> parsedArgs) {
        List<Definition> booleanFlags = getBooleanFlag();
        if (booleanFlags.isEmpty()) {
            return;
        }
        for (Definition booleanFlag : booleanFlags) {
            addBooleanFlag(parsedArgs, booleanFlag.getFlag());
        }
    }

    private void addBooleanFlag(List<ParsedArg> parsedArgs, String flag) {
        if (isInParsedArgs(flag, parsedArgs)) {
            return;
        }
        ParsedArg parsedArg = new ParsedArg(flag, false);
        parsedArgs.add(parsedArg);
    }

    private boolean isInParsedArgs(String flag, List<ParsedArg> parsedArgs) {
        return parsedArgs.stream().anyMatch(parsedArg -> parsedArg.getFlag().equals(flag));
    }

    private List<Definition> getBooleanFlag() {
        return definitions.stream().filter(Definition::isBoolean).collect(Collectors.toList());
    }
}
