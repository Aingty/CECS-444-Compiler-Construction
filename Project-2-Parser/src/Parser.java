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
        LLTable.put("Pgm,prog",1);
        LLTable.put("Main,main",2);
        LLTable.put("BBlock,{",3);
        LLTable.put("Vargroup,main",5);
        LLTable.put("Vargroup,}",5);
        LLTable.put("Vargroup,vars",4);
        LLTable.put("Vargroup,id",5);
        LLTable.put("Vargroup,*",5);
        LLTable.put("Vargroup,fcn",5);
        LLTable.put("Vargroup,$",5);
        LLTable.put("PPvarlist,(",6);
        LLTable.put("Varlist,int",7);
        LLTable.put("Varlist,float",7);
        LLTable.put("Varlist,string",7);
        LLTable.put("Varlist,id",7);
        LLTable.put("Varitem,int",200);
        LLTable.put("Varitem,float",200);
        LLTable.put("Varitem,string",200);
        LLTable.put("Varitem,id",200);
        LLTable.put("Varitem,class",204);
        LLTable.put("Varitem_A int",201);
        LLTable.put("Varitem_A float",201);
        LLTable.put("Varitem_A string",201);
        LLTable.put("Varitem_A id",201);
        LLTable.put("Varitem_B =",203);
        LLTable.put("Varitem_C,class",205);
        LLTable.put("Varitem_D,{",207);

    }

    public void generateRules()
    {
        rules.put(1,"kwdprog,Vargroup,Fcndefs,Main");
        rules.put(2,"kwdmain,BBlock");
        rules.put(3,"brace1,Vargroup,Stmts,brace2");
        rules.put(4,"kwdvars,PPvarlist");
        rules.put(5,"eps");
        rules.put(6,"parens1,Varlist,parens2");
        rules.put(7,"Varitem,semi,Varlist");
        rules.put(8,"eps");
        rules.put(13,"Simplekind,Varspec");
        rules.put(14,"Basekind");
        rules.put(15,"Classid");
        rules.put(16,"int");
        rules.put(17,"float");
        rules.put(18,"string");
        rules.put(19,"id");
        rules.put(22,"Deref_id");
        rules.put(23,"id");
        rules.put(24,"Varid,KKint");
        rules.put(25,"bracket1,int,bracket2");
        rules.put(26,"Deref,id");
        rules.put(27,"aster");
        rules.put(28,"Expr");
        rules.put(29,"BBexpres");
        rules.put(32,"Expr,Moreexprs");
        rules.put(33,"comma Exprlist");
        rules.put(34,"eps");
        rules.put(35,"kwdclass Classid");
        rules.put(36,"Classheader,BBclassitems");
        rules.put(37,"brace1,Classitems,brace2");
        rules.put(38,"Classdecl,Classmom,Interfaces");
        rules.put(39,"colon,Classid");
        rules.put(40,"eps");
        rules.put(41,"Classgroup,Classitems");
        rules.put(42,"eps");
        rules.put(43,"Class_ctrl");
        rules.put(44,"Varlist");
        rules.put(45,"Mddecls");
        rules.put(46,"colon,id");
        rules.put(47,"colon,Classid,Interfaces");
        rules.put(48,"eps");
        rules.put(49,"Mdheader,Mddecls");
        rules.put(50,"eps");
        rules.put(51,"kwdfcn,Md_id,PParmlist,Retkind");
        rules.put(52,"Classid,colon,Fcnid");
        rules.put(53,"Fcndef,Fcndefs");
        rules.put(54,"eps");
        rules.put(55,"Fcnheader,BBlock");
        rules.put(56,"kwdfcn,Fcnid,PParmlist,RetKind");
        rules.put(57,"id");
        rules.put(58,"Kind");
        rules.put(61,"Varspec,More_varspecs");
        rules.put(62,"comma Varspecs");
        rules.put(63,"eps");
        rules.put(64,"parens1,parens2");
        rules.put(65,"Stmt,semi,Stmts");
        rules.put(66,"eps");
        rules.put(69,"Stif");
        rules.put(70,"Stwhile");
        rules.put(71,"Stprint");
        rules.put(72,"Strtn");
        rules.put(73,"Lval,equal,Expr");
        rules.put(76,"Deref_id");
        rules.put(77,"Varid,KKexpr");
        rules.put(78,"bracket1,Expr,bracket2");
        rules.put(79,"Fcnid,PPexprs");
        rules.put(80,"parens1,Exprlist,parens2");
        rules.put(81,"PPonly");
        rules.put(82,"kwdif,PPexpr,BBlock,Elsepart");
        rules.put(83,"kwdelseif,PPexpr,BBlock,Elsepart");
        rules.put(84,"kwdelse,BBlock");
        rules.put(85,"eps");
        rules.put(86,"kwdwhile,PPexpr,BBlock");
        rules.put(87,"kprint,PPexprs");
        rules.put(88,"kwdreturn,Expr");
        rules.put(89,"kwdreturn");
        rules.put(90,"parens1,Expr,parens2");
        rules.put(91,"Expr,Oprel,Rterm");
        rules.put(92,"Rterm");
        rules.put(93,"Rterm,Opadd,Term");
        rules.put(94,"Term");
        rules.put(96,"Fact");
        rules.put(97,"Basekind");
        rules.put(98,"Lval");
        rules.put(99,"Addrof_id");
        rules.put(100,"Fcall");
        rules.put(101,"PPexpr");
        rules.put(102,"ampersand,id");
        rules.put(103,"opeq");
        rules.put(104,"opne");
        rules.put(105,"Lthan");
        rules.put(106,"ople");
        rules.put(107,"opge");
        rules.put(108,"Gthan");
        rules.put(109,"angle1");
        rules.put(110,"angle2");
        rules.put(111,"plus");
        rules.put(112,"minus");
        rules.put(113,"aster");
        rules.put(114,"slash");
        rules.put(115,"caret");

        // Left Factor Rules Starts HERE!//
        rules.put(200,"Varitem_A Varitem_B");
        rules.put(201,"Vardecl");
        rules.put(203,"equal,Varinit");
        rules.put(204,"Varitem_C,Varitem_D");
        rules.put(205,"Classdecl");
        rules.put(207,"BBClassitems,Classmom,Interfaces");
        rules.put(208,"Varspec_A Varspec_B");
        rules.put(209,"Varid");
        rules.put(211,"KKint");

        rules.put(300,"brace1,BBexprs_A");
        rules.put(301,"Exprlist,brace2");
        rules.put(302,"brace2");

        rules.put(400,"PParmlist_A PParmlist_B");
        rules.put(401,"parens1");
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

        rules.put(600,"Fact,Term_Q");
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