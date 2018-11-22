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
    private int nodeID;

    public Node(String v, int givenID)
    {
        value = v;
        nodeID = givenID;
        childrenList = new ArrayList<Node>();
    }

    public void addChild(Node cNode)
    {
        childrenList.add(cNode);
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