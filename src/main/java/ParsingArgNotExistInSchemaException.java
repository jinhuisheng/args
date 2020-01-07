/**
 * @author huisheng.jin
 * @date 2020/1/7.
 */
public class ParsingArgNotExistInSchemaException extends RuntimeException {
    private String msg;

    ParsingArgNotExistInSchemaException(String msg) {

        this.msg = msg;
    }
}
