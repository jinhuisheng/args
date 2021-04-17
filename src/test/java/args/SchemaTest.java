package args;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

class SchemaTest {

    @Test
    void should_parse_l_false() {
        List<Definition> definitions = new ArrayList<>();
        definitions.add(new IntegerDefinition("p",0));
        definitions.add(new BooleanDefinition("l", true));
        definitions.add(new BooleanDefinition("t", true));
        Schema schema = new Schema(definitions);
        Arg arg = new Arg("p", null);
        ParseResult parseResult  = schema.parse(Arrays.asList(arg));
        assertThat(parseResult.valueOf("p")).isEqualTo(0);
        assertThat(parseResult.valueOf("l")).isEqualTo(false);
        assertThat(parseResult.valueOf("t")).isEqualTo(false);
    }
}
