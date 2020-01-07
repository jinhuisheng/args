import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author huisheng.jin
 * @date 2020/1/6.
 */
public class Demo {

    //对外如何使用
//    public static void main(String[] args) {
//        args = "-l -p 8080 -d /usr/logs".split(" ");
//        try {
//
//        SchemaArg schemaArg1 = new SchemaArg("p", "integer", 0);
//        SchemaArg schemaArg2 = new SchemaArg("l", "integer", false);
//        SchemaArg schemaArg3 = new SchemaArg("d", "string", "");
//        Schema schema = new Schema(Arrays.asList(schemaArg1, schemaArg2, schemaArg3));
//
//            Parser parser = new Parser(schema);
//            parser.parse(args);
//
//            ParsedArg parsedArg = parser.getArg("l");
//            Object value = parsedArg.getValue();
//            String type = parsedArg.getType();
//
//        } catch (MisMatchArgsException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }


//    @Test
//    void demo() {
//        String[] args = "-l -p 8080 -d /usr/logs".split(" ");
//
//        SchemaArg schemaArg1 = new SchemaArg("p", "integer", 0);
//        SchemaArg schemaArg2 = new SchemaArg("l", "integer", false);
//        SchemaArg schemaArg3 = new SchemaArg("d", "string", "");
//        Schema schema = new Schema(Arrays.asList(schemaArg1, schemaArg2, schemaArg3));
//
//        Parser parser = new Parser(schema);
//        parser.parse(args);
//
//        ParsedArg parsedArg1 = parser.getArg("l");
//        assertThat(parsedArg1.getValue()).isEqualTo(false);
//        assertThat(parsedArg1.getType()).isEqualTo("boolean");
//
//        ParsedArg parsedArg2 = parser.getArg("p");
//        assertThat(parsedArg2.getValue()).isEqualTo(8080);
//        assertThat(parsedArg2.getType()).isEqualTo("integer");
//
//        ParsedArg parsedArg3 = parser.getArg("d");
//        assertThat(parsedArg3.getValue()).isEqualTo("/usr/logs");
//        assertThat(parsedArg3.getType()).isEqualTo("string");
//    }
}
