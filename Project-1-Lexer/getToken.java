import java.util.Map;

public class Lexicon
{

    private Map<Integer, String> map = new HashMap<Integer, String>();
    
    public Lexicon()
    {
        map.put(10, "prog");
        map.put(11, "main");
        map.put(12, "fcn");
        map.put(13, "class");
        map.put(15, "float");
        map.put(16, "int");
        map.put(17, "string");
        map.put(18, "if");
        map.put(19, "elseif");
        map.put(20, "else");
        map.put(21, "while");
        map.put(22, "input");
        
    }
    public static int getToken(String parsedString)
    {
        if (parsedString.charAt(0) == '"' && parsedString.charAt(parsedString.length() - 1) == '"')
        {
            return 5;
        }
        else if(Character.isLetter(parsedString.charAt(0)))
        {
            if (map.containsValue(parsedString))
            {
                
            }
        }
    
    
        return -1;
        
    }
}