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
        return null;
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
    public Object visit(DivOP c) {
        return null;
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
    public Object visit(EqualsOP c) {
        return null;
    }

    @Override
    public Object visit(Expr c) {
        return null;
    }

    @Override
    public Object visit(GreaterEqualsOP c) {
        return null;
    }

    @Override
    public Object visit(GreaterThanOP c) {
        return null;
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
    public Object visit(LessEqualsOP c) {
        return null;
    }

    @Override
    public Object visit(LessThanOP c) {
        return null;
    }

    @Override
    public Object visit(MinusOP c) {
        return null;
    }

    @Override
    public Object visit(NotEqualsOP c) {
        return null;
    }

    @Override
    public Object visit(NotOP c) {
        return null;
    }

    @Override
    public Object visit(OrOP c) {
        return null;
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
            //TODO
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
    public Object visit(TimesOP c) {
        return null;
    }

    @Override
    public Object visit(UMinusOP c) {
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
}
