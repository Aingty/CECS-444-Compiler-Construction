/*
    Team VOS:                   Email:
        Sebastian Adame         sjadamem@gmail.com
        Darian Bezayiff         darrianbez@gmail.com
        Aingty Eung             aingtyeung@yahoo.com
        Angela Flores           Angfl97@gmail.com
        Matthew Nguyen          matthewvietnguyen@gmail.com

    Description:
        This is the Rule class.....
*/
import java.util.HashMap;

public class Rule
{
    HashMap<Integer,String> rules = new HashMap<Integer,String>();

    public Rule()
    {
        rules.put(1,"kwdprog,Vargroup,Fcndefs,Main");
        rules.put(46,"Fcndef,Fcndefs");
        rules.put(420,"eps");
        rules.put(47,"Fcnheader,BBlock");
        rules.put(48,"kwdfcn,Fcnid,PParmlist,RetKind");
        rules.put(49,"id");
        rules.put(50,"Kind");
        rules.put(51,"parens1,Varspecs,parens2");
        rules.put(52,"PPonly");
        rules.put(53,"Varspec,More_varspecs");
        rules.put(54,"comma,Varspecs");
        rules.put(420,"eps");
        rules.put(55,"parens1,parens2");
        rules.put(56,"Stmt,semi,Stmts");
        rules.put(420,"eps");
        rules.put(57,"Stasgn");
        rules.put(58,"Fcall");
        rules.put(59,"Stif");
        rules.put(60,"Stwhile");
        rules.put(61,"Stprint");
        rules.put(62,"Strtn");
    }
 
    public String getRule(int keyNum)
    {
        return rules.get(keyNum);
    }
}