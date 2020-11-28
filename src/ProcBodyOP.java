import java.util.ArrayList;

public class ProcBodyOP {
    ArrayList<VarDeclOP> vdList;
    ArrayList<Stat> sList;
    ReturnExprsOP re;

    public ProcBodyOP(ArrayList<VarDeclOP> vdList, ArrayList<Stat> sList, ReturnExprsOP re){
        this.vdList= vdList;
        this.sList= sList;
        this.re = re;
    }
}
