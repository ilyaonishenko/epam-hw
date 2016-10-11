package task01;

/**
 * Created by wopqw on 11.10.16.
 */
public enum JavaKeywords {
    ABSTRACT("abstract"),
    CASE("case"),
    CONTINUE("continue"),
    ENUM("enum"),
    FOR("for"),
    INSTANCEOF("instanceof"),
    NEW("new"),
    RETURN("return"),
    SWITCH("switch"),
    TRANSIENT("transient"),
    ASSERT("assert"),
    CATCH("catch"),
    DEFAULT("default"),
    EXTENDS("extends"),
    GOTO("goto"),
    INT("int"),
    PACKAGE("package"),
    SHORT("short"),
    SYNCHRONIZED("synchronized"),
    TRY("try"),
    BOOLEAN("boolean"),
    CHAR("char"),
    DO("do"),
    FINAL("final"),
    IF("if"),
    INTERFACE("interface"),
    PRIVATE("private"),
    STATIC("static"),
    THIS("this"),
    VOID("void"),
    BREAK("break"),
    CLASS("class"),
    DOUBLE("double"),
    FINALLY("finally"),
    IMPLEMENTS("implements"),
    LONG("long"),
    PROTECTED("protected"),
    STRICTFP("strictfp"),
    THROW("throw"),
    VOLATILE("volatile"),
    BYTE("byte"),
    CONST("const"),
    ELSE("else"),
    FLOAT("float"),
    IMPORT("import"),
    NATIVE("native"),
    PUBLIC("public"),
    SUPER("super"),
    THROWS("throws"),
    WHILE("while");

    private final String value;

    JavaKeywords(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

    public static boolean contains(String word){

        for (JavaKeywords s :
                values()) {
            if(s.getValue().equals(word)) {
                return true;
            }
        }
        return false;
    }
}
