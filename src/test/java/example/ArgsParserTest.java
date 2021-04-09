package example;

import args.ArgsParser;
import args.Definition;
import args.ParseResult;
import args.Schema;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ArgsParserTest {
    @Test
    void should_parse_success() {
        List<Definition> definitions = new ArrayList<>();
        definitions.add(new Definition("l", "boolean", true));
        ArgsParser parser = new ArgsParser(new Schema(definitions));
        ParseResult result = parser.parse("-l");
        assertThat(result.valueOf("l")).isEqualTo(true);
    }
}
