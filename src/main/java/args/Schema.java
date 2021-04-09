package args;

import java.util.ArrayList;
import java.util.List;

public class Schema {

    private final List<Definition> definitions;

    public Schema(List<Definition> definitions) {
        this.definitions = definitions;
    }

    public boolean getValue(String flag) {
        return definitions.stream().filter(definition -> definition.getFlag().equals(flag))
                .findFirst().map(Definition::getValue).get();
    }
}
