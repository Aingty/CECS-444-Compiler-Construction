/*
Team VOS:               Email:
Sebastian Adame         sjadamem@gmail.com
Darian Bezayiff         darrianbez@gmail.com
Aingty Eung             aingtyeung@yahoo.com
Angela Flores           Angfl97@gmail.com
Matthew Nguyen          matthewvietnguyen@gmail.com

The main reads input text files with written A4 Lexicon code. Every line is read
individually and passed into the method printFormat() from the Lexicon class, where
its contents will be converted into valid tokens and returned as a formatted String
displaying the token ID, the line it was read from, and the token it represents.
It is then written to a generated output file.

The program will continue to ask the user if they want to continue to read files
until they specify otherwise.
*/
import java.util.*;

public class Main
{
	public static void main (String args[])
	{
		Node a = new Node("Test");
		a.addChild(new Node("Test1"));
		a.addChild(new Node("Test2"));

		System.out.println(a.getValue() + ":");
		for (int i = 0; i < a.getChildren().size(); i++)
		{
			ArrayList<Node> temp = a.getChildren();
			System.out.println(temp.get(i).getValue());
		}
	}
}
