/*
    Team VOS:                   Email:
        Sebastian Adame         sjadamem@gmail.com
        Darian Bezayiff         darrianbez@gmail.com
        Aingty Eung             aingtyeung@yahoo.com
        Angela Flores           Angfl97@gmail.com
        Matthew Nguyen          matthewvietnguyen@gmail.com

    Description: 
        This is the Node class with a private Node ArrayList to store 
        all the children that belong to a particular node, a private string 
        to hold the symbol value stored at the node, and a private int to 
        hold an ID for the node. The purspose of this class is to create 
        the nodes that will eventually form a complete PST
*/
import java.util.ArrayList;

public class Node
{
    private ArrayList<Node> childrenList;
    private String value;
    private int nodeID;
           
    //overloaded constructer for Node
    public Node(String v, int givenID)
    {
        value = v;
        nodeID = givenID;
        childrenList = new ArrayList<Node>();
    }

    //method to add a child to the existing 
    //ArrayList of a Node's children
    public void addChild(Node cNode)
    {
        childrenList.add(cNode);
    }

    //getter method to return the value of the Node
    public String getValue()
    {
        return this.value;
    }

    //getter method to return ID of the Node
    public int getID()
    {
        return this.nodeID;
    }

    //getter method to return children associated wiht a Node
    public ArrayList<Node> getChildren()
    {
        return this.childrenList;
    }

}