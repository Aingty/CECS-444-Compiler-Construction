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
        LLTable.put("Vargroup print",5); //Added
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

        // Sabastian's Part
        LLTable.put("Vardecl int", 13);
        LLTable.put("Vardecl float", 13);
        LLTable.put("Vardecl string", 13);
        LLTable.put("Vardecl id",13);
        LLTable.put("Simplekind int", 14);
        LLTable.put("Simplekind float", 14);
        LLTable.put("Simplekind string", 14);
        LLTable.put("Simplekind id", 15);
        LLTable.put("Basekind int", 16);
        LLTable.put("Basekind float", 17);
        LLTable.put("Basekind string", 18);
        LLTable.put("Classid id", 19);
        LLTable.put("Varspec id", 208);
        LLTable.put("Varspec *", 22);
        LLTable.put("Varspec_A id", 209);
        LLTable.put("Varspec_B ;", 210);
        LLTable.put("Varspec_B =", 210);
        LLTable.put("Varspec_B [", 211);
        LLTable.put("Varspec_B ,", 210);
        LLTable.put("Varid id", 23);
        LLTable.put("Arrspec id", 24);
        LLTable.put("KKint [", 25);
        LLTable.put("Deref_id *", 26);
        LLTable.put("Deref *", 27);
        LLTable.put("Varinit {", 29);
        LLTable.put("Varinit (", 28);
        LLTable.put("Varinit int", 28);
        LLTable.put("Varinit float", 28);
        LLTable.put("Varinit string", 28);
        LLTable.put("Varinit id", 28);
        LLTable.put("Varinit *", 28);
        LLTable.put("Varinit /", 28);
        LLTable.put("Varinit ^", 28);
        LLTable.put("Varinit &", 28);
        LLTable.put("Varinit ==", 28);
        LLTable.put("Varinit !=", 28);
        LLTable.put("Varinit <=", 28);
        LLTable.put("Varinit >=", 28);
        LLTable.put("Varinit <", 28);
        LLTable.put("Varinit >", 28);
        LLTable.put("Varinit +", 28);
        LLTable.put("Varinit -", 28);
        LLTable.put("BBexprs {", 300);
        LLTable.put("BBexprs_A }", 302);
        LLTable.put("BBexprs_A (", 301);
        LLTable.put("BBexprs_A int", 301);
        LLTable.put("BBexprs_A float", 301);
        LLTable.put("BBexprs_A string", 301);
        LLTable.put("BBexprs_A id", 301);
        LLTable.put("BBexprs_A *", 301);
        LLTable.put("BBexprs_A /", 301);
        LLTable.put("BBexprs_A ^", 301);
        LLTable.put("BBexprs_A &", 301);
        LLTable.put("BBexprs_A ==", 301);
        LLTable.put("BBexprs_A !=", 301);
        LLTable.put("BBexprs_A <=", 301);
        LLTable.put("BBexprs_A >=", 301);
        LLTable.put("BBexprs_A <", 301);
        LLTable.put("BBexprs_A >", 301);
        LLTable.put("BBexprs_A +", 301);
        LLTable.put("BBexprs_A -", 301);
        LLTable.put("Exprlist (", 32);
        LLTable.put("Exprlist int", 32);
        LLTable.put("Exprlist float", 32);
        LLTable.put("Exprlist string", 32);
        LLTable.put("Exprlist id", 32);
        LLTable.put("Exprlist *", 32);
        LLTable.put("Exprlist /", 32);
        LLTable.put("Exprlist ^", 32);
        LLTable.put("Exprlist &", 32);
        LLTable.put("Exprlist ==", 32);
        LLTable.put("Exprlist !=", 32);
        LLTable.put("Exprlist <=", 32);
        LLTable.put("Exprlist >=", 32);
        LLTable.put("Exprlist <", 32);
        LLTable.put("Exprlist >", 32);
        LLTable.put("Exprlist +", 32);
        LLTable.put("Exprlist -", 32);
        LLTable.put("Moreexprs }", 34);
        LLTable.put("Moreexprs )", 34);
        LLTable.put("Moreexprs ,", 33);
        LLTable.put("Classdecl class", 35);
        LLTable.put("Classdef class", 36);
        LLTable.put("BBClassitems {", 37);

        // Angela's Part
        LLTable.put("Varinit brace1",29);
        LLTable.put("Varinit parens1",28);
        LLTable.put("Varinit int",28);
        LLTable.put("Varinit float",28);
        LLTable.put("Varinit string",28);
        LLTable.put("Varinit id",28);
        LLTable.put("Varinit aster",28);
        LLTable.put("Varinit slash",28);
        LLTable.put("Varinit caret",28);
        LLTable.put("Varinit ampersand",28);
        LLTable.put("Varinit opeq",28);
        LLTable.put("Varinit opne",28);
        LLTable.put("Varinit ople",28);
        LLTable.put("Varinit opge",28);
        LLTable.put("Varinit angle1",28);
        LLTable.put("Varinit angle2",28);
        LLTable.put("Varinit plus",28);
        LLTable.put("Varinit minus",28);
        LLTable.put("BBexprs brace1",300);
        LLTable.put("BBexprs_A brace2",302);
        LLTable.put("BBexprs_A parens1",301);
        LLTable.put("BBexprs_A int",301);
        LLTable.put("BBexprs_A float",301);
        LLTable.put("BBexprs_A string",301);
        LLTable.put("BBexprs_A id",301);
        LLTable.put("BBexprs_A aster",301);
        LLTable.put("BBexprs_A slash",301);
        LLTable.put("BBexprs_A caret",301);
        LLTable.put("BBexprs_A ampersand",301);
        LLTable.put("BBexprs_A opeq",301);
        LLTable.put("BBexprs_A opne",301);
        LLTable.put("BBexprs_A ople",301);
        LLTable.put("BBexprs_A opge",301);
        LLTable.put("BBexprs_A angle1",301);
        LLTable.put("BBexprs_A angle2",301);
        LLTable.put("BBexprs_A plus",301);
        LLTable.put("BBexprs_A minus",301);
        LLTable.put("Exprlist parens1",32);
        LLTable.put("Exprlist int",32);
        LLTable.put("Exprlist float",32);
        LLTable.put("Exprlist string",32);
        LLTable.put("Exprlist id",32);
        LLTable.put("Exprlist aster",32);
        LLTable.put("Exprlist slash",32);
        LLTable.put("Exprlist caret",32);
        LLTable.put("Exprlist ampersand",32);
        LLTable.put("Exprlist opeq",32);
        LLTable.put("Exprlist opne",32);
        LLTable.put("Exprlist ople",32);
        LLTable.put("Exprlist opge",32);
        LLTable.put("Exprlist angle1",32);
        LLTable.put("Exprlist angle2",32);
        LLTable.put("Exprlist plus",32);
        LLTable.put("Exprlist minus",32);
        LLTable.put("Moreexprs brace2",34);
        LLTable.put("Moreexprs parens2",34);
        LLTable.put("Moreexprs comma",33);
        LLTable.put("Moreexprs eps",34);
        LLTable.put("Classdecl class",35);
        LLTable.put("Classdef class",36);
        LLTable.put("BBClassitems brace1",37);
        LLTable.put("Classheader class",38);
        LLTable.put("Classmom brace1",40);
        LLTable.put("Classmom semi",40);
        LLTable.put("Classmom colon",39);
        LLTable.put("Classmom colon",40);
        LLTable.put("Classitems brace2",42);
        LLTable.put("Classitems int",41);
        LLTable.put("Classitems float",41);
        LLTable.put("Classitems string",41);
        LLTable.put("Classitems id",41);
        LLTable.put("Classitems colon",41);
        LLTable.put("Classitems fcn",41);
        LLTable.put("Classitems class",41);
        LLTable.put("Classgroup int",44);
        LLTable.put("Classgroup float",44);
        LLTable.put("Classgroup string",44);
        LLTable.put("Classgroup id",44);
        LLTable.put("Classgroup colon",43);
        LLTable.put("Classgroup fcn",45);
        LLTable.put("Classgroup class",44);
        LLTable.put("Class_ctrl colon",46);
        LLTable.put("Interfaces brace1",48);
        LLTable.put("Interfaces semi",48);
        LLTable.put("Interfaces colon",47);
        LLTable.put("Interfaces eps",48);
        LLTable.put("Mddecls brace2",50);
        LLTable.put("Mddecls int",50);
        LLTable.put("Mddecls float",50);
        LLTable.put("Mddecls string",50);
        LLTable.put("Mddecls id",50);
        LLTable.put("Mddecls colon",50);
        LLTable.put("Mddecls fcn",50);
        LLTable.put("Mddecls fcn",49);
        LLTable.put("Mddecls class",50);
        LLTable.put("Mddecls eps",50);
        LLTable.put("Mdheader fcn",51);
        LLTable.put("Fcndefs main",54);

        // Matthew's Part
        LLTable.put("Stmts {",66);
        LLTable.put("Stmts id",65);
        LLTable.put("Stmts *",65);
        LLTable.put("Stmts if",65);
        LLTable.put("Stmts while",65);
        LLTable.put("Stmts print",65);
        LLTable.put("Stmts return",65);
        LLTable.put("Stmt id",404);
        LLTable.put("Stmt *",67);
        LLTable.put("Stmt if", 69);
        LLTable.put("Stmt while",70);
        LLTable.put("Stmt print",71);
        LLTable.put("Stmt return",72);
        LLTable.put("Stmt_A id",405);
        LLTable.put("Stmt_A *",405);
        LLTable.put("Stmt_B =",406);
        LLTable.put("Stmt_B id",407);
        LLTable.put("Stasgn id",73);
        LLTable.put("stasgn *",73);
        LLTable.put("Lval id",500);
        LLTable.put("Lval *",73);
        LLTable.put("Lval_A id",501);
        LLTable.put("Lval_B [",503);
        LLTable.put("Aref id",77);
        LLTable.put("KKexpr [",78);
        LLTable.put("Fcall id",79);
        LLTable.put("PPexprs (",504);
        LLTable.put("PPexprs_A (",505);
        LLTable.put("PPexprs_B (",506);
        LLTable.put("PPexprs_B )",507); //follow set
        LLTable.put("PPexprs_B =",506);
        LLTable.put("PPexprs_B int",506);
        LLTable.put("PPexprs_B float",506);
        LLTable.put("PPexprs_B string",506);
        LLTable.put("PPexprs_B id",506);
        LLTable.put("PPexprs_B *",506);
        LLTable.put("PPexprs_B /",506);
        LLTable.put("PPexprs_B ^",506);
        LLTable.put("PPexprs_B opeq",506);
        LLTable.put("PPexprs_B opne",506);
        LLTable.put("PPexprs_B ople",506);
        LLTable.put("PPexprs_B opge",506);
        LLTable.put("PPexprs_B angle1",506);
        LLTable.put("PPexprs_B angle2",506);
        LLTable.put("PPexprs_B +",506);
        LLTable.put("PPexprs_B -",506);
        LLTable.put("Stif if",81);
        LLTable.put("Elsepart semi",85); //follow set
        LLTable.put("Elsepart elseif",83);
        LLTable.put("Elsepart else",84);
        LLTable.put("Stwhile while",86);
        LLTable.put("Stprint print",87);
        LLTable.put("Strtn return",508);
        LLTable.put("Strtn_A return",509);
        LLTable.put("Strtn_B (",510);
        LLTable.put("Strtn_B int",510);
        LLTable.put("Strtn_B float",510);
        LLTable.put("Strtn_B string",510);
        LLTable.put("Strtn_B id",510);
        LLTable.put("Strtn_B *",510);
        LLTable.put("Strtn_B /",510);
        LLTable.put("Strtn_B ^",510);
        LLTable.put("Strtn_B *",510);
        LLTable.put("Strtn_B opeq",510);
        LLTable.put("Strtn_B opne",510);
        LLTable.put("Strtn_B ople",510);
        LLTable.put("Strtn_B opge",510);
        LLTable.put("Strtn_B angle1",510);
        LLTable.put("Strtn_B angle2",510);
        LLTable.put("Strtn_B +",510);
        LLTable.put("Strtn_B -",510);
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
        rules.put(87,"print PPexprs");
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