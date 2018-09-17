import java.util.ArrayList;
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

    // Parser for Matt
    public ArrayList<String> parser(String stringToParsed)
    {
        int j;
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i = 0; i < stringToParsed.length(); i++)
        {
            j = i+1;
            if (stringToParsed.charAt(i) == '/')
            {
                if (j < stringToParsed.length())
                {
                    if (stringToParsed.charAt(j) == '/')
                    {
                        break;
                    }
                }
                arrayList.add(Character.toString(stringToParsed.charAt(i)));      
            }
            else if (Character.isLetter(stringToParsed.charAt(i)))
            {
                while(j < stringToParsed.length())
                {
                    if (Character.isLetter(stringToParsed.charAt(j)) || Character.isDigit(stringToParsed.charAt(j)))
                    {
                        j++;
                    }
                    else
                    {
                        break;
                    }
                }
                arrayList.add(stringToParsed.substring(i, j));
                i = j - 1;
            }
            else if (Character.isDigit(stringToParsed.charAt(i)))
            {
                while(j < stringToParsed.length())
                {
                    if (stringToParsed.charAt(j) == '.' || Character.isDigit(stringToParsed.charAt(j)))
                    {
                        j++;
                    }
                    else
                    {
                        break;
                    }
                }
                arrayList.add(stringToParsed.substring(i, j));
                i = j - 1;
            }
            else if (stringToParsed.charAt(i) == ' ')
            {
                continue;
            }
            else
            {
                switch (stringToParsed.charAt(i))
                {
                    case '-':
                        if (j < stringToParsed.length())
                        {
                            if (stringToParsed.charAt(j) == '>')
                            {
                                j++;
                                arrayList.add(stringToParsed.substring(i, j));
                                i = j - 1;
                            }
                            else
                            {
                                arrayList.add(Character.toString(stringToParsed.charAt(i)));
                            }
                        }
                        else
                        {
                            arrayList.add(Character.toString(stringToParsed.charAt(i)));
                        }
                        break;
                    case '=':
                        if (j < stringToParsed.length())
                        {
                            if (stringToParsed.charAt(j) == '=')
                            {
                                j++;
                                arrayList.add(stringToParsed.substring(i, j));
                                i = j - 1;
                            }
                            else
                            {
                                arrayList.add(Character.toString(stringToParsed.charAt(i)));
                            }
                        }
                        else
                        {
                            arrayList.add(Character.toString(stringToParsed.charAt(i)));
                        }
                        break;
                    case '!':
                        if (j < stringToParsed.length())
                        {
                            if (stringToParsed.charAt(j) == '=')
                            {
                                j++;
                                arrayList.add(stringToParsed.substring(i, j));
                                i = j - 1;
                            }
                            else
                            {
                                arrayList.add(Character.toString(stringToParsed.charAt(i)));
                            }
                        }
                        else
                        {
                            arrayList.add(Character.toString(stringToParsed.charAt(i)));
                        }
                        break;
                    case '<':
                        if (j < stringToParsed.length())
                        {
                            if (stringToParsed.charAt(j) == '=' || stringToParsed.charAt(j) == '<')
                            {
                                j++;
                                arrayList.add(stringToParsed.substring(i, j));
                                i = j - 1;
                            }
                            else
                            {
                                arrayList.add(Character.toString(stringToParsed.charAt(i)));
                            }
                        }
                        else
                        {
                            arrayList.add(Character.toString(stringToParsed.charAt(i)));
                        }
                        break;
                    case '>':
                        if (j < stringToParsed.length())
                        {
                            if (stringToParsed.charAt(j) == '=' || stringToParsed.charAt(j) == '>')
                            {
                                j++;
                                arrayList.add(stringToParsed.substring(i, j));
                                i = j - 1;
                            }
                            else
                            {
                                arrayList.add(Character.toString(stringToParsed.charAt(i)));
                            }
                        }
                        else
                        {
                            arrayList.add(Character.toString(stringToParsed.charAt(i)));
                        }
                        break;
                    case '"':
                        boolean parenthesisAbsent = true;
                        while(j < stringToParsed.length())
                        {
                            if (stringToParsed.charAt(j) != '"')
                            {
                                j++;
                            }
                            else
                            {
                                parenthesisAbsent = false;
                                break;
                            }
                        }
                        if (parenthesisAbsent)
                        {
                            System.out.println("DID NOT FINE CLOSING PARENTHESIS!!!");
                            System.exit(0);
                        }
                        arrayList.add(stringToParsed.substring(i, j+1));
                        i = j;
                        break;
                    default:
                        arrayList.add(Character.toString(stringToParsed.charAt(i)));
                }
            }

        }
        return arrayList;
    }
}