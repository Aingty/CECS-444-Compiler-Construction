/*
	Team VOS:               Email:
		Sebastian Adame         sjadamem@gmail.com
		Darian Bezayiff         darrianbez@gmail.com
		Aingty Eung             aingtyeung@yahoo.com
		Angela Flores           Angfl97@gmail.com
		Matthew Nguyen          matthewvietnguyen@gmail.com
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.*;

public class Main
{
	public static void main (String args[])
	{
		// Declaring all Scanners
		Scanner in = new Scanner(System.in);
		Scanner reader;
		String line, inputFile, userRespone;
		
		// Boolean for keeping the program running till user's quit
		boolean keepGoing = true;

		System.out.println("Welcome to the Parser Program!!");
        while(keepGoing)
        {
			// Stack and Queue used for the Program 
			Queue<String> queue = new LinkedList<String>();
			Stack<Node> stack = new Stack<Node>();

			// Lexicon used from project 1 and new Parser
			Lexicon lexer = new Lexicon();
			Parser parser = new Parser();

			// @PST is tree used to be the Parsed Syntax Tree of the program
			Tree PST = new Tree();
			// @nodeList1 is used to be converted from PST to AST
			ArrayList<Node> nodeList1 = new ArrayList<Node>();

			// Node for Top of stack
			Node top;

			// Integer used to give unique ID
			int givenID = 0;

            System.out.print("\tPlease input file to read from: ");
            inputFile = in.nextLine();

            // Removing/Adding the ".txt" extentsion if user didn't specify
            if(!inputFile.substring(inputFile.length()-4, inputFile.length()).equals(".txt"))
            {
                inputFile = inputFile + ".txt";
            }
			
			ArrayList<String> mainAdd = new ArrayList<String>();
            try
            {
                reader = new Scanner(new File(inputFile));
                do
                {
					line = reader.nextLine();
					ArrayList<String> tempAdd = lexer.parser(line);
					for (int i = 0; i < tempAdd.size(); i++)
					{
						mainAdd.add(tempAdd.get(i));
					}
                } while (reader.hasNextLine());
                reader.close();
            }
            catch (FileNotFoundException e)
            {
                System.out.println("File does not exist!");
                e.printStackTrace();
            }

			// Always the intial push to the Stack
			stack.push(new Node("$",givenID, new Node("$",givenID)));
			givenID++;
			PST.add(stack.peek(),0);
			top = new Node("Pgm",givenID);
			givenID++;
			top.setParent(stack.peek());
			stack.push(top);
			PST.add(top, top.getParent().getID());

			// Generate the rule table for parser
			parser.generateRules();

			// Adding the whole arraylist of lines from file into the Queue
			for (int i = 0; i < mainAdd.size(); i++)
			{
				if (lexer.getToken(mainAdd.get(i)) == 2)
				{
					queue.add("id");
				}
				else if (lexer.getToken(mainAdd.get(i)) == 3)
				{
					queue.add("int");
				}
				else if (lexer.getToken(mainAdd.get(i)) == 4)
				{
					queue.add("float");
				}
				else if (lexer.getToken(mainAdd.get(i)) == 5)
				{
					queue.add("string");
				}
				else
				{
					queue.add(mainAdd.get(i));
				}
			}
			// Adding the end of file symbol
			queue.add("$"); 

			// LL Parser Mechanic
			while (!stack.empty())
			{	
				System.out.println("Top of Stack: " + stack.peek().getValue() + " QUEUE: " + queue.peek() + " ID: "+givenID);
				// M4
				if (Character.isUpperCase(stack.peek().getValue().charAt(0)))
				{
					// Getting the string arraylist of a rule given by the LL Table
					String[] temp = parser.getRule(parser.getRuleNum(stack.peek().getValue() + " " + queue.peek())).split(" ");
					
					top = stack.pop();
					ArrayList<Node> tempChildList = new ArrayList<Node>();
					// Creating a temporary list of children for storing later
					for (int i = 0; i < temp.length; i++)
					{
						if (temp[i].equals("eps"))
						{
							continue;
						}
						else
						{
							Node childTemp = new Node(temp[i], givenID);
							givenID++;
							childTemp.setParent(top);
							tempChildList.add(childTemp);
						}
					}
					// Adding the list of child to the parent's node and to the stack
					if (!tempChildList.isEmpty())
					{
						for (int i = 0; i < tempChildList.size(); i++)
						{
							stack.push(tempChildList.get(tempChildList.size()-i-1));
						}
						for (int i = 0; i < tempChildList.size(); i++)
						{
							PST.add(tempChildList.get(i), top.getID());
						}
					}
				}
				// M1
				else if (lexer.getToken(stack.peek().getValue()) == lexer.getToken(queue.peek()))
				{
					if (lexer.getToken(stack.peek().getValue()) == 0) // Top == $
					{
						System.out.println("WIN!!!");
						break;
					}
					else
					{
						stack.pop();
						queue.remove();
					}
				}
				
				// M2E
				else
				{
					System.out.println("ERROR!!!: TOP of Stack is a TERMINAL, that doesn't match FRONT of Queue (M2)");
					System.out.println("\tAfter this character: " + queue.peek());
					System.exit(0);
				}
				//PST.printTree();
				// M3E : We don't need to do this becasue our cell is never EMPTY!!!!

			}

			// // Converting to AST
			// System.out.println("Converting from PST to AST");
			// for (int i = 0; i < nodeList.size(); i++)
			// {
			// 	ArrayList<Node> childrenTemp = nodeList.get(i).getChildren();
			// 	if (childrenTemp != null)
			// 	{
			// 		for (int j = 0; j < childrenTemp.size(); j++)
			// 		{
			// 			if (!Character.isUpperCase(childrenTemp.get(j).getValue().charAt(0)))
			// 			{
			// 				Node newChild = childrenTemp.get(j);
			// 				for (int k = 0; k < childrenTemp.size(); k++)
			// 				{
			// 					if ((k != j) && Character.isUpperCase(childrenTemp.get(k).getValue().charAt(0)))
			// 					{
			// 						newChild.addChild(childrenTemp.get(k));
			// 					}
			// 				}
			// 				nodeList1.add(newChild);
			// 				break;
			// 			}
			// 		}
			// 	}
			// }
			// // Printing out the Parse TREE 
			// System.out.println("Parsed Tree:");
			// for (int i = 0; i < nodeList.size(); i++)
			// {
			// 	System.out.println("(Rule: " + nodeList.get(i).getValue() + ", ID: " + nodeList.get(i).getID() + ")");
			// 	ArrayList<Node> childrenTemp = nodeList.get(i).getChildren();
			// 	if (childrenTemp != null)
			// 	{
			// 		for (int j = 0; j < childrenTemp.size(); j++)
			// 		{	
			// 			System.out.print("\t|\n\t->(Rule: " + childrenTemp.get(j).getValue() + ", ID: " + childrenTemp.get(j).getID() + ")\n");
			// 		}
			// 	}
			// 	System.out.println();
			// }
			// System.out.println("-----------------------------------------");
			// // Printing out the Abstact TREE
			// System.out.println("\nAbstract Tree:");
			// for (int i = 0; i < nodeList1.size(); i++)
			// {
			// 	System.out.println("(Rule: " + nodeList1.get(i).getValue() + ", ID: " + nodeList1.get(i).getID() + ")");
			// 	ArrayList<Node> childrenTemp = nodeList1.get(i).getChildren();
			// 	if (childrenTemp != null)
			// 	{
			// 		for (int j = 0; j < childrenTemp.size(); j++)
			// 		{	
			// 			System.out.print("\t|\n\t->(Rule: " + childrenTemp.get(j).getValue() + ", ID: " + childrenTemp.get(j).getID() + ")\n");
			// 		}
			// 	}
			// 	System.out.println();
			// }

			PST.printTree();
			keepGoing = false;
			// System.out.print("\n\nWould you like to choose another file? (Y to continue)\n\tYour Input: ");
            // userRespone = in.nextLine();
            // if (!userRespone.equalsIgnoreCase("Y"))
            // {
            //     System.out.println("Thank you! Good Bye!!!");
            //     keepGoing = false;
            // }
			// System.out.println("\n--------------------------------------------\n");
		}
	}
}
