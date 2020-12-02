import java.util.ArrayList;

public class ProcOP {
    // proc
    Id id;
    //lpar
    ArrayList<ParDeclOP> pdList;
    //rpar
    ArrayList<String> rtList;
    //colon
    ProcBodyOP procBodyOP;


    public ProcOP(Id id, ArrayList<ParDeclOP> pdList, ArrayList<String> rtList , ProcBodyOP procBodyOP ) {
        this.id = id;
        this.pdList=pdList;
        this.rtList = rtList;
        this.procBodyOP = procBodyOP;
    }

    public ProcOP(Id id, ArrayList<String> rtList, ProcBodyOP procBodyOP){
        this.id=id;
        this.procBodyOP=procBodyOP;
        this.rtList=rtList;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public ArrayList<ParDeclOP> getPdList() {
        return pdList;
    }

    public void setPdList(ArrayList<ParDeclOP> pdList) {
        this.pdList = pdList;
    }

    public ArrayList<String> getRtList() {
        return rtList;
    }

    public void setRtList(ArrayList<String> rtList) {
        this.rtList = rtList;
    }

    public ProcBodyOP getProcBodyOP() {
        return procBodyOP;
    }

    public void setProcBodyOP(ProcBodyOP procBodyOP) {
        this.procBodyOP = procBodyOP;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }
}
