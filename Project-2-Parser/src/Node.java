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

    // Passing ArrayList due to assumption that children are build already
    public void addChild(ArrayList<Node> cNode)
    {
        for (int i = 0; i < cNode.size(); i++)
        {
            childrenList.add(cNode.get(i));
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