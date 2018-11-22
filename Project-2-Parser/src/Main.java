/*
	Team VOS:               Email:
		Sebastian Adame         sjadamem@gmail.com
		Darian Bezayiff         darrianbez@gmail.com
		Aingty Eung             aingtyeung@yahoo.com
		Angela Flores           Angfl97@gmail.com
		Matthew Nguyen          matthewvietnguyen@gmail.com

	Description:
		The Main class.......
*/
import java.util.*;

public class Main
{
	public static void main (String args[])
	{
		// Stack and Queue used for the Program 
		Queue<String> queue = new LinkedList<String>();
		Stack<String> stack = new Stack<String>();

		// Lexicon used from project 1 and new Parser
		Lexicon lexer = new Lexicon();
		Parser parser = new Parser();

		String lineTest = "prog main { ";

		// @parsedString is used to get an arraylist of word in a line
		ArrayList<String> parsedString = lexer.parser(lineTest);

		// @nodeList is used to keep track of the AST
		ArrayList<Node> nodeList = new ArrayList<Node>();

		// Always the intial push to the Stack
		stack.push("Pgm");

		// Generate the rule table for parser
		parser.generateRules();
		
		// Adding the whole arraylist of a line into the Queue
		for (int i = 0; i < parsedString.size(); i++)
		{
			queue.add(parsedString.get(i));
		}

		// LL Parser Mechanic
		while (!stack.empty())
		{
			// M1
			if (lexer.getToken(stack.peek()) == lexer.getToken(queue.peek()))
			{
				if (lexer.getToken(stack.peek()) == 0) // Top == $
				{
					System.out.println("WIN!!!");
				}
				else
				{
					stack.pop();
					queue.remove();
				}
			}
			
			// M2E
			else if (lexer.getToken(stack.peek()) != 99)
			{
				System.out.println("ERROR!!!: TOP of Stack is a TERMINAL, that doesn't match FRONT of Queue (M2)");
				System.out.println("\tAfter this character: " + queue.peek());
				System.exit(0);
			}

			// M3E : We don't need to do this becasue our cell is never EMPTY!!!!
			
			// M4
			else
			{
				Node top = new Node()
			}
			
		}
	}
}
