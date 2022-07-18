import java.io.File;

public class Main {

    public static void main(String[] args) {
        File file = new File("eurofxref-daily.xml");
        Parser parser = new Parser(file);
        Calculator calculator = new Calculator(parser);
    }
}