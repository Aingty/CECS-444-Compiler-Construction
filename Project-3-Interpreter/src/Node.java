/*
    Team VOS:                   Email:
        Sebastian Adame         sjadamem@gmail.com
        Darian Bezayiff         darrianbez@gmail.com
        Aingty Eung             aingtyeung@yahoo.com
        Angela Flores           Angfl97@gmail.com
        Matthew Nguyen          matthewvietnguyen@gmail.com
*/
import java.util.ArrayList;

public class Node
{
    private ArrayList<Node> childrenList;
    private String value;
    private int nodeID;
    private Node parent;

    // Constructor without Parent
    public Node(String v, int givenID)
    {
        value = v;
        nodeID = givenID;
        childrenList = new ArrayList<Node>();
        parent = null;
    }

    // Constructor with Parent
    public Node(String v, int givenID, Node givenParent)
    {
        value = v;
        nodeID = givenID;
        childrenList = new ArrayList<Node>();
        parent = givenParent;
    }
    
    public void setParent(Node pNode)
    {
        this.parent = pNode;
    }

    public void addChild(Node cNode)
    {
        childrenList.add(cNode);
    }

    public String getValue()
    {
        return this.value;
    }

    public int getID()
    {
        return this.nodeID;
    }

    public Node getParent()
    {
        return parent;
    }
    
    public ArrayList<Node> getChildren()
    {
        return this.childrenList;
    }

}