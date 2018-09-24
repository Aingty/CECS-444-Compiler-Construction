import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Lexicon lexer = new Lexicon();
        String line = "";
        String lineToWrite = "";
        int lineNum = 1;
        Scanner in = new Scanner(System.in);

        System.out.println("Welcom to the Lexicon Program\n\tPlease input file to read from: ");
        String inputFile = in.nextLine();
        System.out.println("\n\tPlease input file to write to: ");
        String outputFile = in.nextLine();

        try {
            Scanner reader = new Scanner(new File(inputFile));
            do {
                line = reader.nextLine();
                lineToWrite = lineToWrite + lexer.printFormat(line, lineNum) + "\n";
                lineNum++;
            } while (reader.hasNextLine());
            lineToWrite = lineToWrite + lexer.printFormat("$", --lineNum);
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist!");
            e.printStackTrace();
        }
        try {
            PrintWriter writer = new PrintWriter(outputFile);
            writer.println(lineToWrite);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not write to file");
            e.printStackTrace();
        }
        in.close();
    }
}
