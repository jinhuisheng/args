package args;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

class ArgsSeparatorTest {

    @Test
    void should_parse_arg_p_with_value() {
        ArgsSeparator argsSeparator = new ArgsSeparator();
        List<Arg> args = argsSeparator.of("-p 8080");
        assertThat(args.get(0).getFlag()).isEqualTo("p");
        assertThat(args.get(0).getValueStr()).isEqualTo("8080");
    }
}
