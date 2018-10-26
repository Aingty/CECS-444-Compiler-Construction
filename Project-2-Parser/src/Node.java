/*
    Team VOS:                   Email:
        Sebastian Adame         sjadamem@gmail.com
        Darian Bezayiff         darrianbez@gmail.com
        Aingty Eung             aingtyeung@yahoo.com
        Angela Flores           Angfl97@gmail.com
        Matthew Nguyen          matthewvietnguyen@gmail.com

    Description:
        This is the Node class.....
*/
import java.util.ArrayList;

public class Node
{
    private ArrayList<Node> childrenList;
    private String value;

    public Node(String v)
    {
        value = v;
        childrenList = new ArrayList<Node>();
    }

    public void addChild(Node cNode)
    {
        if (childrenList.isEmpty())
        {
            childrenList.add(cNode);
        }
        else
        {
            //If we see that a child is a Terminal, then we add to list
            // Else we recursively call addChild()
        }
    }

    public String getValue()
    {
        return this.value;
    }

    public ArrayList<Node> getChildren()
    {
        return this.childrenList;
    }

}