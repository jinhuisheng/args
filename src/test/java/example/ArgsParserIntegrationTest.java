package example;

import args.ArgsParser;
import args.ParseResult;
import args.Schema;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ArgsParserIntegrationTest {
    @Test
    @Disabled
    void should_parse_success() {
        ArgsParser parser = new ArgsParser(new Schema(new ArrayList<>()));
        ParseResult result = parser.parse("-l -p 8080 -d /usr/logs");
        assertThat(result.valueOf("l")).isEqualTo(true);
        assertThat(result.valueOf("p")).isEqualTo(8080);
        assertThat(result.valueOf("d")).isEqualTo("/usr/logs");
    }
}
