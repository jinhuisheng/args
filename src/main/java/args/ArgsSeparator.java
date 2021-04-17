package args;

import java.util.ArrayList;
import java.util.List;

public class ArgsSeparator {
    public ArgsSeparator() {
    }

    List<Arg> of(String args) {
        String[] array = args.split(" ");
        List<Arg> parsingArgs = new ArrayList<>();
        String flag = array[0].substring(1);
        String valueStr = array.length > 1 ? array[1] : null;
        parsingArgs.add(new Arg(flag, valueStr));
        return parsingArgs;
    }
}
