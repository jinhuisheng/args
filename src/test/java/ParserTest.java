import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author huisheng.jin
 * @date 2020/1/7.
 */
class ParserTest {
    @Test
    void should_parse_success() {
        String[] args = "-l -p 8080 -d /usr/logs".split(" ");

        SchemaArg schemaArg1 = new IntegerSchemaArg("p");
        SchemaArg schemaArg2 = new BooleanSchemaArg("l");
        SchemaArg schemaArg3 = new StringSchemaArg("d");
        Schema schema = new Schema(Arrays.asList(schemaArg1, schemaArg2, schemaArg3));

        Parser parser = new Parser(schema);
        parser.parse(args);

        ParsedArg parsedArg1 = parser.getArg("l");
        assertThat(parsedArg1.getValue()).isEqualTo(false);
        assertThat(parsedArg1.getType()).isEqualTo("boolean");

        ParsedArg parsedArg2 = parser.getArg("p");
        assertThat(parsedArg2.getValue()).isEqualTo(8080);
        assertThat(parsedArg2.getType()).isEqualTo("integer");

        ParsedArg parsedArg3 = parser.getArg("d");
        assertThat(parsedArg3.getValue()).isEqualTo("/usr/logs");
        assertThat(parsedArg3.getType()).isEqualTo("string");
    }

    @Test
    void should_parse_arg_array_success_with_one_arg() {
        String[] args = "-p 8080".split(" ");
        Parser parser = new Parser(null);
        List<ParsingArg> parsingArgs = parser.parseArgs(args);
        ParsingArg parsingArg = parsingArgs.get(0);
        assertThat(parsingArg.getFlag()).isEqualTo("p");
        assertThat(parsingArg.getValue()).isEqualTo("8080");
    }

    @Test
    void should_parse_arg_array_success_with_two_args() {
        String[] args = "-p 8080 -d /usr/logs".split(" ");
        Parser parser = new Parser(null);
        List<ParsingArg> parsingArgs = parser.parseArgs(args);
        ParsingArg parsingArg1 = parsingArgs.get(0);
        assertThat(parsingArg1.getFlag()).isEqualTo("p");
        assertThat(parsingArg1.getValue()).isEqualTo("8080");

        ParsingArg parsingArg2 = parsingArgs.get(1);
        assertThat(parsingArg2.getFlag()).isEqualTo("d");
        assertThat(parsingArg2.getValue()).isEqualTo("/usr/logs");
    }

    @Test
    void should_parse_arg_array_success_without_value_when_one_arg() {
        String[] args = "-l".split(" ");
        Parser parser = new Parser(null);
        List<ParsingArg> parsingArgs = parser.parseArgs(args);
        ParsingArg parsingArg1 = parsingArgs.get(0);
        assertThat(parsingArg1.getFlag()).isEqualTo("l");
        assertThat(parsingArg1.getValue()).isEqualTo("");
    }

    @Test
    void should_parse_arg_array_success_when_one_arg_no_value_and_one_arg_has_value() {
        String[] args = "-l -d /usr/logs".split(" ");
        Parser parser = new Parser(null);
        List<ParsingArg> parsingArgs = parser.parseArgs(args);
        ParsingArg parsingArg1 = parsingArgs.get(0);
        assertThat(parsingArg1.getFlag()).isEqualTo("l");
        assertThat(parsingArg1.getValue()).isEqualTo("");

        ParsingArg parsingArg2 = parsingArgs.get(1);
        assertThat(parsingArg2.getFlag()).isEqualTo("d");
        assertThat(parsingArg2.getValue()).isEqualTo("/usr/logs");
    }

    @Test
    void should_parse_arg_array_success_with_three_multiple_arg() {
        String[] args = "-l -p 8080 -d /usr/logs".split(" ");
        Parser parser = new Parser(null);
        List<ParsingArg> parsingArgs = parser.parseArgs(args);
        ParsingArg parsingArg1 = parsingArgs.get(0);
        assertThat(parsingArg1.getFlag()).isEqualTo("l");
        assertThat(parsingArg1.getValue()).isEqualTo("");

        ParsingArg parsingArg2 = parsingArgs.get(1);
        assertThat(parsingArg2.getFlag()).isEqualTo("p");
        assertThat(parsingArg2.getValue()).isEqualTo("8080");

        ParsingArg parsingArg3 = parsingArgs.get(2);
        assertThat(parsingArg3.getFlag()).isEqualTo("d");
        assertThat(parsingArg3.getValue()).isEqualTo("/usr/logs");

    }

}
