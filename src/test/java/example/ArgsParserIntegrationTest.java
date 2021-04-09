package example;

import args.ArgsParser;
import args.ParseResult;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ArgsParserIntegrationTest {
    @Test
    @Disabled
    void should_parse_success() {
        ArgsParser parser = new ArgsParser();
        ParseResult result = parser.parse("-l -p 8080 -d /usr/logs");
        assertThat(result.getFlag("l")).isEqualTo(true);
        assertThat(result.getFlag("p")).isEqualTo(8080);
        assertThat(result.getFlag("d")).isEqualTo("/usr/logs");
    }
}
