import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) 
    {
        Lexicon lexer = new Lexicon();
        String line, lineToWrite, inputFile, outputFile, userRespone;
        boolean keepGoing = true;
        int lineNum;
        Scanner in = new Scanner(System.in);
        Scanner reader;
        PrintWriter writer;

        System.out.println("Welcome to the Lexicon Program!!");
        while(keepGoing)
        {
            line = "";
            lineToWrite = "";
            lineNum = 1;
            System.out.println("\tPlease input file to read from: ");
            inputFile = in.nextLine();
            System.out.println("\tPlease input file to write to: ");
            outputFile = in.nextLine();

            // Removing/Adding the ".txt" extentsion if user didn't specify
            if(!inputFile.substring(inputFile.length()-4, inputFile.length()).equals(".txt"))
            {
                inputFile = inputFile + ".txt";
            }
            if(!outputFile.substring(outputFile.length()-4, outputFile.length()).equals(".txt"))
            {
                outputFile = outputFile + ".txt";
            }

            try 
            {
                reader = new Scanner(new File(inputFile));
                do 
                {
                    line = reader.nextLine();
                    lineToWrite = lineToWrite + lexer.printFormat(line, lineNum) + "\n";
                    lineNum++;
                } while (reader.hasNextLine());
                lineToWrite = lineToWrite + lexer.printFormat("$", --lineNum);
                reader.close();
            } 
            catch (FileNotFoundException e) 
            {
                System.out.println("File does not exist!");
                e.printStackTrace();
            }
            try 
            {
                writer = new PrintWriter(outputFile);
                writer.println(lineToWrite);
                writer.close();
            } 
            catch (FileNotFoundException e) 
            {
                System.out.println("Could not write to file");
                e.printStackTrace();
            }
            System.out.println("File written as: " + outputFile +"\nWould you like to continue? (Y to continue)");
            userRespone = in.nextLine();
            if (!userRespone.equalsIgnoreCase("Y"))
            {
                System.out.println("Thank you! Good Bye!!!");
                keepGoing = false;
            }
            System.out.println("\n--------------------------------------------\n");
        }
        in.close();
    }
}
