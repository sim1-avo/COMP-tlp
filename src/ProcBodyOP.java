import java.util.ArrayList;

public class ProcBodyOP {
    ArrayList<VarDeclOP> vdList;
    BodyOP sList;
    ArrayList<Expr> re;

    public ProcBodyOP(ArrayList<VarDeclOP> vdList, BodyOP sList,ArrayList<Expr> re){
        this.vdList= vdList;
        this.sList= sList;
        this.re = re;
    }
}
