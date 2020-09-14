import java.util.List;

/**
 * @author huisheng.jin
 * @date 2020/9/13.
 */
public class Schema {
    private List<SchemaArg> schemaArgList;

    public Schema(List<SchemaArg> schemaArgList) {
        this.schemaArgList = schemaArgList;
    }

    public ParsedArg parse(Arg arg) {
        SchemaArg schemaArg = getSchemaArg(arg.getFlag());
        return schemaArg.getParsedArg(arg.getValue());
    }

    private SchemaArg getSchemaArg(String flag) {
        return schemaArgList.stream()
                .filter(item -> item.getFlag().equals(flag))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("参数与参数结构不匹配"));
    }
}
