import java.util.ArrayList;

public class ProcOP {
    // proc
    Id id;
    //lpar
    ArrayList pdList;
    //rpar
    ArrayList rtList;
    //colon
    ProcBodyOP procBodyOP;


    public ProcOP(Id id, ArrayList pdList, ArrayList rtList , ProcBodyOP procBodyOP ) {
        this.id = id;
        this.pdList=pdList;
        this.rtList = rtList;
        this.procBodyOP = procBodyOP;
    }

    public ProcOP(Id id, ArrayList rtList, ProcBodyOP procBodyOP){
        this.id=id;
        this.procBodyOP=procBodyOP;
        this.rtList=rtList;
    }
}
