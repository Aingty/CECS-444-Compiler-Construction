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

public class Node
{
    private ArrayList<Node> childrenList;
    private String value;

    public Node(String v)
    {
        value = v;
        childrenList = new ArrayList<Node>();
    }

    public void display()
    {
        
    }
}