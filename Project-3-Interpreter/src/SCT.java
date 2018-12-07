import java.util.*;

public class SCT
{
    private ScopeNode root;

    private ArrayList<ScopeNode> tree = new ArrayList<ScopeNode>();

    public SCT()
    {
        root = null;
    }

    public void addNode(ScopeNode n)
    {
        if (root == null)
        {
            root = n;
            tree.add(root);
        }
        else
        {
            tree.add(n);
        }
    }

    public ScopeNode getRoot()
    {
        return root.GetName();
    }
}
