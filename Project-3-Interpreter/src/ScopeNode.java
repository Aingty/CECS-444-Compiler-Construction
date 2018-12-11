/*
    Team VOS:                   Email:
        Sebastian Adame         sjadamem@gmail.com
        Darian Bezayiff         darrianbez@gmail.com
        Aingty Eung             aingtyeung@yahoo.com
        Angela Flores           Angfl97@gmail.com
        Matthew Nguyen          matthewvietnguyen@gmail.com

    Description:
        This is the ScopeNode class with a string to hold the name of the ScopeNode, 
        an ArrayList to store the ScopeNodes associated as children of the current 
        ScopeNode, and an ArrayList to store the symbol table associated with the 
        ScopeNode. The purpose for this class is to define the nodes that will be
        used to model a complete SCT
*/

import java.util.*;

//class of nodes that will be used to build the scope tree
public class ScopeNode{

    //name of ScopeNode
    public string name;

    //children nodes this ScopeNode points to
    ArrayList<ScopeNode> children = new ArrayList<ScopeNode>();

    //symbol table associated w/ this ScopeNode (name:type:attribute)
    ArrayList<string> symTab = new ArrayList<string>();

    //ScopeNode constructor
    public ScopeNode(string name){
        this.name = name;
    }

    //method to add a child node
    public void AddChild(ScopeNode child){
        children.add(child);
    }

    //method to add a symbol to the node's symbol table
    public void EnterSymbol(string name, string type, string attribute){
        symTab.add(name + ": " + type + ": " + attribute);
    }

    //method to return the current ScopeNode
    public ScopeNode RetrieveScopeNode(string name){
        if(this.name ==name){
            return this;
        }
    }

    //method to return node name
    public string GetName(){
        return name;
    }

    
}