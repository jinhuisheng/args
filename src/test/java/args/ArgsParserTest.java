package args;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ArgsParserTest {
    @Test
    void should_parse_arg_l_true_success() {
        List<Definition> definitions = new ArrayList<>();
        definitions.add(new BooleanDefinition("l", true));
        ArgsParser parser = new ArgsParser(new Schema(definitions));
        ParseResult result = parser.parse("-l");
        assertThat(result.valueOf("l")).isEqualTo(true);
    }

    @Test
    void should_parse_arg_p_success() {
        List<Definition> definitions = new ArrayList<>();
        definitions.add(new IntegerDefinition("p", 0));
        definitions.add(new BooleanDefinition("l", true));
        ArgsParser parser = new ArgsParser(new Schema(definitions));
        ParseResult result = parser.parse("-p");
        assertThat(result.valueOf("p")).isEqualTo(0);
        assertThat(result.valueOf("l")).isEqualTo(false);
    }

    @Test
    void should_parse_arg_p_with_value_success() {
        List<Definition> definitions = new ArrayList<>();
        definitions.add(new IntegerDefinition("p", 0));
        ArgsParser parser = new ArgsParser(new Schema(definitions));
        ParseResult result = parser.parse("-p 8080");
        assertThat(result.valueOf("p")).isEqualTo(8080);
    }

    @Test
    void should_parse_arg_d_with_value_success() {
        List<Definition> definitions = new ArrayList<>();
        definitions.add(new StringDefinition("d",""));
        ArgsParser parser = new ArgsParser(new Schema(definitions));
        ParseResult result = parser.parse("-d /usr/logs");
        assertThat(result.valueOf("d")).isEqualTo("/usr/logs");
    }

    @Test
    void should_parse_arg_d_without_value_success() {
        List<Definition> definitions = new ArrayList<>();
        definitions.add(new StringDefinition("d",""));
        ArgsParser parser = new ArgsParser(new Schema(definitions));
        ParseResult result = parser.parse("-d");
        assertThat(result.valueOf("d")).isEqualTo("");
    }


}
