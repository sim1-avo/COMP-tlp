import java.io.*;
import java_cup.runtime.*;

public class Tester {
    public static void main(String[] args) throws Exception {

        File file=new File(args[0]);
        InputStream in = new FileInputStream(file);
        Reader reader = new InputStreamReader(in);

        parser p = new parser(new Yylex(reader));
        System.out.println(p.parse().value);
    }
}
