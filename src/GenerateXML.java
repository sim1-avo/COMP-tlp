import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GenerateXML implements Visitor{

    private Document document;

    public GenerateXML () throws ParserConfigurationException {
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        document = documentBuilder.newDocument();
    }

    @Override
    public Object visit(ProgramOP p) {
        Element programOP = document.createElement("ProgramOP");

        for (VarDeclOP var :p.getVarDeclList() ) {
            Element l= (Element) var.accept(this);
            programOP.appendChild(l);
        }

        for (ProcOP var: p.getProcList()) {
            Element r= (Element) var.accept(this);
            //TODO
        }
        //TODO right

        return 0;
    }

    @Override
    public Object visit(AndOP a) {
        Element andOP = document.createElement("AndOP");
        Element e= (Element) a.getE().accept(this);
        Element e1= (Element) a.getE1().accept(this);
        andOP.appendChild(e);
        andOP.appendChild(e1);
        return andOP;
    }

    @Override
    public Object visit(AssignOP a) {

        return null;
    }

    @Override
    public Object visit(BodyOP b) {
        return null;
    }

    @Override
    public Object visit(CallProcOP cp) {
        Element callProcOP =document.createElement("CallProcOP");
        callProcOP.appendChild(document.createTextNode("(ID,\""+cp.getVal()+"\")"));
        for(Expr e : cp.getElist()) {
            Object o = e.accept(this);
            //TODO
        }
        //TODO
        return null;
    }

    @Override
    public Object visit(DivOP d) {
        Element divOP= document.createElement("DivOP");
        Element e= (Element) d.getE().accept(this);
        Element e1= (Element) d.getE1().accept(this);
        divOP.appendChild(e);
        divOP.appendChild(e1);
        return divOP;
    }

    @Override
    public Object visit(ElifOP c) {
        return null;
    }

    @Override
    public Object visit(ElseOP c) {
        return null;
    }

    @Override
    public Object visit(EqualsOP d) {
        Element eqOP= document.createElement("EqualsOP");
        Element e= (Element) d.getE().accept(this);
        Element e1= (Element) d.getE1().accept(this);
        eqOP.appendChild(e);
        eqOP.appendChild(e1);
        return eqOP;
    }

    @Override
    public Object visit(Expr e) {
        if(e.getCp() != null){
            Object o= e.getCp().accept(this);
            //TODO
        }

        //TODO float e int e boolean

        return null;
    }

    @Override
    public Object visit(GreaterEqualsOP ge) {
        Element geOP= document.createElement("GreaterEqualsOP");
        Element e= (Element) ge.getE().accept(this);
        Element e1= (Element) ge.getE1().accept(this);
        geOP.appendChild(e);
        geOP.appendChild(e1);
        return geOP;
    }

    @Override
    public Object visit(GreaterThanOP gt) {
        Element gtOP= document.createElement("GreaterThanOP");
        Element e= (Element) gt.getE().accept(this);
        Element e1= (Element) gt.getE1().accept(this);
        gtOP.appendChild(e);
        gtOP.appendChild(e1);
        return gtOP;
    }

    @Override
    public Object visit(Id id) {
        return "(ID, \""+id.getId()+"\")";
    }

    @Override
    public Object visit(IdListInitOP x) {
        if(x.getExpr() != null) return "(ID, \""+x.getId()+"\") (\""+ x.getExpr() +"\")";
         else return "(ID, \""+x.getId()+"\")";
    }

    @Override
    public Object visit(IfOP c) {
        return null;
    }

    @Override
    public Object visit(LessEqualsOP le) {
        Element leOP= document.createElement("LessEqualsOP");
        Element e= (Element)  le.getE().accept(this);
        Element e1= (Element) le.getE1().accept(this);
        leOP.appendChild(e);
        leOP.appendChild(e1);
        return leOP;
    }

    @Override
    public Object visit(LessThanOP lt) {
        Element ltOP= document.createElement("LessThanOP");
        Element e= (Element) lt.getE().accept(this);
        Element e1= (Element) lt.getE1().accept(this);
        ltOP.appendChild(e);
        ltOP.appendChild(e1);
        return ltOP;
    }

    @Override
    public Object visit(MinusOP m) {
        Element mOP= document.createElement("MinusOP");
        Element e= (Element) m.getE().accept(this);
        Element e1= (Element) m.getE1().accept(this);
        mOP.appendChild(e);
        mOP.appendChild(e1);
        return mOP;
    }

    @Override
    public Object visit(NotEqualsOP ne) {
        Element neOP= document.createElement("NotEqualsOP");
        Element e= (Element) ne.getE().accept(this);
        Element e1= (Element) ne.getE1().accept(this);
        neOP.appendChild(e);
        neOP.appendChild(e1);
        return neOP;
    }

    @Override
    public Object visit(NotOP n) {
        return null;
        //TODO
    }

    @Override
    public Object visit(OrOP or) {
        Element orOP= document.createElement("OrOP");
        Element e= (Element) or.getE().accept(this);
        Element e1= (Element) or.getE1().accept(this);
        orOP.appendChild(e);
        orOP.appendChild(e1);
        return orOP;
    }

    @Override
    public Object visit(ParDeclOP p) {
        Element parDeclOp=document.createElement("ParDeclOp");
        parDeclOp.appendChild(document.createTextNode(p.type.toString()));
        String id_tot="";
        for(Id id : p.getIdList()) {
            String s =(String) id.accept(this);
            id_tot.concat(s);
            id_tot.concat(" ");
        }
        Element idOp=document.createElement("IdOp");
        idOp.appendChild(document.createTextNode(id_tot));
        parDeclOp.appendChild(idOp);

        return parDeclOp;
    }

    @Override
    public Object visit(ProcBodyOP pb) {
        Element procBodyOP = document.createElement("ProcBodyOP");

        for (VarDeclOP var : pb.getVdList() ) {
            Element l= (Element) var.accept(this);
            procBodyOP.appendChild(l);
        }

        for(Stat s : pb.getsList().getStatList()) {
            Object o=s.accept(this);
            //TODO
        }

        for(Expr e : pb.getRe()) {
            Object o=e.accept(this);
            //TODO
        }
        //TODO
        return null;
    }

    @Override
    public Object visit(ProcOP p) {
        Element procOP= document.createElement("ProcOP");
        procOP.appendChild(document.createTextNode(p.getId().toString()));
        for (ParDeclOP parDecl  : p.getPdList()) {
            Element parDeclOP= (Element) parDecl.accept(this);
            procOP.appendChild(parDeclOP);
        }
        String resultType = "";
        for (String s: p.getRtList()) {
            resultType.concat("("+s+")");
        }
        Element resultTypeListOp = document.createElement("ResultTypeListOp");
        resultTypeListOp.appendChild(document.createTextNode(resultType));
        Object last= p.getProcBodyOP().accept(this);
        //TODO

        return null;
    }

    @Override
    public Object visit(ReadOP c) {
        return null;
    }

    @Override
    public Object visit(ReturnExprsOP c) {
        return null;
    }

    @Override
    public Object visit(Stat s) {
        Object o= s.getCp().accept(this);
        //TODO

        return null;
    }

    @Override
    public Object visit(TimesOP t) {
        Element timesOP= document.createElement("TimesOP");
        Element e= (Element) t.getE().accept(this);
        Element e1= (Element) t.getE1().accept(this);
        timesOP.appendChild(e);
        timesOP.appendChild(e1);
        return timesOP;
    }

    @Override
    public Object visit(UMinusOP c) {
        //TODO
        return null;
    }

    @Override
    public Object visit(VarDeclOP c) {
        Element varDeclOp=document.createElement("VarDeclOp");
        varDeclOp.appendChild(document.createTextNode(c.getType()));
        String r_tot="";
        for(IdListInitOP idList : c.getIdListInit()) {
            String r= (String)idList.accept(this);
            r_tot=r_tot.concat(r);
            r_tot=r_tot.concat(" ");
        }
        Element idListInitOp = document.createElement("IdListInitOp");
        idListInitOp.appendChild(document.createTextNode(r_tot));
        varDeclOp.appendChild(idListInitOp);

        return varDeclOp;
    }

    @Override
    public Object visit(WhileOP c) {
        return null;
    }

    @Override
    public Object visit(WriteOP c) {
        return null;
    }

    @Override
    public Object visit(StringConst sc) {
        Element e= document.createElement("ExprOP");
        e.appendChild(document.createTextNode("(STRING_CONST, \""+ sc.getS() +"\")"));
        return e;
    }

    @Override
    public Object visit(IntConst ic) {
        Element e= document.createElement("ExprOP");
        e.appendChild(document.createTextNode("(INT_CONST, \""+ ic.getVal() +"\")"));
        return e;
    }

    @Override
    public Object visit(Bool b) {
        Element e= document.createElement("ExprOP");
        e.appendChild(document.createTextNode("("+ b.isB()+")"));

        return e;
    }

    @Override
    public Object visit(Null c) {
        Element e= document.createElement("ExprOP");
        e.appendChild(document.createTextNode(c.getN()));
        return e;
    }

    @Override
    public Object visit(FloatConst fc) {
        Element e= document.createElement("ExprOP");
        e.appendChild(document.createTextNode("(FLOAT_CONST, \""+ fc.getF() +"\")"));
        return e;
    }
}
