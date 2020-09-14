import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author huisheng.jin
 * @date 2020/9/13.
 */
public class AcceptanceTest {
    private Schema schema;

    @BeforeEach
    void setUp() {
        schema = ArgsDataBuilder.givenSchema();
    }

    @Test
    void success() {
        Parser parser = new Parser(schema);
        parser.parse("-l -p 8080 -d /usr/logs");

        ParsedArg parsedArgL = parser.getArg("l");
        assertThat(parsedArgL.getValue()).isEqualTo(true);
        assertThat(parsedArgL.getType()).isEqualTo("boolean");

        ParsedArg parsedArgP = parser.getArg("p");
        assertThat(parsedArgP.getValue()).isEqualTo(8080);
        assertThat(parsedArgP.getType()).isEqualTo("integer");

        ParsedArg parsedArgD = parser.getArg("d");
        assertThat(parsedArgD.getValue()).isEqualTo("/usr/logs");
        assertThat(parsedArgD.getType()).isEqualTo("string");
    }

    @Test
    void failure() {
        Parser parser = new Parser(schema);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> parser.parse("-t"));
        assertThat(exception.getMessage()).isEqualTo("参数与参数结构不匹配");
    }

    @Test
    void extend_success() {
        Parser parser = new Parser(schema);
        parser.parse("-g this,is,a,list -h 1,2,-3,5");

        ParsedArg parsedArgG = parser.getArg("g");
        assertThat(parsedArgG.getValue()).isEqualTo(Arrays.asList("this", "is", "a", "list"));
        assertThat(parsedArgG.getType()).isEqualTo("stringArray");

        ParsedArg parsedArgD = parser.getArg("h");
        assertThat(parsedArgD.getValue()).isEqualTo(Arrays.asList(1, 2, -3, 5));
        assertThat(parsedArgD.getType()).isEqualTo("integerArray");

    }
}
