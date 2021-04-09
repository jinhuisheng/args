package args;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringParserTest {

    @Test
    void should_parse_arg_p_with_value() {
        StringParser stringParser = new StringParser();
        List<ParsingArg> parsingArgs = stringParser.parseArgsStr("-p 8080");
        assertThat(parsingArgs.get(0).getFlag()).isEqualTo("p");
        assertThat(parsingArgs.get(0).getValueStr()).isEqualTo("8080");
    }
}
