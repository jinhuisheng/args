# args

## 初始需求

我们经常会遇到需要解析命令行参数的场景。如果没有趁手的工具，我们可以自己写一个，自己想办法处理传给main函数的参数。

传入一个程序的参数包含了“标记”（flag）和“值”（value）。标记都是一个字母，前面加上“-”号（例如“-p”这样）。每个标记可以有一个值与之对应，也可以没有对应的值。

我们要开发一个解析器（parser）来处理这些参数。这个解析器需要一个参数结构（schema）来描述“这个程序应该接受哪些参数”的信息，包括：

应该有几个标记；

每个标记应该是什么类型；

每个标记的缺省值是什么。

参数结构指定好以后，就可以把实际接收到的参数列表传给参数解析器。解析器会首先验证参数列表是否与参数结构相匹配。然后，程序就可以向参数解析器查询每个参数的值（根据参数的标记名）。返回值的类型应该与参数结构中规定的类型相一致。

例如，程序接收到的参数是这样：

-l -p 8080 -d /usr/logs

那么对应的参数结构应该规定3个标记：l、p、d

l（logging，是否记录日志）标记没有与之对应的值，这是一个布尔型的标记，如果传入了“-l”就为True，否则为False。

p（port，端口号）标记的值是整数型。

d（directory，目录）标记的值是字符串型。

如果参数结构中规定了的标记在实际的参数列表中没有出现，那么就应该返回合理的缺省值，例如布尔型的缺省值可以是False，数值型的缺省值可以是0，字符串型的缺省值可以是空字符串。

如果实际给出的参数与参数结构不匹配，需要给出良好的错误信息，解释清楚出错的原因。
### 任务分解

* 验证参数列表是否与参数结构相匹配
      验证参数列表,如果实际给出的参数与参数结构不匹配，需要给出良好的错误信息，解释清楚出错的原因。
* 解析参数 
      解析参数,参数值，参数类型
      如果没有传值，设置参数缺省值
* 程序就可以向参数解析器查询每个参数的值（根据参数的标记名）。返回值的类型应该与参数结构中规定的类型相一致。

### 对外如何使用
```java
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

```

或者说，最外层的测试是:

```
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

```
### 框定范围（建立最外层测试)
创建各个类
```java
//class ParserTest {
//    @Test
//    void should_parse_success() {
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
//}

```
意图驱动开发，驱动出parse的逻辑：
```java
//    public void parse(String[] args) {
//        //1.从参数中匹配出参数及参数值
//        List<ParsingArg> paringArgList = parseArgs(args);
//        //2.根据参数去参数结构（schema）中获取参数类型，并将参数值转换为对应的类型
//        parsedArgList = schema.convert(paringArgList);
//    }
```
对第一步操作，加测试，进行驱动

```java
//    Object convertValue(String value) {
//        if (StringUtils.isBlank(value)) {
//            return defaultValue;
//        }
//        switch (type) {
//            case "boolean":
//                return Boolean.parseBoolean(value);
//            case "string":
//                return value;
//            case "integer":
//                return Integer.parseInt(value);
//            default:
//                return "";
//        }
//    }

```

类型码type跟行为有关，所以需要以子类取代类型码:

* SchemaArg
* StringSchemaArg
* IntegerSchemaArg
* BooleanSchemaArg


主流程开发完成，检查任务分解列表，增加遗漏的测试(比如：异常流程,参数与参数结构不匹配)

疑问：
```java
//    public void parse(String[] args) {
//        List<ParsingArg> paringArgList = parseArgs(args);
//        parsedArgList = schema.convert(paringArgList);
//    }
//
//    public List<ParsingArg> parseArgs(String[] args) {
//        List<ParsingArg> parsingArgList = new ArrayList<>();
//        for (int i = 0; i < args.length; i++) {
//            parseArg(args, parsingArgList, i);
//        }
//        return parsingArgList;
//    }

```
其中，parseArgs(String[] args) 需要有一个类去承担这个行为吗？但没有找到可以说服自己的类，不然，针对parseArgs方法的测试，需要将该方法改为公共方法才可以测试


## 扩展需求

扩展代码，支持列表类型的参数。例如下列参数中：

-g this,is,a,list -d 1,2,-3,5

g标记对应的是字符串类型的列表（[“this”, “is”, “a”, “list”]），d标记对应的是整数类型的列表（[1, 2, -3, 5]）。

代码应该具有良好的可扩展性，这样在添加新的值类型时才会简单明了。



## 重点

分离关注点
当前kata 适合编写边加测试，很多测试写之前是想不出来，因为它不是具体的业务规则，而是实现细节。
基本类型偏执，用类去代替，更面向对象
