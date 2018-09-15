import java.util.HashMap;
import java.util.Map;
import java.lang.String;

public class Lexicon
{

    private Map<Integer, String> map = new HashMap<Integer, String>();
    
    public Lexicon()
    {
        map.put(6, ",");      
        map.put(7, ";");      
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
        map.put(23, "print"); 
        map.put(24, "new");   
        map.put(25, "return");
        map.put(26, "var");   
        map.put(31,"<");      
        map.put(32, ">");     
        map.put(33, "{");
        map.put(34, "}");
        map.put(35, "[");
        map.put(36, "]");
        map.put(37, "(");
        map.put(38, ")");
        map.put(41, "*");
        map.put(42, "^");
        map.put(43, ":");
        map.put(44, ".");
        map.put(45, "=");
        map.put(46, "-");
        map.put(47, "+");
        map.put(48, "/");
        map.put(51, "->");
        map.put(52, "==");
        map.put(53, "!=");
        map.put(54, "<=");
        map.put(55, ">=");
        map.put(56, "<<");
        map.put(57, ">>");
    }

    public int getToken(String parsedString)
    {
        if (parsedString.charAt(0) == '"' && parsedString.charAt(parsedString.length() - 1) == '"')
        {
            return 5;
        }
        else if (checkInt(parsedString))
        {
            return 3;
        }
        else if (checkFloat(parsedString))
        {
            return 4;
        }
        else
        {
            if (map.containsValue(parsedString))
            {
                for (int key : map.keySet())
                {
                    if (map.get(key).equalsIgnoreCase(parsedString))
                    {
                        return key;
                    }
                }
            }
            else if(Character.isLetter(parsedString.charAt(0)) || parsedString.charAt(0) == '_')
            {
                return 2;
            }
            else
            {
                return 99;
            }
        }
        return 99;   
    }

    // Method used to check if string is an integer by doing try-catch
    private static boolean checkInt(String givenString)
    {
        try 
        { 
            Integer.parseInt(givenString); 
            return true;
        }  
        catch (NumberFormatException e)  
        { 
            return false;
        } 
    }

    // Method used to check if string is a float by doing try-catch
    private static boolean checkFloat(String giveString)
    {
        try 
        { 
            Float.parseFloat(giveString); 
            return true;
        }  
        catch (NumberFormatException e)  
        { 
            return false;
        } 
    }
}