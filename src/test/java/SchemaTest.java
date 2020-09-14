import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author huisheng.jin
 * @date 2020/9/13.
 */
class SchemaTest {

    private Schema schema;

    @BeforeEach
    void setUp() {
        schema = ArgsDataBuilder.givenSchema();
    }

    @Test
    void should_parse_boolean_arg_with_value() {
        ParsedArg parsedArg = schema.parse(new Arg("l", "false"));
        assertThat(parsedArg.getFlag()).isEqualTo("l");
        assertThat(parsedArg.getValue()).isEqualTo(false);
        assertThat(parsedArg.getType()).isEqualTo("boolean");
    }

    @Test
    void should_parse_integer_arg_with_value() {
        ParsedArg parsedArg = schema.parse(new Arg("p", "8080"));
        assertThat(parsedArg.getFlag()).isEqualTo("p");
        assertThat(parsedArg.getValue()).isEqualTo(8080);
        assertThat(parsedArg.getType()).isEqualTo("integer");
    }

    @Test
    void should_parse_string_arg_with_value() {
        ParsedArg parsedArg = schema.parse(new Arg("d", "/usr/logs"));
        assertThat(parsedArg.getFlag()).isEqualTo("d");
        assertThat(parsedArg.getValue()).isEqualTo("/usr/logs");
        assertThat(parsedArg.getType()).isEqualTo("string");
    }

    @Test
    void should_parse_boolean_arg_without_value() {
        ParsedArg parsedArg = schema.parse(new Arg("l", ""));
        assertThat(parsedArg.getFlag()).isEqualTo("l");
        assertThat(parsedArg.getValue()).isEqualTo(true);
        assertThat(parsedArg.getType()).isEqualTo("boolean");
    }

    @Test
    void should_parse_integer_arg_without_value() {
        ParsedArg parsedArg = schema.parse(new Arg("p", ""));
        assertThat(parsedArg.getFlag()).isEqualTo("p");
        assertThat(parsedArg.getValue()).isEqualTo(0);
        assertThat(parsedArg.getType()).isEqualTo("integer");
    }

    @Test
    void should_parse_string_arg_without_value() {
        ParsedArg parsedArg = schema.parse(new Arg("d", ""));
        assertThat(parsedArg.getFlag()).isEqualTo("d");
        assertThat(parsedArg.getValue()).isEqualTo("");
        assertThat(parsedArg.getType()).isEqualTo("string");
    }

    @Test
    void should_parse_stringArray_arg_with_value() {
        ParsedArg parsedArg = schema.parse(new Arg("g", "this,is,a,list"));
        assertThat(parsedArg.getFlag()).isEqualTo("g");
        assertThat(parsedArg.getValue()).isEqualTo(Arrays.asList("this", "is", "a", "list"));
        assertThat(parsedArg.getType()).isEqualTo("stringArray");
    }

    @Test
    void should_parse_stringArray_arg_without_value() {
        ParsedArg parsedArg = schema.parse(new Arg("g", ""));
        assertThat(parsedArg.getFlag()).isEqualTo("g");
        assertThat(parsedArg.getValue()).isEqualTo(new ArrayList<String>());
        assertThat(parsedArg.getType()).isEqualTo("stringArray");
    }

    @Test
    void should_parse_integerArray_arg_with_value() {
        ParsedArg parsedArg = schema.parse(new Arg("h", "1,2,-3,5"));
        assertThat(parsedArg.getFlag()).isEqualTo("h");
        assertThat(parsedArg.getValue()).isEqualTo(Arrays.asList(1, 2, -3, 5));
        assertThat(parsedArg.getType()).isEqualTo("integerArray");
    }

}