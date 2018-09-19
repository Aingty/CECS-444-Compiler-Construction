public class Main {
    public static void main(String[] args) {
        Lexicon lexer = new Lexicon();

        String inputFun = "    prog main / <= <> <<{ print( \"ASCII:\", \" A= \", 65, \" Z= \", 90 ); }";
        System.out.println(lexer.parser(inputFun));

    }
}
