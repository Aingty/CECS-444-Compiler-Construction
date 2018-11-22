/*
    Team VOS:                   Email:
        Sebastian Adame         sjadamem@gmail.com
        Darian Bezayiff         darrianbez@gmail.com
        Aingty Eung             aingtyeung@yahoo.com
        Angela Flores           Angfl97@gmail.com
        Matthew Nguyen          matthewvietnguyen@gmail.com

    Description:
        This is the Parser class.....
*/
import java.util.*;

public class Parser
{
    private HashMap<String,Integer> LLTable = new HashMap<String,Integer>();
    private HashMap<Integer,String> rules = new HashMap<Integer,String>();
    
    public Parser()
    {
        LLTable.put("Pgm prog",1);
        LLTable.put("Main main",2);
        LLTable.put("BBlock {",3);
        LLTable.put("Vargroup main",5);
        LLTable.put("Vargroup }",5);
        LLTable.put("Vargroup vars",4);
        LLTable.put("Vargroup id",5);
        LLTable.put("Vargroup *",5);
        LLTable.put("Vargroup fcn",5);
        LLTable.put("Vargroup $",5);
        LLTable.put("PPvarlist (",6);
        LLTable.put("Varlist int",7);
        LLTable.put("Varlist float",7);
        LLTable.put("Varlist string",7);
        LLTable.put("Varlist id",7);
        LLTable.put("Varitem int",200);
        LLTable.put("Varitem float",200);
        LLTable.put("Varitem string",200);
        LLTable.put("Varitem id",200);
        LLTable.put("Varitem class",204);
        LLTable.put("Varitem_A int",201);
        LLTable.put("Varitem_A float",201);
        LLTable.put("Varitem_A string",201);
        LLTable.put("Varitem_A id",201);
        LLTable.put("Varitem_B =",203);
        LLTable.put("Varitem_C class",205);
        LLTable.put("Varitem_D {",207);

    }

    public void generateRules()
    {
        rules.put(1,"prog Vargroup Fcndefs Main");
        rules.put(2,"main BBlock");
        rules.put(3,"{ Vargroup Stmts }");
        rules.put(4,"vars PPvarlist");
        rules.put(5,"eps");
        rules.put(6,"( Varlist )");
        rules.put(7,"Varitem ; Varlist");
        rules.put(8,"eps");
        rules.put(13,"Simplekind Varspec");
        rules.put(14,"Basekind");
        rules.put(15,"Classid");
        rules.put(16,"int");
        rules.put(17,"float");
        rules.put(18,"string");
        rules.put(19,"id");
        rules.put(22,"Deref_id");
        rules.put(23,"id");
        rules.put(24,"Varid KKint");
        rules.put(25,"[ int ]");
        rules.put(26,"Deref id");
        rules.put(27,"*");
        rules.put(28,"Expr");
        rules.put(29,"BBexpres");
        rules.put(32,"Expr Moreexprs");
        rules.put(33,", Exprlist");
        rules.put(34,"eps");
        rules.put(35,"class Classid");
        rules.put(36,"Classheader BBclassitems");
        rules.put(37,"{ Classitems }");
        rules.put(38,"Classdecl Classmom Interfaces");
        rules.put(39,": Classid");
        rules.put(40,"eps");
        rules.put(41,"Classgroup Classitems");
        rules.put(42,"eps");
        rules.put(43,"Class_ctrl");
        rules.put(44,"Varlist");
        rules.put(45,"Mddecls");
        rules.put(46,": id");
        rules.put(47,": Classid Interfaces");
        rules.put(48,"eps");
        rules.put(49,"Mdheader Mddecls");
        rules.put(50,"eps");
        rules.put(51,"fcn Md_id PParmlist Retkind");
        rules.put(52,"Classid : Fcnid");
        rules.put(53,"Fcndef Fcndefs");
        rules.put(54,"eps");
        rules.put(55,"Fcnheader BBlock");
        rules.put(56,"fcn Fcnid PParmlist RetKind");
        rules.put(57,"id");
        rules.put(58,"Kind");
        rules.put(61,"Varspec More_varspecs");
        rules.put(62,", Varspecs");
        rules.put(63,"eps");
        rules.put(64,"( )");
        rules.put(65,"Stmt ; Stmts");
        rules.put(66,"eps");
        rules.put(69,"Stif");
        rules.put(70,"Stwhile");
        rules.put(71,"Stprint");
        rules.put(72,"Strtn");
        rules.put(73,"Lval = Expr");
        rules.put(76,"Deref_id");
        rules.put(77,"Varid KKexpr");
        rules.put(78,"[ Expr ]");
        rules.put(79,"Fcnid PPexprs");
        rules.put(80,"( Exprlist )");
        rules.put(81,"PPonly");
        rules.put(82,"if PPexpr BBlock Elsepart");
        rules.put(83,"elseif PPexpr BBlock Elsepart");
        rules.put(84,"else BBlock");
        rules.put(85,"eps");
        rules.put(86,"while PPexpr BBlock");
        rules.put(87,"kprint PPexprs");
        rules.put(88,"return Expr");
        rules.put(89,"return");
        rules.put(90,"( Expr )");
        rules.put(91,"Expr Oprel Rterm");
        rules.put(92,"Rterm");
        rules.put(93,"Rterm Opadd Term");
        rules.put(94,"Term");
        rules.put(96,"Fact");
        rules.put(97,"Basekind");
        rules.put(98,"Lval");
        rules.put(99,"Addrof_id");
        rules.put(100,"Fcall");
        rules.put(101,"PPexpr");
        rules.put(102,"& id");
        rules.put(103,"==");
        rules.put(104,"!=");
        rules.put(105,"Lthan");
        rules.put(106,"<=");
        rules.put(107,">=");
        rules.put(108,"Gthan");
        rules.put(109,"<");
        rules.put(110,">");
        rules.put(111,"+");
        rules.put(112,"-");
        rules.put(113,"*");
        rules.put(114,"\\");
        rules.put(115,"^");

        // Left Factor Rules Starts HERE!//
        rules.put(200,"Varitem_A Varitem_B");
        rules.put(201,"Vardecl");
        rules.put(203,"= Varinit");
        rules.put(204,"Varitem_C Varitem_D");
        rules.put(205,"Classdecl");
        rules.put(207,"BBClassitems Classmom Interfaces");
        rules.put(208,"Varspec_A Varspec_B");
        rules.put(209,"Varid");
        rules.put(211,"KKint");

        rules.put(300,"{ BBexprs_A");
        rules.put(301,"Exprlist }");
        rules.put(302,"}");

        rules.put(400,"PParmlist_A PParmlist_B");
        rules.put(401,"(");
        rules.put(403,"PPonly");
        rules.put(404,"Stmt_A Stmt_B");
        rules.put(405,"Stasgn");
        rules.put(407,"Fcall");

        rules.put(500,"Lval_A Lval_B");
        rules.put(501,"Varid");
        rules.put(503,"KKexpr");
        rules.put(504,"Strtn_A Strtn_B");
        rules.put(505,"return");
        rules.put(506,"Expr");

        rules.put(600,"Fact Term_Q");
        rules.put(602,"Opmul Fact Term_Q");
    }

    public int getRuleNum(String key)
    {
        return LLTable.get(key);
    }

    public String getRule(int keyNum)
    {
        return rules.get(keyNum);
    }
}