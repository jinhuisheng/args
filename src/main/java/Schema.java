import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huisheng.jin
 * @date 2020/1/7.
 */
public class Schema {
    private List<SchemaArg> schemaArgList;

    public Schema(List<SchemaArg> schemaArgList) {
        this.schemaArgList = schemaArgList;
    }

    public List<ParsedArg> convert(List<ParsingArg> paringArgList) {
        return paringArgList.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    private ParsedArg convert(ParsingArg parsingArg) {
        SchemaArg schemaArg = getSchemaArg(parsingArg.getFlag());
        Object value = schemaArg.convertValue(parsingArg.getValue());
        return new ParsedArg(parsingArg.getFlag(), schemaArg.getType(), value);
    }

    private SchemaArg getSchemaArg(String flag) {
        return schemaArgList.stream()
                .filter(arg -> arg.getFlag().equals(flag))
                .findFirst()
                .orElseThrow(() -> new ParsingArgNotExistInSchemaException("输入参数与参数结构不匹配"));
    }
}
