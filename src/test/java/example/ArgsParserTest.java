package example;

import args.ArgsParser;
import args.ParseResult;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ArgsParserTest {
    @Test
    void should_parse_success() {
        ArgsParser parser = new ArgsParser();
        ParseResult result = parser.parse("-l");
        assertThat(result.getFlag("l")).isEqualTo(true);
    }
}