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
        Object e= a.getE().accept(this);
        if(e instanceof String){andOP.appendChild(document.createTextNode(e.toString()));}
        if(e instanceof Element){andOP.appendChild((Element)e);}
        Object e1= a.getE1().accept(this);
        if(e1 instanceof String){andOP.appendChild(document.createTextNode(e1.toString()));}
        if(e1 instanceof Element){andOP.appendChild((Element)e1);}
        return andOP;
    }

    @Override
    public Object visit(AssignOP a) {

        return null;
    }

    @Override
    public Object visit(BodyOP b) {
        Element bodyop= document.createElement("BodyOP");
        for(Stat s:b.getStatList()){
            Element stat= (Element) s.accept(this);
            bodyop.appendChild(stat);
        }

        return bodyop;
    }

    @Override
    public Object visit(CallProcOP cp) {
        Element callProcOP =document.createElement("CallProcOP");
        callProcOP.appendChild(document.createTextNode("(ID,\""+cp.getVal()+"\")"));
        Element exprOPList= document.createElement("ExprOPList");
        for(Expr e : cp.getElist()) {
            Element exprOP= document.createElement("ExprOP");
            Object o = e.accept(this);
            if(o instanceof String){exprOP.appendChild(document.createTextNode(o.toString()));}
            if(o instanceof Element){exprOP.appendChild((Element) o);}
            exprOPList.appendChild(exprOP);
        }
        callProcOP.appendChild(exprOPList);
        return callProcOP;
    }

    @Override
    public Object visit(DivOP d) {
        Element divOP= document.createElement("DivOP");
        Object e= d.getE().accept(this);
        if(e instanceof String){divOP.appendChild(document.createTextNode(e.toString()));}
        if(e instanceof Element){divOP.appendChild((Element)e);}
        Object e1= d.getE1().accept(this);
        if(e1 instanceof String){divOP.appendChild(document.createTextNode(e1.toString()));}
        if(e1 instanceof Element){divOP.appendChild((Element)e1);}
        return divOP;
    }

    @Override
    public Object visit(ElifOP c) {
        Element elifop= document.createElement("ElifOP");
        Element exprop= document.createElement("ExprOP");
        Object o= c.getE().accept(this);
        if(o instanceof String){exprop.appendChild(document.createTextNode(o.toString()));}
        if(o instanceof Element){exprop.appendChild((Element)o);}
        elifop.appendChild(exprop);

        Element bodyop= (Element) c.getsList().accept(this);
        elifop.appendChild(bodyop);


        return elifop;
    }

    @Override
    public Object visit(ElseOP c) {
        Element elseop= document.createElement("ElseOP");
        Element bodyop= (Element) c.getsList().accept(this);
        elseop.appendChild(bodyop);

        return elseop;
    }

    @Override
    public Object visit(EqualsOP d) {
        Element eqOP= document.createElement("EqualsOP");
        Object e= d.getE().accept(this);
        if(e instanceof String){eqOP.appendChild(document.createTextNode(e.toString()));}
        if(e instanceof Element){eqOP.appendChild((Element)e);}
        Object e1= d.getE1().accept(this);
        if(e1 instanceof String){eqOP.appendChild(document.createTextNode(e1.toString()));}
        if(e1 instanceof Element){eqOP.appendChild((Element)e1);}
        return eqOP;
    }

    @Override
    public Object visit(Expr e) {
        Element exprOP = document.createElement("ExprOP");
        if(e.getCp() != null){
            Element el= (Element) e.getCp().accept(this);
            exprOP.appendChild(el);
            return exprOP;
        }

        return null;
    }

    @Override
    public Object visit(GreaterEqualsOP ge) {
        Element geOP= document.createElement("GreaterEqualsOP");
        Object e= ge.getE().accept(this);
        if(e instanceof String){geOP.appendChild(document.createTextNode(e.toString()));}
        if(e instanceof Element){geOP.appendChild((Element)e);}
        Object e1= ge.getE1().accept(this);
        if(e1 instanceof String){geOP.appendChild(document.createTextNode(e1.toString()));}
        if(e1 instanceof Element){geOP.appendChild((Element)e1);}
        return geOP;
    }

    @Override
    public Object visit(GreaterThanOP gt) {
        Element gtOP= document.createElement("GreaterThanOP");
        Object e= gt.getE().accept(this);
        if(e instanceof String){gtOP.appendChild(document.createTextNode(e.toString()));}
        if(e instanceof Element){gtOP.appendChild((Element)e);}
        Object e1= gt.getE1().accept(this);
        if(e1 instanceof String){gtOP.appendChild(document.createTextNode(e1.toString()));}
        if(e1 instanceof Element){gtOP.appendChild((Element)e1);}
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
        Element ifOP= document.createElement("IfOP");
        Object o=c.getE().accept(this);
        Element e= document.createElement("ExprOP");
        if(o instanceof String){e.appendChild(document.createTextNode(o.toString()));}
        if(o instanceof Element){e.appendChild((Element)o);}
        ifOP.appendChild(e);

        Element bodyop=(Element) c.getsList().accept(this);
        ifOP.appendChild(bodyop);


        for(ElifOP elif: c.getElList()){
            Object elf= elif.accept(this);
            //TODO
        }
        if(c.getEl()!=null) {
            Object elseop = c.getEl().accept(this);
        }
        //TODO



        return null;
    }

    @Override
    public Object visit(LessEqualsOP le) {
        Element leOP= document.createElement("LessEqualsOP");
        Object e= le.getE().accept(this);
        if(e instanceof String){leOP.appendChild(document.createTextNode(e.toString()));}
        if(e instanceof Element){leOP.appendChild((Element)e);}
        Object e1= le.getE1().accept(this);
        if(e1 instanceof String){leOP.appendChild(document.createTextNode(e1.toString()));}
        if(e1 instanceof Element){leOP.appendChild((Element)e1);}
        return leOP;


    }


    @Override
    public Object visit(LessThanOP lt) {
        Element ltOP= document.createElement("LessThanOP");
        Object e= lt.getE().accept(this);
        if(e instanceof String){ltOP.appendChild(document.createTextNode(e.toString()));}
        if(e instanceof Element){ltOP.appendChild((Element)e);}
        Object e1= lt.getE1().accept(this);
        if(e1 instanceof String){ltOP.appendChild(document.createTextNode(e1.toString()));}
        if(e1 instanceof Element){ltOP.appendChild((Element)e1);}
        return ltOP;
    }

    @Override
    public Object visit(MinusOP m) {
        Element mOP= document.createElement("MinusOP");
        Object e= m.getE().accept(this);
        if(e instanceof String){mOP.appendChild(document.createTextNode(e.toString()));}
        if(e instanceof Element){mOP.appendChild((Element)e);}
        Object e1= m.getE1().accept(this);
        if(e1 instanceof String){mOP.appendChild(document.createTextNode(e1.toString()));}
        if(e1 instanceof Element){mOP.appendChild((Element)e1);}
        return mOP;
    }

    @Override
    public Object visit(NotEqualsOP ne) {
        Element neOP= document.createElement("NotEqualsOP");
        Object e= ne.getE().accept(this);
        if(e instanceof String){neOP.appendChild(document.createTextNode(e.toString()));}
        if(e instanceof Element){neOP.appendChild((Element)e);}
        Object e1= ne.getE1().accept(this);
        if(e1 instanceof String){neOP.appendChild(document.createTextNode(e1.toString()));}
        if(e1 instanceof Element){neOP.appendChild((Element)e1);}
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
        Object e= or.getE().accept(this);
        if(e instanceof String){orOP.appendChild(document.createTextNode(e.toString()));}
        if(e instanceof Element){orOP.appendChild((Element)e);}
        Object e1= or.getE1().accept(this);
        if(e1 instanceof String){orOP.appendChild(document.createTextNode(e1.toString()));}
        if(e1 instanceof Element){orOP.appendChild((Element)e1);}
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
    public Object visit(PlusOP p) {
        Element plusOP= document.createElement("OrOP");
        Object e= p.getE().accept(this);
        if(e instanceof String){plusOP.appendChild(document.createTextNode(e.toString()));}
        if(e instanceof Element){plusOP.appendChild((Element)e);}
        Object e1= p.getE1().accept(this);
        if(e1 instanceof String){plusOP.appendChild(document.createTextNode(e1.toString()));}
        if(e1 instanceof Element){plusOP.appendChild((Element)e1);}
        return plusOP;
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
        Element exprList = document.createElement("ExprOPList");
        for(Expr e : pb.getRe()) {
            Element exprOP= document.createElement("ExprOP");
            Object o=e.accept(this);
            if(o instanceof String){ exprOP.appendChild(document.createTextNode(o.toString()));}
            if(o instanceof Element){ exprOP.appendChild((Element)o);}
            exprList.appendChild(exprOP);
        }
        procBodyOP.appendChild(exprList);
        return procBodyOP;
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
        Element readOP= document.createElement("ReadlnOP");
        Element idList= document.createElement("IdList");
        for(Id i:c.getIdList()){
            String s= i.accept(this).toString();
            idList.appendChild(document.createTextNode(s));
        }
        readOP.appendChild(idList);
        return readOP;
    }

    @Override
    public Object visit(ReturnExprsOP c) {
        return null;
    }

    @Override
    public Object visit(Stat s) {
        Element stat = document.createElement("Stat");
        if(s.getCp() != null){
            Element el= (Element) s.getCp().accept(this);
            stat.appendChild(el);
            return stat;
        }

        return null;
    }

    @Override
    public Object visit(TimesOP t) {
        Element tOP= document.createElement("TimesOP");
        Object e= t.getE().accept(this);
        if(e instanceof String){tOP.appendChild(document.createTextNode(e.toString()));}
        if(e instanceof Element){tOP.appendChild((Element)e);}
        Object e1= t.getE1().accept(this);
        if(e1 instanceof String){tOP.appendChild(document.createTextNode(e1.toString()));}
        if(e1 instanceof Element){tOP.appendChild((Element)e1);}
        return tOP;
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
        Element writeOP= document.createElement("WriteOP");
        Element exprList= document.createElement("ExprListOP");
        for(Expr e : c.getExprList()) {
            Element exprOP= document.createElement("ExprOP");
            Object o=e.accept(this);
            if(o instanceof String){ exprOP.appendChild(document.createTextNode(o.toString()));}
            if(o instanceof Element){ exprOP.appendChild((Element)o);}
            exprList.appendChild(exprOP);
        }
        return writeOP;
    }

    @Override
    public Object visit(StringConst sc) {
        return "(STRING_CONST, \""+ sc.getS() +"\")";
    }

    @Override
    public Object visit(IntConst ic) {
        return "(INT_CONST, \""+ ic.getVal() +"\")";
    }

    @Override
    public Object visit(Bool b) {
        return "("+ b.isB()+")";

    }

    @Override
    public Object visit(Null c) {
        return c.getN();
    }

    @Override
    public Object visit(FloatConst fc) {
        return "(FLOAT_CONST, \""+ fc.getF() +"\")";
    }
}
