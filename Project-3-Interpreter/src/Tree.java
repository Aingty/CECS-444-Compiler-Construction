/*
    Team VOS:                   Email:
        Sebastian Adame         sjadamem@gmail.com
        Darian Bezayiff         darrianbez@gmail.com
        Aingty Eung             aingtyeung@yahoo.com
        Angela Flores           Angfl97@gmail.com
        Matthew Nguyen          matthewvietnguyen@gmail.com
*/
import java.util.*;

public class Tree
{
    private Node root;
    
    public Tree()
    {
        root = null;
    }

    public void add(Node child, int parentID)
    {
        if (root == null)
        {
            root = child;
        }
        else
        {
            addToParent(root, child, parentID);
        }
    }

    private boolean addToParent(Node pNode, Node cNode, int parentID)
    {
        if (pNode.getID() == parentID)
        {
            System.out.println("Added: " + cNode.getValue() + ":" + cNode.getID() + " to " + pNode.getValue() + ":" + pNode.getID());
            pNode.addChild(cNode);
            return true;
        }
        else
        {
            if (pNode.getChildren().isEmpty())
            {
                return false;
            }
            else
            {
                for (Node child : pNode.getChildren())
                {
                    boolean temp = addToParent(child, cNode, parentID);
                    if (temp)
                    {
                        break;
                    }
                }
                return true;
            }
        }
    }

    public void printTree()
    {
        if (root == null)
        {
            System.out.println("Tree is EMPTY!!!!");
        }
        else
        {
            print(root);
        }
    }

    private void print(Node pNode)
    {
        System.out.println("(Rule: " + pNode.getValue() + ", ID: " + pNode.getID() + ")");
        ArrayList<Node> childrenTemp = pNode.getChildren();
        if (!childrenTemp.isEmpty())
        {
            for (int j = 0; j < childrenTemp.size(); j++)
            {
                System.out.print("\t|\n\t->(Rule: " + childrenTemp.get(j).getValue() + ", ID: " + childrenTemp.get(j).getID() + ")\n");
            }
            System.out.println();
            for (int j = 0; j < childrenTemp.size(); j++)
            {
                print(childrenTemp.get(j));
            }
        }
    }
}
