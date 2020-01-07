import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author huisheng.jin
 * @date 2020/1/7.
 */
class SchemaTest {

    @Test
    void should_convert_integer_arg_success() {
        SchemaArg schemaArg = new IntegerSchemaArg("l");
        Schema schema = new Schema(Collections.singletonList(schemaArg));
        List<ParsingArg> parsingArgList = Collections.singletonList(new ParsingArg("l", "8080"));
        List<ParsedArg> parsedArgList = schema.convert(parsingArgList);
        ParsedArg parsedArg = parsedArgList.get(0);
        assertThat(parsedArg.getType()).isEqualTo("integer");
        assertThat(parsedArg.getValue()).isEqualTo(8080);
    }

    @Test
    void should_convert_integer_arg_without_value_success() {
        SchemaArg schemaArg = new IntegerSchemaArg("l");
        Schema schema = new Schema(Collections.singletonList(schemaArg));
        List<ParsingArg> parsingArgList = Collections.singletonList(new ParsingArg("l", ""));
        List<ParsedArg> parsedArgList = schema.convert(parsingArgList);
        ParsedArg parsedArg = parsedArgList.get(0);
        assertThat(parsedArg.getType()).isEqualTo("integer");
        assertThat(parsedArg.getValue()).isEqualTo(0);
    }

    @Test
    void should_convert_boolean_arg_success() {
        SchemaArg schemaArg = new BooleanSchemaArg("l");
        Schema schema = new Schema(Collections.singletonList(schemaArg));
        List<ParsingArg> parsingArgList = Collections.singletonList(new ParsingArg("l", "true"));
        List<ParsedArg> parsedArgList = schema.convert(parsingArgList);
        ParsedArg parsedArg = parsedArgList.get(0);
        assertThat(parsedArg.getType()).isEqualTo("boolean");
        assertThat(parsedArg.getValue()).isEqualTo(true);
    }

    @Test
    void should_convert_boolean_arg_without_value_success() {
        SchemaArg schemaArg = new BooleanSchemaArg("l");
        Schema schema = new Schema(Collections.singletonList(schemaArg));
        List<ParsingArg> parsingArgList = Collections.singletonList(new ParsingArg("l", ""));
        List<ParsedArg> parsedArgList = schema.convert(parsingArgList);
        ParsedArg parsedArg = parsedArgList.get(0);
        assertThat(parsedArg.getType()).isEqualTo("boolean");
        assertThat(parsedArg.getValue()).isEqualTo(false);
    }

    @Test
    void should_convert_string_arg_success() {
        SchemaArg schemaArg = new StringSchemaArg("d");
        Schema schema = new Schema(Collections.singletonList(schemaArg));
        List<ParsingArg> parsingArgList = Collections.singletonList(new ParsingArg("d", "/usr/logs"));
        List<ParsedArg> parsedArgList = schema.convert(parsingArgList);
        ParsedArg parsedArg = parsedArgList.get(0);
        assertThat(parsedArg.getType()).isEqualTo("string");
        assertThat(parsedArg.getValue()).isEqualTo("/usr/logs");
    }

    @Test
    void should_convert_string_arg_without_value_success() {
        SchemaArg schemaArg = new StringSchemaArg("d");
        Schema schema = new Schema(Collections.singletonList(schemaArg));
        List<ParsingArg> parsingArgList = Collections.singletonList(new ParsingArg("d", ""));
        List<ParsedArg> parsedArgList = schema.convert(parsingArgList);
        ParsedArg parsedArg = parsedArgList.get(0);
        assertThat(parsedArg.getType()).isEqualTo("string");
        assertThat(parsedArg.getValue()).isEqualTo("");
    }

    @Test
    void should_convert_multiple_arg_success() {
        SchemaArg schemaArg1 = new IntegerSchemaArg("p");
        SchemaArg schemaArg2 = new BooleanSchemaArg("l");
        SchemaArg schemaArg3 = new StringSchemaArg("d");
        Schema schema = new Schema(Arrays.asList(schemaArg1, schemaArg2, schemaArg3));

        List<ParsingArg> parsingArgList = Arrays.asList(new ParsingArg("l", "")
                , new ParsingArg("d", "/usr/logs")
                , new ParsingArg("p", "8080"));
        List<ParsedArg> parsedArgList = schema.convert(parsingArgList);
        ParsedArg parsedArg1 = parsedArgList.get(0);
        assertThat(parsedArg1.getFlag()).isEqualTo("l");
        assertThat(parsedArg1.getType()).isEqualTo("boolean");
        assertThat(parsedArg1.getValue()).isEqualTo(false);

        ParsedArg parsedArg2 = parsedArgList.get(1);
        assertThat(parsedArg2.getFlag()).isEqualTo("d");
        assertThat(parsedArg2.getType()).isEqualTo("string");
        assertThat(parsedArg2.getValue()).isEqualTo("/usr/logs");

        ParsedArg parsedArg3 = parsedArgList.get(2);
        assertThat(parsedArg3.getFlag()).isEqualTo("p");
        assertThat(parsedArg3.getType()).isEqualTo("integer");
        assertThat(parsedArg3.getValue()).isEqualTo(8080);
    }

    @Test
    void should_throw_exception_when_parsing_arg_is_not_in_schema() {
        SchemaArg schemaArg = new StringSchemaArg("d");
        Schema schema = new Schema(Collections.singletonList(schemaArg));
        List<ParsingArg> parsingArgList = Collections.singletonList(new ParsingArg("p", "8080"));
        Assertions.assertThrows(ParsingArgNotExistInSchemaException.class, () -> schema.convert(parsingArgList), "输入参数与参数结构不匹配");
    }
}