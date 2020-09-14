import java.util.ArrayList;
import java.util.List;

/**
 * @author huisheng.jin
 * @date 2020/9/13.
 */
public class ArgsSeparator {
    public static List<Arg> separate(String args) {
        List<Arg> result = new ArrayList<>();
        String[] array = args.split(" ");
        for (int i = 0; i < array.length; i++) {
            if (array[i].startsWith("-")) {
                String flag = array[i].substring(1);
                if (i == array.length - 1 || array[i + 1].startsWith("-")) {
                    result.add(new Arg(flag, ""));
                } else {
                    result.add(new Arg(flag, array[i + 1]));
                }
            }
        }
        return result;
    }
}
