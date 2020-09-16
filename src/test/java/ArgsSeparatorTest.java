import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author huisheng.jin
 * @date 2020/9/13.
 */
class ArgsSeparatorTest {

    private ArgsSeparator argsSeparator;

    @BeforeEach
    void setUp() {
        argsSeparator = new ArgsSeparator();
    }

    @Test
    void should_separate_one_flag_with_flag_and_value_success() {
        List<Arg> args = argsSeparator.separate("-p 8080");
        assertThat(args.size()).isEqualTo(1);
        Arg arg = args.get(0);
        assertThat(arg.getFlag()).isEqualTo("p");
        assertThat(arg.getValue()).isEqualTo("8080");
    }

    @Test
    void should_separate_two_flag_with_flag_and_value_success() {
        List<Arg> args = argsSeparator.separate("-p 8080 -d /usr/logs");
        assertThat(args.size()).isEqualTo(2);
        Arg arg1 = args.get(0);
        assertThat(arg1.getFlag()).isEqualTo("p");
        assertThat(arg1.getValue()).isEqualTo("8080");

        Arg arg2 = args.get(1);
        assertThat(arg2.getFlag()).isEqualTo("d");
        assertThat(arg2.getValue()).isEqualTo("/usr/logs");
    }

    @Test
    void should_separate_one_flag_with_flag_but_not_value_success() {
        List<Arg> args = argsSeparator.separate("-l");
        assertThat(args.size()).isEqualTo(1);
        Arg arg = args.get(0);
        assertThat(arg.getFlag()).isEqualTo("l");
        assertThat(arg.getValue()).isEqualTo("");
    }

    @Test
    void should_separate_two_flag_with_one_arg_has_flag_but_not_value_and_one_arg_has_value_success() {
        List<Arg> args = argsSeparator.separate("-l -p 8080");
        assertThat(args.size()).isEqualTo(2);
        Arg arg1 = args.get(0);
        assertThat(arg1.getFlag()).isEqualTo("l");
        assertThat(arg1.getValue()).isEqualTo("");

        Arg arg2 = args.get(1);
        assertThat(arg2.getFlag()).isEqualTo("p");
        assertThat(arg2.getValue()).isEqualTo("8080");
    }

    @Test
    void should_separate_three_flag_with_one_arg_has_flag_but_not_value_and_two_arg_has_value_success() {
        List<Arg> args = argsSeparator.separate("-l -p 8080 -d /usr/logs");
        assertThat(args.size()).isEqualTo(3);
        Arg arg1 = args.get(0);
        assertThat(arg1.getFlag()).isEqualTo("l");
        assertThat(arg1.getValue()).isEqualTo("");

        Arg arg2 = args.get(1);
        assertThat(arg2.getFlag()).isEqualTo("p");
        assertThat(arg2.getValue()).isEqualTo("8080");

        Arg arg3 = args.get(2);
        assertThat(arg3.getFlag()).isEqualTo("d");
        assertThat(arg3.getValue()).isEqualTo("/usr/logs");

    }

    @Test
    void should_separate_one_stringArray_flag_with_value_success() {
        List<Arg> args = argsSeparator.separate("-g this,is,a,list");
        assertThat(args.size()).isEqualTo(1);
        Arg arg = args.get(0);
        assertThat(arg.getFlag()).isEqualTo("g");
        assertThat(arg.getValue()).isEqualTo("this,is,a,list");
    }

    @Test
    void should_separate_one_stringArray_flag_without_value_success() {
        List<Arg> args = argsSeparator.separate("-g");
        assertThat(args.size()).isEqualTo(1);
        Arg arg = args.get(0);
        assertThat(arg.getFlag()).isEqualTo("g");
        assertThat(arg.getValue()).isEqualTo("");
    }

    @Test
    void should_separate_one_integerArray_flag_with_value_success() {
        List<Arg> args = argsSeparator.separate("-d 1,2,-3,5");
        assertThat(args.size()).isEqualTo(1);
        Arg arg = args.get(0);
        assertThat(arg.getFlag()).isEqualTo("d");
        assertThat(arg.getValue()).isEqualTo("1,2,-3,5");
    }

    @Test
    void should_separate_one_integerArray_flag_without_value_success() {
        List<Arg> args = argsSeparator.separate("-d");
        assertThat(args.size()).isEqualTo(1);
        Arg arg = args.get(0);
        assertThat(arg.getFlag()).isEqualTo("d");
        assertThat(arg.getValue()).isEqualTo("");
    }

    @Test
    void should_separate_two_array_flags() {
        List<Arg> args = argsSeparator.separate("-d 1,2,-3,5 -g this,is,a,list");
        assertThat(args.size()).isEqualTo(2);
        Arg arg = args.get(0);
        assertThat(arg.getFlag()).isEqualTo("d");
        assertThat(arg.getValue()).isEqualTo("1,2,-3,5");

        Arg arg2 = args.get(1);
        assertThat(arg2.getFlag()).isEqualTo("g");
        assertThat(arg2.getValue()).isEqualTo("this,is,a,list");
    }

}