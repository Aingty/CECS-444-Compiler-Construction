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

    private void addToParent(Node pNode, Node cNode, int parentID)
    {
        if ()
    }
}
