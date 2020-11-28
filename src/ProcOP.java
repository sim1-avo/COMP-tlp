import java.util.ArrayList;

public class ProcOP {
    // proc
    Id id;
    //lpar
    ArrayList<ParDeclOP> pdList;
    //rpar
    ArrayList<ResultTypeOP> rtList;
    //colon
    ProcBodyOP procBodyOP;


    public ProcOP(Id id, ArrayList<ParDeclOP> pdList, ArrayList<ResultTypeOP> rtList , ProcBodyOP procBodyOP ) {
        this.id = id;
        this.pdList=pdList;
        this.rtList = rtList;
        this.procBodyOP = procBodyOP;
    }

    public ProcOP(Id id, ArrayList<ResultTypeOP> rtList, ProcBodyOP procBodyOP){
        this.id=id;
        this.procBodyOP=procBodyOP;
        this.rtList=rtList;
    }
}
