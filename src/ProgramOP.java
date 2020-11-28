import java.util.ArrayList;

public class ProgramOP {
    private ArrayList<VarDeclOP> VarDeclList ;
    private ArrayList<ProcOP> ProcList;

    ProgramOP(ArrayList<VarDeclOP> VarDeclListOP ,ArrayList<ProcOP> ProcListOP){
        this.ProcList= ProcListOP;
        this.VarDeclList= VarDeclListOP;

    }

}
